package com.mlk.model.cmis.enums;

public enum CmisObjectType {
	DOCUMENT("cmis:document"), FOLDER("cmis:folder");

	private String type;

	private CmisObjectType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
