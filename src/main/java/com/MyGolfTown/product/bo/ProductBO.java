package com.MyGolfTown.product.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyGolfTown.product.domain.Product;
import com.MyGolfTown.product.mapper.ProductMapper;

@Service
public class ProductBO {

	@Autowired
	private ProductMapper productMapper;
	
	public Product getProductById(int Id){
		return productMapper.selectProductById(Id);
	}
	
	public List<Product> getProductByClubId(int clubId){
		return productMapper.selectProductByClubId(clubId);
	}
}
