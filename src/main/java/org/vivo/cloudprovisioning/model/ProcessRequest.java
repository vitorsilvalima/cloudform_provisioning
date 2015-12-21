package org.vivo.cloudprovisioning.model;

import javax.xml.bind.annotation.XmlRootElement;
import com.vivo.cloud_provision.RequisicaoData;
/**
 * Created by vlima on 12/16/15.
 */
@XmlRootElement
public class ProcessRequest
{
    private User user;
    private RequisicaoData requisicaoData;
    public ProcessRequest()
    {

    }
    public ProcessRequest(User user, RequisicaoData requisicaoData) {
        this.user = user;
        this.requisicaoData = requisicaoData;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RequisicaoData getRequisicaoData() {
        return requisicaoData;
    }

    public void setRequisicaoData(RequisicaoData requisicaoData) {
        this.requisicaoData = requisicaoData;
    }
}
