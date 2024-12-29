package com.safety.Dao;

import com.safety.Model.ManufacturingLogin;

public interface ManufacturingLoginDao {
	
	ManufacturingLogin fetchOne(String email);
}
