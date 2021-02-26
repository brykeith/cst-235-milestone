package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class User {

	// Registration details at a minimum should include First Name, Last Name, Email
	// Address, Phone Number, and Login Credentials (Username and Password).

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String emailAddress;
	private String phoneNumber;

	public User() {
		this.firstName = this.getFirstName();
		this.lastName = this.getLastName();
		this.userName = this.getUserName();
		this.password = this.getPassword();
		this.emailAddress = this.getEmailAddress();
		this.phoneNumber = this.getPhoneNumber();
	}

	public User(String firstName, String lastName, String userName, String password, String emailAddress,
			String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
