package org.vivo.cloudprovisioning.rest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.vivo.cloudprovisioning.factory.UserFactory;
import org.vivo.cloudprovisioning.model.User;


@Path("/users")
public class UserRest {
	

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllUsers() 
    {
    	//JbpmManager test = new JbpmManager();
    //	test.startProcess();
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
		//JbpmManager test = new JbpmManager();
		//test.claimTask();
		Map status = new HashMap();//the return
    	UserFactory fUser = new UserFactory();
    	List<User>users = fUser.getUserByName(user.getLogin());
    	for(User u: users)
    	{
    		if(u.getLogin().equals(user.getLogin()) && u.getPwd().equals(user.getPwd()))
    		{
    			//status.setStatus(true);
				status.put("status",true);
				status.put("group",u.getGroup());
				status.put("name",u.getName());
    			return Response.ok(status).build();
    		}
    	}
		status.put("status", false);
    	return Response.ok(status).build();
    }
}
