package de.wim.smarthome;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class OpenHabConnector {
	
	public static final String URL = "localhost:8080/rest/items/Light_FF_Bed_Ceiling";

	public static void main(String[] args) {
		call();
	}

	public static void call() {
		Client client = ClientBuilder.newBuilder().build();
		WebTarget target = client.target(URL);
		Response response = target.request().get();
		response.close();
	}
}
