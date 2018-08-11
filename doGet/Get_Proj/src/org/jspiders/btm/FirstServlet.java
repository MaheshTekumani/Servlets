package org.jspiders.btm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FirstServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String mno=req.getParameter("mn");
		long mn=Long.parseLong(mno);
		PrintWriter out=resp.getWriter();
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="select * from seja4.person where mobileno=?";
		ResultSet rs=null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=mahesh");
			pstmt=con.prepareStatement(qry);
			pstmt.setLong(1, mn);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String address=rs.getString("address");
			out.println("<html><body>"
					+ "<h1>Id is ="+id+"<br>"
							+ "Name is ="+name+"<br>"
									+ "Address is ="+address+"<br></h1></body></html>");
			
			
			}
		}
		catch(ClassNotFoundException|SQLException e)
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
