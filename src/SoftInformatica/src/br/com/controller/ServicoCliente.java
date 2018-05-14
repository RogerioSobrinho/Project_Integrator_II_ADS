/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import java.util.List;
import br.com.model.Clientes;
import br.com.validador.ValidadorCliente;
import br.com.mock.MockCliente;

/**
 *
 * @author jose.ofbcarvalho
 */
public class ServicoCliente {

    //Insere um cliente na fonte de dados
    public static String cadastrarCliente(Clientes cliente) {

        //Cria uma variável de resposta para retorno
        String resposta = null;

        //Chama o validador para verificar o estado deste cliente
        resposta = ValidadorCliente.validar(cliente);

        //Se o retorno do validador for "null", o cliente está válido
        if (resposta == null) {

            try {

                //Realiza a chamada de inserção na fonte de dados
                MockCliente.inserir(cliente);

            } catch (Exception e) {
                //Imprime qualquer erro técnico no console

                e.printStackTrace();
                resposta = "Erro na fonte de dados";
            }

        }

        //Retorna a resposta para a classe que chamou o serviço
        //Se não houver resposta, o cliente foi inserido corretamente
        return resposta;
    }

    //Atualiza um cliente
    public static String atualizarCliente(Clientes cliente) {

        //Cria uma variável de resposta para retorno
        String resposta = null;

        //Chama o validador para verificar o estado deste cliente
        //e armazena sua resposta na variável de resposta
        resposta = ValidadorCliente.validar(cliente);

        //Se o retorno do validador for "null", o cliente está válido
        if (resposta == null) {

            try {

                //Realiza a chamada de atualização na fonte de dados
                MockCliente.atualiza(cliente);

            } catch (Exception e) {

                //Imprime qualquer erro técnico no console
                e.printStackTrace();
                resposta = "Erro na fonte de dados";
            }
        }

        //Retorna a resposta para a classe que chamou o serviço
        return resposta;

    }

    //Exclui o cliente com ID informado do mock
    public static String excluirCliente(Integer id) {

        //Cria uma variável de resposta para retorno
        String resposta = null;

        try {

            //Solicita a fonte de dados a exclusão do cliente informado
            MockCliente.excluir(id);

        } catch (Exception e) {

            //Imprime qualquer erro técnico no console
            e.printStackTrace();
            resposta = "Erro na fonte de dados";

        }

        return resposta;
    }

    //Realiza a pesquisa de um cliente por nome/sobrenome na fonte de dados
    public static List<Clientes> procurarCliente(String nome) {

        //Declara uma variável para armazenar a resposta da fonte de dados
        List<Clientes> listaResposta = null;

        try {

            //Verifica se um parâmetro de pesquisa não foi informado.
            if (nome == null || "".equals(nome)) {
                listaResposta = MockCliente.listar();
            } else {
                listaResposta = MockCliente.procurar(nome);
            }

        } catch (Exception e) {

            //Imprime qualquer erro técnico no console
            e.printStackTrace();

        }

        //Retorna a lista de clientes encontrados
        return listaResposta;
    }

    //Obtem o cliente com ID informado do mock
    public static Clientes obterCliente(Integer id) {

        //Declara uma variável para armazenar a resposta 
        Clientes clienteResposta = null;

        try {

            //Retorna o cliente obtido com a fonte de dados
            clienteResposta = MockCliente.obter(id);

        } catch (Exception e) {

            //Imprime qualquer erro técnico no console
            e.printStackTrace();

        }

        //Retorna o clientes encontrado 
        return clienteResposta;

    }

}
