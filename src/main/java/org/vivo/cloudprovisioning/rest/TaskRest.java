package org.vivo.cloudprovisioning.rest;


import org.vivo.cloudprovisioning.bpm.TaskControl;
import org.vivo.cloudprovisioning.model.TaskRequest;
import org.vivo.cloudprovisioning.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vlima on 12/18/15.
 */
@Path("/task")
public class TaskRest
{
    @Path("/tasks")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getTasks(User user)
    {
        TaskControl taskControl = new TaskControl(user);
        List<TaskRequest> taskRequestList = taskControl.getTasks();
        Map tasksMap = new HashMap();
        if(taskRequestList!=null) {
            tasksMap.put("tasks",taskRequestList);
        }else{
            tasksMap.put("tasks",null);
        }
        return Response.ok(tasksMap).build();
    }
    @Path("/complete")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response completegTask(TaskRequest taskRequest)
    {
        TaskControl taskControl = new TaskControl(taskRequest.getUser());
        Map vars = new HashMap();
        vars.put("requisicao_out",taskRequest.getRequisicaoData());
        vars.put("approval_out",taskRequest.isApproval());
        taskControl.completeTask(taskRequest.getID(),vars);
        return Response.ok().build();
    }
}
