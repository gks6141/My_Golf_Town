package com.MyGolfTown.product.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.MyGolfTown.product.domain.Order;

@Mapper	
public interface OrderMapper {

	public int insertOrder(
			@Param("userId") int userId, 
			@Param("productId") int productId,
			@Param("orderName") String orderName, 
			@Param("orderAddress") String orderAddress,
			@Param("orderPhoneNumber") String orderPhoneNumber,
			@Param("paymentMethod") String paymentMethod,
			@Param("price") int price,
			@Param("orderStatus") String orderStatus);
	
	public Order selectOrderById(int id);
}
