package com.safety.Controller;

import java.io.IOException;

import com.safety.Dao.IndustryDetailsDao;
import com.safety.Dao.IndustryRequirementDao;
import com.safety.DaoImpl.IndustryDetailsDaoImpl;
import com.safety.DaoImpl.IndustryRequirementDaoImpl;
import com.safety.Model.IndustryDetails;
import com.safety.Model.IndustryRequirement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class IndRequirements extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String indType = req.getParameter("industrytype");
		float minTemp = Float.parseFloat(req.getParameter("mintemp"));
		float maxTemp = Float.parseFloat(req.getParameter("maxtemp"));
		float minCold = Float.parseFloat(req.getParameter("mincold"));
		float maxCold = Float.parseFloat(req.getParameter("maxcold"));
		float minPressure = Float.parseFloat(req.getParameter("minpressure"));
		float maxPressure = Float.parseFloat(req.getParameter("maxpressure"));
		int flexibility = Integer.parseInt(req.getParameter("flexibility"));
		String status = "pending";



		HttpSession session = req.getSession();
		String email = (String) session.getAttribute("userEmail");
		
		try {
			
			IndustryDetailsDao impl = new IndustryDetailsDaoImpl();
			IndustryDetails indDet = impl.fetchOne(email);

			int indId = indDet.getIndustryId();
			session.setAttribute("userId", indId);

			IndustryRequirement indReq = new IndustryRequirement( indId,indType,minTemp,maxTemp,minCold,maxCold,minPressure,maxPressure,flexibility,status,email);
			
			IndustryRequirementDao daoImpl = new IndustryRequirementDaoImpl();
			daoImpl.insert(indReq);
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}


	}
}
