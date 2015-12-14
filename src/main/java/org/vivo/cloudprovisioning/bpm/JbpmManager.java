package org.vivo.cloudprovisioning.bpm;
import org.jbpm.services.task.commands.ExecuteDeadlinesCommand;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.task.TaskService;
import org.kie.api.task.model.Content;
import org.kie.api.task.model.Task;
import org.kie.api.task.model.TaskData;
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
	String applicationContext="http://localhost:8080/business-central";
	private  RemoteRestRuntimeEngineFactory restSessionFactory = null;
	private  RuntimeEngine engine = null;
	private  KieSession ksession = null;
	private  TaskService task = null;
	public void startProcess()
	{
		try {
			restSessionFactory = RemoteRuntimeEngineFactory.newRestBuilder()
					.addUrl(new URL("http://localhost:8080/business-central"))
					.addUserName("bpmsAdmin").addPassword("Windows8-19")
					.addDeploymentId("com.vivo:cloud_provisioning:1.0").buildFactory();
			engine = restSessionFactory.newRuntimeEngine();
			engine = restSessionFactory.newRuntimeEngine();
			KieSession ksession = engine.getKieSession();
			task = engine.getTaskService();

			Task userTask = task.getTaskById(task.getTasksAssignedAsPotentialOwner("bpmsAdmin", "en-UK").get(0).getId());
			TaskData taskData = userTask.getTaskData();
			Content content = task.getContentById(taskData.getDocumentContentId());
			Map<?, ?> variableMap = ((Map<?, ?>) ContentMarshallerHelper.unmarshall(content.getContent(), null));
			System.out.println(variableMap);
			Map vars = new HashMap();
			//vars.put("numero",30);
			// long id = ksession.startProcess("cloud_provisioning.CloudProvision",vars).getParentProcessInstanceId();
			//System.out.println(id);;
			System.out.println(content.getContent());
			;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
}
