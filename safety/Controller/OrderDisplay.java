package com.safety.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.safety.Dao.OrderDetailsDao;
import com.safety.DaoImpl.OrderDetailsDaoImpl;
import com.safety.Model.OrderDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class OrderDisplay extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			OrderDetailsDao impl = new OrderDetailsDaoImpl();
			List<OrderDetails> al = impl.fetchAll();
			
			HttpSession session = req.getSession();
			session.setAttribute("OrdersList", al);
			
			PrintWriter pw = resp.getWriter();
			resp.sendRedirect("industry_orders_details.jsp");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
