package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import beans.Movie;
import beans.User;

@ManagedBean
public class DatabaseService {

	// connect DB
	String dbURL = "jdbc:mysql://localhost:3306/MOVIE_STORE";
	String user = "root";
	String password = "root";

	Connection c = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int rowsAffected = 0;

	// four crud operations

	public int deleteOne(int id) throws SQLException, Exception {
		int numberOfRowsAffected = 0;

		// db work
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection(dbURL, user, password);
		System.out.println("Connection is successful");

		// create a SQL statement
		pstmt = c.prepareStatement("delete from movie_store.users where USER_ID = ?");
		pstmt.setInt(1, id);

		// execute the statement
		rowsAffected = pstmt.executeUpdate();

		// process the rows in the result set
		System.out.println("Rows deleted: " + rowsAffected);

		// close connection
		pstmt.close();
		c.close();

		return numberOfRowsAffected;
	}

	public int insertOne(User u) throws SQLException, ClassNotFoundException {
		int numberOfRowsAffected = 0;

		// db work
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection(dbURL, user, password);
		System.out.println("Connection is successful");

		// create a SQL statement
		pstmt = c.prepareStatement("insert into movie_store.users values(null, ?, ?, ?, ?, ?, ? )");
		pstmt.setString(1, u.getFirstName());
		pstmt.setString(2, u.getLastName());
		pstmt.setString(3, u.getUserName());
		pstmt.setString(4, u.getPassword());
		pstmt.setString(5, u.getEmailAddress());
		pstmt.setString(6, u.getPhoneNumber());

		// execute the statement
		rowsAffected = pstmt.executeUpdate();

		// process the rows in the result set
		System.out.println("Rows Affected: " + rowsAffected);

		// close connection
		pstmt.close();
		c.close();

		return numberOfRowsAffected;
	}

	public ArrayList<User> readAll() throws SQLException, Exception {
		ArrayList<User> everyone = new ArrayList<User>();

		// db work
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection(dbURL, user, password);
		System.out.println("Connection is successful");

		// create a SQL statement
		stmt = c.createStatement();

		// execute the statement
		rs = stmt.executeQuery("Select * from movie_store.users");

		// process the rows in the result set
		while (rs.next()) {
			System.out.println("User ID: " + rs.getInt("USER_ID") + " First Name: " + rs.getString("FIRST_NAME")
					+ " Last Name: " + rs.getString("LAST_NAME") + " Username: " + rs.getString("USER_NAME")
					+ " Password: " + rs.getString("PASSWORD") + " Email: " + rs.getString("EMAIL") + " Phone: "
					+ rs.getString("PHONE"));
		}

		// close connection
		rs.close();
		stmt.close();
		c.close();

		return everyone;
	}

	public int updateOne(int id, User u) throws SQLException, ClassNotFoundException {
		int numberOfRowsAffected = 0;

		// db work
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection(dbURL, user, password);
		System.out.println("Connection is successful");

		// create a SQL statement
		pstmt = c.prepareStatement(
				"update movie_store.users set FIRST_NAME=?, LAST_NAME=?, USER_NAME=?, PASSWORD=?, EMAIL=?, PHONE=? where USER_ID=?");
		pstmt.setString(1, u.getFirstName());
		pstmt.setString(2, u.getLastName());
		pstmt.setString(3, u.getUserName());
		pstmt.setString(4, u.getPassword());
		pstmt.setString(5, u.getEmailAddress());
		pstmt.setString(6, u.getPhoneNumber());
		pstmt.setInt(7, id);

		// execute the statement
		rowsAffected = pstmt.executeUpdate();

		// process the rows in the result set
		System.out.println("Rows updated: " + rowsAffected);

		// close connection
		pstmt.close();
		c.close();

		return numberOfRowsAffected;

	}

	public int login(String submittedusername, String submittedpassword) throws SQLException, ClassNotFoundException {
		int found = 0;

		// db connection
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection(dbURL, user, password);
		System.out.println("Connection is successful");

		// create a SQL statement
		pstmt = c.prepareStatement("select USER_ID from movie_store.users where USER_NAME=? and PASSWORD=?");
		pstmt.setString(1, submittedusername);
		pstmt.setString(2, submittedpassword);

		rs = pstmt.executeQuery();

		if (rs.next() != true) {
			System.out.println("0");
			found = 0;
		} else {
			System.out.println("1");
			found = 1;
		}

		return found;
	}

	public int movieAdd(Movie m) throws ClassNotFoundException, SQLException {
		int numberOfRowsAffected = 0;

		// db work
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection(dbURL, user, password);
		System.out.println("Connection is successful");

		// create a SQL statement
		pstmt = c.prepareStatement("insert into movie_store.movie set TITLE=?, RATING=?, DURATION=?, YEAR=?, DIRECTOR=?, SYNOPSIS=?");
		
		pstmt.setString(1, m.getTitle());
		pstmt.setString(2, m.getContentRating());
		pstmt.setString(3, m.getDuration());
		pstmt.setString(4, m.getReleaseDate());
		pstmt.setString(5, m.getDirector());
		pstmt.setString(6, m.getSynopsis());
		

		// execute the statement
		rowsAffected = pstmt.executeUpdate();

		// process the rows in the result set
		System.out.println("Rows updated: " + rowsAffected);

		// close connection
		pstmt.close();
		c.close();

		return numberOfRowsAffected;
	}

	public ArrayList<Movie> readAllMovies() throws SQLException, Exception {
		ArrayList<Movie> everyone = new ArrayList<Movie>();

		// db work
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection(dbURL, user, password);
		System.out.println("Connection is successful");

		// create a SQL statement
		stmt = c.createStatement();

		// execute the statement
		rs = stmt.executeQuery("Select * from movie_store.movie");

		// process the rows in the result set


		while (rs.next()) {
			System.out.println("Movie ID: "+rs.getInt("MOVIE_ID")+" Title: " + rs.getString("TITLE") + " Year: " + rs.getString("YEAR") + " Duration: "
					+ rs.getString("DURATION") + " Rating: " + rs.getString("RATING"));
			Movie m = new Movie(rs.getInt("MOVIE_ID"), rs.getString("TITLE"), rs.getString("DIRECTOR"), rs.getString("DURATION"), rs.getString("YEAR"),
					rs.getString("RATING"), rs.getString("SYNOPSIS"));
			everyone.add(m);
		}

		// close connection
		rs.close();
		stmt.close();
		c.close();

		return everyone;
	}
	
	public int addMovieID(Movie m) throws SQLException, ClassNotFoundException {
		int movieID = 0;
		
		// db work
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection(dbURL, user, password);
		System.out.println("Connection is successful");
		
		pstmt = c.prepareStatement("Select MOVIE_ID from movie_store.movie where TITLE=? and DIRECTOR=?");
		pstmt.setString(1, m.getTitle());
		pstmt.setString(2, m.getDirector());
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			movieID = rs.getInt("MOVIE_ID");
		}
		
		
		System.out.println("Movie ID being Added: "+movieID);
		
		// close connection
		rs.close();
		pstmt.close();
		c.close();
		
		return movieID;
	}
	
	public Movie displayMovie(int MovieID) throws SQLException, ClassNotFoundException {
		
		//creates blank movie object
		Movie m = new Movie();
		
		// db work
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection(dbURL, user, password);
		System.out.println("Connection is successful");
		
		pstmt = c.prepareStatement("Select * from movie_store.movie where MOVIE_ID=?");
		pstmt.setInt(1, MovieID);
		
		//sets data fields to found queried movie
		while(rs.next()) {
			m.setMovieID(rs.getInt("MOVIE_ID"));
			m.setTitle(rs.getString("TITLE"));
			m.setDirector(rs.getString("DIRECTOR"));
			m.setDuration(rs.getString("DURATION"));
			m.setReleaseDate(rs.getString("YEAR"));
			m.setContentRating(rs.getString("RATING"));
			m.setSynopsis(rs.getString("SYNOPSIS"));	
		}
		
		//executes query
		rs = pstmt.executeQuery();
		
		//closes connection
		rs.close();
		pstmt.close();
		c.close();
		
		//returns movie object
		return m;
	}
	
	public int deleteMovie(int MovieID) throws SQLException, ClassNotFoundException {
		int numberOfRowsAffected = 0;
		
		// db work
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection(dbURL, user, password);
		System.out.println("Connection is successful");
	
		// create a SQL statement
		pstmt = c.prepareStatement("delete from movie_store.movie where MOVIE_ID = ?");
		pstmt.setInt(1, MovieID);
	
		// execute the statement
		rowsAffected = pstmt.executeUpdate();
	
		// process the rows in the result set
		System.out.println("Rows deleted: " + rowsAffected);
	
		// close connection
		pstmt.close();
		c.close();

		return numberOfRowsAffected;
	}
	
	public int updateMovie(int MovieID, Movie m) throws SQLException, ClassNotFoundException {
		int numberOfRowsAffected = 0;
		
		// db work
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection(dbURL, user, password);
		System.out.println("Connection is successful");

		// create a SQL statement
		pstmt = c.prepareStatement("update movie_store.movie set TITLE=?, DIRECTOR=?, DURATION=?, YEAR=?, RATING=?, SYNOPSIS=? where MOVIE_ID=?");
		pstmt.setString(1, m.getTitle());
		pstmt.setString(2, m.getDirector());
		pstmt.setString(3, m.getDuration());
		pstmt.setString(4, m.getReleaseDate());
		pstmt.setString(5, m.getContentRating());
		pstmt.setString(6, m.getSynopsis());
		pstmt.setInt(7, MovieID);

		// execute the statement
		rowsAffected = pstmt.executeUpdate();

		// process the rows in the result set
		System.out.println("Rows updated: " + rowsAffected);

		// close connection
		pstmt.close();
		c.close();
		
		
		return numberOfRowsAffected;
	}

}
