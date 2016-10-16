package br.com.squadra.teste;

import br.com.squadra.dao.DAOUsuarios;
import br.com.squadra.entities.BeanUsuarios;
import br.com.squadra.util.Mensagem;
import br.com.squadra.util.PersistenceFactory;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.Test;

/**
 *
 * @author Renato Borges Cardoso
 */
public class TestUsuarios {

    private EntityManager em = null;
    BeanUsuarios bUsuario = new BeanUsuarios();

    DAOUsuarios daoUsuarios = new DAOUsuarios();

    public TestUsuarios() {
        em = PersistenceFactory.createEntityManager();
    }

//    @Test
    public void salvar() {
        try {
            bUsuario.setNome("renato");
            bUsuario.setSenha("12345");
            em.getTransaction().begin();
            daoUsuarios.salvar(em, bUsuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            Mensagem.getInstance().erro("Erro: " + e.getMessage());
        } finally {
            em.close();
        }
    }

//    @Test
    public void lista() {
        List<BeanUsuarios> lista = daoUsuarios.lista(em);
        for (BeanUsuarios obj : lista) {
            System.out.println("Nome:" + obj.getNome());
        }
    }

//    @Test
    public void pesqId() {
        bUsuario = daoUsuarios.pesqId(em, 1);
        System.out.println("Nome:" + bUsuario.getNome());
    }

    @Test
    public void pesqNamedQuery() {
        bUsuario = daoUsuarios.pesqNamedQuery(em, "BeanUsuarios.findByNome","nome","renato",0);
        System.out.println("Senha: " + bUsuario.getSenha());
    }

}
