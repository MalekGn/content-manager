package com.mlk.cmis.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.commons.enums.VersioningState;

public interface CmisCreateObjectService {
	
	/**
	 * 
	 * @param session
	 * @param parent
	 * @param properties
	 * @return
	 */
	public Folder createFolder(Session session, Folder parent, Map<String, String> properties);
	
	/**
	 * 
	 * @param session
	 * @param parent
	 * @param file
	 * @param properties
	 * @param versioningState
	 * @return
	 * @throws FileNotFoundException
	 */
	public Document createDocument(Session session, Folder parent, File file, Map<String, String> properties, VersioningState versioningState)
			throws FileNotFoundException;
	
	
}
