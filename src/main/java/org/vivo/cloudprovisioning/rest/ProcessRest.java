package org.vivo.cloudprovisioning.rest;

import org.vivo.cloudprovisioning.bpm.ProcessControl;
import org.vivo.cloudprovisioning.model.ProcessRequest;
import com.vivo.cloud_provision.RequisicaoVM;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vlima on 12/15/15.
 */
@Path("/process")
public class ProcessRest
{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProcess()
    {
        RequisicaoVM r = new RequisicaoVM();
        r.setNumero_vcpus(12);
        r.setQuantidade_vm(54);
        r.setSo("RHEL");
        ProcessControl processControl = new ProcessControl();
      //  System.out.println("The process has started with the id: " + processControl.starProcess(r));
        return Response.ok(r).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response startProcessUser(ProcessRequest request)
    {
        ProcessControl processControl = new ProcessControl(request.getUser().getLogin(),request.getUser().getPwd());
        if(request.getRequisicaoData()!=null)
        {
            System.out.println(request);
            System.out.println("The process has started with the id: " + processControl.starProcess(request.getRequisicaoData()));
          //  System.out.println("Cliente: "+ request.getRequisicaoData().getCliente());
           // System.out.println("Projeto: "+ request.getRequisicaoData().getNumero_projeto());
        }
        Map res = new HashMap();
        res.put("status",true);
        return Response.ok(res).build();
    }
}
