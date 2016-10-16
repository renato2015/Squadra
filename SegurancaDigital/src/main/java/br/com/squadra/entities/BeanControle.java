/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.squadra.entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Renato
 */
@Entity
@Table(name = "controle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BeanControle.findAll", query = "SELECT b FROM BeanControle b"),
    @NamedQuery(name = "BeanControle.findByIdControle", query = "SELECT b FROM BeanControle b WHERE b.idControle = :idControle"),
    @NamedQuery(name = "BeanControle.findByStatus", query = "SELECT b FROM BeanControle b WHERE b.status = :status"),
    @NamedQuery(name = "BeanControle.findByDataUltAlteracao", query = "SELECT b FROM BeanControle b WHERE b.dataUltAlteracao = :dataUltAlteracao"),
    @NamedQuery(name = "BeanControle.findByJustificativa", query = "SELECT b FROM BeanControle b WHERE b.justificativa = :justificativa")})
public class BeanControle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_controle")
    private Integer idControle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private Character status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_ult_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltAlteracao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "justificativa")
    private String justificativa;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private BeanUsuarios idUsuario;

    public BeanControle() {
    }

    public BeanControle(Integer idControle) {
        this.idControle = idControle;
    }

    public BeanControle(Integer idControle, Character status, Date dataUltAlteracao, String justificativa) {
        this.idControle = idControle;
        this.status = status;
        this.dataUltAlteracao = dataUltAlteracao;
        this.justificativa = justificativa;
    }

    public Integer getIdControle() {
        return idControle;
    }

    public void setIdControle(Integer idControle) {
        this.idControle = idControle;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Date getDataUltAlteracao() {
        return dataUltAlteracao;
    }

    public void setDataUltAlteracao(Date dataUltAlteracao) {
        this.dataUltAlteracao = dataUltAlteracao;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public BeanUsuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BeanUsuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idControle != null ? idControle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BeanControle)) {
            return false;
        }
        BeanControle other = (BeanControle) object;
        if ((this.idControle == null && other.idControle != null) || (this.idControle != null && !this.idControle.equals(other.idControle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.squadra.entities.BeanControle[ idControle=" + idControle + " ]";
    }
    
}
