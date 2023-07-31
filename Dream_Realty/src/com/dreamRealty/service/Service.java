package com.dreamRealty.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dreamRealty.database.DreamRealtyDAO;
import com.dreamRealty.model.Property;

public class Service {
	public Connection getConnection()
	{
		DreamRealtyDAO dao=new DreamRealtyDAO();
		return dao.createConnection();
	}
	
	public void DropTable() throws SQLException
	{
		Connection conn=getConnection();
		if(conn==null)
		{
			System.out.println("Could not able to establish connection for given operation.");
		}
		Statement stmt = conn.createStatement();
		String dropTableCommand="DROP TABLE IF EXISTS PROPERTIES";
		stmt.executeUpdate(dropTableCommand);
        System.out.println("Table dropped successfully...");
	}
	
	// Will create table name properties if table doesn't exist
	public void createTableProperties() throws SQLException
	{
		Connection conn=getConnection();
		if(conn==null)
		{
			System.out.println("Could not able to establish connection for given operation.");
		}
		Statement stmt = conn.createStatement();
		String createTableCommand ="CREATE TABLE IF NOT EXISTS Properties (\r\n"
				+ "    Id int NOT NULL AUTO_INCREMENT,\r\n"
				+ "    AgentName varchar(255),\r\n"
				+ "    AskingPrice double(30,3),\r\n"
				+ "    Region varchar(255),\r\n"
				+ "    Type varchar(255),\r\n"							
				+ "    ClosingDate date,\r\n"
				+ " Primary key(Id));";
	         stmt.executeUpdate(createTableCommand);
	         System.out.println("Table created successfully...");
	}
	
	public void insertInitialData() throws SQLException
	{
		Connection conn=getConnection();
		if(conn==null)
		{
			System.out.println("Could not able to establish connection for given operation.");
		}
		Statement stmt = conn.createStatement();
		String insertCommand ="INSERT INTO properties (AgentName,AskingPrice,Region,Type,ClosingDate) VALUES \r\n"
				+ "  ('Ashita',250000,'Ontario',\"Detached\",\"2023-09-01\"),\r\n"
				+ "  ('John',300000,'Ontario',\"Detached\",\"2023-10-01\"),\r\n"
				+ "  ('Janice',290000,'Manitoba',\"Detached\",\"2023-12-01\"),\r\n"
				+ "  ('Harshal',400000,'Alberta',\"Detached\",\"2024-01-01\"),\r\n"
				+ "  ('Keshav',340000,'Alberta',\"Detached\",\"2024-09-01\"),\r\n"
				+ "  ('Randeep',290000,'Ontario',\"Detached\",\"2023-09-28\");";
	         stmt.executeUpdate(insertCommand);
	         System.out.println("records inserted successfully...");
	}
	
	public void displayAllRecords() throws SQLException
	{   
		Connection conn=getConnection();
		if(conn==null)
		{
			System.out.println("Could not able to establish connection for given operation.");
		}
		ResultSet rs = null;
		Statement stmt = conn.createStatement();
		String selectCommand ="SELECT * FROM PROPERTIES;";
		
		try {
			rs = stmt.executeQuery(selectCommand);
			List<Property> listOfProperties= new ArrayList<>();
			Property property=null;
			 while (rs.next()) {
	                property = new Property();
	                /*Retrieve one employee details 
	                and store it in employee object*/
	                property.setAgentName(rs.getString("AgentName"));
	                property.setRegion(rs.getString("Region"));
	                property.setClosingDate(rs.getDate("ClosingDate"));
	                property.setAskingPrice(rs.getDouble("AskingPrice"));
	                property.setType(rs.getString("Type"));
	 	                
	                listOfProperties.add(property);
	            }
			 for(Property p:listOfProperties)
			 {
				 System.out.println(p);
			 }
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
