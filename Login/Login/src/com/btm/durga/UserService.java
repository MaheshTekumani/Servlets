package com.btm.durga;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserService {
	Connection con;
	Statement st;
	ResultSet rs;
	String status="";
	public UserService() {
	try {
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root","mahesh");
	st=con.createStatement();
	} 
	catch (Exception e) {
	e.printStackTrace();
	}
	}
	public String checkLogin(String uname, String upwd){
	try {
	rs=st.executeQuery("select * from mahesh.reg_Users where uname='"+uname+"' and upwd='"+upwd+"'");
	boolean b=rs.next();
	if(b==true){
		status="success";
		}else{
		status="failure";
		}
		} catch (Exception e) {
		}
		return status;
		}
		public String registration(String uname, String upwd, String uemail, String umobile){
		try {
		rs=st.executeQuery("select * from mahesh.reg_Users where uname='"+uname+"'");
		boolean b=rs.next();
		if(b==true)
		{
		status="existed";
		}
		else{
		st.executeUpdate("insert into mahesh.reg_Users	values('"+uname+"','"+upwd+"','"+uemail+"','"+umobile+"')");
		status="success";
		}
		
		} catch (Exception e) {
		status="failure";
		e.printStackTrace();
		}
		return status;
		}
}
