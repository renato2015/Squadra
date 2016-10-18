package br.com.squadra.managedbean;

import br.com.squadra.controller.ControllerDados;
import br.com.squadra.entities.BeanDados;
import br.com.squadra.util.Mensagem;
import br.com.squadra.util.PersistenceFactory;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Renato Borges Cardoso
 * @version 1.00
 */
@Named
@RequestScoped
public class MBDados {

    private EntityManager em = null;

    private BeanDados bDados = new BeanDados();
    private BeanDados dadosSelecionado = new BeanDados();

    private List<BeanDados> listaDados = new ArrayList<>();

    private boolean renderizarPesquisa = false;
    private boolean renderizarAlterar = false;

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

    public void salvar() {
        try {
            abreConexao();
            em.getTransaction().begin();
            bDados.setStatus("ATIVO");
            ControllerDados.getInstance().salvar(em, bDados);
            em.getTransaction().commit();
            limparIncluir();
            Mensagem.getInstance().informativo("salvou");
        } catch (Exception e) {
            Mensagem.getInstance().erro("" + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            fechaConexao();
        }
    }

    public void alterar() {
        try {
            abreConexao();
            em.getTransaction().begin();
            ControllerDados.getInstance().alterar(em, bDados);
            em.getTransaction().commit();
        } catch (Exception e) {
            Mensagem.getInstance().erro("");
            em.getTransaction().rollback();
        } finally {
            fechaConexao();
        }
    }

    public List<BeanDados> listaTudo() {
        try {
            abreConexao();
            em.getTransaction().begin();
            listaDados = ControllerDados.getInstance().lista(em);
            em.getTransaction().commit();
        } catch (Exception e) {
            Mensagem.getInstance().erro("");
        } finally {
            fechaConexao();
        }
        return listaDados;
    }

    public void dadosSel(BeanDados obj) {
        if (obj.getIdDados() != null) {
            bDados = dadosSelecionado;
            renderizarPesquisa = false;
            renderizarAlterar = true;
        }
    }

    public void pesquisar() {
        listaDados = this.listaTudo();
        renderizarPesquisa = true;
        renderizarAlterar = false;
    }

    public void limpar() {
        RequestContext.getCurrentInstance().reset("formPesquisa");
        bDados = null;
    }

    public void limparIncluir() {
        RequestContext.getCurrentInstance().reset("formIncluir");
        bDados = null;
    }

    //Getter And Setter
    public BeanDados getbDados() {
        return bDados;
    }

    public boolean isRenderizarPesquisa() {
        return renderizarPesquisa;
    }

    public boolean isRenderizarAlterar() {
        return renderizarAlterar;
    }

    public List<BeanDados> getListaDados() {
        return listaDados;
    }

    public BeanDados getDadosSelecionado() {
        return dadosSelecionado;
    }

    public void setDadosSelecionado(BeanDados dadosSelecionado) {
        this.dadosSelecionado = dadosSelecionado;
    }

}
