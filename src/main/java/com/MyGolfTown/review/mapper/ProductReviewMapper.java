package com.MyGolfTown.review.mapper;

import org.apache.ibatis.annotations.Param;

import com.MyGolfTown.review.domain.ProductReview;

public interface ProductReviewMapper {

	public void insertProductReivew(
			@Param("userId") int userId,
			@Param("productId") int productId,
			@Param("productId") String reviewText,
			@Param("reviewScore") int reviewScore);
	
	public ProductReview selectProductReviewByProductId(int productId);
}
