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

    @Override
    public void salvar(EntityManager em, BeanControle ent) {
        em.persist(ent);
    }

    @Override
    public void alterar(EntityManager em, BeanControle ent) {
        em.merge(ent);
    }

    @Override
    public BeanControle pesqId(EntityManager em, int id) {
        return em.find(BeanControle.class, id);
    }

    @Override
    public List<BeanControle> lista(EntityManager em) {
        return em.createQuery("SELECT o FROM BeanControle o").getResultList();
    }

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