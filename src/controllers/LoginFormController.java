package controllers;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.User;

@ManagedBean
public class LoginFormController {
	
	public String onSubmit() throws Exception {

		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);

		//adding user to DB
		DatabaseService ds = new DatabaseService();
		
		int founduser = ds.login(user.getUserName(), user.getPassword());
		if(founduser == 1) {
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
			return "SuccessfulLogin.xhtml";
		}else {
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
			return "FailedLogin.xhtml";
		}

	

	}
	
}
