package br.com.squadra.teste;

import br.com.squadra.dao.DAOControle;
import br.com.squadra.dao.DAOUsuarios;
import br.com.squadra.entities.BeanControle;
import br.com.squadra.entities.BeanUsuarios;
import br.com.squadra.util.Mensagem;
import br.com.squadra.util.PersistenceFactory;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.junit.Test;

/**
 *
 * @author Renato Borges Cardoso
 */
public class TestControle {

    @Inject
    private EntityManager em ;
    
    BeanControle bControle = new BeanControle();
    BeanUsuarios bUsuarios = new BeanUsuarios();

    @Inject
    DAOControle daoControle ;
    
    @Inject
    DAOUsuarios daoUsuarios ;

    

//    @Test
    public void salvar() {
        try {
            em.getTransaction().begin();
            bUsuarios = daoUsuarios.pesqId(em, 1);
            if (bUsuarios != null) {
                bControle.setIdUsuario(bUsuarios);
                bControle.setJustificativa("Teste justificativa");
                bControle.setStatus('A');
                bControle.setDataUltAlteracao(new Date());
                em.getTransaction().begin();
                daoControle.salvar(em, bControle);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            Mensagem.getInstance().erro("Erro: " + e.getMessage());
        } finally {
            em.close();
        }
    }

//    @Test
    public void lista() {
        List<BeanControle> lista = daoControle.lista(em);
        for (BeanControle obj : lista) {
            System.out.println("Justificativa:" + obj.getJustificativa());
        }
    }

//    @Test
    public void pesqId() {
        bControle = daoControle.pesqId(em, 1);
        System.out.println("Justificativa:" + bControle.getJustificativa());
    }

    @Test
    public void pesqNamedQuery() {
        bControle = daoControle.pesqNamedQuery(em, "BeanControle.findByJustificativa", "justificativa", "Teste justificativa", 0);
        System.out.println("Justificativa: " + bControle.getJustificativa());
    }

}
