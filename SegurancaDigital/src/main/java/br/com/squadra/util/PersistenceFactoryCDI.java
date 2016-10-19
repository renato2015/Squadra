package br.com.squadra.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Renato
 */
public class PersistenceFactoryCDI {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("squadraPU");
    
    private EntityManager em;

    @Produces
    @RequestScoped
    public EntityManager criaEntityManager() {
        return factory.createEntityManager();
    }

    public void finaliza(@Disposes EntityManager manager) {
        manager.close();
    }
}
