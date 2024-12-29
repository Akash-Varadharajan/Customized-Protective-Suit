package com.safety.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.safety.Dao.OrderDetailsDao;
import com.safety.Model.OrderDetails;
import com.safety.Utility.Driver;

public class OrderDetailsDaoImpl implements OrderDetailsDao {

	static Connection con;
	static {
		con = Driver.connect();
	}

	private PreparedStatement pstmt;

	@Override
	public int insert(OrderDetails ordDet) {

		String insert = "insert into orderdetails(industryId,productId,productName,quantity,totalAmount,status) values(?,?,?,?,?,?)";


		try {

			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, ordDet.getIndustryId());
			pstmt.setInt(2, ordDet.getProductId());
			pstmt.setString(3, ordDet.getProductName());
			pstmt.setInt(4, ordDet.getQuantity());
			pstmt.setInt(5, ordDet.getTotalAmount());
			pstmt.setString(6, ordDet.getStatus());
			return pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public OrderDetails fetchOne(int indId) {

		OrderDetails ordDet = null;
		String fetchOne = "select * from orderdetails where industryId = ?";

		try {
			pstmt = con.prepareStatement(fetchOne);
			pstmt.setInt(1, indId);
			ResultSet rr = pstmt.executeQuery();
			while(rr.next()) {

				ordDet = new OrderDetails( rr.getInt("orderId"),rr.getInt("industryId"),rr.getInt("productId"),
						rr.getString("productName"),rr.getInt("quantity"),rr.getInt("totalAmount"),rr.getString("status"));
			}
			return ordDet;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OrderDetails> fetchAll() {

		List<OrderDetails> al = new ArrayList<OrderDetails>();
		String fetchAll = "select * from orderdetails";

		try {
			Statement stmt = con.createStatement();
			ResultSet rr = stmt.executeQuery(fetchAll);

			while(rr.next()) {

				OrderDetails ordDet = new OrderDetails( rr.getInt("orderId"),rr.getInt("industryId"),rr.getInt("productId"),
						rr.getString("productName"),rr.getInt("quantity"),rr.getInt("totalAmount"),rr.getString("status"));
				al.add(ordDet);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}



}
