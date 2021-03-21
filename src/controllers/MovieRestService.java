package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Movie;
import beans.User;



@RequestScoped
@Path("/movies")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class MovieRestService {

	DatabaseService ds = new DatabaseService();
	
	//get records and display in JSON
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Movie> getOrdersAsJson() throws SQLException, Exception {
		return ds.readAllMovies();
	}
	
	//get one record by ID # and display in JSON
	@GET
	@Path("/getjsonbyid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Movie getOneOrderAsJson(@PathParam("id") int id ) throws SQLException, ClassNotFoundException {
		return ds.displayMovie(id);
	}
	
	//get one record by name and display in JSON
	@GET
	@Path("/getjsonbyname/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getOneOrderAsJsonName(@PathParam("name") String name ) throws SQLException {
		return ds.searchFor(name);
	}
	
	//post Movie to DB
	@POST
	@Path("/addmoviepostjson")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Movie postJsonadd(Movie m) throws SQLException, ClassNotFoundException {
		ds.movieAdd(m);
		return m;
	}
	
	//post Movie to DB
	@POST
	@Path("/deletepostjsonbyid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String postJsondelete(@PathParam("id") int id ) throws SQLException, ClassNotFoundException {
		return "Movie deleted";
	}
}
