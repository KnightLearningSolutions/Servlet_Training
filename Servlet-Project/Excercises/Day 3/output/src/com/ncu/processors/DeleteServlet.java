package com.ncu.processors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
 
import java.io.PrintWriter;
import java.io.IOException;

import org.bson.types.ObjectId;
import com.mongodb.client.MongoCollection;  
import com.mongodb.client.MongoDatabase; 
import com.mongodb.DBCollection;
import com.mongodb.MongoClient; 
import org.bson.Document; 
import com.mongodb.client.MongoCollection;  
public class DeleteServlet extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
String str=req.getParameter("uname");

out.println(str);
try
{
	
  MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	     MongoDatabase db = mongoClient.getDatabase("at");
MongoCollection<Document> collection = db.getCollection("people");
     collection.deleteOne(new Document("_id", new ObjectId(str)));
     out.println("Record Deleted");
	
    res.sendRedirect("login");


	}
	catch(Exception e)
	{
     out.println("Exception");
	}
}
}