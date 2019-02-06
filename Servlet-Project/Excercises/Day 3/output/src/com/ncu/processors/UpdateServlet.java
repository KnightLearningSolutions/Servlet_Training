package com.ncu.processors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

 import java.io.IOException;
import java.io.PrintWriter;
  
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;  
import com.mongodb.client.MongoDatabase;  
import com.mongodb.MongoClient;  
import org.bson.*; 
import org.bson.types.ObjectId;
import org.bson.Document;
import org.bson.conversions.Bson;
public class UpdateServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String id=req.getParameter("uname");
		//out.println(id);
		out.println("<form  action='update' method='GET'>");
		out.println("<html><body style='background-color: darkorange;height:200px';>");
		out.println("<head><h1 align='center'><u>Update User Record</u></h1></head>");
		out.print("<table width=30% align='center' border=1>");  
		out.println("<tr><td>Update Mobile</td><td><input type='text' name='mob'></td>");
		out.println("<tr><td>Update Password</td><td><input type='text' name='pass'></td>");
        out.println("<tr><td> id</td><td><input type='hidden' type='text' name='getId' value='"+id+"'></td>");
		out.println("<tr><td>Update Email</td><td><input type='text' name='email'></td></tr>");
		out.println("<tr><td><input type='submit' name='submit' value='submit'><td></tr></form>");
		String mob=req.getParameter("mob");
		String pass=req.getParameter("pass");
		String email=req.getParameter("email");
		String newId=req.getParameter("getId");
		//out.println("New ID"+newId);
        if(!newId.equals(null)){
		try
		{  
		    MongoClient mongoClient = new MongoClient( "localhost" , 27017 );  
			MongoDatabase db = mongoClient.getDatabase("at");  
			MongoCollection<Document> collection = db.getCollection("people");

 
			Document Query = new Document("_id", new ObjectId(newId));

			// Creating Object to update value .
			Document infoObject = new Document("mobile Number", mob);
			infoObject.put("pass",pass);
			infoObject.put("email",email);
			Bson updateObject = new Document("$set", infoObject);

			// update value in collection (people);
			collection.updateOne(Query, updateObject);
			res.sendRedirect("login");
		}
		catch(Exception e)
		{
      out.println("404");
		}
	  }
	  else
	  {
	  	out.println("else");
	  }
	}
}
