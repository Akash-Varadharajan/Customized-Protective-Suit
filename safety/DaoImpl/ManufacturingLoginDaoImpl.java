package com.safety.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.safety.Dao.ManufacturingLoginDao;
import com.safety.Model.ManufacturingLogin;
import com.safety.Utility.Driver;

public class ManufacturingLoginDaoImpl implements ManufacturingLoginDao {
	
	static Connection con;
	static {
		con = Driver.connect();
	}

	@Override
	public ManufacturingLogin fetchOne(String email) {
		ManufacturingLogin manLog = null;
		String fetchOne = "select * from manufacturinglogin where email = ?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(fetchOne);
			
			pstmt.setString(1, email);
			ResultSet rr = pstmt.executeQuery();
			
			while(rr.next()) {
				manLog = new ManufacturingLogin(rr.getString("email"),rr.getString("password"));
			}
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return manLog;
	}

}
