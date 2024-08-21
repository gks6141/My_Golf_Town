package com.MyGolfTown.productlist.domain;

import com.MyGolfTown.golf.domain.GolfClub;
import com.MyGolfTown.golf.domain.GolfEquipment;
import com.MyGolfTown.product.domain.Product;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ProductList {

	private Product product;
	private GolfClub golfClub;
	private GolfEquipment golfEquipment;
}
