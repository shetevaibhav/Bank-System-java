package bank.datasource;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	
	public static Connection getConnection()
    {
		try
	    {  
	        Class.forName("com.mysql.jdbc.Driver");  
	        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");  
	        System.out.println("connected");
	        return con;
          
	    }
	    catch(Exception e)
	    { 
	        System.out.println(e);
	    }
		return null;
		 
    }

}
