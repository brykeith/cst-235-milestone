package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Users {
	List<User> users = new ArrayList<User>();

	public Users() {
		User u = new User();
		users.add(new User(u.getFirstName(), u.getLastName(), u.getUserName(), u.getPassword(), u.getEmailAddress(),
				u.getPhoneNumber()));
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
	}
}
