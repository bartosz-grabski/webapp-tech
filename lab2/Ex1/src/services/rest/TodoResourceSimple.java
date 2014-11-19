package services.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/todosimple")
public class TodoResourceSimple {

	@GET
	@Produces({MediaType.TEXT_XML})
	public Todo getHTML() {
		Todo todo = new Todo();
		todo.setSummary("This is my first todo");
		todo.setDescription("Desc");
		return todo;
		
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Todo getTodo() {
		Todo todo = new Todo();
		todo.setSummary("todo");
		todo.setDescription("desc");
		return todo;
	}
}
