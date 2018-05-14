/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.mock.MockProduto;
import br.com.model.Produto;
import br.com.validador.ValidadorProduto;
import java.util.List;

/**
 *
 * @author rubens.fhuneke
 */

//Classe de serviço de produto
public class ServicoProduto {

    //Insere um cliente na fonte de dados
    public static String cadastrarProduto(Produto produto) {
        
        //Cria uma variável de resposta para retorno
        String resposta = null;

        //Chama o validador para verificar o estado deste produto
        //e armazena sua resposta na variável de resposta
        resposta = ValidadorProduto.validar(produto);

        //Se o retorno do validador for "null", o produto está válido
        //e pronto para ser inserido na fonte de dados
        if (resposta == null) {

            //Vamos chamar a fonte de dados. Como operações com a fonte de dados
            //sempre podem apresentar problemas (inclusive pela indicação de 
            //"throws" no método "inserir" da fonte de dados), é necessário 
            //tratar estes possíveis problemas com try/catch
            try {

                //Realiza a chamada de inserção na fonte de dados,
                //passando o produto fornecido como parâmetro na chamada
                //do serviço para ser inserido na fonte de dados
                MockProduto.inserir(produto);

            } catch (Exception e) {
                //Imprime qualquer erro técnico no console e devolve
                //uma mensagem amigável a camada de visão, utilizando a
                //variável resposta para tanto
                e.printStackTrace();
                resposta = "Erro na fonte de dados";
            }

        }

        //Retorna a resposta para a classe que chamou o serviço
        //Se não houver resposta, o produto foi inserido corretamente
        return resposta;
    }

    //Atualiza um produto na fonte de dados
    public static String atualizarProduto(Produto produto) {
        
        //Cria uma variável de resposta para retorno
        String resposta = null;

        //Chama o validador para verificar o estado deste produto
        //e armazena sua resposta na variável de resposta
        resposta = ValidadorProduto.validar(produto);

        //Se o retorno do validador for "null", o produto está válido
        //e pronto para ser atualizado na fonte de dados
        if (resposta == null) {

            //Vamos chamar a fonte de dados. Como operações com a fonte de dados
            //sempre podem apresentar problemas (inclusive pela indicação de 
            //"throws" no método "atualizar" da fonte de dados), é necessário 
            //tratar estes possíveis problemas com try/catch
            try {

                //Realiza a chamada de atualização na fonte de dados
                MockProduto.atualizar(produto);

            } catch (Exception e) {

                //Imprime qualquer erro técnico no console e devolve
                //uma mensagem amigável a camada de visão, utilizando a
                //variável resposta para tanto
                e.printStackTrace();
                resposta = "Erro na fonte de dados";
            }
        }

        //Retorna a resposta para a classe que chamou o serviço
        //Se não houver resposta, o produto foi atualizado corretamente
        return resposta;        
        
    }

    //Exclui o produto com ID informado do mock
    public static String excluirProduto(Integer id) {
        
        //Cria uma variável de resposta para retorno
        String resposta = null;

        try {

            //Solicita a fonte de dados a exclusão do produto informado
            MockProduto.excluir(id);

        } catch (Exception e) {
            
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            resposta = "Erro na fonte de dados";
            
        }

        return resposta;
    }

    //Realiza a pesquisa de um produto por nome na fonte de dados
    public static List<Produto> procurarProduto(String nome, String ean) {
        
        //Declara uma variável para armazenar a resposta da fonte de dados
        List<Produto> listaResposta = null;

        //Vamos chamar a fonte de dados. Como operações com a fonte de dados
        //sempre podem apresentar problemas (inclusive pela indicação de 
        //"throws" nos métodos "listar" e "procurar" da fonte de dados), é
        //necessário tratar estes possíveis problemas com try/catch
        try {

            //Verifica se um parâmetro de pesquisa não foi informado.
            //Caso afirmativo, realiza uma listagem simples.
            //Caso contrário, realiza uma pesquisa com o parâmetro fornecido
            
            if (nome == null || "".equals(nome)) {
                listaResposta = MockProduto.listar();
            } else if (ean == null || "".equals(ean)) {
                listaResposta = MockProduto.listar();
            }else if (ean != "") {
                listaResposta = MockProduto.procurar(ean);
            }else {
                listaResposta = MockProduto.procurar(nome);
            }

        } catch (Exception e) {
            
            //Imprime qualquer erro técnico no console
            e.printStackTrace();
            
        }

        //Retorna a lista de produtos encontrados na fonte de dados
        //para a classe que chamou este método do serviço
        return listaResposta;
    }

    //Obtem o cliente com ID informado do mock
    public static Produto obterProduto(Integer id) {
        
        //Declara uma variável para armazenar a resposta da fonte de dados
        Produto produtoResposta = null;

        //Vamos chamar a fonte de dados. Como operações com a fonte de dados
        //sempre podem apresentar problemas (inclusive pela indicação de 
        //"throws" no método "obter" da fonte de dados), é necessário tratar
        //estes possíveis problemas com try/catch
        try {

            //Retorna o produto obtido com a fonte de dados
            produtoResposta = MockProduto.obter(id);

        } catch (Exception e) {
            
            //Imprime qualquer erro técnico no console
            e.printStackTrace();
            
        }

        //Retorna o produto encontrado na fonte de dados que tenha o ID
        //fornecido como parâmetro para a classe que chamou este método do
        //serviço
        return produtoResposta;
        
    }

}
