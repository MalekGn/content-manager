package com.mlk.model;

import java.io.File;
import java.util.LinkedHashMap;

public class Action {
	
	private File importedFile;
	private String selectOption;
	
	private LinkedHashMap<String, String> list = new LinkedHashMap<>();

	public File getImportedFile() {
		return importedFile;
	}

	public void setImportedFile(File file) {
		this.importedFile = file;
	}

	public String getSelectOption() {
		return selectOption;
	}

	public void setSelectOption(String selectOption) {
		this.selectOption = selectOption;
	}

	public LinkedHashMap<String, String> getList() {
		return list;
	}

	public void setList(LinkedHashMap<String, String> list) {
		this.list = list;
	}
	
}
