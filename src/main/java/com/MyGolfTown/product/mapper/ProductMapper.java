package com.MyGolfTown.product.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.MyGolfTown.product.domain.Product;

@Mapper
public interface ProductMapper {

	public Product selectProductById(int Id);
	
}
