package com.MyGolfTown.golf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MyGolfTown.golf.bo.GolfClubBO;
import com.MyGolfTown.golf.domain.GolfClub;
import com.MyGolfTown.product.bo.ProductBO;
import com.MyGolfTown.product.domain.Product;

@Controller
@RequestMapping("/golf")
public class GolfController {

	@Autowired
	private GolfClubBO golfClubBO;
	
	@Autowired
	private ProductBO productBO;
	
	@GetMapping("/main-view")
	public String mainView() {
		return "golf/mainView";
	}
	 
	@GetMapping("/driver-view")
	public String driverView(Model model) {
		List<Product> products = productBO.getGolfClubProductByUsedClubAndClubType(true, "diver");
		GolfClub golfClubs = golfClubBO.getGolfClubById(products.get(1).getClubId());
		model.addAttribute("products",products);
		model.addAttribute("club",golfClubs);
		return "golf/driverView";
	}
	
	
	@GetMapping("/iron-view")
	public String ironView() {
		return "golf/ironView";
	}
	
	@GetMapping("/util-wood-view")
	public String utilWoodView() {
		return "golf/utilWoodView";
	}
	
	@GetMapping("/wedge-view")
	public String wedgeView() {
		return "golf/wedgeView";
	}
	
	@GetMapping("/putter-view")
	public String putterView() {
		return "golf/putterView";
	}
	
	@GetMapping("/women-club-view")
	public String womenClubView() {
		return "golf/womenClubView";
	}
	
	@GetMapping("/fullset-view")
	public String fullsetView() {
		return "golf/fullsetView";
	}
	
	@GetMapping("/shaft-view")
	public String shaftView() {
		return "golf/shaftView";
	}
	
	
}
