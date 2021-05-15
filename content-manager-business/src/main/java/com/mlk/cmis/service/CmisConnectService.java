package com.mlk.cmis.service;

import org.apache.chemistry.opencmis.client.api.Session;

public interface CmisConnectService {

	public String SERVICE_URL = "http://<host>:<port>/alfresco/api/-default-/public/cmis/versions/1.1/browser"; // Browser
																												// binding
	public String DEFAULT_REPOSITORY_ID = "-default-";

	/**
	 * create CMIS Session
	 * 
	 * @param login
	 * @param password
	 * @return
	 */
	public Session getSession(String login, String password);

}
