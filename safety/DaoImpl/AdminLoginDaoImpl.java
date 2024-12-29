package com.safety.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.safety.Dao.AdminLoginDao;
import com.safety.Model.AdminLogin;
import com.safety.Utility.Driver;

public class AdminLoginDaoImpl implements AdminLoginDao {
	
	static Connection con;
	static {
		con = Driver.connect();
	}

	@Override
	public AdminLogin fetchOne(String email) {
		
		AdminLogin admLog = null;
		String fetchOne = "select * from adminlogin where email = ?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(fetchOne);
			pstmt.setString(1, email);
			
			ResultSet rr = pstmt.executeQuery();
			
			while(rr.next()) {
				
				admLog = new AdminLogin(rr.getString("email"),rr.getString("password"));
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return admLog;
	}

}
