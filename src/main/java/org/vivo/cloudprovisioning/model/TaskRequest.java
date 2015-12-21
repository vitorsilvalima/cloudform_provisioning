package org.vivo.cloudprovisioning.model;

import com.vivo.cloud_provision.RequisicaoData;

/**
 * Created by vlima on 12/21/15.
 */

public class TaskRequest
{
    private long ID;
    RequisicaoData requisicaoData;

    public TaskRequest(long ID, RequisicaoData requisicaoData) {
        this.ID = ID;
        this.requisicaoData = requisicaoData;
    }
    public TaskRequest()
    {

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
