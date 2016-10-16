package br.com.squadra.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Renato Borges Cardoso
 * @version 1.00 14/10/2016
 */
public class PersistenceFactory {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("squadraPU");
    private static EntityManager em = null;

    /**
     * Método estático responsável por fornecer uma referência à instância
     * privada de EntityManager.
     *
     * @return EntityManager
     */
    public static EntityManager createEntityManager() {
        if (em == null || !em.isOpen()) {
            return em = emf.createEntityManager();
        } else {
            return em;
        }
    }

    /**
     * Método estático responsável por fechar a instância privada de
     * EntityManager.
     *
     */
    public static void closeEntityManager() {
        try {
            if(em.isOpen() || em != null){
                em.close();
            }
        } catch (Exception e) {
        }
    }
}
