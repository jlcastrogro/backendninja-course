package com.udemy.model;

public class UserCredential {
	private String name;
	private String password;

	/**
	 * 
	 */
	public UserCredential() {
		super();
	}

	/**
	 * @param name
	 * @param password
	 */
	public UserCredential(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserCredential [name=" + name + ", password=" + password + "]";
	}

}
