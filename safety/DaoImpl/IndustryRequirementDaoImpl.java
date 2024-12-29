package com.safety.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.safety.Dao.IndustryRequirementDao;
import com.safety.Model.IndustryRequirement;
import com.safety.Utility.Driver;

public class IndustryRequirementDaoImpl implements IndustryRequirementDao {

	static Connection con;
	static {
		con = Driver.connect();
	}

	private PreparedStatement pstmt;
	
	@Override
	public int insert(IndustryRequirement indReq) {
		String insert = "insert into industryrequirements values(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, indReq.getIndustryId());
			pstmt.setString(2, indReq.getIndustryType());
			pstmt.setFloat(3, indReq.getMinTemp());
			pstmt.setFloat(4, indReq.getMaxTemp());
			pstmt.setFloat(5, indReq.getMinCold());
			pstmt.setFloat(6, indReq.getMaxCold());
			pstmt.setFloat(7, indReq.getMinPressure());
			pstmt.setFloat(8, indReq.getMaxPressure());
			pstmt.setInt(9, indReq.getFlexibility());
			pstmt.setString(10, indReq.getStatus());
			pstmt.setString(11, indReq.getEmail());
			
			return pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public IndustryRequirement fetchOne(String email) {
		
		IndustryRequirement indReq = null;
		String fetchOne = "select * from industryrequirements where email = ?";
		
		try {
			pstmt = con.prepareStatement(fetchOne);
			pstmt.setString(1, email);
			
			ResultSet rr = pstmt.executeQuery();
			while(rr.next()) {
	
			indReq = new IndustryRequirement(rr.getInt("industryId"),rr.getString("industryType"),
						rr.getFloat("minTemp"),rr.getFloat("maxTemp"),
						rr.getFloat("minCold"),rr.getFloat("maxCold"),
						rr.getFloat("minPressure"),rr.getFloat("maxPressure"),
						rr.getInt("flexibility"),rr.getString("status"),rr.getString("email") );
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return indReq;
	}

	@Override
	public List<IndustryRequirement> fetchAll() {
		
		List<IndustryRequirement> al = new ArrayList<IndustryRequirement>();
		String fetchAll = "select * from industryrequirements";
		
		try {
			pstmt = con.prepareStatement(fetchAll);
			ResultSet rr = pstmt.executeQuery();
			
			while(rr.next()) {
				
				IndustryRequirement indReq = new IndustryRequirement(rr.getInt("industryId"),rr.getString("industryType"),
							rr.getFloat("minTemp"),rr.getFloat("maxTemp"),
							rr.getFloat("minCold"),rr.getFloat("maxCold"),
							rr.getFloat("minPressure"),rr.getFloat("maxPressure"),
							rr.getInt("flexibility"),rr.getString("status"),rr.getString("email") );
				al.add(indReq);
				}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return al;
	}

}
