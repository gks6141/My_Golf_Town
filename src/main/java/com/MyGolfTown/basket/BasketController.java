package com.MyGolfTown.basket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basket")
public class BasketController {

	@GetMapping("/basket-view")
	public String basket() {
		return "/basket/basketView";
	}
}
