/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfsconsultoria.radiologic.dao;

import br.com.nfsconsultoria.radiologic.domain.Convenio;
import br.com.nfsconsultoria.radiologic.domain.Exame;
import java.math.BigDecimal;
import org.junit.Test;

/**
 *
 * @author luis
 */
public class ExameDAOTest {
   
    @Test
    public void testSomeMethod() {
        ExameDAO exameDAO = new ExameDAO();
        Exame exame = new Exame();
        ConvenioDAO convenioDAO = new ConvenioDAO();
        Convenio convenio = convenioDAO.buscarNome("OdontoPrev");
        
        exame.setNome("Panoramica");
        exame.setValor(new BigDecimal(70.20));
        exame.setConvenioIdconvenio(convenio);
        exameDAO.salvar(exame);
    }
    
}
