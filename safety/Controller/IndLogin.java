package com.safety.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.safety.Dao.AdminLoginDao;
import com.safety.Dao.IndustryRegistrationDao;
import com.safety.Dao.ManufacturingLoginDao;
import com.safety.DaoImpl.AdminLoginDaoImpl;
import com.safety.DaoImpl.IndustryRegistrationDaoImpl;
import com.safety.DaoImpl.ManufacturingLoginDaoImpl;
import com.safety.Model.AdminLogin;
import com.safety.Model.IndustryRegistration;
import com.safety.Model.ManufacturingLogin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class IndLogin extends HttpServlet {



	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("loginemail");
		String role = request.getParameter("role");
		String password = request.getParameter("loginpassword");


		
		if(role.equals("ind")) {

			IndustryRegistrationDao impl = new IndustryRegistrationDaoImpl();
			
			 IndustryRegistration indReg = impl.fetchOne(email);

			String dbEmail = indReg.getEmail();
			String dbPwd = indReg.getPassword();

			if(email.equals(dbEmail) || password.equals(dbPwd)) {
				
				
				HttpSession session = request.getSession();
				session.setAttribute("userEmail", email);
				
				String url = "industryHome.jsp";

				PrintWriter pr = response.getWriter();
				pr.println("<script>");
				pr.println("alert('Industry Login Successfull')");
				pr.println("window.location.href = '"+ url +"';");
				pr.println("</script>");
			}
			
			else {
				PrintWriter pr = response.getWriter();
				pr.println("email & password not matched");
			}



			//			RequestDispatcher rd = request.getRequestDispatcher("industryHome.jsp");
			//			rd.forward(request, response);
		}

		else if(role.equals("ad")) {

			AdminLoginDao impl = new AdminLoginDaoImpl();
			AdminLogin adLog = impl.fetchOne(email);

			String dbEmail = adLog.getEmail();

			if(email.equals(dbEmail)) {
				
				HttpSession session = request.getSession();
				session.setAttribute("userEmail", email);

				String url = "adminHome.jsp";

				PrintWriter pr = response.getWriter();
				pr.println("<script>");
				pr.println("alert('Admin Login Successfull')");
				pr.println("window.location.href = '"+ url +"';");
				pr.println("</script>");

			}
		}

		else if(role.equals("manu")) {
			
			ManufacturingLoginDao impl = new ManufacturingLoginDaoImpl();
			ManufacturingLogin manLog = impl.fetchOne(email);
			
			String dbEmail = manLog.getEmail();
			if(email.equals(dbEmail)) {
				
				String url = "manufacturingHome.jsp";

				PrintWriter pr = response.getWriter();
				pr.println("<script>");
				pr.println("alert('Manufacturing Login Successfull')");
				pr.println("window.location.href = '"+ url +"';");
				pr.println("</script>");
				
			}
		}

		else {
			response.sendRedirect("wrongEmailPass.jsp");
		}


	}

}
