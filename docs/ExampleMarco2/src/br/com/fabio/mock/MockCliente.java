package br.com.fabio.mock;

import br.com.fabio.model.clientes.Cliente;
import java.util.ArrayList;
import java.util.List;

//Mock de Cliente. Realiza operações de fonte de dados com o cliente. 
public class MockCliente {

    //Sequência de IDs para cadastro de clientes    
    private static int sequenciaIdClientes = 0;
    
    //Armazena a lista de clientes inseridos para manipulação em memória
    //PRINCIPAL ITEM DA FONTE DE DADOS
    private static List<Cliente> listaClientes = new ArrayList<Cliente>();

    //Insere um cliente no mock "cliente"
    public static void inserir(Cliente cliente)
            throws Exception {

        //Configura um ID para o cliente usando a variável de sequência de
        //clientes e a incrementando em seguida
        cliente.setId(sequenciaIdClientes++);
        
        //Adiciona o cliente na lista em memória
        listaClientes.add(cliente);

    }

    //Realiza a atualização dos dados de um cliente, com ID e dados
    //fornecidos como parâmetro através de um objeto da classe "Cliente"
    public static void atualizar(Cliente clienteAtualizacao)
            throws Exception {

        //Verifica se foi fornecido um cliente para atualização (é diferente de
        //de null e tem um ID fornecido) e se a lista de clientes em memória
        //não está vazia antes de tentar iniciar a atualização
        if (clienteAtualizacao != null
                && clienteAtualizacao.getId() != null
                && listaClientes.size() > 0) {

            //Se há um cliente a atualizar e a lista não está vazia, percorremos
            //a lista até encontrar o cliente com o mesmo ID do cliente
            //fornecido para atualização. Quando o encontrar-mos, atualizamos
            //seus dados (menos o ID) e configuramos a flag adequada para sair
            //do while
            int contador = 0;
            boolean clienteAtualizado = false;
            while (contador < listaClientes.size() && !clienteAtualizado) {
                
                //Obtém o cliente da posição corrente da lista
                Cliente clienteLista = listaClientes.get(contador);

                //Se há um cliente nesta posição da lista e o ID dele é igual
                //ao ID do cliente fornecido como parâmetro para atualização,
                //atualizamos seus dados e paramos a pesquisa com a flag
                if (clienteLista != null
                        && clienteLista.getId() == clienteAtualizacao.getId()) {

                    //Atualização dos dados no objeto de modelo de cliente
                    clienteLista.setGenero(
                            clienteAtualizacao.getGenero()
                    );

                    clienteLista.setDataNascimento(
                            clienteAtualizacao.getDataNascimento()
                    );

                    clienteLista.setNome(
                            clienteAtualizacao.getNome()
                    );

                    clienteLista.setSobrenome(
                            clienteAtualizacao.getSobrenome()
                    );

                    //Configura a flag indicando que a atualização foi realizada
                    clienteAtualizado = true;
                }

                //Atualiza o contadorPosicao para ir para o próximo item
                contador++;
            }

        }
        //Se não foi fornecido um cliente para atualizar ou não há clientes
        //na lista de clientes, lança um erro (outra classe que usar esse
        //método terá que usar um try/catch para tratar isso)
        else {
            throw new Exception("Não há cliente para atualizar");
        }

    }

    //Realiza a exclusão de um cliente no mock, com ID fornecido
    //como parâmetro.
    public static void excluir(int id) throws Exception {

        //Verifica se a lista de clientes em memória não está vazia antes de
        //tentar iniciar a exclusão
        if (listaClientes.size() > 0) {

            //Se há um id de cliente para remoção e a lista não está vazia,
            //percorremos a lista até encontrar o cliente com o mesmo ID do
            //cliente fornecido para remoção. Quando o encontrar-mos, removemos
            //esse cliente da lista de clientes e paramos a pesquisa com a flag
            int contadorPosicao = 0;
            boolean clienteRemovido = false;
            while (contadorPosicao < listaClientes.size() && !clienteRemovido) {
                //Obtém o cliente da posição corrente da lista
                Cliente clienteLista = listaClientes.get(contadorPosicao);

                //Verifica se há cliente cadastrado corretamente nessa posição
                //da lista e se o mesmo tem ID igual ao ID do cliente a ser
                //removido (parâmetro deste método). Caso verdadeiro, remove o
                //cliente daquela posição da lista e pára a procura
                if (clienteLista != null && clienteLista.getId() == id) {
                    listaClientes.remove(contadorPosicao);
                    clienteRemovido = true;
                }

                //Atualiza o contadorPosicao para ir para o próximo item
                contadorPosicao++;
            }
            
        }
        //Se não há clientes na lista de clientes, lança um erro (outra classe
        //que usar esse método terá que usar um try/catch para tratar isso)
        else {
            
            throw new Exception("Não há cliente para remover");
            
        }
        
    }

    //Lista todos os clientes
    public static List<Cliente> listar()
            throws Exception {
        
        //Simplesmente retorna a lista de clientes
        return listaClientes;
        
    }

    //Procura um cliente no mock, de acordo com o nome
    //ou com o sobrenome, passados como parâmetro
    public static List<Cliente> procurar(String valor)
            throws Exception {
        
        //Primeiro, montamos uma lista de resultados que irá armazenar todos os
        //clientes encontrados que atendem o critério de pesquisa especificado
        //Começa vazia, mas instanciada
        List<Cliente> listaResultado = new ArrayList<Cliente>();

        //Verifica se foi fornecido um parâmetro para pesquisa e também se a
        //lista de clientes em memória não está vazia antes de tentar iniciar
        //a busca
        if (valor != null && listaClientes.size() > 0) {

            //Se há valor para pesquisa e a lista não está vazia, vamos
            //percorrer a lista toda e encontrar clientes cujo nome e/ou
            //sobrenome contenham o parâmetro de valor informado no método.
            //Quando um cliente atender a estes critérios, o adicionamos na
            //lista auxiliar de resultados de pesquisa (listaResultado).
            //A busca deve ir até o final aqui, por isso não há flag de controle
            int contadorPosicao = 0;
            while (contadorPosicao < listaClientes.size()) {
                
                //Obtém o cliente da posição corrente da lista
                Cliente clienteLista = listaClientes.get(contadorPosicao);

                //Verifica se há cliente cadastrado corretamente nessa posição
                //da lista e se o mesmo tem nome e/ou sobrenome
                if (clienteLista != null
                        && clienteLista.getNome() != null
                        && clienteLista.getSobrenome() != null) {

                    //Caso o cliente desta posição tenha dados cadastrados 
                    //corretamente, verifica se este possui nome ou
                    //sobrenome que contenham o valor fornecido como
                    //parâmetro no método. Caso uma das afirmações seja
                    //verdadeira, adiciona este cliente na lista de
                    //resultados.
                    //OBS.: Não está ignorando maiúsculas ou
                    //minúsculas, pode ser interessante implementar este
                    //comportamente para evitar a necessidade do usuário
                    //digitar a pesquisa EXATAMENTE como está cadastrado
                    //para conseguir encontrar o cliente
                    if (clienteLista.getNome().contains(valor)
                            || clienteLista.getSobrenome().contains(valor)) {

                        listaResultado.add(clienteLista);

                    }

                }

                //Atualiza o contadorPosicao para ir para o próximo item
                contadorPosicao++;
            }

        }
        //Se não há clientes na lista de clientes, lança um erro (outra classe
        //que usar esse método terá que usar um try/catch para tratar isso)
        else {
            
            throw new Exception("Não há dados para pesquisa");
            
        }

        //Retorna a lista de clientes encontrados
        return listaResultado;
        
    }

    //Obtém um cliente da lista
    public static Cliente obter(int id)
            throws Exception {
        
        //Verifica se a lista de clientes em memória não está vazia antes de
        //tentar iniciar a busca
        if (listaClientes.size() > 0) {

            //Se a lista não está vazia, vamos percorrer a lista toda até
            //encontrar o cliente com aquele ID e retorná-lo
            int contadorPosicao = 0;
            while (contadorPosicao < listaClientes.size()) {
                //Obtém o cliente da posição corrente da lista
                Cliente clienteLista = listaClientes.get(contadorPosicao);

                //Verifica se há clientes cadastrados corretamente nessa posição
                //da lista e se o mesmo tem nome e/ou sobrenome
                if (clienteLista != null
                        && clienteLista.getId() != null
                        && clienteLista.getId() == id) {

                    //Case seja o cliente desejado, retorna-o a quem chamou
                    return clienteLista;

                }

                //Atualiza o contadorPosicao para ir para o próximo item
                contadorPosicao++;
            }

        }
        //Se não há clientes na lista de clientes, lança um erro (outra classe
        //que usar esse método terá que usar um try/catch para tratar isso)
        else {
            throw new Exception("Não há dados para pesquisa");
        }

        //Se percorreu a lista toda e não achou o cliente desejado, retorna null
        return null;
    }
}