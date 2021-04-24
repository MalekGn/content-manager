package com.mlk.cmis;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.commons.data.ContentStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CmisDownloadService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CmisDownloadService.class);
	
	/**
	 * download document by uuid <br/>
	 * <b>targetDirectory</b> should contain the file name and extension
	 * 
	 * @param session
	 * @param uuid
	 * @param targetDirectory
	 */
	public void downloadDocumentByUUID(Session session, String uuid, String targetDirectory) {

		Document document = (Document) session.getObject(uuid);
		ContentStream contentStream = document.getContentStream();
		String docName = document.getName();

		try (BufferedInputStream inputStream = new BufferedInputStream(contentStream.getStream());
				OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(targetDirectory + docName))) {

			int b;
			while ((b = inputStream.read()) != -1) {
				outputStream.write(b);
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	/**
	 * download document by directory
	 * 
	 * @param session
	 * @param sourceDirectory
	 * @param targetDirectory
	 */
	public void downloadDocumentByDirectory(Session session, String sourceDirectory, String targetDirectory) {

		Document document = (Document) session.getObjectByPath(sourceDirectory);
		ContentStream contentStream = document.getContentStream();
		String docName = document.getName();

		try (BufferedInputStream inputStream = new BufferedInputStream(contentStream.getStream());
				OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(targetDirectory + docName))) {

			int b;
			while ((b = inputStream.read()) != -1) {
				outputStream.write(b);
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
}
