package models;

public class UserData {
	//=================================================================================================================
	private String name;
	private String lastName;
	private String email;
	private String password;

	//Setters
	//===============================================================================
	private void setName (String name) {
		this.name = name;
	}

	public UserData withName (String name) {
		this.name = name;
		return this;
	}

	//- - - - - - - - - - - - - - - - - - - - - - -
	private void setLastName (String lastName) {
		this.lastName = lastName;
	}

	public UserData withLastName (String lastName) {
		this.lastName = lastName;
		return this;
	}

	//- - - - - - - - - - - - - - - - - - - - - - -
	private void setEmail (String email) {
		this.email = email;
	}

	public UserData withEmail (String email) {
		this.email = email;
		return this;
	}

	//- - - - - - - - - - - - - - - - - - - - - - -
	private void setPassword (String password) {
		this.password = password;
	}

	public UserData withPassword (String password) {
		this.password = password;
		return this;
	}

	//Getters
	//===============================================================================

	public String getName () {return name;}

	public String getLastName () {return lastName;}

	public String getEmail () {return email;}

	public String getPassword () {return password;}

	//Constructor
	//===============================================================================
	public UserData (String name, String lastName, String email, String password) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public UserData () {}
}
