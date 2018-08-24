package com.btm.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int Id=Integer.parseInt(req.getParameter("id"));
		String pname=req.getParameter("name");
		double price=Double.parseDouble(req.getParameter("price"));
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	Connection con=null;
	PreparedStatement pstmt=null;
	String sqlqry="insert into Product values(?,?,?)";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mahesh?user=root&password=mahesh");
		pstmt=con.prepareStatement(sqlqry);
		pstmt.setInt(1, Id);
		pstmt.setString(2,pname);
		pstmt.setDouble(3, price);
		pstmt.executeUpdate();
		
	} catch (ClassNotFoundException | SQLException e) 
	{
		e.printStackTrace();
	}
	finally
	{
		if(pstmt!=null)
		{
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	}
}
