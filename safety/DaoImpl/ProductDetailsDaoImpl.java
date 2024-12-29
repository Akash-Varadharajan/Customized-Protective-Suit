package com.safety.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.safety.Dao.ProductDetailsDao;
import com.safety.Model.ProductDetails;
import com.safety.Utility.Driver;

public class ProductDetailsDaoImpl implements ProductDetailsDao {
	
	static Connection con;
	static {
		con = Driver.connect();
	}
	
	@Override
	public int insert(ProductDetails prdDet) {
		
		String insert = "insert into productdetails values(?,?,?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, prdDet.getProductId());
			pstmt.setString(2, prdDet.getProductName());
			pstmt.setInt(3, prdDet.getProductPrice());
			return pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<ProductDetails> fetchAll() {
		List<ProductDetails> al = new ArrayList<ProductDetails>();
		
		String fetchAll = "select * from productdetails";
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rr = stmt.executeQuery(fetchAll);
			
			while(rr.next()) {
				
				ProductDetails prdDet = new ProductDetails(rr.getInt("productId"),
						rr.getString("productName"),rr.getInt("productPrice"));
				
				al.add(prdDet);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return al;
	}

}
