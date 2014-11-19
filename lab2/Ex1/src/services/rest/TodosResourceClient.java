package services.rest;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

public class TodosResourceClient {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		WebTarget service = client.target(getBaseURI());
		
		print(service.path("rest").path("todos").request(MediaType.TEXT_XML).get().readEntity(String.class));
		print(service.path("rest").path("todos").request(MediaType.APPLICATION_XML).get().readEntity(String.class));
		print(service.path("rest").path("todos").request(MediaType.APPLICATION_JSON).get().readEntity(String.class));
		
		Todo todo = new Todo("5","blabla");
		Response response = service.path("rest").path("todos")
				.path(todo.getId()).request(MediaType.APPLICATION_XML)
				.put(Entity.xml(todo));
		
		print(String.valueOf(response.getStatus()));
		print(response.getStatusInfo().toString());
		print(service.path("rest").path("todos")
				.request(MediaType.TEXT_XML).get(String.class));
		
		response = service.path("rest").path("todos/1").request().delete();
		print(String.valueOf(response.getStatus()));
		print(response.getStatusInfo().toString());
		print(service.path("rest").path("todos").request(MediaType.APPLICATION_XML).get(String.class));
		
		
	}
	
	
	public static void print(String arg) {
		System.out.println(arg);
	}
	
	public static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/Ex1").build();
	}

}
