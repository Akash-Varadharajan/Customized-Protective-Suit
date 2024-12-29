package com.safety.Controller;

import java.io.IOException;
import java.util.List;

import com.safety.DaoImpl.IndustryRequirementDaoImpl;
import com.safety.Model.IndustryRequirement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ViewIndustryRequirement extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			IndustryRequirementDaoImpl impl = new IndustryRequirementDaoImpl();
			List<IndustryRequirement> al = impl.fetchAll();
			
			for(int i = 0; i < al.size() ; i++) {
				
				System.out.println(al.get(i));
			}
			
			HttpSession session = req.getSession();
			session.setAttribute("IndustryRequirements", al);
			String email = (String)session.getAttribute("userEmail");
			
			if(email.equals("admin@gmail.com")) {
				resp.sendRedirect("admin_view_industry_requirement.jsp");
			}
			else {
				resp.sendRedirect("emailMissMatch.jsp");
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
