package com.ncu.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

public class CheckServlet extends HttpServlet{
	  Logger logger;
  
  public CheckServlet()
{
  // initialization of GetLogger to get logger object 
    GetLogger loggerObject=new GetLogger();
    Logger logger=loggerObject.loggerValue("CheckServlet");
    this.logger=logger;

}
public void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{
	logger.info("klssssssssssssssssssssssssssssss");
	
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<html><body style='background-color:darkorange;height:200px';>");
out.println("<head><h1 align='center' style='margin-top:30px;'><u>User LogIn</u></h1></head>");
out.println("<table width=30% style='margin-top:100px;height:200px' align='center' border=1>");  
out.println("<form action='verify'><tr><td>Enter Username</td><td><input type='text' name='name'></td></tr>");
out.println("<tr><td>Enter Password</td><td><input type='password' name='pass'></td></tr></table>");
out.println("<input type='submit' style='color:blue;margin-left:580px;margin-top:30px;width:90px;height:40px;' value='LogIn'></form>");
}
}