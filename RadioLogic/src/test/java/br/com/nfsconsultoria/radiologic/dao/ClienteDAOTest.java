/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfsconsultoria.radiologic.dao;

import br.com.nfsconsultoria.radiologic.domain.Cliente;
import br.com.nfsconsultoria.radiologic.domain.Convenio;
import br.com.nfsconsultoria.radiologic.domain.Dentista;
import br.com.nfsconsultoria.radiologic.domain.Exame;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

/**
 *
 * @author luissantos
 */
public class ClienteDAOTest {
    
    @Test
    public void salvar() {
        
        try {
            Cliente cliente = new Cliente();
            ClienteDAO clienteDAO = new ClienteDAO();
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date data = sdf.parse("10/09/1984");
            
            DentistaDAO dentistaDAO = new DentistaDAO();
            Dentista dentista = dentistaDAO.buscarNome("Paulo Renato");
            
            ConvenioDAO convenioDAO = new ConvenioDAO();
            Convenio convenio = convenioDAO.buscarNome("Amil");
            
            ExameDAO exameDAO = new ExameDAO();
            Collection<Exame> exames = new ArrayList<>();
            exames.add(exameDAO.buscarCodigo(1L));
            exames.add(exameDAO.buscarCodigo(2L));
            
            cliente.setNome("Flavia Andrade");
            cliente.setCpf("320.000.558-00");
            cliente.setEndereco("Rua Renato Paes de Barro, 50, São Paulo");
            cliente.setEmail("flavia@hotmail.com");
            cliente.setNascimento(data);
            cliente.setTelefone("(11) 98385-2579");
            cliente.setNumConvenio(78658);
            cliente.setDentistaIddentista(dentista);
            cliente.setConvenioIdconvenio(convenio);
            cliente.setExameCollection(exames);
            clienteDAO.salvar(cliente);
            
        } catch (ParseException ex) {
            Logger.getLogger(ClienteDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
