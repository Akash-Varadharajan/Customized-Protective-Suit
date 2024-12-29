package com.safety.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.safety.Dao.IndustryDetailsDao;
import com.safety.Model.IndustryDetails;
import com.safety.Utility.Driver;

public class IndustryDetailsDaoImpl implements IndustryDetailsDao {

	public static Connection con;
	static {
		con = Driver.connect();
	}

	private PreparedStatement pstmt;

	@Override
	public int insert(IndustryDetails indDet) {

		String insert = "insert into industrydetails(industryType,industryName,location,phoneNo,noOfEmp,webUrl,industryEmail ) values(?,?,?,?,?,?,?)"; 

		try {
			pstmt = con.prepareStatement(insert);
			
			pstmt.setString(1, indDet.getIndustryType());
			pstmt.setString(2, indDet.getIndustryName());
			pstmt.setString(3, indDet.getLocation());
			pstmt.setString(4, indDet.getPhoneNo());
			pstmt.setInt(5, indDet.getNoOfEmp());
			pstmt.setString(6, indDet.getWebUrl());
			pstmt.setString(7, indDet.getEmail());
			
			return pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public IndustryDetails fetchOne(String email) {

		IndustryDetails indDet = null;
		String fetchOne = "select * from industrydetails where industryEmail = ?";

		try {
			pstmt = con.prepareStatement(fetchOne);
			pstmt.setString(1, email);
			ResultSet rr = pstmt.executeQuery();
			while(rr.next()) {

				indDet = new IndustryDetails(rr.getInt("industryId"),rr.getString("industryType"),rr.getString("industryName"),rr.getString("location"),rr.getString("phoneNo"),rr.getInt("noOfEmp"),rr.getString("webUrl"),rr.getString("industryEmail"));                               
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return indDet;
	}

	@Override
	public List<IndustryDetails> fetchAll() {
		
		List<IndustryDetails> al= new ArrayList<IndustryDetails>();
		
		String fetchAll = "select * from industrydetails";
		try {
			Statement stmt = con.createStatement();
			ResultSet rr = stmt.executeQuery(fetchAll);

			while(rr.next()) {
				
				IndustryDetails indDet = new IndustryDetails(rr.getInt("industryId"),
						rr.getString("industryType"),rr.getString("industryName"),
						rr.getString("location"),rr.getString("phoneNo"),rr.getInt("noOfEmp"),
						rr.getString("webUrl"),rr.getString("industryEmail"));   
				
				al.add(indDet);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}
















}
