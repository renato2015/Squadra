/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.squadra.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Atendimento
 */
@Entity
@Table(name = "dados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BeanDados.findAll", query = "SELECT b FROM BeanDados b"),
    @NamedQuery(name = "BeanDados.findByIdDados", query = "SELECT b FROM BeanDados b WHERE b.idDados = :idDados"),
    @NamedQuery(name = "BeanDados.findByDescricao", query = "SELECT b FROM BeanDados b WHERE b.descricao = :descricao"),
    @NamedQuery(name = "BeanDados.findByEmail", query = "SELECT b FROM BeanDados b WHERE b.email = :email"),
    @NamedQuery(name = "BeanDados.findBySigla", query = "SELECT b FROM BeanDados b WHERE b.sigla = :sigla"),
    @NamedQuery(name = "BeanDados.findByUrl", query = "SELECT b FROM BeanDados b WHERE b.url = :url"),
    @NamedQuery(name = "BeanDados.findByStatus", query = "SELECT b FROM BeanDados b WHERE b.status = :status")})
public class BeanDados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dados")
    private Integer idDados;
    @Size(max = 100)
    @Column(name = "descricao")
    private String descricao;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 10)
    @Column(name = "sigla")
    private String sigla;
    @Size(max = 50)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "status")
    private String status;

    public BeanDados() {
    }

    public BeanDados(Integer idDados) {
        this.idDados = idDados;
    }

    public BeanDados(Integer idDados, String status) {
        this.idDados = idDados;
        this.status = status;
    }

    public Integer getIdDados() {
        return idDados;
    }

    public void setIdDados(Integer idDados) {
        this.idDados = idDados;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDados != null ? idDados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BeanDados)) {
            return false;
        }
        BeanDados other = (BeanDados) object;
        if ((this.idDados == null && other.idDados != null) || (this.idDados != null && !this.idDados.equals(other.idDados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.squadra.entities.BeanDados[ idDados=" + idDados + " ]";
    }
    
}
