package br.com.squadra.dao;

import br.com.squadra.entities.BeanControle;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Renato
 */
public class DAOControle implements DAOInterface<BeanControle>{

    private static DAOControle instance;
    
    public static DAOControle getInstance(){
        if(instance == null){
            instance = new DAOControle();
        }
        return instance;
    }
    
    /**
     * Metodo que persiste o objeto no banco de dados
     * @param em EntityManager
     * @param ent Classe de entidade quer vai ser salvo
     */
    @Override
    public void salvar(EntityManager em, BeanControle ent) {
        em.persist(ent);
    }

    /**
     * Metodo que altera no banco de dados
     * @param em EntityManager
     * @param ent Classe de entidade quer vai ser alterado
     */
    @Override
    public void alterar(EntityManager em, BeanControle ent) {
        em.merge(ent);
    }

    /**
     * Metodo que pesquisa pelo id da entidade
     * @param em EntityManager
     * @param id Valor do id
     * @return 
     */
    @Override
    public BeanControle pesqId(EntityManager em, int id) {
        return em.find(BeanControle.class, id);
    }

    /**
     * Metodo que lista todos os dados do banco
     * @param em EntityManager
     * @return Lista de objeto do tipo BeanControle
     */
    @Override
    public List<BeanControle> lista(EntityManager em) {
        return em.createQuery("SELECT o FROM BeanControle o").getResultList();
    }

    /**
     * Metodo que pesquisa pela namedQuery na classe de entidade
     * @param em EntityManager
     * @param namedQuery Nome da query
     * @param param Parametro a ser passado
     * @param valor 
     * @param valorInt
     * @return Retorna objeto do tipo BeanControle
     */
    @Override
    public BeanControle pesqNamedQuery(EntityManager em, String namedQuery, String param, String valor, int valorInt) {
        Query query = em.createNamedQuery(namedQuery);
        if(!valor.equals("")){
            query.setParameter(param, valor);
        }else{
            query.setParameter(param, valorInt);
        }
        return (BeanControle) query.getSingleResult();
    }
    
}