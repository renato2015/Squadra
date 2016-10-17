package br.com.squadra.managedbean;

import br.com.squadra.util.Mensagem;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Renato Borges Cardoso
 * @version 1.00
 */
@Named("dados")
@ViewScoped
public class MBDados{

    public MBDados() {
    }
    
    
    public void salvar(){
        Mensagem.getInstance().advertencia("Teste");
    }
    
    
    
}
