package br.com.squadra.dao;

import br.com.squadra.entities.BeanDados;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Renato Borges Cardoso
 * @version 1.00
 */
public class DAODados implements DAOInterface<BeanDados>{

    @Override
    public void salvar(EntityManager em, BeanDados ent) {
        em.persist(ent);
    }

    @Override
    public void alterar(EntityManager em, BeanDados ent) {
        em.merge(ent);
    }

    @Override
    public BeanDados pesqId(EntityManager em, int id) {
        return em.find(BeanDados.class, id);
    }

    @Override
    public List<BeanDados> lista(EntityManager em) {
        return em.createQuery("SELECT o FROM BeanDados o").getResultList();
    }

    @Override
    public BeanDados pesqNamedQuery(EntityManager em, String namedQuery, String param, String valor, int valorInt) {
        Query query = em.createNamedQuery(namedQuery);
        if(!valor.equals("")){
            query.setParameter(param, valor);
        }else{
            query.setParameter(param, valorInt);
        }
        return (BeanDados) query.getSingleResult();
    }
    
}
