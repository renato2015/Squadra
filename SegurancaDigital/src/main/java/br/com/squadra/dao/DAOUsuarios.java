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

    @Override
    public void salvar(EntityManager em, BeanUsuarios ent) {
        em.persist(ent);
    }

    @Override
    public void alterar(EntityManager em, BeanUsuarios ent) {
        em.merge(ent);
    }

    @Override
    public BeanUsuarios pesqId(EntityManager em,int id) {
        return em.find(BeanUsuarios.class, id);
    }

    @Override
    public List<BeanUsuarios> lista(EntityManager em) {
        Query query = em.createQuery("SELECT o FROM BeanUsuarios o");
        return query.getResultList();
    }
 
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
