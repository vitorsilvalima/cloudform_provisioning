package org.vivo.cloudprovisioning.rest;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.vivo.cloudprovisioning.bpm.JbpmManager;
import org.vivo.cloudprovisioning.factory.UserFactory;
import org.vivo.cloudprovisioning.model.User;


@Path("/users")
public class UserRest {
	
	//@Inject 
	//private JbpmManager jbpmManager;
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllUsers() 
    {
    	JbpmManager test = new JbpmManager();
    	test.startProcess();
    	UserFactory fUser = new UserFactory();
    	List<User>users = fUser.getList();
    	if(users.isEmpty()) return Response.noContent().build();
        return Response.ok(users).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response lookupUserByLogin(User user)
    {
    	class Status
    	{
    		public boolean status;
    		public Status()
    		{
    			this.status=false;
    		}
    		public void setStatus(boolean status)
    		{
    			this.status=status;
    		}
    	}
    	Status status = new Status();
    	//System.out.println(user.getName()); 
    	UserFactory fUser = new UserFactory();
    	List<User>users = fUser.getUserByName(user.getLogin());
    	for(User u: users)
    	{
    		if(u.getLogin().equals(user.getLogin()) && u.getPwd().equals(user.getPwd()))
    		{
    			status.setStatus(true);
    			return Response.ok(status).build();
    		}
    	}
    	status.setStatus(false);
    	return Response.ok(status).build();
    }
}
