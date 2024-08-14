package com.MyGolfTown.review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MyGolfTown.review.bo.ProductReviewBO;
import com.MyGolfTown.review.domain.ProductReview;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/product")
@RestController
public class ProductReviewRestController {

	@Autowired
	private ProductReviewBO productReviewBO;
	
	@PostMapping("/review-insert")
	public Map<String, Object> reviewInsert(
			@RequestParam("productId") int productId,
			@RequestParam(value="reviewText", required = false) String reviewText,
			@RequestParam("reviewScore") int reviewScore,
			HttpSession session){
		
		Map<String, Object> result = new HashMap<>();
		
		Integer userId = (Integer)session.getAttribute("userId");
		
		if(userId != null) {
			productReviewBO.addProductReview(userId, productId, reviewText, reviewScore);
			
			result.put("code", 200);
			result.put("result", "성공");	
		} else {
			result.put("code", 500);
			result.put("result", "로그인 부탁드립니다.");	
		}
		
		return result;
	}
	
	@GetMapping("review-select-productId")
	public Map<String,Object> reviewSelectProductId(
			@RequestParam("productId") int productId){
		List<ProductReview> review = productReviewBO.selectProductReviewByProductId(productId);
		Map<String, Object> result = new HashMap<>();
		
		if(review != null) {
			result.put("code", 200);
			result.put("result", "성공");	
		} else {
			result.put("code", 500);
			result.put("result", "조회된 리뷰가 없습니다.");	
		}
		
		return result;
	}
	
	
}
