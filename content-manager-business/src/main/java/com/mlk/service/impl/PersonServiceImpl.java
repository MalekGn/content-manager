package com.mlk.service.impl;

import com.mlk.model.Person;
import com.mlk.model.enums.UserType;
import com.mlk.service.PersonService;

public class PersonServiceImpl implements PersonService{

	@Override
	public Person getStoredPerson(Person person, UserType userType) {
		
		return person;
	}

	

}
