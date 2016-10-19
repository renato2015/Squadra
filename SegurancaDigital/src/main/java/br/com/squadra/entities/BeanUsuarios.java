/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.squadra.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Atendimento
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BeanUsuarios.findAll", query = "SELECT b FROM BeanUsuarios b"),
    @NamedQuery(name = "BeanUsuarios.findByIdUsuario", query = "SELECT b FROM BeanUsuarios b WHERE b.idUsuario = :idUsuario"),
    @NamedQuery(name = "BeanUsuarios.findByNome", query = "SELECT b FROM BeanUsuarios b WHERE b.nome = :nome"),
    @NamedQuery(name = "BeanUsuarios.findBySenha", query = "SELECT b FROM BeanUsuarios b WHERE b.senha = :senha")})
public class BeanUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
    @Size(max = 255)
    @Column(name = "senha")
    private String senha;
    @OneToMany(mappedBy = "idUsuario")
    private List<BeanControle> beanControleList;

    public BeanUsuarios() {
    }

    public BeanUsuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @XmlTransient
    public List<BeanControle> getBeanControleList() {
        return beanControleList;
    }

    public void setBeanControleList(List<BeanControle> beanControleList) {
        this.beanControleList = beanControleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BeanUsuarios)) {
            return false;
        }
        BeanUsuarios other = (BeanUsuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.squadra.entities.BeanUsuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
