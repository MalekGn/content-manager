package com.mlk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.mlk.model.Person;

public class ConnectToAlfresco {

	private static final String HOST = "localhost";
	private static final String PORT = "8080";
	private static final String USER_PARAM = "u";
	private static final String PASSWORD_PARAM = "pw";

	private static final String URL = "http://1?:2?/alfresco/s/api/login?3?=admin&4?=admin";
	
	private static ConnectToAlfresco connectToAlfresco = null;
	
	private ConnectToAlfresco() {
		
	}
	
	public static ConnectToAlfresco getInstance() {
		if(connectToAlfresco == null) {
			connectToAlfresco = new ConnectToAlfresco();
		}
		return connectToAlfresco;
	}

	public String retrieveAlfTicket(Person user) throws IOException {

		if (user == null) {
			return null;
		}

		String urlS = URL.replace("1?", HOST).replace("2?", PORT).replace("3?", USER_PARAM).replace("4?",
				PASSWORD_PARAM);

		// Create a neat value object to hold the URL
		URL url = new URL(urlS.replace("admin", user.getUserName()).replace("admin", user.getPassword()));

		// Open a connection(?) on the URL(??) and cast the response(???)
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// request method
		connection.setRequestMethod("GET");

		// Now it's "open", we can set the request method, headers etc.
		connection.setRequestProperty("accept", "application/json");

		int responseCode = connection.getResponseCode();
		if(responseCode != 200) {
			System.out.println(responseCode);
			return null;
		}

		// This line makes the request
		InputStream responseStream = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(responseStream));

		String line = null;
		StringBuilder s = new StringBuilder();
		while ((line = reader.readLine()) != null) {
			s.append(line);
		}

		return s.toString();
	}
}
