package com.ncu.validators;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;

import java.io.IOException;
import com.mongodb.*;
import com.mongodb.DB;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;  
import com.mongodb.client.MongoCollection;  
import com.mongodb.client.MongoDatabase;  
import org.bson.types.ObjectId;
public class Verify extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
String name=req.getParameter("name");
String pass=req.getParameter("pass");
String name1="";
String pass1="";
 try
{
  MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
  DB db = mongoClient.getDB("at");
            DBCollection collection = db.getCollection("people");
            DBCursor dbo = collection.find();
  while(dbo.hasNext())
  {
           DBObject dbq=dbo.next();
       name1=(String) dbq.get("name");
       pass1=(String) dbq.get("pass");
       
}
if(name.equalsIgnoreCase(name1) && pass.equalsIgnoreCase(pass1))
{
	res.sendRedirect("login");
}
else
{
	res.sendRedirect("error");
}
}
catch(Exception e)
{
	out.println(e);
}
}
}