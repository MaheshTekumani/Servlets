package com.btm.durga;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		String uemail=request.getParameter("uemail");
		String umobile=request.getParameter("umobile");
		UserService us=new UserService();
		String status=us.registration(uname,upwd,uemail,umobile);
		out.println("<html>");
		out.println("<body bgcolor='lightblue'>");
		out.println("<center><br><br>");
		out.println("<font color='red' size='7'>");
		if(status.equals("success")){
		out.println("Registration Success");
		}
		if(status.equals("failure")){
		out.println("Registration Failure");
		}
		if(status.equals("existed")){
		out.println("User Existed Already");
		}
		out.println("</font></center></body></html>");
		}
		
	}


