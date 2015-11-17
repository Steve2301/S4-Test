package at.fhv.itm14.fhvgis.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import at.fhv.itm14.fhvgis.domain.*;

@Path("/users")
public class UserWebservice {
	private static Test _test = Test.getInstance();
	
	@Path("/{username}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("username") String username)
	{
		return _test.getUser(username);
 	}
}
