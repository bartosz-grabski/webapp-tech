package services.rest;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

public class RESTHelloWorldClient {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		WebTarget service = client.target(getBaseURI());
		
		print(service.path("rest").path("hello").request(MediaType.TEXT_PLAIN).get().readEntity(String.class));
		print(service.path("rest").path("hello").request(MediaType.TEXT_XML).get().readEntity(String.class));
		print(service.path("rest").path("hello").request(MediaType.TEXT_HTML).get().readEntity(String.class));
		
	}
	
	
	public static void print(String arg) {
		System.out.println(arg);
	}
	
	public static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/Ex1").build();
	}

}
