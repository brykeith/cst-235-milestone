package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.User;

@ManagedBean
public class RegistrationFormController {
	public String onSubmit() {

		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);

		// use for testing
		System.out.println(user.getFirstName());

		// puts User object into POST request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);

		// shows response page
		return "RegistrationResponse.xhtml";

	}

	public RegistrationFormController() {
		// TODO Auto-generated constructor stub
	}

}
