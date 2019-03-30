package com.caps.dev.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class ThirdStep {
	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;

		try
		{
			//Loads the Driver Class
			java.sql.Driver driver = (java.sql.Driver)Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);

			//Estb. the db connection via Driver
			String dburl = "jdbc:mysql://localhost:3306/capsjava_db";
			FileReader reader = new FileReader("C:/Users/suyash/Desktop/Test/db_credential.properties");
			Properties prop = new Properties();
			prop.load(reader);
			con = DriverManager.getConnection(dburl,prop);

			//Issue the Sql Query via Connection
			String query = "insert into ipl_table values(3,'MI','SharmaJi',3)";
			stmt = con.createStatement();
			int count = stmt.executeUpdate(query);

			if(count>0)
			{
				System.out.println("Data Added Successfully..........");
			}
			else
			{
				System.out.println("Something Went Wrong");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception.............");
		}finally
		{

		}



	}
}
