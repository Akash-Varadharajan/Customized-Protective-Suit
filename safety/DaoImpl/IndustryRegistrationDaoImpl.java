package com.safety.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.safety.Dao.IndustryRegistrationDao;
import com.safety.Model.IndustryRegistration;
import com.safety.Utility.Driver;

public class IndustryRegistrationDaoImpl implements IndustryRegistrationDao {
	
	static Connection con;
	static {
		con = Driver.connect();
	}


	private PreparedStatement pstmt;
	

	@Override
	public int insert(IndustryRegistration indReg) {
		
		String insert = "insert into industryregistration values(?,?,?)";
		
		try {
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, indReg.getUserName());
			pstmt.setString(2, indReg.getEmail());
			pstmt.setString(3, indReg.getPassword());
			
			return pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}


	@Override
	public IndustryRegistration fetchOne(String email) {
		
		IndustryRegistration indReg2 = null;
		String fetchOne = "select * from industryregistration where email = ?";
		
		try {
			pstmt = con.prepareStatement(fetchOne);
			pstmt.setString(1, email);
			
			ResultSet rr = pstmt.executeQuery();
			while(rr.next()) {
				
				indReg2 = new IndustryRegistration(rr.getString("userName"),rr.getString("email"), rr.getString("password"));  
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("indReg2 : "+indReg2);
		return indReg2;
	}

}
