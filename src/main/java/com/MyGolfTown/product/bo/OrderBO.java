package com.MyGolfTown.product.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyGolfTown.product.domain.Order;
import com.MyGolfTown.product.mapper.OrderMapper;

@Service
public class OrderBO {

	@Autowired
	private OrderMapper orderMapper;
	
	public int insertOrder(int userId, int productId,String orderName, String orderAddress,String orderPhoneNumber,int price,String paymentMethod) {
		String orderStatus = null;
		if(paymentMethod.equals("no_card")) {
			orderStatus = "입금 대기";
		} else {
			orderStatus = "입금 완료";
		}
		return orderMapper.insertOrder(userId, productId, orderName, orderAddress,orderPhoneNumber,paymentMethod, price, orderStatus);
	}
	
	public Order getOrderById(int id) {
		return orderMapper.selectOrderById(id);
	}
	
}
