package com.safety.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.safety.Dao.IndustryRegistrationDao;
import com.safety.DaoImpl.IndustryRegistrationDaoImpl;
import com.safety.Model.IndustryRegistration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IndRegistration extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uName= req.getParameter("username");
		String email = req.getParameter("email");
		String pwd = req.getParameter("password");
		String cpwd = req.getParameter("cpassword");
		
	 	
	 	
	 	if(pwd.equals(cpwd)) {
	 		
	 		IndustryRegistrationDao impl = new IndustryRegistrationDaoImpl();
	 		
	 		IndustryRegistration indReg = new IndustryRegistration(uName,email,pwd);
	 		impl.insert(indReg);
	 		
	 		String url = "index.jsp";
	 		
	 		PrintWriter pw = resp.getWriter();
	 		pw.println("<script>");
	 		pw.println("alert('Industry Registration Successfull')");
	 		pw.println("window.location.href = '"+ url +"';");
	 		pw.println("</script>");
	 	}
	 	else {
	 		
	 		String url = "index.jsp";
	 		PrintWriter pw = resp.getWriter();
	 		pw.println("<script>");
	 		pw.println("alert('Check password and confirmPassword once again')");
	 		pw.println("window.location.href = '"+ url +"';");
	 		pw.println("</script>");
	 	}
	 	
	 	
		
	}
}
