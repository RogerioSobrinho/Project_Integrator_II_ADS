package br.com.db.dao;

import br.com.db.utils.ConnectionUtils;
import br.com.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Data Access Object de Produto. Realiza operações de BD com o produto. 
public class DaoProduto {

    //Insere um produto na tabela "produto" do banco de dados
    public static void inserir(Produto produto)
            throws SQLException, Exception {
        //Monta a string de inserção de um produto no BD,
        //utilizando os dados do produto passados como parâmetro
        String sql = "INSERT INTO Produto (nome, precoVenda, ean, quantidade, "
                + "descricao, fornecedor, cnpj, categoria, habilitado) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
        
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setFloat(2, produto.getPrecoVenda());
            preparedStatement.setString(3, produto.getEan());
            preparedStatement.setInt(4, produto.getQuantidade());
            preparedStatement.setString(5, produto.getDescricao());
            preparedStatement.setString(6, produto.getFornecedor());
            preparedStatement.setString(7, produto.getCnpj());
            preparedStatement.setString(8, produto.getCategoria());
            preparedStatement.setBoolean(9, produto.getHabilitado());

            

            //Executa o comando no banco de dados
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    //Realiza a atualização dos dados de um cliente, com ID e dados
    //fornecidos como parâmetro através de um objeto da classe "Produto"
    public static void atualizar(Produto produto)
            throws SQLException, Exception {
        //Monta a string de atualização do produto no BD, utilizando
        //prepared statement
        String sql = "UPDATE Produto SET nome=?, precoVenda=?, ean=?,"
                + " quantidade=?, descricao=?, fornecedor=?, cnpj=?,"
                + " categoria=?, habilitado=? WHERE (id=?)";
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setFloat(2, produto.getPrecoVenda());
            preparedStatement.setString(3, produto.getEan());
            preparedStatement.setInt(4, produto.getQuantidade());
            preparedStatement.setString(5, produto.getDescricao());
            preparedStatement.setString(6, produto.getFornecedor());
            preparedStatement.setString(7, produto.getCnpj());
            preparedStatement.setString(8, produto.getCategoria());
            preparedStatement.setBoolean(9, produto.getHabilitado());
            preparedStatement.setInt(10, produto.getId());
            
            
            //Executa o comando no banco de dados
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    //Realiza a exclusão lógica de um produto no BD, com ID fornecido
    //como parâmetro. A exclusão lógica simplesmente "desliga" o
    //cliente, configurando um atributo específico, a ser ignorado
    //em todas as consultas de cliente ("Habilitado").
    public static void excluir(Integer id) throws SQLException, Exception {
        //Monta a string de atualização do produto no BD, utilizando
        //prepared statement
        String sql = "UPDATE Produto SET habilitado=? WHERE (id=?)";
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setBoolean(1, false);
            preparedStatement.setInt(2, id);

            //Executa o comando no banco de dados
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    //Lista todos os produtos da tabela produtos
    public static List<Produto> listar()
            throws SQLException, Exception {
        //Monta a string de listagem de produtos no banco, considerando
        //apenas a coluna de ativação de produtos ("habilitado")
        String sql = "SELECT * FROM Produto WHERE (habilitado=?)";
        //Lista de produtos de resultado
        List<Produto> listaProdutos = null;
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaProdutos == null) {
                    listaProdutos = new ArrayList<Produto>();
                }
                //Cria uma instância de Produto e popula com os valores do BD
                Produto produto = new Produto();
                produto.setId(result.getInt("id"));
                produto.setNome(result.getString("nome"));
                produto.setPrecoVenda(result.getFloat("precoVenda"));
                produto.setEan(result.getString("ean"));
                produto.setQuantidade(result.getInt("quantidade"));
                produto.setDescricao(result.getString("descricao"));
                produto.setFornecedor(result.getString("fornecedor"));
                produto.setCnpj(result.getString("cnpj"));
                produto.setCategoria(result.getString("categoria"));
                produto.setHabilitado(result.getBoolean("habilitado"));
                
                //Adiciona a instância na lista
                listaProdutos.add(produto);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Retorna a lista de produtos do banco de dados
        return listaProdutos;
    }

    //Procura um produto no banco de dados, de acordo com o nome
    //ou com o codigo EAN, passados como parâmetro
    public static List<Produto> procurar(String valor)
            throws SQLException, Exception {
        //Monta a string de consulta de produtos no banco, utilizando
        //o valor passado como parâmetro para busca nas colunas de
        //nome ou ean (através do "LIKE" e ignorando minúsculas
        //ou maiúsculas, através do "UPPER" aplicado à coluna e ao
        //parâmetro). Além disso, também considera apenas os elementos
        //que possuem a coluna de ativação de produtos configurada com
        //o valor correto ("habilitado" com "true")
        String sql = "SELECT * FROM Produto WHERE ((UPPER(nome) LIKE UPPER(?) "
                + "OR UPPER(produto.ean) LIKE UPPER(?)) AND habilitado=?)";
        //Lista de produtos de resultado
        List<Produto> listaProdutos = null;
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, "%" + valor + "%");
            preparedStatement.setString(2, "%" + valor + "%");
            preparedStatement.setBoolean(3, true);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaProdutos == null) {
                    listaProdutos = new ArrayList<Produto>();
                }
                //Cria uma instância de Produto e popula com os valores do BD
                Produto produto = new Produto();
                produto.setId(result.getInt("id"));
                produto.setNome(result.getString("nome"));
                produto.setPrecoVenda(result.getFloat("precoVenda"));
                produto.setEan(result.getString("ean"));
                produto.setQuantidade(result.getInt("quantidade"));
                produto.setDescricao(result.getString("descricao"));
                produto.setFornecedor(result.getString("fornecedor"));
                produto.setCnpj(result.getString("cnpj"));
                produto.setCategoria(result.getString("categoria"));
                produto.setHabilitado(result.getBoolean("habilitado"));
                                
                //Adiciona a instância na lista
                listaProdutos.add(produto);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Retorna a lista de produtos do banco de dados
        return listaProdutos;
    }

    //Obtém uma instância da classe "Produto" através de dados do
    //banco de dados, de acordo com o ID fornecido como parâmetro
    public static Produto obter(Integer id)
            throws SQLException, Exception {
        //Compõe uma String de consulta que considera apenas o produto
        //com o ID informado e que esteja ativo ("habilitado" com "true")
        String sql = "SELECT * FROM Produto WHERE (id=? AND habilitado=?)";

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setInt(1, id);
            preparedStatement.setBoolean(2, true);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Verifica se há pelo menos um resultado
            if (result.next()) {
                //Cria uma instância de Produto e popula com os valores do BD
                                
                Produto produto = new Produto();
                produto.setId(result.getInt("id"));
                produto.setNome(result.getString("nome"));
                produto.setPrecoVenda(result.getFloat("precoVenda"));
                produto.setEan(result.getString("ean"));
                produto.setQuantidade(result.getInt("quantidade"));
                produto.setDescricao(result.getString("descricao"));
                produto.setFornecedor(result.getString("fornecedor"));
                produto.setCnpj(result.getString("cnpj"));
                produto.setCategoria(result.getString("categoria"));
                produto.setHabilitado(result.getBoolean("habilitado"));
                
                //Retorna o resultado
                return produto;
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

        //Se chegamos aqui, o "return" anterior não foi executado porque
        //a pesquisa não teve resultados
        //Neste caso, não há um elemento a retornar, então retornamos "null"
        return null;
    }
}
