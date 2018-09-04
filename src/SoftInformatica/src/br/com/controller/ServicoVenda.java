package br.com.controller;

import br.com.model.Venda;
import br.com.validador.ValidadorVenda;
import br.com.db.dao.DaoVenda;

public class ServicoVenda {
    
    //Insere uma venda na fonte de dados
    public static String registrarVenda (Venda venda, Float valorTotal){
        
        //variavel para armazenar a resposta do validador
        String resposta = null;
        
        //chamando o validador da venda
        resposta = ValidadorVenda.validarVenda(venda);
        
        //se o retorno for nulo quer dizer que a venda foi validada corretamente
        //e pode ser inserido na fonte de dados
        if(resposta == null){


            //Vamos chamar a fonte de dados. Como operações com a fonte de dados
            //sempre podem apresentar problemas (inclusive pela indicação de 
            //"throws" no método "inserir" da fonte de dados), é necessário 
            //tratar estes possíveis problemas com try/catch
            try {

                //Realiza a chamada de inserção na fonte de dados,
                //passando a venda fornecida como parâmetro na chamada
                //do serviço para ser inserida na fonte de dados
                //MockVenda.inserirVenda(venda);
                DaoVenda.inserirVenda(venda, valorTotal);

            } catch (Exception e) {
                //Imprime qualquer erro técnico no console e devolve
                //uma mensagem amigável a camada de visão, utilizando a
                //variável resposta para tanto
                e.printStackTrace();
                resposta = "Erro na fonte de dados";
            }
        //Retorna a resposta para a classe que chamou o serviço
        //Se não houver resposta, o cliente foi inserido corretamente
        }          
        return resposta;      
        
    }
    
}
