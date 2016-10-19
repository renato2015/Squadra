package br.com.squadra.dao;

import br.com.squadra.entities.BeanControle;
import br.com.squadra.util.Mensagem;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author Renato
 */
public class DAOControle implements DAOInterface<BeanControle> {

    private static DAOControle instance;

    public static DAOControle getInstance() {
        if (instance == null) {
            instance = new DAOControle();
        }
        return instance;
    }

    /**
     * Metodo que persiste o objeto no banco de dados
     *
     * @param em EntityManager
     * @param ent Classe de entidade quer vai ser salvo
     */
    @Override
    public void salvar(EntityManager em, BeanControle ent) {
        em.persist(ent);
    }

    /**
     * Metodo que altera no banco de dados
     *
     * @param em EntityManager
     * @param ent Classe de entidade quer vai ser alterado
     */
    @Override
    public void alterar(EntityManager em, BeanControle ent) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<BeanControle>> constraintViolations = validator.validate(ent);
        if (constraintViolations.size() > 0) {
            Iterator<ConstraintViolation<BeanControle>> iterator = constraintViolations.iterator();
            while (iterator.hasNext()) {
                ConstraintViolation<BeanControle> cv = iterator.next();
                System.err.println(cv.getRootBeanClass().getName() + "." + cv.getPropertyPath() + " " + cv.getMessage());

                Mensagem.getInstance().erro(cv.getRootBeanClass().getSimpleName() + "." + cv.getPropertyPath() + " " + cv.getMessage());
//                JsfUtil.addErrorMessage(cv.getRootBeanClass().getSimpleName() + "." + cv.getPropertyPath() + " " + cv.getMessage());
            }
        } else {
            em.merge(ent);
        }
        
    }

    /**
     * Metodo que pesquisa pelo id da entidade
     *
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
     *
     * @param em EntityManager
     * @return Lista de objeto do tipo BeanControle
     */
    @Override
    public List<BeanControle> lista(EntityManager em) {
        return em.createQuery("SELECT o FROM BeanControle o").getResultList();
    }

    /**
     * Metodo que pesquisa pela namedQuery na classe de entidade
     *
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
        if (!valor.equals("")) {
            query.setParameter(param, valor);
        } else {
            query.setParameter(param, valorInt);
        }
        return (BeanControle) query.getSingleResult();
    }

    @Override
    public BeanControle pesqUltimoRegistro(EntityManager em) {
        Query query = em.createQuery("SELECT o FROM BeanControle o ORDER BY o.idControle DESC ");
        return (BeanControle) query.setMaxResults(1).getSingleResult();
    }

    /**
     * Metodo que pesquisa com like, utilizado para autocomplete
     *
     * @param em
     * @param campo
     * @param valor
     * @return Lista de objeto
     */
    @Override
    public List<BeanControle> pesqComLike(EntityManager em, String campo, String valor) {
        String hql = "FROM BeanControle o WHERE o." + campo + " LIKE '%" + valor + "%'";
        Query query = em.createQuery(hql);
//      query.setParameter("param", "'%" + valor + "%'");
        return query.getResultList();
    }

}
