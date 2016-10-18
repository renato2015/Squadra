package br.com.squadra.util;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Renato Borges
 */
@ManagedBean
public class Paginas implements Serializable {

    public String novo() {
        return "incluir.xhtml?faces-redirect=true";
    }

    public String pesquisa() {
        return "/sistema/pesquisa.xhtml?faces-redirect=true";
    }

    public String alterar() {
        return "alterar";
    }

}
