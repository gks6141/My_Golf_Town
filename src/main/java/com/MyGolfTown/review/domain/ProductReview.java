package com.MyGolfTown.review.domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ProductReview {
	private int id;
	private int userId;
	private int productId;
	private String reviewText;
	private int reviewScore;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
