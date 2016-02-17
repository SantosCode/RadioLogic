/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfsconsultoria.radiologic.dao;

import br.com.nfsconsultoria.radiologic.domain.Convenio;
import org.junit.Test;

/**
 *
 * @author luis
 */
public class ConvenioDAOTest {
    
    public ConvenioDAOTest() {
    }
  
    @Test
    public void salvar() {
        
            ConvenioDAO convenioDAO = new ConvenioDAO();
            Convenio convenio = new Convenio();
            
            convenio.setNome("OdontoPrev");
            convenioDAO.salvar(convenio);
    }
    
}
