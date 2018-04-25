/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fabio.test;

import br.com.fabio.model.cliente.Cliente;
import br.com.fabio.model.validador.cliente.ValidadorCliente;
import java.util.Date;
import java.util.List;

/**
 *
 * @author fabio.afreire
 */
public class TesteModeloCliente {
    public static void main(String[] args) {
        testeValidacaoCliente();
    }
    
    private static void testeValidacaoCliente() {
        //Criando um novo cliente
        Cliente cli = new Cliente();
        cli.setId(0);
        cli.setNome("Fabio");
        cli.setSobrenome("Henrique");
        cli.setDataNascimento(new Date());        
        cli.setGenero("Masculino");
        
        //Validando o cliente
        String resultado = ValidadorCliente.validar(cli);
        
        //Verifica o resultado, se == null (não há erros),
        //exibe uma mensagem de sucesso. Se houver erros
        //exibe-os no console (obtém os erros do retorno
        //do método)
        if (resultado == null) {            
            System.out.println("Válido!");
        }
        else {
            System.out.println("ERRO: " + resultado);
        }
    }    
}
