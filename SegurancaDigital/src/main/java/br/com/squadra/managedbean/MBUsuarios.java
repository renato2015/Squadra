package br.com.squadra.managedbean;

import br.com.squadra.controller.ControllerUsuarios;
import br.com.squadra.entities.BeanUsuarios;
import br.com.squadra.util.Criptografia;
import br.com.squadra.util.Mensagem;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Renato Borges Cardoso
 * @version 1.00
 */
@Named
@SessionScoped
public class MBUsuarios implements Serializable{
    
    private BeanUsuarios bUsuario = new BeanUsuarios();
    
    @Inject
    private EntityManager em;
    
    private String senha;

    /**
     * Metodo para logar no sistema
     * @return Retorna para a pagina de pesquisa
     */
    public String logar(){
        try {
            bUsuario = ControllerUsuarios.getInstance().pesqId(em, bUsuario.getIdUsuario());
            if(bUsuario != null){
                if(bUsuario.getSenha().equals(Criptografia.criptografiaSenha(senha))){
                    HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    httpSession.setAttribute("usuario", bUsuario.getNome());
                    return "sistema/pesquisa.xhtml?faces-redirect=true";
                }else{
                    Mensagem.getInstance().erro("Usuário sem permissão para entrar no sistema.");
                }
            }else{
                Mensagem.getInstance().erro("Usuário não encontrado.");
            }
        } catch (Exception e) {
            Mensagem.getInstance().erro("Erro ao realizar operação.");
        }
        return "";
    }
    
    /**
     * Metodo para deslogar do sistema
     * @return Retorna para a pagina de login
     */
    public String deslogar(){
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSession.removeAttribute("usuario");
        return "/index.xhtml?faces-redirect=true";
    }

    
    
    public BeanUsuarios getbUsuario() {
        return bUsuario;
    }

    public void setbUsuario(BeanUsuarios bUsuario) {
        this.bUsuario = bUsuario;
    }
    

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
