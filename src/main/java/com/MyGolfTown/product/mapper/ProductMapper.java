package com.MyGolfTown.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.MyGolfTown.product.domain.Product;

@Mapper
public interface ProductMapper {

	public Product selectProductById(int Id);
	
	public List<Product> selectProductByClubId(int clubId);
	
	
	public List<Product> selectGolfClubProductByUsedClubAndClubType(
			@Param("usedClub") boolean usedClub, 
			@Param("clubType") String clubType);
}
