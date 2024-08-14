package com.MyGolfTown.review.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.MyGolfTown.review.domain.ProductReview;

@Mapper
public interface ProductReviewMapper {

	public void insertProductReivew(
			@Param("userId") int userId,
			@Param("productId") int productId,
			@Param("productId") String reviewText,
			@Param("reviewScore") int reviewScore);
	
	public List<ProductReview> selectProductReviewByProductId(int productId);
}
