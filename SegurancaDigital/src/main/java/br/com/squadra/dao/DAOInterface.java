package br.com.squadra.dao;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Renato Borges Cardoso
 * @version 1.00
 * @param <Entidade>
 */
public interface DAOInterface<Entidade> {

    public void salvar(EntityManager em, Entidade ent );

    public void alterar(EntityManager em, Entidade ent);

    public Entidade pesqId(EntityManager em, int id);

    public List<Entidade> lista(EntityManager em);
    
    public Entidade pesqNamedQuery(EntityManager em, String namedQuery, String param, String valor,int valorInt);
}
