package br.com.squadra.controller;

import br.com.squadra.dao.DAODados;
import br.com.squadra.entities.BeanDados;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Renato Borges Cardoso
 * @version 1.00
 */
public class ControllerDados {

    private static ControllerDados instance;

    public static ControllerDados getInstance() {
        if (instance == null) {
            instance = new ControllerDados();
        }
        return instance;
    }

    /**
     * Metodo que persiste o objeto no banco de dados
     *
     * @param em
     * @param bDados
     */
    public void salvar(EntityManager em, BeanDados bDados) {
        DAODados.getInstance().salvar(em, bDados);
    }

    /**
     * Metodo que altera o objeto no banco de dados
     *
     * @param em
     * @param bDados
     */
    public void alterar(EntityManager em, BeanDados bDados) {
        DAODados.getInstance().alterar(em, bDados);
    }

    /**
     * Metodo que pesquisa pelo id da entidade
     *
     * @param em EntityManager
     * @param id Valor do id
     * @return
     */
    public BeanDados pesqId(EntityManager em, int id) {
        return DAODados.getInstance().pesqId(em, id);
    }

    /**
     * Metodo que lista todos os dados do banco
     *
     * @param em EntityManager
     * @return Lista de objeto do tipo BeanDados
     */
    public List<BeanDados> lista(EntityManager em) {
        return DAODados.getInstance().lista(em);
    }

    /**
     * Metodo que pesquisa pela namedQuery na classe de entidade
     *
     * @param em EntityManager
     * @param namedQuery Nome da query
     * @param param Parametro a ser passado
     * @param valor
     * @param valorInt
     * @return Retorna objeto do tipo BeanDados
     */
    public BeanDados pesqNamedQuery(EntityManager em, String namedQuery, String param, String valor, int valorInt) {
        return DAODados.getInstance().pesqNamedQuery(em, namedQuery, param, valor, valorInt);
    }

}
