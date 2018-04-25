package br.com.fabio.model.validador;

import br.com.fabio.model.clientes.Cliente;

//Validador de dados do cliente
public class ValidadorCliente {

    public static String validar(Cliente cliente) {
        //Realização de validações de negócio
        //Verifica se foi especificado um cliente
        if (cliente == null) {
            return "Não foi informado um cliente";
        }

        //Verifica se o cliente tem nome definido
        if (cliente.getNome() == null || "".equals(cliente.getNome())) {
            return "É necessário informar um nome de cliente";
        }

        //Verifica se o cliente tem sobrenome
        if (cliente.getSobrenome() == null
                || "".equals(cliente.getSobrenome())) {
            return "É necessário informar um sobrenome de cliente";
        }

        //Verifica se o cliente tem data de nascimento
        if (cliente.getDataNascimento() == null) {
            return "É necessário informar um valor de data de nascimento"
                    + " válido";
        }

        //Verifica se o cliente tem um gênero e o mesmo é válido
        if (cliente.getGenero() == null || "".equals(cliente.getGenero())
                || (!cliente.getGenero().equals("Masculino"))
                && !cliente.getGenero().equals("Feminino")) {

            return "É necessário informar o gênero do cliente";

        }

        //Vetorna "null" indicando que todas as validações foram feitas e o
        //cliente é um cliente válido de acordo com as necessidades do negócio
        return null;
    }

}
