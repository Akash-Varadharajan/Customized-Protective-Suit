package com.safety.Dao;

import java.util.List;

import com.safety.Model.IndustryRequirement;

public interface IndustryRequirementDao {
	
	int insert(IndustryRequirement indReq);
	IndustryRequirement fetchOne(String email);
	List<IndustryRequirement> fetchAll();
}
