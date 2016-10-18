package br.com.squadra.managedbean;

import br.com.squadra.entities.BeanControle;
import br.com.squadra.entities.BeanDados;
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
public class MBControle implements Serializable{
    private EntityManager em = null;
    
    private BeanDados dadosSelecionado = new BeanDados();
    
    private BeanControle bControle = new BeanControle();

    public MBControle() {
         String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap() .get("id");
         System.out.println("ID:" + id);
    }
    
    public void abreConexao(){
        if(em == null){
            em = PersistenceFactory.createEntityManager();
        }
    }
    
    public void fechaConexao(){
        if(em != null){
            em.close();
            em = null;
        }
    }
    
    public void salvar(){
        try {
            abreConexao();
        } catch (Exception e) {
            Mensagem.getInstance().erro("");
        }finally{
            fechaConexao();
        }
    }
    
    public void alterar(){
        try {
            abreConexao();
        } catch (Exception e) {
            Mensagem.getInstance().erro("");
        }finally{
            fechaConexao();
        }
    }
    
    public void listaTudo(){
        try {
            abreConexao();
        } catch (Exception e) {
            Mensagem.getInstance().erro("");
        }finally{
            fechaConexao();
        }
    }
    
    public void limpar(){
        RequestContext.getCurrentInstance().reset("");
        bControle = null;
    }

    
    public BeanControle getbControle() {
        return bControle;
    }

    public void setbControle(BeanControle bControle) {
        this.bControle = bControle;
    }

    public BeanDados getDadosSelecionado() {
        return dadosSelecionado;
    }

    public void setDadosSelecionado(BeanDados dadosSelecionado) {
        this.dadosSelecionado = dadosSelecionado;
    }
    
    
}
