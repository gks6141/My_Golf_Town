package com.MyGolfTown.product.domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Order {
	private int id;
	private int userId;
	private int productId;
	private String orderName;
	private String orderPhoneNumber;
	private String orderAddress;
	private String paymentMethod;
	private String orderStatus;
	private int price;
	private int invoiceNumber;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
