package com.MyGolfTown.review.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyGolfTown.review.domain.ProductReview;
import com.MyGolfTown.review.mapper.ProductReviewMapper;

@Service
public class ProductReviewBO {

	@Autowired
	private ProductReviewMapper productReviewMapper;
	
	public void addProductReview(int userId, int productId, String reviewText, int reviewScore) {
		productReviewMapper.insertProductReivew(userId, productId, reviewText, reviewScore);
	}
	
	public ProductReview selectProductReviewByProductId(int productId) {
		return productReviewMapper.selectProductReviewByProductId(productId);
		
	}
	
}
