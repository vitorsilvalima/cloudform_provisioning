package org.vivo.cloudprovisioning.model;

import com.vivo.cloud_provision.RequisicaoData;

/**
 * Created by vlima on 12/21/15.
 */

public class TaskRequest
{
    private long ID;
    private RequisicaoData requisicaoData;
    private User user;
    private boolean approval;
    public TaskRequest(long ID, RequisicaoData requisicaoData, User user) {
        this.ID = ID;
        this.requisicaoData = requisicaoData;
        this.user = user;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public TaskRequest()
    {
    }
    public boolean isApproval() {
        return approval;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public RequisicaoData getRequisicaoData() {
        return requisicaoData;
    }

    public void setRequisicaoData(RequisicaoData requisicaoData) {
        this.requisicaoData = requisicaoData;
    }
}
