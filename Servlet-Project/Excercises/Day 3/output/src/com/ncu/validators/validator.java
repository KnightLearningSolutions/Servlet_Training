package com.ncu.validators;
import com.ncu.exceptions.*;

public class validator{
	
	public boolean validate(String name,String mob,String pass,String email)
	{
		try
		{
      validator obj=new validator();
      obj.empty(name,mob,pass,email);
       }
      catch(InvalidData e)
      {
      	return false;
      }
      return true;
	}
   
   void empty(String name,String mob,String pass,String email) throws InvalidData
   { 
   	if(name.equals(null) || mob.equals(null) || pass.equals(null) || email.equals(null))
       {
    throw new InvalidData("Data Not Complete");
      }
   }
}