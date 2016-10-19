package br.com.squadra.teste;

import br.com.squadra.controller.ControllerControle;
import br.com.squadra.entities.BeanControle;
import br.com.squadra.util.PersistenceFactory;
import javax.persistence.EntityManager;
import org.junit.Test;

/**
 *
 * @author Renato Borges Cardoso
 */
public class TestControle {
     private EntityManager em = null;
     
     private BeanControle bControle = new BeanControle();

    public TestControle() {
        em = PersistenceFactory.createEntityManager();
    }
     
//    @Test
    public void pesqUltimoRegistro(){
        bControle = ControllerControle.getInstance().pesqUltimoRegistro(em);
        System.out.println("Controle:" + bControle.getStatus());
    }
      
     
    
    
}
