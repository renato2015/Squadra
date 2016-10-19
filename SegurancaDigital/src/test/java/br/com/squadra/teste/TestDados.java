package br.com.squadra.teste;

import br.com.squadra.dao.DAODados;
import br.com.squadra.entities.BeanDados;
import br.com.squadra.util.Mensagem;
import br.com.squadra.util.PersistenceFactory;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.Test;

/**
 *
 * @author Renato Borges Cardoso
 */
public class TestDados {

    private EntityManager em = null;
    BeanDados bDados = new BeanDados();

    DAODados daoDados = new DAODados();

    public TestDados() {
        em = PersistenceFactory.createEntityManager();
    }

    //    @Test
    public void salvar() {
        try {
            bDados.setDescricao("Dado 1");
            bDados.setEmail("renato.programador2015@gmail.com");
            bDados.setSigla("TE");
            bDados.setUrl("https://www.squadra.com.br/teste");
            em.getTransaction().begin();
            daoDados.salvar(em, bDados);
            em.getTransaction().commit();
        } catch (Exception e) {
            Mensagem.getInstance().erro("Erro: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    //    @Test
    public void lista() {
        List<BeanDados> lista = daoDados.lista(em);
        for (BeanDados obj : lista) {
            System.out.println("Descrição:" + obj.getDescricao());
        }
    }

    //    @Test
    public void pesqId() {
        bDados = daoDados.pesqId(em, 1);
        System.out.println("Descrição:" + bDados.getDescricao());
    }

    @Test
    public void pesqNamedQuery() {
        bDados = daoDados.pesqNamedQuery(em, "BeanDados.findByDescricao", "descricao", "Dado 1", 0);
        System.out.println("Descrição: " + bDados.getDescricao());
    }

}
