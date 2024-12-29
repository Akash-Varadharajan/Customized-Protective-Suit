package com.safety.Dao;

import java.util.List;

import com.safety.Model.IndustryDetails;

public interface IndustryDetailsDao {
	
	int insert(IndustryDetails indDet);
	IndustryDetails fetchOne(String email);
	List<IndustryDetails> fetchAll();
}
