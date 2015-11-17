package org.vivo.cloudprovisioning.rest;

import java.util.ArrayList;
import java.util.List;

import org.vivo.cloudprovisioning.factory.UserFactory;
import org.vivo.cloudprovisioning.model.User;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserRest 
{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllUsers() 
    {
    	UserFactory fUser = new UserFactory();
    	List<User>users = fUser.getList();
    	if(users.isEmpty()) return Response.noContent().build();
        return Response.ok(users).build();
    }
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response lookupUserByLogin(User user)
    {
    	System.out.println(user);
    	UserFactory fUser = new UserFactory();
    	List<User>users = fUser.getUserByName(user.getLogin());
    	for(User u: users)
    	{
    		if(u.getLogin().equals(user.getLogin()) && u.getPwd().equals(user.getPwd()))
    		{
    			return Response.ok(true).build();
    		}
    	}
    	return Response.ok(false).build();
    }
}
