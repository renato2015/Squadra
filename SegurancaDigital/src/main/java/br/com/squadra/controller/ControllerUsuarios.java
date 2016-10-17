package br.com.squadra.controller;

import br.com.squadra.dao.DAOUsuarios;
import br.com.squadra.entities.BeanUsuarios;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Renato Borges Cardoso
 * @version 1.00
 */
public class ControllerUsuarios {
  
    private static ControllerUsuarios instance;

    public static ControllerUsuarios getInstance() {
        if (instance == null) {
            instance = new ControllerUsuarios();
        }
        return instance;
    }

    /**
     * Metodo que persiste o objeto no banco de dados
     *
     * @param em
     * @param bUsuarios
     */
    public void salvar(EntityManager em, BeanUsuarios bUsuarios) {
        DAOUsuarios.getInstance().salvar(em, bUsuarios);
    }

    /**
     * Metodo que altera o objeto no banco de dados
     *
     * @param em
     * @param bUsuarios
     */
    public void alterar(EntityManager em, BeanUsuarios bUsuarios) {
        DAOUsuarios.getInstance().alterar(em, bUsuarios);
    }

    /**
     * Metodo que pesquisa pelo id da entidade
     *
     * @param em EntityManager
     * @param id Valor do id
     * @return
     */
    public BeanUsuarios pesqId(EntityManager em, int id) {
        return DAOUsuarios.getInstance().pesqId(em, id);
    }

    /**
     * Metodo que lista todos os dados do banco
     *
     * @param em EntityManager
     * @return Lista de objeto do tipo BeanUsuarios
     */
    public List<BeanUsuarios> lista(EntityManager em) {
        return DAOUsuarios.getInstance().lista(em);
    }

    /**
     * Metodo que pesquisa pela namedQuery na classe de entidade
     *
     * @param em EntityManager
     * @param namedQuery Nome da query
     * @param param Parametro a ser passado
     * @param valor
     * @param valorInt
     * @return Retorna objeto do tipo BeanUsuarios
     */
    public BeanUsuarios pesqNamedQuery(EntityManager em, String namedQuery, String param, String valor, int valorInt) {
        return DAOUsuarios.getInstance().pesqNamedQuery(em, namedQuery, param, valor, valorInt);
    }

}
