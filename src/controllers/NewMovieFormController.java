package controllers;

import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import beans.Movie;


@ManagedBean
public class NewMovieFormController {

	public String onSubmit() throws SQLException {

		FacesContext context = FacesContext.getCurrentInstance();
		Movie m = context.getApplication().evaluateExpressionGet(context, "#{movie}", Movie.class);

		//adding movie to DB
		//DatabaseService ds = new DatabaseService();

		
		// use for testing
		//System.out.println(m.getTitle());

		// puts Movie object into POST request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("movie", m);

		// shows response page
		return " ";

	}
}
