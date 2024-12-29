package com.safety.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.safety.Dao.AdminLoginDao;
import com.safety.Dao.IndustryDetailsDao;
import com.safety.DaoImpl.AdminLoginDaoImpl;
import com.safety.DaoImpl.IndustryDetailsDaoImpl;
import com.safety.Model.AdminLogin;
import com.safety.Model.IndustryDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ViewIndustryDetails extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IndustryDetailsDao daoImpl = new IndustryDetailsDaoImpl();
		List<IndustryDetails> al = daoImpl.fetchAll();
		
		
		
		HttpSession session = req.getSession();
		session.setAttribute("IndustryDetailsList", al);
		
		String email = (String)session.getAttribute("userEmail");
		System.out.println("Email : "+email);
		
		
		AdminLoginDao impl = new AdminLoginDaoImpl();
		AdminLogin adLog = impl.fetchOne(email);
		
		System.out.println("AdminLogin : "+adLog);
		String dbEmail = adLog.getEmail();
		
		
		
		System.out.println("dbEmail : "+dbEmail);
		
		System.out.println("from ViewIndustryRequirements Servlet");
		if(email.equals(dbEmail)) {
			
			resp.sendRedirect("admin_view_industry_details.jsp");
		}
		else {
			
			String url = "adminHome.jsp";
			PrintWriter pw = resp.getWriter();
			pw.println("<script>");
			pw.println("alert('Sorry, Somethig went wrong!')");
			pw.println("windows.location.href= '"+url+"';" );
			pw.println("</script>");
		}
		
		
		
	}
}
