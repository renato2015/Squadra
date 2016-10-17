package br.com.squadra.dao;

import br.com.squadra.entities.BeanUsuarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Renato Borges Cardoso
 * @version 1.00
 */
public class DAOUsuarios implements DAOInterface<BeanUsuarios>{

    private static DAOUsuarios instance;
    
    public static DAOUsuarios getInstance(){
        if(instance == null){
            instance = new DAOUsuarios();
        }
        return instance;
    }
    
    /**
     * Metodo que persiste o objeto no banco de dados
     * @param em EntityManager
     * @param ent Classe de entidade quer vai ser salvo
     */
    @Override
    public void salvar(EntityManager em, BeanUsuarios ent) {
        em.persist(ent);
    }

    /**
     * Metodo que altera no banco de dados
     * @param em EntityManager
     * @param ent Classe de entidade quer vai ser alterado
     */
    @Override
    public void alterar(EntityManager em, BeanUsuarios ent) {
        em.merge(ent);
    }

    /**
     * Metodo que pesquisa pelo id da entidade
     * @param em EntityManager
     * @param id Valor do id
     * @return 
     */
    @Override
    public BeanUsuarios pesqId(EntityManager em,int id) {
        return em.find(BeanUsuarios.class, id);
    }

    /**
     * Metodo que lista todos os dados do banco
     * @param em EntityManager
     * @return Lista de objeto do tipo BeanUsuarios
     */
    @Override
    public List<BeanUsuarios> lista(EntityManager em) {
        Query query = em.createQuery("SELECT o FROM BeanUsuarios o");
        return query.getResultList();
    }
 
    
    /**
     * Metodo que pesquisa pela namedQuery na classe de entidade
     * @param em EntityManager
     * @param namedQuery Nome da query
     * @param param Parametro a ser passado
     * @param valor 
     * @param valorInt
     * @return Retorna objeto do tipo BeanUsuarios
     */
    @Override
    public BeanUsuarios pesqNamedQuery(EntityManager em, String namedQuery, String param, String valor,int valorInt) {
        Query query = em.createNamedQuery(namedQuery);
        if(!valor.equals("")){
            query.setParameter(param, valor);
        }else{
            query.setParameter(param, valorInt);
        }
        return (BeanUsuarios) query.getSingleResult();
    }

    
}
