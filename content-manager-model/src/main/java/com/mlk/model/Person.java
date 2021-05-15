package com.mlk.model;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {

	private static final long serialVersionUID = 8852968615916646047L;

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private Date dateOfBirth;

	/**
	 * Empty Constructor
	 */
	public Person() {
		super();
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param userName
	 * @param password
	 * @param dateOfBirth
	 */
	public Person(String firstName, String lastName, String userName, String password, Date dateOfBirth) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * 
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * 
	 * @param dateOfBirth
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
