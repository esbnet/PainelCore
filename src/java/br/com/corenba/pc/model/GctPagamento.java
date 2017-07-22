/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.corenba.pc.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edmilson
 */
@Entity
@Table(name = "gct_pagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GctPagamento.findAll", query = "SELECT g FROM GctPagamento g")
    , @NamedQuery(name = "GctPagamento.findByPagamentoId", query = "SELECT g FROM GctPagamento g WHERE g.pagamentoId = :pagamentoId")
    , @NamedQuery(name = "GctPagamento.findByDataPagamento", query = "SELECT g FROM GctPagamento g WHERE g.dataPagamento = :dataPagamento")
    , @NamedQuery(name = "GctPagamento.findByMesReferencia", query = "SELECT g FROM GctPagamento g WHERE g.mesReferencia = :mesReferencia")
    , @NamedQuery(name = "GctPagamento.findByValorPago", query = "SELECT g FROM GctPagamento g WHERE g.valorPago = :valorPago")})
public class GctPagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PagamentoId")
    private Integer pagamentoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DataPagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MesReferencia")
    private int mesReferencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ValorPago")
    private long valorPago;
    @JoinColumn(name = "ContratoId_FK", referencedColumnName = "ContratoId")
    @ManyToOne(optional = false)
    private GctContrato contratoIdFK;

    public GctPagamento() {
    }

    public GctPagamento(Integer pagamentoId) {
        this.pagamentoId = pagamentoId;
    }

    public GctPagamento(Integer pagamentoId, Date dataPagamento, int mesReferencia, long valorPago) {
        this.pagamentoId = pagamentoId;
        this.dataPagamento = dataPagamento;
        this.mesReferencia = mesReferencia;
        this.valorPago = valorPago;
    }

    public Integer getPagamentoId() {
        return pagamentoId;
    }

    public void setPagamentoId(Integer pagamentoId) {
        this.pagamentoId = pagamentoId;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public int getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(int mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public long getValorPago() {
        return valorPago;
    }

    public void setValorPago(long valorPago) {
        this.valorPago = valorPago;
    }

    public GctContrato getContratoIdFK() {
        return contratoIdFK;
    }

    public void setContratoIdFK(GctContrato contratoIdFK) {
        this.contratoIdFK = contratoIdFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagamentoId != null ? pagamentoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GctPagamento)) {
            return false;
        }
        GctPagamento other = (GctPagamento) object;
        if ((this.pagamentoId == null && other.pagamentoId != null) || (this.pagamentoId != null && !this.pagamentoId.equals(other.pagamentoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.corenba.pc.model.GctPagamento[ pagamentoId=" + pagamentoId + " ]";
    }
    
}
