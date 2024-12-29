package com.safety.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.safety.Dao.IndustryDetailsDao;
import com.safety.Dao.IndustryRegistrationDao;
import com.safety.DaoImpl.IndustryDetailsDaoImpl;
import com.safety.DaoImpl.IndustryRegistrationDaoImpl;
import com.safety.Model.IndustryDetails;
import com.safety.Model.IndustryRegistration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class IndDetails extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String indType = req.getParameter("industrytype");
		String indName = req.getParameter("industryname");
		String loc = req.getParameter("location");
		String phNo = req.getParameter("phonenumber");
		int noOfEmp =Integer.parseInt(req.getParameter("noe"));
		String webUrl = req.getParameter("weburl");
		
		

		HttpSession session = req.getSession();
		String email = (String)session.getAttribute("userEmail");
		
		
		
		System.out.println("Email from IndDetails servlet : "+email);
		

		IndustryRegistrationDao impl = new IndustryRegistrationDaoImpl();
		IndustryRegistration indReg = impl.fetchOne(email);

		String dbEmail = indReg.getEmail();
		if(email.equals(dbEmail)) {

			IndustryDetails indDetails = new IndustryDetails(indType,indName,loc,phNo,noOfEmp,webUrl,email);

			IndustryDetailsDao daoImpl = new IndustryDetailsDaoImpl();
			daoImpl.insert(indDetails);
//			IndustryDetails indDet = daoImpl.fetchOne(email);
//
//		    int indId = indDet.getIndustryId();

			String url = "industryHome.jsp";

			PrintWriter pw = resp.getWriter();
			pw.println("<script>");
			pw.println("alert('Industry details registered Successfully')");
			//pw.println("alert(your Industry Id is : )'"+ indId +"';");
			pw.println("window.location.href = '"+ url +"';");
			pw.println("</script>");

		}
		else {
			String url = "industryHome.jsp";

			PrintWriter pw = resp.getWriter();
			pw.println("<script>");
			pw.println("alert('Wrong email please enter again')");
			pw.println("window.location.href = '"+ url +"';");
			pw.println("</script>");
		}

	}








}
