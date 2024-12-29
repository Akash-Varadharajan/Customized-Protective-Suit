package com.safety.Dao;

import com.safety.Model.AdminLogin;

public interface AdminLoginDao {
	
	AdminLogin fetchOne(String email);
}
