package com.MyGolfTown.productlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.MyGolfTown.productlist.bo.ProductListBO;
import com.MyGolfTown.productlist.domain.ProductList;

@Controller
public class ProductListController {

	@Autowired
	private ProductListBO productListBO;
	
	@GetMapping("/{usedClub}/{clubType}-view")
	public String driverView(Model model,
			@PathVariable("usedClub") String usedClub,
			@PathVariable("clubType") String clubType) {
		boolean used = Boolean.parseBoolean(usedClub);
		List<ProductList> productList =  productListBO.generateProductList(used, clubType);
		
		model.addAttribute("productList", productList);
		return "golf/"+usedClub+"club/"+ clubType + "View"; 
	}
	
	@GetMapping("/{equipmentType}-view")
	public String driverView(Model model,
			@PathVariable("equipmentType") String equipmentType) {
		List<ProductList> productList =  productListBO.generateProductListEquipment(equipmentType);
		
		
		model.addAttribute("productList", productList);
		return "golf/equipment/"+ equipmentType + "View"; 
	}
	
}
