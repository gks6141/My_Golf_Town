package com.MyGolfTown.product.domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Product {
	private int id;
	private Integer clubId;
	private Integer equipmentId;
	private String productSubject;
	private String productInformationText;
	private String productInformationImagePath;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
