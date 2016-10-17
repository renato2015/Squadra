package br.com.squadra.managedbean;

import br.com.squadra.controller.ControllerUsuarios;
import br.com.squadra.entities.BeanUsuarios;
import br.com.squadra.util.Criptografia;
import br.com.squadra.util.Mensagem;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Renato Borges Cardoso
 * @version 1.00
 */
@ManagedBean(name = "usuario")
public class MBUsuarios implements Serializable{
    
    @Inject
    private BeanUsuarios bUsuario;
    @Inject
    private EntityManager em;
    
    private String senha;

    public void logar(){
        try {
            bUsuario = ControllerUsuarios.getInstance().pesqId(em, bUsuario.getIdUsuario());
            if(bUsuario != null){
                System.out.println(bUsuario.getSenha());
                if(bUsuario.getSenha().equals(Criptografia.criptografiaSenha(senha))){
                    HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    httpSession.setAttribute("usuario", bUsuario.getNome());
                }else{
                    Mensagem.getInstance().erro("Usuário sem permissão para entrar no sistema.");
                }
            }else{
                Mensagem.getInstance().erro("Usuário não encontrado.");
            }
        } catch (Exception e) {
            Mensagem.getInstance().erro(e.getMessage());
        }
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
