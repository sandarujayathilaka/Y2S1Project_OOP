package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.FuelManDButil;



@WebServlet("/insertFuelMan")
public class insertFuelMan extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String tel =request.getParameter("tel");
		String address = request.getParameter("address");
		String password =request.getParameter("password");
		String nic =request.getParameter("nic");
		String marit =request.getParameter("marit");
		
		
	boolean isTrue = FuelManDButil.insertFuelmanager(id,name, tel, address,password,nic,marit);
		
		if(isTrue ==true) {
			RequestDispatcher dis = request.getRequestDispatcher("FuelManAllServlet");//redirect to FuelManagerAll servlet
			dis.forward(request, response);		
		}
		
		else {
			RequestDispatcher dis = request.getRequestDispatcher("notcompleted.jsp");
			dis.forward(request, response);	
			
		}
		
		
		
	}

}
