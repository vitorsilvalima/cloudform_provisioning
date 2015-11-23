package org.vivo.cloudprovisioning.bpm;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jbpm.kie.services.impl.KModuleDeploymentUnit;
import org.jbpm.services.ejb.api.ProcessServiceEJBRemote;
import org.jbpm.services.ejb.api.RuntimeDataServiceEJBRemote;
import org.jbpm.services.ejb.api.UserTaskServiceEJBRemote;

@Stateless
public class JbpmManager 
{
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
		System.out.println(kmodule.getDeploymentDescriptor());
		//processService.startProcess(kmodule.getIdentifier(),"VivoProvisioning.VivoProcess");
	}
	
}
