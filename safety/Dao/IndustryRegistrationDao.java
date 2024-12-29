package com.safety.Dao;

import com.safety.Model.IndustryRegistration;

public interface IndustryRegistrationDao {
	
	int insert(IndustryRegistration indReg);
	IndustryRegistration fetchOne(String email);
}
