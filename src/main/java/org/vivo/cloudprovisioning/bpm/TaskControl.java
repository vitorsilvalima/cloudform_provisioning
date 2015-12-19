package org.vivo.cloudprovisioning.bpm;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.task.TaskService;
import org.kie.api.task.model.Status;
import org.kie.api.task.model.Task;
import org.kie.services.client.api.RemoteRestRuntimeEngineFactory;
import org.kie.services.client.api.RemoteRuntimeEngineFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlima on 12/18/15.
 */
public class TaskControl
{
    private String userName;
    private String passWord;
    private String applicationContext;
    private RuntimeEngine engine = null;
    private KieSession ksession = null;
    private TaskService taskService = null;
    public TaskControl(String userName, String passWord)
    {
        RemoteRestRuntimeEngineFactory restSessionFactory = null;
        applicationContext="http://localhost:8080/business-central";
        this.userName=userName;
        this.passWord=passWord;
        try
        {
            restSessionFactory = RemoteRuntimeEngineFactory.newRestBuilder()
                    .addUrl(new URL(applicationContext))
                    .addUserName(userName).addPassword(passWord)
                    .addDeploymentId("com.vivo:cloud_provision:1.0").buildFactory();
            engine=restSessionFactory.newRuntimeEngine();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public List<Task> getTasks()
    {
        List<Status> statuses = new ArrayList<>();
        taskService.getTasksAssignedAsPotentialOwnerByStatus(userName,statuses,null);

    }
}
