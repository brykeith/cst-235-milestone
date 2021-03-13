package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import beans.Movie;
import beans.User;


@ManagedBean
public class MovieChangeController {

	public String OnViewMovieSubmit() throws ClassNotFoundException, SQLException {
		
		//getting ID from form
		FacesContext context = FacesContext.getCurrentInstance();
		int mi = context.getApplication().evaluateExpressionGet(context, "#{movieID}", Integer.class);
		
		//creating DB object
		DatabaseService ds = new DatabaseService();
		
		
		Movie m = ds.displayMovie(mi);
		
		// puts Movie object into POST request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("movie", m);
		
		return "ViewMovie.xhtml";
	}
	
	public String PopulateUpdateMovieForm() throws ClassNotFoundException, SQLException {
		//getting ID from form
		FacesContext context = FacesContext.getCurrentInstance();
		int mi = context.getApplication().evaluateExpressionGet(context, "#{movieID}", Integer.class);
		
		
		//creating DB object
		DatabaseService ds = new DatabaseService();
		
		
		Movie m = ds.displayMovie(mi);
		System.out.println("Populate movie ID check: "+m.getMovieID());
		
		// puts Movie object into POST request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("movie", m);
		
		return "UpdateMovieForm.xhtml";
		
	}
	
	public String OnUpdateMovieSubmit() throws ClassNotFoundException, SQLException {
		
		//getting ID from form
		FacesContext context = FacesContext.getCurrentInstance();
		Movie m = context.getApplication().evaluateExpressionGet(context, "#{movie}", Movie.class);
		
		
		//creating DB object
		DatabaseService ds = new DatabaseService();
		
		//create movie object from DB
		//Movie m = ds.displayMovie(mi);
		m.setMovieID(ds.addMovieID(m));
		int m1 = ds.updateMovie(m.getMovieID(), m);
		System.out.println("OnUpdateMovieSubmit movie ID check: "+m.getMovieID());
		
		System.out.println("Rows updated: "+m1);
		
		// puts Movie object into POST request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("movie", m);
		
		return "ViewMovie.xhtml";
	}
	
	public String OnDeleteMovieSubmit() throws Exception {
		//getting ID from form
		FacesContext context = FacesContext.getCurrentInstance();
		int mi = context.getApplication().evaluateExpressionGet(context, "#{movieID}", Integer.class);
		
		//creating DB object
		DatabaseService ds = new DatabaseService();
		
		int numberofrowsAffected = ds.deleteMovie(mi);
		
		
		
		return "SuccessfulLogin.xhtml";
	}
}
