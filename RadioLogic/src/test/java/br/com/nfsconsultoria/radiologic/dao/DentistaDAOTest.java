/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfsconsultoria.radiologic.dao;

import br.com.nfsconsultoria.radiologic.domain.Dentista;
import org.junit.Test;

/**
 *
 * @author luis
 */
public class DentistaDAOTest {
    
    public DentistaDAOTest() {
    }
    
    @Test
    public void salvar() {
       
        DentistaDAO dentistaDAO = new DentistaDAO();
        Dentista dentista = new Dentista();
        
       dentista.setNome("Paulo Renato");
       dentista.setEndereco("Rua Conselheiro Saraiva, 70, São Paulo");
       dentista.setClinica("Radiodoc");
       dentista.setTelefone("(11) 4106-3383");
       dentista.setEmail("paulo.renato@radiodoc.com.br");
       
       dentistaDAO.salvar(dentista);
    }
    
}
