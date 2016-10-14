package br.com.squadra.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Renato Borges Cardoso
 * @version 1.00
 */
@Entity
@Table(name="dados")
@XmlRootElement
public class Dados implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dados")
    private Integer idDados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descricao")
    @Size(min = 0, max = 100)
    private String descricao;
    @Column(name = "descricao")
    @Size(min = 0, max = 10)
    private String sigla;
    @Column(name = "email")
    private String email;
    @Column(name = "url")
    private String url;

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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idDados);
        hash = 53 * hash + Objects.hashCode(this.descricao);
        hash = 53 * hash + Objects.hashCode(this.sigla);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.url);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dados other = (Dados) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.sigla, other.sigla)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        if (!Objects.equals(this.idDados, other.idDados)) {
            return false;
        }
        return true;
    }
    
    
    
}
