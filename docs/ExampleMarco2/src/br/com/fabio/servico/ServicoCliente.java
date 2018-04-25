package br.com.fabio.servico;

import br.com.fabio.mock.MockCliente;
import br.com.fabio.model.clientes.Cliente;
import br.com.fabio.model.validador.ValidadorCliente;
import java.util.List;

//Classe de serviço de cliente
public class ServicoCliente {

    //Insere um cliente na fonte de dados
    public static String cadastrarCliente(Cliente cliente) {
        
        //Cria uma variável de resposta para retorno
        String resposta = null;

        //Chama o validador para verificar o estado deste cliente
        //e armazena sua resposta na variável de resposta
        resposta = ValidadorCliente.validar(cliente);

        //Se o retorno do validador for "null", o cliente está válido
        //e pronto para ser inserido na fonte de dados
        if (resposta == null) {

            //Vamos chamar a fonte de dados. Como operações com a fonte de dados
            //sempre podem apresentar problemas (inclusive pela indicação de 
            //"throws" no método "inserir" da fonte de dados), é necessário 
            //tratar estes possíveis problemas com try/catch
            try {

                //Realiza a chamada de inserção na fonte de dados,
                //passando o cliente fornecido como parâmetro na chamada
                //do serviço para ser inserido na fonte de dados
                MockCliente.inserir(cliente);

            } catch (Exception e) {
                //Imprime qualquer erro técnico no console e devolve
                //uma mensagem amigável a camada de visão, utilizando a
                //variável resposta para tanto
                e.printStackTrace();
                resposta = "Erro na fonte de dados";
            }

        }

        //Retorna a resposta para a classe que chamou o serviço
        //Se não houver resposta, o cliente foi inserido corretamente
        return resposta;
    }

    //Atualiza um cliente na fonte de dados
    public static String atualizarCliente(Cliente cliente) {
        
        //Cria uma variável de resposta para retorno
        String resposta = null;

        //Chama o validador para verificar o estado deste cliente
        //e armazena sua resposta na variável de resposta
        resposta = ValidadorCliente.validar(cliente);

        //Se o retorno do validador for "null", o cliente está válido
        //e pronto para ser atualizado na fonte de dados
        if (resposta == null) {

            //Vamos chamar a fonte de dados. Como operações com a fonte de dados
            //sempre podem apresentar problemas (inclusive pela indicação de 
            //"throws" no método "atualizar" da fonte de dados), é necessário 
            //tratar estes possíveis problemas com try/catch
            try {

                //Realiza a chamada de atualização na fonte de dados
                MockCliente.atualizar(cliente);

            } catch (Exception e) {

                //Imprime qualquer erro técnico no console e devolve
                //uma mensagem amigável a camada de visão, utilizando a
                //variável resposta para tanto
                e.printStackTrace();
                resposta = "Erro na fonte de dados";
            }
        }

        //Retorna a resposta para a classe que chamou o serviço
        //Se não houver resposta, o cliente foi atualizado corretamente
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
            
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            resposta = "Erro na fonte de dados";
            
        }

        return resposta;
    }

    //Realiza a pesquisa de um cliente por nome/sobrenome na fonte de dados
    public static List<Cliente> procurarCliente(String nome) {
        
        //Declara uma variável para armazenar a resposta da fonte de dados
        List<Cliente> listaResposta = null;

        //Vamos chamar a fonte de dados. Como operações com a fonte de dados
        //sempre podem apresentar problemas (inclusive pela indicação de 
        //"throws" nos métodos "listar" e "procurar" da fonte de dados), é
        //necessário tratar estes possíveis problemas com try/catch
        try {

            //Verifica se um parâmetro de pesquisa não foi informado.
            //Caso afirmativo, realiza uma listagem simples.
            //Caso contrário, realiza uma pesquisa com o parâmetro fornecido
            if (nome == null || "".equals(nome)) {
                listaResposta = MockCliente.listar();
            } else {
                listaResposta = MockCliente.procurar(nome);
            }

        } catch (Exception e) {
            
            //Imprime qualquer erro técnico no console
            e.printStackTrace();
            
        }

        //Retorna a lista de clientes encontrados na fonte de dados
        //para a classe que chamou este método do serviço
        return listaResposta;
    }

    //Obtem o cliente com ID informado do mock
    public static Cliente obterCliente(Integer id) {
        
        //Declara uma variável para armazenar a resposta da fonte de dados
        Cliente clienteResposta = null;

        //Vamos chamar a fonte de dados. Como operações com a fonte de dados
        //sempre podem apresentar problemas (inclusive pela indicação de 
        //"throws" no método "obter" da fonte de dados), é necessário tratar
        //estes possíveis problemas com try/catch
        try {

            //Retorna o cliente obtido com a fonte de dados
            clienteResposta = MockCliente.obter(id);

        } catch (Exception e) {
            
            //Imprime qualquer erro técnico no console
            e.printStackTrace();
            
        }

        //Retorna o clientes encontrado na fonte de dados que tenha o ID
        //fornecido como parâmetro para a classe que chamou este método do
        //serviço
        return clienteResposta;
        
    }

}
