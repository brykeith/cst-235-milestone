package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import beans.Movie;
import beans.User;


@ManagedBean
public class NewMovieFormController {

	public String onSubmit() throws SQLException, ClassNotFoundException {

		FacesContext context = FacesContext.getCurrentInstance();
		Movie m = context.getApplication().evaluateExpressionGet(context, "#{movie}", Movie.class);
		//User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);

		//adding movie to DB
		DatabaseService ds = new DatabaseService();

		ds.movieAdd(m);
		// use for testing
		System.out.println("ID: "+m.getMovieID()+ " Title: "+m.getTitle()+" Director: "+m.getDirector()+" Year: "+m.getReleaseDate()+" Duration: "+m.getDuration()+" Rating: "+m.getContentRating()+" Synopsis: "+m.getSynopsis());

		// puts Movie object into POST request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("movie", m);

		// shows response page
		return "NewMovieResponse.xhtml";

	}

}
