package com.ncu.processors;

import com.mongodb.client.MongoCollection;  
import com.mongodb.client.MongoDatabase; 
import com.mongodb.DBCollection;
import com.mongodb.MongoClient; 
public class ConnectionDb
{

	public static MongoCollection getConnection()
	{
	MongoCollection con=null;
	try
{
	MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	MongoDatabase db = mongoClient.getDatabase("at");
            MongoCollection collection = db.getCollection("people");
	}
catch(Exception e)
{
	}
return con;
	
}
}