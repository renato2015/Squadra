package br.com.squadra.managedbean;

import br.com.squadra.controller.ControllerDados;
import br.com.squadra.entities.BeanDados;
import br.com.squadra.util.Mensagem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
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
public class MBDados implements Serializable {

    @Inject
    private EntityManager em;

    private BeanDados bDados = new BeanDados();
    private BeanDados dadosSelecionado = new BeanDados();

    private List<BeanDados> listaDados = new ArrayList<>();

    private boolean renderizarPesquisa = false;

    public void salvar() {
        try {
            em.getTransaction().begin();
            bDados.setStatus("ATIVO");
            ControllerDados.getInstance().salvar(em, bDados);
            em.getTransaction().commit();
            limparIncluir();
            Mensagem.getInstance().informativo("Operação realizada com sucesso.");
        } catch (Exception e) {
            Mensagem.getInstance().erro("Erro ao realizar operação.");
        } 
    }

    public void alterar() {
        try {
            em.getTransaction().begin();
            ControllerDados.getInstance().alterar(em, bDados);
            em.getTransaction().commit();
        } catch (Exception e) {
            Mensagem.getInstance().erro("Erro ao realizar operação.");
        }
    }

    public List<BeanDados> listaTudo() {
        try {
            listaDados = ControllerDados.getInstance().lista(em);
        } catch (Exception e) {
            Mensagem.getInstance().erro("Erro ao realizar operação.");
        }
        return listaDados;
    }

    public void pesquisar() {
        try {
            if (bDados.getDescricao() != null) {
                listaDados = ControllerDados.getInstance().pesqComLike(em, "descricao", bDados.getDescricao());
            } else if (bDados.getSigla() != null) {
                listaDados = ControllerDados.getInstance().pesqComLike(em, "sigla", bDados.getDescricao());
            } else if (bDados.getEmail() != null) {
                listaDados = ControllerDados.getInstance().pesqComLike(em, "email", bDados.getDescricao());
            }
        } catch (Exception e) {
            Mensagem.getInstance().erro("Erro ao realizar operação.");
        }
        renderizarPesquisa = true;
    }

    public void limpar() {
        RequestContext.getCurrentInstance().reset("formPesquisa");
        renderizarPesquisa = false;
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
