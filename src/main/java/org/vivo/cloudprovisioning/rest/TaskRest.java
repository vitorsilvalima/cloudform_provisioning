package org.vivo.cloudprovisioning.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vlima on 12/18/15.
 */
@Path("/task")
public class TaskRest
{
    @Path("/tasks")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProcess()
    {
        Map test = new HashMap();
        test.put("oi",432);
        test.put("test",432);
        return Response.ok(test).build();
    }
}
