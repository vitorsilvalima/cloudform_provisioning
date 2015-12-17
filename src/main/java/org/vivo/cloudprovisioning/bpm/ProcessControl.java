package org.vivo.cloudprovisioning.bpm;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.task.TaskService;
import org.kie.services.client.api.RemoteRestRuntimeEngineFactory;
import org.kie.services.client.api.RemoteRuntimeEngineFactory;
import org.vivo.cloudprovisioning.model.RequisicaoVM;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ProcessControl
{
    private String userName;
    private String passWord;
    private String applicationContext;
    private RuntimeEngine engine = null;
    private KieSession ksession = null;
    private TaskService taskService = null;
    public ProcessControl()
    {
        RemoteRestRuntimeEngineFactory restSessionFactory = null;
        applicationContext="http://localhost:8080/business-central";
        userName="wilson";
        passWord="redhat@1";
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
    public ProcessControl(String userName, String passWord)
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
    public long starProcess(RequisicaoVM requisicao)
    {
        Map vars = new HashMap();
        vars.put("requisicao",requisicao);
        vars.put("capacity_approval",false);
        vars.put("network_approval",false);
        vars.put("ti_approval",false);
        KieSession kieSession= engine.getKieSession();
        return kieSession.startProcess("cloud_provision.BPCloudProvision",vars).getId();
    }
}
