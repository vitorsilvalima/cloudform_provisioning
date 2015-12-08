package org.vivo.cloudprovisioning.bpm;

import java.net.MalformedURLException;
import java.net.URL;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jbpm.kie.services.impl.KModuleDeploymentUnit;
import org.jbpm.marshalling.impl.JBPMMessages.ProcessInstance;
import org.jbpm.services.ejb.api.ProcessServiceEJBRemote;
import org.jbpm.services.ejb.api.RuntimeDataServiceEJBRemote;
import org.jbpm.services.ejb.api.UserTaskServiceEJBRemote;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.task.TaskService;
import org.kie.services.client.api.RemoteRestRuntimeEngineFactory;

@Stateless
public class JbpmManager 
{
	String applicationContext="http://localhost:8080/business-central";
	String deploymentId ="vivo:Vivo_Provision:1.0";
	KModuleDeploymentUnit kmodule;
	@EJB(lookup = "ejb:/sample-war-ejb-app/ProcessServiceEJBImpl!org.jbpm.services.ejb.api.ProcessServiceEJBRemote")
	private ProcessServiceEJBRemote processService;

	@EJB(lookup = "ejb:/sample-war-ejb-app/UserTaskServiceEJBImpl!org.jbpm.services.ejb.api.UserTaskServiceEJBRemote")
	private UserTaskServiceEJBRemote userTaskService;

	@EJB(lookup = "ejb:/sample-war-ejb-app/RuntimeDataServiceEJBImpl!org.jbpm.services.ejb.api.RuntimeDataServiceEJBRemote")
	private RuntimeDataServiceEJBRemote runtimeDataService;
	public void startProcess()
	{
		kmodule = new KModuleDeploymentUnit("com.vivo", "vivo-provisioning", "1.0");
		//System.out.println(kmodule.getDeploymentDescriptor());
//		System.out.println(kmodule.getDeploymentDescriptor());
		//processService.startProcess(kmodule.getIdentifier(),"VivoProvisioning.VivoProcess");
		URL jbpmURL;
		try 
		{
			jbpmURL = new URL(applicationContext);
			RemoteRestRuntimeEngineFactory remoteRestSesionFactory = new RemoteRestRuntimeEngineFactory(deploymentId, jbpmURL, "bpmsAdmin", "Windows8-19");
			RuntimeEngine  runtimeEngine = remoteRestSesionFactory.newRuntimeEngine();
			KieSession kieSession = runtimeEngine.getKieSession();
			TaskService taskService= runtimeEngine.getTaskService();
			org.kie.api.runtime.process.ProcessInstance processInstance = kieSession.startProcess("Vivo_Provision.bp_vivo");
			long procId = processInstance.getId();
			System.out.println("The process ID is: "+procId);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
