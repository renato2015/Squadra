package br.com.squadra.managedbean;

import br.com.squadra.controller.ControllerDados;
import br.com.squadra.entities.BeanDados;
import br.com.squadra.util.Mensagem;
import br.com.squadra.util.PersistenceFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Renato Borges Cardoso
 * @version 1.00
 */
@Named
public class MBDados implements Serializable{

    private EntityManager em = null;

    private BeanDados bDados = new BeanDados();
    private BeanDados dadosSelecionado = new BeanDados();

    private List<BeanDados> listaDados = new ArrayList<>();

    private boolean renderizarPesquisa = false;

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
            Mensagem.getInstance().informativo("Operação realizada com sucesso.");
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

    public void pesquisar() {
        abreConexao();
//        if(bDados.getDescricao() != null){
//            listaDados = ControllerDados.getInstance().pesqComLike(em, "descricao", bDados.getDescricao());
//        }
//        fechaConexao();
        listaDados = this.listaTudo();
        renderizarPesquisa = true;
    }

    public void limpar() {
        RequestContext.getCurrentInstance().reset("formPesquisa");
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
