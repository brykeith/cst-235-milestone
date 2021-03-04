package controllers;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import beans.User;
import beans.Users;

@ManagedBean
public class UserController {

	public String userController() {

		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);

// 		for testing
//		System.out.println("first name: " + user.getFirstName());
//		System.out.println("last name: " + user.getLastName());
//		System.out.println("username: " + user.getUserName());
//		System.out.println("password: " + user.getPassword());

		List<User> users = new ArrayList<User>();
		Users u = new Users();
		users.add(new User(user.getFirstName(), user.getLastName(), user.getUserName(), user.getPassword(),
				user.getEmailAddress(), user.getPhoneNumber()));

		System.out.println(users.get(0).getFirstName());
		u.setUsers(users);

		// will likely return "LoginForm.xhtml";
		return "";
	}

}
