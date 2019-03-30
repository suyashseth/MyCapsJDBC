package com.caps.dev.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the driver class");
//		String driverClass = sc.next();
//		System.out.println("Enter Username");
//		String user = sc.next();
//		System.out.println("Enter Password");
//		String pass = sc.next();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try
		{

//			java.sql.Driver driver = (java.sql.Driver)Class.forName(driverClass).newInstance();
//			DriverManager.registerDriver(driver);

			/*Driver d= new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);*/

//			//EStb the conn via Driver
//			String url = "jdbc:mysql://localhost:3306/capsjava_db?user=root&password=root";
////		con = DriverManager.getConnection(url);
//			con = DriverManager.getConnection(url,user,pass);
//					
			//Step:2 - Estb the Connection via Driver
			String dburl = "jdbc:mysql://localhost:3306/capsjava_db";
			FileReader fr = new FileReader("C:/Users/suyash/Desktop/Test/db_credential.properties");
			Properties prop = new Properties();
			prop.load(fr);
			con = DriverManager.getConnection(dburl,prop);


			String query = "Select * from ipl_table";
			stmt = con.createStatement();
			//System.out.println("Statement Impl Class =====> "+stmt.getClass());
			rs = stmt.executeQuery(query);

			while(rs.next())
			{
				int sno = rs.getInt("s_no");
				String name = rs.getString("name");
				String cap = rs.getString("captain");
				int points = rs.getInt("points");

				System.out.println(sno);
				System.out.println(name);
				System.out.println(cap);
				System.out.println(points);
				System.out.println("********************");

			}

		}catch(Exception e)
		{
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
		finally
		{

		}
















	}
}
