package com.ncu.validators;
import com.ncu.exceptions.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import com.ncu.exceptions.*;
import java.io.IOException;
import java.io.PrintWriter;

import java.io.IOException;
public class AddVerify extends HttpServlet
{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{
	res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<form  action='add' method='GET'>");
out.println("<html><body style='background-color: darkorange';> ");
out.println("<head><h1 align='center' style='margin-top:30px;' ><u>Add User</u></h1></head>");
out.print("<table align='center' style='margin-top:70px;height:300px;' border=1>");  
out.println("<tr><td>Name</td><td><input type='text' name='uname'></td></tr>");
out.println("<tr><td>Mobile No</td><td><input type='text' name='mob' ></td></tr>");
out.println("<tr><td>Password</td><td><input type='password' name='pass'></td></tr>");
out.println("<tr><td>Email</td><td><input type='text' name='email'></td></tr></table>");
 out.println("<input type='submit' align='center' style='margin-left:630;width:90px;height:40px;margin-top:30px;' value='submit'>");
	
String str=req.getParameter("uname");
String str2=req.getParameter("mob");
String str1=req.getParameter("pass");
String str3=req.getParameter("email");

try
{
	AddVerify(str,str2,str1,str3);
}	
catch(Exception e)
{
	out.println("Exception Occured"+e);
	//res.sendRedirect("error");
}

}
static void AddVerify(String uname,String mob,String pass,String email) throws InvalidData
{
if(uname.equals(null) || mob.equals(null) || pass.equals(null) || email.equals(null))
{
//	out.println("thisssssss"+"---"+uname);
    throw new InvalidData("Data Not Complete");
}
}
}

