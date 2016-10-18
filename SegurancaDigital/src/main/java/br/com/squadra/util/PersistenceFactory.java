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

    // again, the container injects it
//    @PersistenceContext(unitName = "squadraPU")
    private EntityManager em;

    /**
     * Método estático responsável por fornecer uma referência à instância
     * privada de EntityManager.
     *
     * @return EntityManager
     */
//    @Produces
//    @RequestScoped
    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Método estático responsável por fechar a instância privada de
     * EntityManager.
     *
     * @param manager @Disposes 
     */
    public static void closeEntityManager(EntityManager manager) {
        try {
            manager.close();
        } catch (Exception e) {
            Mensagem.getInstance().erro("Erro ao fechar conexão"+e.getMessage());
        }
    }
}
