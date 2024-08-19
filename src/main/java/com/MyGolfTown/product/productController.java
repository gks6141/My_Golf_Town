package com.MyGolfTown.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MyGolfTown.golf.bo.GolfClubBO;
import com.MyGolfTown.golf.bo.GolfEquipmentBO;
import com.MyGolfTown.golf.domain.GolfClub;
import com.MyGolfTown.golf.domain.GolfEquipment;
import com.MyGolfTown.product.bo.ProductBO;
import com.MyGolfTown.product.domain.Product;

@RequestMapping("/product")
@Controller
public class productController {

	@Autowired
	private ProductBO productBO;
	
	@Autowired
	private GolfEquipmentBO golfEquipmentBO;

	@Autowired
	private GolfClubBO golfClubBO;
	
	@GetMapping("/product-view")
	public String productView(Model model,
			@RequestParam("productId") int Id) {
		
		Product product = productBO.getProductById(Id);
		
		if(product.getClubId() == null) {
			GolfEquipment equipment = golfEquipmentBO.getGolfEquipmentById(product.getEquipmentId());
			List<GolfEquipment> equipments = golfEquipmentBO.getGolfEquipmentByName((String)equipment.getEquipmentName());
			model.addAttribute("equipment", equipment);
			model.addAttribute("equipments", equipments);
		} else {
			GolfClub club = golfClubBO.getGolfClubById(product.getClubId());
			List<GolfClub> clubs= golfClubBO.getGolfClubByName((String)club.getClubName());
			model.addAttribute("club", club);
			model.addAttribute("clubs", clubs);
		}
			
		model.addAttribute("product", product);
		return "product/productView";
	}
	
	@GetMapping("/order-view")
	public String orderView() {
		return "product/orderView";
	}
}
