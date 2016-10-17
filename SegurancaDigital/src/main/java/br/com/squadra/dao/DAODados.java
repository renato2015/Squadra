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
    
    private static DAODados instance;
    
    public static DAODados getInstance(){
        if(instance == null){
            instance = new DAODados();
        }
        return instance;
    }

    /**
     * Metodo que persiste o objeto no banco de dados
     * @param em EntityManager
     * @param ent Classe de entidade quer vai ser salvo
     */
    @Override
    public void salvar(EntityManager em, BeanDados ent) {
        em.persist(ent);
    }

    /**
     * Metodo que altera no banco de dados
     * @param em EntityManager
     * @param ent Classe de entidade quer vai ser alterado
     */
    @Override
    public void alterar(EntityManager em, BeanDados ent) {
        em.merge(ent);
    }

    /**
     * Metodo que pesquisa pelo id da entidade
     * @param em EntityManager
     * @param id Valor do id
     * @return 
     */
    @Override
    public BeanDados pesqId(EntityManager em, int id) {
        return em.find(BeanDados.class, id);
    }

    /**
     * Metodo que lista todos os dados do banco
     * @param em EntityManager
     * @return Lista de objeto do tipo BeanDados
     */
    @Override
    public List<BeanDados> lista(EntityManager em) {
        return em.createQuery("SELECT o FROM BeanDados o").getResultList();
    }

    /**
     * Metodo que pesquisa pela namedQuery na classe de entidade
     * @param em EntityManager
     * @param namedQuery Nome da query
     * @param param Parametro a ser passado
     * @param valor 
     * @param valorInt
     * @return Retorna objeto do tipo BeanDados
     */
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
