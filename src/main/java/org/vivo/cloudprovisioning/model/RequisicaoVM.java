package org.vivo.cloudprovisioning.model;

/**
 * Created by vlima on 12/14/15.
 */
public class RequisicaoVM implements java.io.Serializable
{

    static final long serialVersionUID = 1L;

    private int quantidade_vm;
    private int numero_vcpus;
    private int quantidade_ram;
    private java.lang.String so;
    private java.lang.String extraInfo;
    private long numeroProjeto;
    private java.lang.String cliente;

    private java.lang.String ip_producao;

    private java.lang.String ip_backup;

    private java.lang.String ip_gerenciamento;

    public RequisicaoVM()
    {
    }

    public int getQuantidade_vm()
    {
        return this.quantidade_vm;
    }

    public void setQuantidade_vm(int quantidade_vm)
    {
        this.quantidade_vm = quantidade_vm;
    }

    public int getNumero_vcpus()
    {
        return this.numero_vcpus;
    }

    public void setNumero_vcpus(int numero_vcpus)
    {
        this.numero_vcpus = numero_vcpus;
    }

    public int getQuantidade_ram()
    {
        return this.quantidade_ram;
    }

    public void setQuantidade_ram(int quantidade_ram)
    {
        this.quantidade_ram = quantidade_ram;
    }

    public java.lang.String getSo()
    {
        return this.so;
    }

    public void setSo(java.lang.String so)
    {
        this.so = so;
    }

    public java.lang.String getExtraInfo()
    {
        return this.extraInfo;
    }

    public void setExtraInfo(java.lang.String extraInfo)
    {
        this.extraInfo = extraInfo;
    }

    public java.lang.String getCliente()
    {
        return this.cliente;
    }

    public void setCliente(java.lang.String cliente)
    {
        this.cliente = cliente;
    }

    public long getNumeroProjeto()
    {
        return this.numeroProjeto;
    }

    public void setNumeroProjeto(long numeroProjeto)
    {
        this.numeroProjeto = numeroProjeto;
    }

    public java.lang.String getIp_producao()
    {
        return this.ip_producao;
    }

    public void setIp_producao(java.lang.String ip_producao)
    {
        this.ip_producao = ip_producao;
    }

    public java.lang.String getIp_backup()
    {
        return this.ip_backup;
    }

    public void setIp_backup(java.lang.String ip_backup)
    {
        this.ip_backup = ip_backup;
    }

    public java.lang.String getIp_gerenciamento()
    {
        return this.ip_gerenciamento;
    }

    public void setIp_gerenciamento(java.lang.String ip_gerenciamento)
    {
        this.ip_gerenciamento = ip_gerenciamento;
    }

    public RequisicaoVM(int quantidade_vm, int numero_vcpus, int quantidade_ram,
                        java.lang.String so, java.lang.String extraInfo, long numeroProjeto,
                        java.lang.String cliente, java.lang.String ip_producao,
                        java.lang.String ip_backup, java.lang.String ip_gerenciamento)
    {
        this.quantidade_vm = quantidade_vm;
        this.numero_vcpus = numero_vcpus;
        this.quantidade_ram = quantidade_ram;
        this.so = so;
        this.extraInfo = extraInfo;
        this.numeroProjeto = numeroProjeto;
        this.cliente = cliente;
        this.ip_producao = ip_producao;
        this.ip_backup = ip_backup;
        this.ip_gerenciamento = ip_gerenciamento;
    }

}
