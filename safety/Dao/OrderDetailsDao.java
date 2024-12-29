package com.safety.Dao;

import java.util.List;

import com.safety.Model.OrderDetails;

public interface OrderDetailsDao {
	
	int insert(OrderDetails ordDet);
	OrderDetails fetchOne(int indId);
	List<OrderDetails> fetchAll();

}
