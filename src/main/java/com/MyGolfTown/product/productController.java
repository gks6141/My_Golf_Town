package com.MyGolfTown.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MyGolfTown.golf.bo.GolfClubBO;
import com.MyGolfTown.golf.bo.GolfEquipmentBO;
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
			model.addAttribute("equipment", golfEquipmentBO.getGolfEquipmentById(product.getEquipmentId()));
		} else {
			model.addAttribute("club", golfClubBO.getGolfClubById(product.getClubId()));
		}
			
		model.addAttribute("product", product);
		return "product/productView";
	}
	
	@GetMapping("/order-view")
	public String orderView() {
		return "product/orderView";
	}
}
