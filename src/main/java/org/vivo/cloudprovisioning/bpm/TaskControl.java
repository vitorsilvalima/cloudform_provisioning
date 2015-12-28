package org.vivo.cloudprovisioning.bpm;

import com.vivo.cloud_provision.RequisicaoData;
import org.jbpm.services.task.utils.ContentMarshallerHelper;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.task.TaskService;
import org.kie.api.task.model.*;
import org.kie.services.client.api.RemoteRestRuntimeEngineFactory;
import org.kie.services.client.api.RemoteRuntimeEngineFactory;
import org.vivo.cloudprovisioning.model.*;
import org.vivo.cloudprovisioning.model.User;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by vlima on 12/18/15.
 */
public class TaskControl
{
    private User user;
    private String applicationContext;
    private RuntimeEngine engine = null;
    private KieSession ksession = null;
    private TaskService taskService = null;
    public TaskControl(User user)
    {
        RemoteRestRuntimeEngineFactory restSessionFactory = null;
        applicationContext="http://localhost:8080/business-central";
        this.user=user;
        try
        {
            restSessionFactory = RemoteRuntimeEngineFactory.newRestBuilder()
                    .addUrl(new URL(applicationContext))
                    .addUserName(this.user.getLogin()).addPassword(this.user.getPwd())
                    .addDeploymentId("com.vivo:cloud_provision:1.0").buildFactory();
            engine=restSessionFactory.newRuntimeEngine();
            taskService=engine.getTaskService();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public List<TaskRequest> getTasks()
    {
        List<Status> statuses = new ArrayList<>();
        statuses.add(Status.Ready);
        List<TaskSummary>taskSummaries=taskService.getTasksAssignedAsPotentialOwnerByStatus(user.getLogin(), statuses, null);
        List<TaskRequest> taskRequests = new ArrayList<TaskRequest>();
        for(TaskSummary tasksummary: taskSummaries)
        {
            Long id=tasksummary.getId();
            Task task = taskService.getTaskById(id);
            TaskData taskData = task.getTaskData();
            Content content = taskService.getContentById(taskData.getDocumentContentId());
            Object objectMap = ContentMarshallerHelper.unmarshall(content.getContent(), null);
            Map<String,Object> mapContent = (Map<String,Object>)objectMap;
            RequisicaoData requisicaoData = (RequisicaoData)mapContent.get("requisicao_in");
            taskRequests.add(new TaskRequest(id,requisicaoData,user));
        }
        return taskRequests;
    }
    public void completeTask(Long taskID,Map vars)
    {
        taskService.claim(taskID,user.getLogin());
        taskService.start(taskID,user.getLogin());
        taskService.complete(taskID,user.getLogin(),vars);
        System.out.println("Task "+taskID+" was successfully completed!");
    }
}
