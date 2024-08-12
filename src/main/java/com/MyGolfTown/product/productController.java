package com.MyGolfTown.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/product")
@Controller
public class productController {

	@GetMapping("/product-view")
	public String productView() {
		return "product/productView";
	}
	
	@GetMapping("/order-view")
	public String orderView() {
		return "product/orderView";
	}
}
