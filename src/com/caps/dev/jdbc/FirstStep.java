package com.caps.dev.jdbc;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
public class FirstStep {
	
	public static void main(String[] args) {
		
		    Connection con = null;
		    Statement stmt = null;
		
		try {
			//Step:1 - Loads the driver class
			/*java.sql.Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);*/
			String name = "com.mysql.jdbc.Driver";
			java.sql.Driver d = (java.sql.Driver)Class.forName(name).newInstance();
			DriverManager.registerDriver(d);
			
			//Step:2 - Estb the Connection via Driver
			String dburl = "jdbc:mysql://localhost:3306/capsjava_db";
			FileReader fr = new FileReader("C:/Users/suyash/Desktop/Test/db_credential.properties");
			Properties prop = new Properties();
			prop.load(fr);
			con = DriverManager.getConnection(dburl,prop);
			
			//Step:3 - Issue the SQL Query via Connection
			String query = "Select * from ipl_table";
			stmt = con.createStatement();
			stmt.executeQuery(query);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}catch(Exception e)
		{
		}
		finally
		{
		}
	}
}
