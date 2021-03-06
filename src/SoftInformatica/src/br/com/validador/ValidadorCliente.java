/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.validador;

import br.com.model.Clientes;

/**
 *
 * @author Otavio
 */
//Validador dos dados do cliente
public class ValidadorCliente {

    public static String validar(Clientes cliente) {

        //Verifica se foi especificado um cliente
        if (cliente == null || "".equals(cliente)) {
            return "Campo cliente é obrigatório";
        }
        
        //Verifica se o nome foi informado
        if (cliente.getNome() == null || "".equals(cliente.getNome())) {
            return "É necessário informar o nome";
        }

        //Verifica se o sexo foi informado
        if (cliente.getSexo() == null || "".equals(cliente.getSexo())
                || (!cliente.getSexo().equals("Masculino"))
                && !cliente.getSexo().equals("Feminino")) {

            return "É necessário informar o sexo";

        }

        //Verifica se foi informado o cpf
        if (cliente.getCpf() == null || "".equals(cliente.getCpf())) {
            return "É necessário informar o cpf";
        }

        //Verifica se foi informado o rg
        if (cliente.getRg() == null || "".equals(cliente.getRg())) {
            return "É necessário informar o rg";
        }

        //Verifica se a data de nascimento foi informada 
        if (cliente.getDataNasc() == null) {
            return "É necessário informar a data de nascimento";
        }

        //Verifica se o cep foi informado
        if (cliente.getCep() == null || "".equals(cliente.getCep())) {
            return "É necessário informar o cep";
        }

        //Verifica se o endereço foi informado
        if (cliente.getEndereco() == null || "".equals(cliente.getEndereco())) {
            return "É necessário informar o endereço";
        }
        
        //Verifica numero do endereço informado
        if (cliente.getNumero() == null || cliente.getNumero() <= 0) {
            return "É necessário informar o numero do endereço";
        }

        //Verifica se o telefone foi informado
        if (cliente.getTelefone() == null || "".equals(cliente.getTelefone())) {
            return "É necessário informar o telefone";
        }

        //retorna null se todos os campos estiverem corretos
        return null;

    }

}
