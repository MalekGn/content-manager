package com.mlk.cmis.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.commons.PropertyIds;
import org.apache.chemistry.opencmis.commons.data.ContentStream;
import org.apache.chemistry.opencmis.commons.enums.VersioningState;
import org.apache.chemistry.opencmis.commons.exceptions.CmisContentAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mlk.cmis.service.CmisCreateObjectService;

public class CmisCreateObjectServiceImpl implements CmisCreateObjectService{
	private static final Logger LOGGER = LoggerFactory.getLogger(CmisCreateObjectServiceImpl.class);

	@Override
	public Folder createFolder(Session session, Folder parent, Map<String, String> properties) {
		Folder folder = null;
		if (parent == null) {
			parent = (Folder) session.getObjectByPath("/");
		}
		
		properties.computeIfAbsent(PropertyIds.OBJECT_TYPE_ID, param -> "cmis:folder");
		
		try {
			folder = parent.createFolder(properties);
		} catch (CmisContentAlreadyExistsException e) {
			folder = (Folder) session.getObjectByPath(parent.getPath(), properties.get(PropertyIds.NAME));
			LOGGER.info("{} already exists", folder.getPath());
		}
		return folder;
	}

	@Override
	public Document createDocument(Session session, Folder parent, File file, Map<String, String> properties, VersioningState versioningState)
			throws FileNotFoundException {
		
		Document document = null;

		InputStream inputStream = new FileInputStream(file);

		ContentStream contentStream = session.getObjectFactory().createContentStream(file.getName(), -1, null,
				inputStream);

		versioningState = versioningState == null ? VersioningState.CHECKEDOUT : versioningState;

		properties = properties == null ? new HashMap<>() : properties;
		
		properties.computeIfAbsent(PropertyIds.NAME, param -> file.getName());
		properties.computeIfAbsent(PropertyIds.OBJECT_TYPE_ID, param -> "cmis:document");
		
		try {
			document = parent.createDocument(properties, contentStream, versioningState);
		} catch (CmisContentAlreadyExistsException e) {
			document = (Document) session.getObjectByPath(parent.getPath(), properties.get(PropertyIds.NAME));
			LOGGER.info("{} already exists", document.getName());
		}
		return document;
	}

}
