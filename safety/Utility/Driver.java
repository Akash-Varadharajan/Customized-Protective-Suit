package com.safety.Utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class Driver {
	
	public static Connection con;
	
	public static Connection connect() {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/industry", "root", "javadeveloper");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

}
