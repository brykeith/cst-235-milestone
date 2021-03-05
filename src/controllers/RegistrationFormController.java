package controllers;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.User;

@ManagedBean
public class RegistrationFormController {
	public String onSubmit() throws SQLException {

		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);

		// adding user to DB
		DatabaseService ds = new DatabaseService();
		ds.insertOne(user);

		// use for testing
		System.out.println(user.getFirstName());

		// puts User object into POST request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);

		// shows response page
		return "RegistrationResponse.xhtml";

	}

}
