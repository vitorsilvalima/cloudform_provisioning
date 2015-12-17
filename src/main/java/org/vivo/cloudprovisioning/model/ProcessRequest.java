package org.vivo.cloudprovisioning.model;

import org.vivo.cloudprovisioning.bpm.ProcessControl;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by vlima on 12/16/15.
 */
@XmlRootElement
public class ProcessRequest
{
    private User user;
    private List<RequisicaoVM> requisicaoVMs;
    public ProcessRequest()
    {

    }
    public ProcessRequest(User user) {
        this.user = user;
        this.requisicaoVMs = requisicaoVMs;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<RequisicaoVM> getRequisicaoVMs() {
        return requisicaoVMs;
    }

    public void setRequisicaoVMs(List<RequisicaoVM> requisicaoVMs) {
        this.requisicaoVMs = requisicaoVMs;
    }
}
