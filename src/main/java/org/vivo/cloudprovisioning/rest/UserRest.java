package org.vivo.cloudprovisioning.rest;

import java.util.ArrayList;
import java.util.List;


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

@Path("/members")
public class UserRest 
{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllMembers() 
    {
    	List<User> users = new  ArrayList<User>();
    	users.add(new User("Vitor","vlima","Windows8-19","user"));    	
    	if(users.isEmpty()) return Response.noContent().build();
    	
        return Response.ok(users).build();
    }
}
