package org.vivo.cloudprovisioning.model;

/**
 * Created by vlima on 12/17/15.
 */
@org.kie.api.remote.Remotable
public class RequisicaoData implements java.io.Serializable
{

    static final long serialVersionUID = 1L;

    private java.util.List<RequisicaoVM> listRequisicao;
    private java.lang.Long numero_projeto;
    private java.lang.String extra_info;
    private java.lang.String cliente;

    public RequisicaoData()
    {
    }

    public java.util.List<RequisicaoVM> getListRequisicao()
    {
        return this.listRequisicao;
    }

    public void setListRequisicao(
            java.util.List<RequisicaoVM> listRequisicao)
    {
        this.listRequisicao = listRequisicao;
    }

    public java.lang.Long getNumero_projeto()
    {
        return this.numero_projeto;
    }

    public void setNumero_projeto(java.lang.Long numero_projeto)
    {
        this.numero_projeto = numero_projeto;
    }

    public java.lang.String getExtra_info()
    {
        return this.extra_info;
    }

    public void setExtra_info(java.lang.String extra_info)
    {
        this.extra_info = extra_info;
    }

    public java.lang.String getCliente()
    {
        return this.cliente;
    }

    public void setCliente(java.lang.String cliente)
    {
        this.cliente = cliente;
    }
    public RequisicaoData(
            java.util.List<RequisicaoVM> listRequisicao,
            java.lang.Long numero_projeto, java.lang.String extra_info,
            java.lang.String cliente)
    {
        this.listRequisicao = listRequisicao;
        this.numero_projeto = numero_projeto;
        this.extra_info = extra_info;
        this.cliente = cliente;
    }
}