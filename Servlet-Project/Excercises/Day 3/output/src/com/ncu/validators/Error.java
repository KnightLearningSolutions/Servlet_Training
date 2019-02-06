package com.ncu.validators;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;

public class Error extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<html><body style='background-color: darkorange';>");
out.println("<head><h1 align='center' style='margin-top:30px;'><u>UserName And Password Incorrect</u></h1></head>");

}
}