package com.MyGolfTown.productist.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyGolfTown.golf.bo.GolfClubBO;
import com.MyGolfTown.golf.bo.GolfEquipmentBO;
import com.MyGolfTown.golf.domain.GolfClub;
import com.MyGolfTown.product.bo.ProductBO;
import com.MyGolfTown.product.domain.Product;
import com.MyGolfTown.productist.domain.ProductList;

@Service
public class ProductListBO {
	@Autowired
	private GolfClubBO golfClubBO;
	
	@Autowired
	private GolfEquipmentBO golfEquipmentBO;
	
	@Autowired
	private ProductBO productBO;
	
	public List<ProductList> generateProductList(boolean usedClub , String clubType){
		List<ProductList> productList = new ArrayList<>();
		
		List<Product> products = productBO.getGolfClubProductByUsedClubAndClubType(usedClub, clubType);
		
		for(Product product : products) {
			ProductList oneProduct = new ProductList();
			
			oneProduct.setProduct(product);
			
			GolfClub club = golfClubBO.getGolfClubById(product.getClubId());
			
			oneProduct.setGolfClub(club);
			
			productList.add(oneProduct);
		}
		
		return productList;
		
	}
	
}
