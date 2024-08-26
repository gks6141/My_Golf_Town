package com.MyGolfTown.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MyGolfTown.product.bo.OrderBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/product")
@RestController
public class ProductRestController {

	@Autowired
	private OrderBO orderBO;
	
	@PostMapping("/order-insert")
	public Map<String,Object> orderInsert(
			@RequestParam("productId") int productId ,
			@RequestParam("orderName") String orderName,
			@RequestParam("orderAddress") String orderAddress,
			@RequestParam("orderPhoneNumber") String orderPhoneNumber,
			@RequestParam("paymentMethod") String paymentMethod,
//			@RequestParam("price") String price,
			HttpSession session){
		Map<String, Object> result = new HashMap<>();
		int userId = (int)session.getAttribute("userId");
//		int intPrice = Integer.valueOf(price);
		int orderId=orderBO.insertOrder(userId, productId, orderName, orderAddress, orderPhoneNumber, 190000, paymentMethod);
		
		result.put("code",200);
		result.put("result","성공");
		result.put("orderId", orderId);
		
		
		return result;

	}
	
}
