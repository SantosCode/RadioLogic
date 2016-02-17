/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfsconsultoria.radiologic.dao;

import br.com.nfsconsultoria.radiologic.domain.Funcionario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

/**
 *
 * @author luis
 */
public class FuncionarioDAOTest {
   
    @Test
    public void salvar() {
        try {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            Funcionario funcionario = new Funcionario();
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date data = sdf.parse("07/01/1983");
            
            funcionario.setNome("Luis Santos");
            funcionario.setCpf("320.000.558-00");
            funcionario.setEmail("luis.santos@nfsconsultoria.com.br");
            funcionario.setEndereco("Rua Dr. Cândido ores, 160, São Paulo");
            funcionario.setNascimento(data);
            funcionario.setFuncao("Recepção");
            funcionario.setTelefone("(11) 98385-2579");
            funcionario.setLogin("luis.santos");
            funcionario.setSenha("Mudar123");
            
            funcionarioDAO.salvar(funcionario);
        } catch (ParseException ex) {
            Logger.getLogger(FuncionarioDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
