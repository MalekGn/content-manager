package com.mlk.cmis.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.commons.data.ContentStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mlk.cmis.service.CmisDownloadService;

public class CmisDownloadServiceImpl implements CmisDownloadService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CmisDownloadServiceImpl.class);

	@Override
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

	@Override
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
