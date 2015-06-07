package org.nyx;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/service")
public class Service {

	@GET
	@Path("/simple")
	public String simple(){
		return "Hello!";
	}
}
