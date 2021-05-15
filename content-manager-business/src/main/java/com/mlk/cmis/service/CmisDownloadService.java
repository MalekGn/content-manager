package com.mlk.cmis.service;

import org.apache.chemistry.opencmis.client.api.Session;

public interface CmisDownloadService {

	/**
	 * download document by uuid <br/>
	 * <b>targetDirectory</b> should contain the file name and extension
	 * 
	 * @param session
	 * @param uuid
	 * @param targetDirectory
	 */
	public void downloadDocumentByUUID(Session session, String uuid, String targetDirectory);

	/**
	 * download document by directory
	 * 
	 * @param session
	 * @param sourceDirectory
	 * @param targetDirectory
	 */
	public void downloadDocumentByDirectory(Session session, String sourceDirectory, String targetDirectory);

}
