/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.corenba.pc.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author edmilson
 */
@Entity
@Table(name = "gct_contrato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GctContrato.findAll", query = "SELECT g FROM GctContrato g")
    , @NamedQuery(name = "GctContrato.findByContratoId", query = "SELECT g FROM GctContrato g WHERE g.contratoId = :contratoId")
    , @NamedQuery(name = "GctContrato.findByCodigo", query = "SELECT g FROM GctContrato g WHERE g.codigo = :codigo")
    , @NamedQuery(name = "GctContrato.findByNome", query = "SELECT g FROM GctContrato g WHERE g.nome = :nome")
    , @NamedQuery(name = "GctContrato.findByDataInicio", query = "SELECT g FROM GctContrato g WHERE g.dataInicio = :dataInicio")
    , @NamedQuery(name = "GctContrato.findByDuracao", query = "SELECT g FROM GctContrato g WHERE g.duracao = :duracao")
    , @NamedQuery(name = "GctContrato.findByValorTotal", query = "SELECT g FROM GctContrato g WHERE g.valorTotal = :valorTotal")
    , @NamedQuery(name = "GctContrato.findBySaldo", query = "SELECT g FROM GctContrato g WHERE g.saldo = :saldo")})
public class GctContrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ContratoId")
    private Integer contratoId;
    @Size(max = 30)

    @Column(name = "Codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)

    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull

    @Column(name = "DataInicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Basic(optional = false)
    @NotNull

    @Column(name = "Duracao")
    @Temporal(TemporalType.DATE)
    private Date duracao;
    @Basic(optional = false)
    @NotNull

    @Column(name = "ValorTotal")
    private long valorTotal;
    @Basic(optional = false)
    @NotNull

    @Column(name = "Saldo")
    private long saldo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contratoIdFK")
    private Collection<GctPagamento> gctPagamentoCollection;

    public GctContrato() {
    }

    public GctContrato(Integer contratoId) {
        this.contratoId = contratoId;
    }

    public GctContrato(Integer contratoId, String nome, Date dataInicio, Date duracao, long valorTotal, long saldo) {
        this.contratoId = contratoId;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.duracao = duracao;
        this.valorTotal = valorTotal;
        this.saldo = saldo;
    }

    public Integer getContratoId() {
        return contratoId;
    }

    public void setContratoId(Integer contratoId) {
        this.contratoId = contratoId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDuracao() {
        return duracao;
    }

    public void setDuracao(Date duracao) {
        this.duracao = duracao;
    }

    public long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(long valorTotal) {
        this.valorTotal = valorTotal;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    @XmlTransient
    public Collection<GctPagamento> getGctPagamentoCollection() {
        return gctPagamentoCollection;
    }

    public void setGctPagamentoCollection(Collection<GctPagamento> gctPagamentoCollection) {
        this.gctPagamentoCollection = gctPagamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contratoId != null ? contratoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GctContrato)) {
            return false;
        }
        GctContrato other = (GctContrato) object;
        if ((this.contratoId == null && other.contratoId != null) || (this.contratoId != null && !this.contratoId.equals(other.contratoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.corenba.pc.model.GctContrato[ contratoId=" + contratoId + " ]";
    }
    
}
