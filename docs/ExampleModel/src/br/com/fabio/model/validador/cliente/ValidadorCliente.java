package br.com.fabio.model.validador.cliente;

import br.com.fabio.model.cliente.Cliente;

//Validador de dados do cliente
public class ValidadorCliente {
    public static String validar(Cliente cliente) {
        //Realização de validações de negócio
        if (cliente == null) {
            return "Não foi informado um cliente";
        }
        if (cliente.getNome() == null || "".equals(cliente.getNome())) {
            return "É necessário informar um nome de cliente";
        }
        if (cliente.getSobrenome() == null
                || "".equals(cliente.getSobrenome())) {
            return "É necessário informar um sobrenome de cliente";
        }
        if (cliente.getDataNascimento() == null) {
            return "É necessário informar um valor de data de nascimento válido";
        }
        if (cliente.getGenero() == null || "".equals(cliente.getGenero())
                || (!cliente.getGenero().equals("Masculino"))
                && !cliente.getGenero().equals("Feminino")) {
            return "É necessário informar o gênero do cliente";
        }
        
        return null;
    }
}
