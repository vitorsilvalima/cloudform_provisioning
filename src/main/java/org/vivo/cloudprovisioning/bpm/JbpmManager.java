package org.vivo.cloudprovisioning.bpm;
import org.jbpm.services.task.commands.ExecuteDeadlinesCommand;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.task.TaskService;
import org.kie.api.task.model.Content;
import org.kie.api.task.model.Task;
import org.kie.api.task.model.TaskData;
import org.kie.api.task.model.TaskSummary;
import org.kie.services.client.api.RemoteRestRuntimeEngineFactory;
import org.kie.services.client.api.RemoteRuntimeEngineFactory;
import org.jbpm.services.task.utils.ContentMarshallerHelper;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;

@Stateless
public class JbpmManager 
{
	private String userName;
	private String passWord;
	private String applicationContext;
	private  RemoteRestRuntimeEngineFactory restSessionFactory = null;
	private  RuntimeEngine engine = null;
	private  KieSession ksession = null;
	private  TaskService taskService = null;
	public JbpmManager()
	{
		applicationContext="http://localhost:8080/business-central";
		userName="wilson";
		passWord="redhat@1";
		try
		{
			restSessionFactory = RemoteRuntimeEngineFactory.newRestBuilder()
					.addUrl(new URL(applicationContext))
					.addUserName(userName).addPassword(passWord)
					.addDeploymentId("com.vivo:cloud_provision:1.0").buildFactory();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

	}
	public void startProcess()
	{
		/*y {
			engine = restSessionFactory.newRuntimeEngine();
			KieSession ksession = engine.getKieSession();
			taskService = engine.getTaskService();
			Task userTask = taskService.getTaskById(taskService.getTasksAssignedAsPotentialOwner("bpmsAdmin", "en-UK").get(0).getId());
			TaskData taskData = userTask.getTaskData();
			Content content = taskService.getContentById(taskData.getDocumentContentId());
			Map<?, ?> variableMap = ((Map<?, ?>) ContentMarshallerHelper.unmarshall(content.getContent(), null));
			System.out.println(variableMap);
			System.out.println(content.getContent());
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}*/
	}
	public void claimTask()
	{
		try
		{
			engine = restSessionFactory.newRuntimeEngine();
			KieSession ksession = engine.getKieSession();
			taskService = engine.getTaskService();
			TaskSummary task1 = taskService.getTasksAssignedAsPotentialOwner(userName, "en-UK").get(0);
			System.out.println("Sales-rep executing task " + task1.getName() + "(" + task1.getId() + ": " + task1.getDescription());
			taskService.claim(task1.getId(), userName);
			taskService.start(task1.getId(), userName);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
}
