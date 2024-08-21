package com.MyGolfTown.productlist.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyGolfTown.golf.bo.GolfClubBO;
import com.MyGolfTown.golf.bo.GolfEquipmentBO;
import com.MyGolfTown.golf.domain.GolfClub;
import com.MyGolfTown.golf.domain.GolfEquipment;
import com.MyGolfTown.product.bo.ProductBO;
import com.MyGolfTown.product.domain.Product;
import com.MyGolfTown.productlist.domain.ProductList;

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
		
		List<Product> products = productBO.getProduct();
		
		//채의 종류랑 usedclub에 해당하는 애들만 가져와야됨
		
		for(Product product : products) {
			ProductList oneProduct = new ProductList();

			//해당 clubId 의 사진이랑 가격을 가져와야해
			GolfClub club = golfClubBO.getGolfClubByIdUsedClubClubType(product.getClubId(), usedClub, clubType);
			if(club == null) {
				continue;
			} else {
				oneProduct.setProduct(product);
				
				oneProduct.setGolfClub(club);
				
				productList.add(oneProduct);
			}
		}
		
		return productList;
		
	}
	
	public List<ProductList> generateProductListEquipment(String equipmentType){
		List<ProductList> productList = new ArrayList<>();
		
		List<Product> products = productBO.getProduct();
		
		//채의 종류랑 usedclub에 해당하는 애들만 가져와야됨
		
		for(Product product : products) {
			ProductList oneProduct = new ProductList();

			//해당 clubId 의 사진이랑 가격을 가져와야해
			GolfEquipment equipment = golfEquipmentBO.getGolfEquipmentByIdEquipmentType(product.getEquipmentId(), equipmentType);
			if(equipment == null) {
				continue;
			} else {
				oneProduct.setProduct(product);
				
				oneProduct.setGolfEquipment(equipment);
				
				productList.add(oneProduct);
			}
		}
		
		return productList;
		
	}
	
}
