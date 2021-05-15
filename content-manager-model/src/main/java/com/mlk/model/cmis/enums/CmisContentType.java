package com.mlk.model.cmis.enums;

public enum CmisContentType {
	PLAIN_TEXT("content/text"), PDF("content/pfd");

	private String type;

	CmisContentType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
