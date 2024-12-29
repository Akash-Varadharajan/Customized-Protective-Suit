package com.safety.Dao;

import java.util.List;

import com.safety.Model.ProductDetails;

public interface ProductDetailsDao {
	
	int insert(ProductDetails prdDet);
	List<ProductDetails> fetchAll();
}
