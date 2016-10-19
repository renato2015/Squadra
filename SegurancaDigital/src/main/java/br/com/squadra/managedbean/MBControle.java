package br.com.squadra.managedbean;

import br.com.squadra.controller.ControllerControle;
import br.com.squadra.controller.ControllerDados;
import br.com.squadra.entities.BeanControle;
import br.com.squadra.entities.BeanDados;
import br.com.squadra.entities.BeanUsuarios;
import br.com.squadra.util.Mensagem;
import br.com.squadra.util.PersistenceFactory;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Renato Borges Cardoso
 * @version 1.00
 */
@Named
@ViewScoped
public class MBControle implements Serializable {

    private EntityManager em = null;

    private BeanDados bDados = new BeanDados();
    private BeanControle bControle = new BeanControle();

    private String novaJustificativa;
    
    public void abreConexao() {
        if (em == null) {
            em = PersistenceFactory.createEntityManager();
        }
    }

    public void fechaConexao() {
        if (em != null) {
            em.close();
            em = null;
        }
    }

    public MBControle() {
        abreConexao();
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        bDados = ControllerDados.getInstance().pesqId(em, Integer.parseInt(id));
        bControle = ControllerControle.getInstance().pesqUltimoRegistro(em);
        fechaConexao();
    }

    public void salvar(BeanUsuarios bUsuario) {
        try {
            abreConexao();
            em.getTransaction().begin();
            bControle.setIdUsuario(bUsuario);
            bControle.setJustificativa(novaJustificativa);
            ControllerControle.getInstance().salvar(em, bControle);
            em.getTransaction().commit();
            novaJustificativa = "" ;
            Mensagem.getInstance().informativo("Operação realizada com sucesso.");
        } catch (Exception e) {
            Mensagem.getInstance().erro("");
        } finally {
            fechaConexao();
        }
    }
    
    public void limpar() {
        RequestContext.getCurrentInstance().reset("formAlterar");
        bControle = null;
    }

    public BeanControle getbControle() {
        return bControle;
    }

    public BeanDados getbDados() {
        return bDados;
    }
    
    public String getNovaJustificativa() {
        return novaJustificativa;
    }

    public void setNovaJustificativa(String novaJustificativa) {
        this.novaJustificativa = novaJustificativa;
    }
    

}
