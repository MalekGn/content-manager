package com.mlk.cmis.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.enums.BindingType;

import com.mlk.cmis.service.CmisConnectService;

public class CmisConnectServiceImpl implements CmisConnectService {

	@Override
	public Session getSession(String login, String password) {

		SessionFactory sessionFactory = SessionFactoryImpl.newInstance();

		Map<String, String> parameters = new HashMap<>();

		parameters.put(SessionParameter.BINDING_TYPE, BindingType.BROWSER.value());
		parameters.put(SessionParameter.BROWSER_URL, getServiceUrl());
		parameters.put(SessionParameter.REPOSITORY_ID, DEFAULT_REPOSITORY_ID);
		parameters.put(SessionParameter.USER, login);
		parameters.put(SessionParameter.PASSWORD, password);
		return sessionFactory.createSession(parameters);
	}
	
	/**
	 * 
	 * @return
	 */
	private String getServiceUrl() {
		String host = "localhost"; // retrieve from a config file
		String port = "8080"; //retrieve from a config file
		
		return SERVICE_URL.replace("<host>", host).replace("<port>", port);
	}
}
