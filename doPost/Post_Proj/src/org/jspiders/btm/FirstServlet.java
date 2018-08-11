package org.jspiders.btm;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class FirstServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String sid=req.getParameter("i");
	int id=Integer.parseInt(sid);
	String sname=req.getParameter("nm");
	String sdep=req.getParameter("dp");
	String sper=req.getParameter("pr");
	double per=Double.parseDouble(sper);
	PrintWriter out=resp.getWriter();
	Connection con=null;
	PreparedStatement pstmt=null;
	String qry="insert into student values(?,?,?,?)";
	try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mahesh?user=root&password=mahesh");
		pstmt= con.prepareStatement(qry);
		pstmt.setInt(1, id);
		pstmt.setString(2, sname);
		pstmt.setString(3,sdep);
		pstmt.setDouble(4,per);
		pstmt.executeUpdate();	
		out.println("<html><body bgcolor='yellow'>"
				+ "<h2>id :"+id+"<br>"
						+ "name :"+sname+""
								+ "<br>"
								+ "department :"+sdep+""
										+ "<br>"
										+ "percentage :"+per+"</h2></body></html>");
	}catch(ClassNotFoundException|SQLException e)
	{
		System.out.println(e);
	}finally
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
