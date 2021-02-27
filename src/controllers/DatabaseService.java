package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.User;


public class DatabaseService {

	//connect DB
			String dbURL = "jdbc:mysql://localhost:3306/MOVIE_STORE";
			String user = "root";
			String password = "root";
				
			Connection c = null;
			Statement stmt = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int rowsAffected = 0;
			
			
		//four crud operations
	
	public int deleteOne(int id) throws SQLException {
		int numberOfRowsAffected = 0;
		
		//db work
		c = DriverManager.getConnection(dbURL, user, password);
		System.out.println("Connection is successful");
		
		//create a SQL statement
		pstmt = c.prepareStatement("delete from movie_store.users where USER_ID = ?");
		pstmt.setInt(1, id);
		
		//execute the statement
		rowsAffected = pstmt.executeUpdate();
		
		//process the rows in the result set
		System.out.println("Rows deleted: "+rowsAffected);
		
		//close connection
		pstmt.close();
		c.close();
		
		return numberOfRowsAffected;
	}
	
	public int insertOne(User u) throws SQLException {
		int numberOfRowsAffected = 0;
		
		//db work
		c = DriverManager.getConnection(dbURL, user,password);
		System.out.println("Connection is successful");
		
		//create a SQL statement
		pstmt = c.prepareStatement("insert into movie_store.users values(null, ?, ?, ?, ?, ?, ? )");
		pstmt.setString(1, u.getFirstName());
		pstmt.setString(2, u.getLastName());
		pstmt.setString(3, u.getUserName());
		pstmt.setString(4, u.getPassword());
		pstmt.setString(5, u.getEmailAddress());
		pstmt.setString(6, u.getPhoneNumber());
		
		//execute the statement
		rowsAffected = pstmt.executeUpdate();
		
		//process the rows in the result set
		System.out.println("Rows Affected: "+rowsAffected);
		
		//close connection
		pstmt.close();
		c.close();
		
		return numberOfRowsAffected;	
	}
	
	public ArrayList<User> readAll() throws SQLException{
		ArrayList<User> everyone = new ArrayList<User>();
		
		//db work

		c = DriverManager.getConnection(dbURL, user,password);
		System.out.println("Connection is successful");
		
		//create a SQL statement
		stmt = c.createStatement();
		
		//execute the statement
		rs = stmt.executeQuery("Select * from movie_store.users");
		
		//process the rows in the result set
		while(rs.next()) {
			System.out.println("User ID: "+rs.getInt("USER_ID")+" First Name: "+rs.getString("FIRST_NAME")+" Last Name: "+rs.getString("LAST_NAME")+" Username: "+rs.getString("USER_NAME")+
					" Password: "+rs.getString("PASSWORD")+" Email: "+rs.getString("EMAIL")+ " Phone: "+rs.getString("PHONE"));
		}
		
		//close connection
		rs.close();
		stmt.close();
		c.close();
		
		return everyone;
	}
	
	public int updateOne(int id, User u) throws SQLException {
		int numberOfRowsAffected = 0;
		
		//db work
		c = DriverManager.getConnection(dbURL, user, password);
		System.out.println("Connection is successful");
		
		//create a SQL statement
		pstmt = c.prepareStatement("update movie_store.users set FIRST_NAME=?, LAST_NAME=?, USER_NAME=?, PASSWORD=?, EMAIL=?, PHONE=? where USER_ID=?");
		pstmt.setString(1, u.getFirstName());
		pstmt.setString(2, u.getLastName());
		pstmt.setString(3, u.getUserName());
		pstmt.setString(4, u.getPassword());
		pstmt.setString(5, u.getEmailAddress());
		pstmt.setString(6, u.getPhoneNumber());
		pstmt.setInt(7, id);
				
		//execute the statement
		rowsAffected = pstmt.executeUpdate();
		
		//process the rows in the result set
		System.out.println("Rows updated: "+rowsAffected);
		
		//close connection
		pstmt.close();
		c.close();
		
		return numberOfRowsAffected;
		
	}
	
	public int login(String submittedusername, String submittedpassword) throws SQLException {
		int found = 0;
		
		//db connection
		c = DriverManager.getConnection(dbURL, user, password);
		System.out.println("Connection is successful");
		
		//create a SQL statement
		pstmt = c.prepareStatement("select USER_ID from movie_store.users where USER_NAME=? and PASSWORD=?");
		pstmt.setString(1, submittedusername);
		pstmt.setString(2, submittedpassword);
		
		rs = pstmt.executeQuery();

		
		if(rs.next() != true) {
			System.out.println("0");
			found = 0;
		}else {
			System.out.println("1");
			found = 1;
		}
		
		
		return found;
	}
}
