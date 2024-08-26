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
import com.MyGolfTown.product.bo.OrderBO;
import com.MyGolfTown.product.bo.ProductBO;
import com.MyGolfTown.product.domain.Order;
import com.MyGolfTown.product.domain.Product;
import com.MyGolfTown.user.bo.UserBO;
import com.MyGolfTown.user.entity.UserEntity;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/product")
@Controller
public class productController {

	@Autowired
	private UserBO userBO;
	
	@Autowired
	private ProductBO productBO;
	
	@Autowired
	private GolfEquipmentBO golfEquipmentBO;

	@Autowired
	private GolfClubBO golfClubBO;
	
	@Autowired
	private OrderBO orderBO;
	
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
	public String orderView(HttpSession session,
			Model model,
			@RequestParam("productId") int productId) {
		int userId = (int) session.getAttribute("userId");
		Product product= productBO.getProductById(productId);
		GolfEquipment equipment = null;
		GolfClub club = null;
		
		if(product.getClubId() != null) {			
			club = golfClubBO.getGolfClubById(product.getClubId());
		} else {
			equipment = golfEquipmentBO.getGolfEquipmentById(product.getEquipmentId());
		}
		UserEntity user= userBO.getUserEntityByUserId(userId);
		
		model.addAttribute("club", club);
		model.addAttribute("equipment", equipment);
		model.addAttribute("product",product);
		model.addAttribute("user", user);
		return "product/orderView";
	}
	
	@GetMapping("/done-view")
	public String doneView(Model model,
			@RequestParam("id") int id) {
		Order order = orderBO.getOrderById(id);
		Product product= productBO.getProductById(order.getProductId());
		model.addAttribute("order",order);
		model.addAttribute("product",product);
		return "product/doneView";
	}
}
