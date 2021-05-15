package com.mlk.service;

import com.mlk.model.Person;
import com.mlk.model.enums.UserType;

public interface PersonService {
	
	/**
	 * 
	 * @param person
	 * @param userType
	 * @return
	 */
	public Person getStoredPerson(Person
			person, UserType userType);
}
