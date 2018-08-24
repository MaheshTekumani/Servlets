package com.btm.durga;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String uname=request.getParameter("uname");
			String upwd=request.getParameter("upwd");
			UserService us=new UserService();
			String status=us.checkLogin(uname,upwd);
			out.println("<html>");
			out.println("<body bgcolor='lightblue'>");
			out.println("<center><br><br>");
			out.println("<font color='red' size='7'>");
			if(status.equals("success")){
			out.println("Login Success");
			}
			if(status.equals("failure")){
				out.println("Login Failure");
			}
			out.println("</font></center></body></html>");
			}
			

}
