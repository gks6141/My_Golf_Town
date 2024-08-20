package com.MyGolfTown.productist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.MyGolfTown.productist.bo.ProductListBO;
import com.MyGolfTown.productist.domain.ProductList;

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
		return "golf/"+ clubType + "View"; 
	}
	
}
