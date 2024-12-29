package com.safety.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.safety.Dao.IndustryDetailsDao;
import com.safety.Dao.OrderDetailsDao;
import com.safety.DaoImpl.IndustryDetailsDaoImpl;
import com.safety.DaoImpl.OrderDetailsDaoImpl;
import com.safety.Model.IndustryDetails;
import com.safety.Model.OrderDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class OrdDetails extends HttpServlet {
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String email = (String) session.getAttribute("userEmail");
		
		try {
			IndustryDetailsDao impl = new IndustryDetailsDaoImpl();
			IndustryDetails indDeta = impl.fetchOne(email);
			int iId = indDeta.getIndustryId();
			int pId = Integer.parseInt(req.getParameter("productid"));
			String pName = req.getParameter("productname");
			int qty = Integer.parseInt(req.getParameter("quntity"));
			int totAmt = Integer.parseInt(req.getParameter("totalAmount"));
			String status = "pending";

			OrderDetails order = new OrderDetails(iId,pId,pName,qty,totAmt,status);
			
			OrderDetailsDao ordDet = new OrderDetailsDaoImpl();
			if(ordDet.insert(order) == 1) {
				
				String url = "industryHome.jsp";
				PrintWriter pw = resp.getWriter();	
				pw.println("<script>");
				pw.println("alert('Order Placed Successfully')");
				pw.println("window.location.href='"+url+"';");
				
				pw.println("</script>");
				
			}
			else {
				String url = "industryHome.jsp";
				
				PrintWriter pw = resp.getWriter();	
				pw.println("<script>");
				pw.println("alert('Something went wrong! try again.')");
				pw.println("window.location.href='"+url+"';");
				pw.println("</script>");
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
