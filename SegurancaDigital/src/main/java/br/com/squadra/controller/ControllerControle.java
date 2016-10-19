package br.com.squadra.controller;

import br.com.squadra.dao.DAOControle;
import br.com.squadra.entities.BeanControle;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Renato Borges Cardoso
 * @version 1.00
 */
public class ControllerControle {
  
    private static ControllerControle instance;

    public static ControllerControle getInstance() {
        if (instance == null) {
            instance = new ControllerControle();
        }
        return instance;
    }

    /**
     * Metodo que persiste o objeto no banco de dados
     *
     * @param em
     * @param bControle
     */
    public void salvar(EntityManager em, BeanControle bControle) {
        DAOControle.getInstance().salvar(em, bControle);
    }

    /**
     * Metodo que altera o objeto no banco de dados
     *
     * @param em
     * @param bControle
     */
    public void alterar(EntityManager em, BeanControle bControle) {
        DAOControle.getInstance().alterar(em, bControle);
    }

    /**
     * Metodo que pesquisa pelo id da entidade
     *
     * @param em EntityManager
     * @param id Valor do id
     * @return
     */
    public BeanControle pesqId(EntityManager em, int id) {
        return DAOControle.getInstance().pesqId(em, id);
    }

    /**
     * Metodo que lista todos os dados do banco
     *
     * @param em EntityManager
     * @return Lista de objeto do tipo BeanControle
     */
    public List<BeanControle> lista(EntityManager em) {
        return DAOControle.getInstance().lista(em);
    }

    /**
     * Metodo que pesquisa pela namedQuery na classe de entidade
     *
     * @param em EntityManager
     * @param namedQuery Nome da query
     * @param param Parametro a ser passado
     * @param valor
     * @param valorInt
     * @return Retorna objeto do tipo BeanControle
     */
    public BeanControle pesqNamedQuery(EntityManager em, String namedQuery, String param, String valor, int valorInt) {
        return DAOControle.getInstance().pesqNamedQuery(em, namedQuery, param, valor, valorInt);
    }
    
    public BeanControle pesqUltimoRegistro(EntityManager em){
        return DAOControle.getInstance().pesqUltimoRegistro(em);
    }

}
