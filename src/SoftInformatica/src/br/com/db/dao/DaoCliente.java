package br.com.db.dao;

import br.com.db.utils.ConnectionUtils;
import br.com.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

//Data Access Object de Cliente. Realiza operações de BD com o cliente. 
public class DaoCliente {

    //Insere um cliente na tabela "cliente" do banco de dados
    public static void inserir(Clientes cliente)
            throws SQLException, Exception {
        //Monta a string de inserção de um cliente no BD,
        //utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO Cliente (Nome, Sexo, Cpf, Rg, DataNasc,"
                + " Cep, Endereco, Numero, Complemento, Cidade, UF, Telefone, Habilitado"
                + " ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getSexo());
            preparedStatement.setString(3, cliente.getCpf());
            preparedStatement.setString(4, cliente.getRg());
            java.util.Date dt = cliente.getDataNasc();
            java.sql.Date d = new java.sql.Date (dt.getTime());
            preparedStatement.setDate(5, d);
            preparedStatement.setString(6, cliente.getCep());
            preparedStatement.setString(7, cliente.getEndereco());
            preparedStatement.setInt(8, cliente.getNumero());
            preparedStatement.setString(9, cliente.getComplemento());
            preparedStatement.setString(10, cliente.getCidade());
            preparedStatement.setString(11, cliente.getUF());
            preparedStatement.setString(12, cliente.getTelefone());
            preparedStatement.setBoolean(13, cliente.getHabilitado());

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
    //fornecidos como parâmetro através de um objeto da classe "Cliente"
    public static void atualizar(Clientes cliente)
            throws SQLException, Exception {
        //Monta a string de atualização do cliente no BD, utilizando
        //prepared statement
        String sql = "UPDATE Cliente SET nome=?, sexo=?, cpf=?, rg=?, DataNasc=?,"
                + " cep=?, endereco=?, numero=?, complemento=?, cidade=?, uf=?,"
                + " telefone=?, habilitado=? "
                + "WHERE (id=?)";
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

            
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getSexo());
            preparedStatement.setString(3, cliente.getCpf());
            preparedStatement.setString(4, cliente.getRg());
            java.util.Date dt = cliente.getDataNasc();
            java.sql.Date d = new java.sql.Date (dt.getTime());
            preparedStatement.setDate(5, d);
            preparedStatement.setString(6, cliente.getCep());
            preparedStatement.setString(7, cliente.getEndereco());
            preparedStatement.setInt(8, cliente.getNumero());
            preparedStatement.setString(9, cliente.getComplemento());
            preparedStatement.setString(10, cliente.getCidade());
            preparedStatement.setString(11, cliente.getUF());
            preparedStatement.setString(12, cliente.getTelefone());
            preparedStatement.setBoolean(13, cliente.getHabilitado());
            preparedStatement.setInt(14, cliente.getId());
            //preparedStatement.setString(14, cliente.getCelular());
            //preparedStatement.setString(15, cliente.getHabilitado());

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

    //Realiza a exclusão lógica de um cliente no BD, com ID fornecido
    //como parâmetro. A exclusão lógica simplesmente "desliga" o
    //cliente, configurando um atributo específico, a ser ignorado
    //em todas as consultas de cliente ("enabled").
    public static void excluir(Integer id) throws SQLException, Exception {
        //Monta a string de atualização do cliente no BD, utilizando
        //prepared statement
        String sql = "UPDATE Cliente SET enabled=? WHERE (cliente_id=?)";
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

    //Lista todos os clientes da tabela clientes
    public static List<Clientes> listar()
            throws SQLException, Exception {
        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        String sql = "SELECT * FROM Cliente WHERE (enabled=?)";
        //Lista de clientes de resultado
        List<Clientes> listaClientes = null;
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
                if (listaClientes == null) {
                    listaClientes = new ArrayList<Clientes>();
                }
                //Cria uma instância de Cliente e popula com os valores do BD
                Clientes cliente = new Clientes();

                cliente.setId(result.getInt("id"));
                cliente.setNome(result.getString("Nome"));
                cliente.setSexo(result.getString("Sexo"));
                cliente.setCpf(result.getString("Cpf"));
                cliente.setRg(result.getString("Rg"));
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                java.sql.Date data = new java.sql.Date(format.parse(result.getString("DataNasc").replace("-","/").replace("-","/")).getTime());
                cliente.setDataNasc(data);
                cliente.setCep(result.getString("Cep"));
                cliente.setEndereco(result.getString("Endereco"));
                cliente.setNumero(Integer.parseInt(result.getString("Numero")));
                cliente.setComplemento(result.getString("Complemento"));
                cliente.setCidade(result.getString("Cidade"));
                cliente.setUF(result.getString("UF"));
                cliente.setTelefone(result.getString("Telefone"));
                cliente.setHabilitado(Boolean.parseBoolean(result.getString("Habilitado")));

                //Adiciona a instância na lista
                listaClientes.add(cliente);
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
        //Retorna a lista de clientes do banco de dados
        return listaClientes;
    }

    //Procura um cliente no banco de dados, de acordo com o nome
    //ou com o sobrenome, passado como parâmetro
    public static List<Clientes> procurar(String valor, String cpf)
            throws SQLException, Exception {
        //Monta a string de consulta de clientes no banco, utilizando
        //o valor passado como parâmetro para busca nas colunas de
        //nome ou sobrenome (através do "LIKE" e ignorando minúsculas
        //ou maiúsculas, através do "UPPER" aplicado à coluna e ao
        //parâmetro). Além disso, também considera apenas os elementos
        //que possuem a coluna de ativação de clientes configurada com
        //o valor correto ("enabled" com "true")
        String sql = "SELECT * FROM Cliente WHERE ((UPPER(nome) LIKE UPPER(?) OR CPF = ? ) "
                + " AND habilitado=?)";
        //Lista de clientes de resultado
        List<Clientes> listaClientes = null;
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
            preparedStatement.setString(2, "%" + cpf.replace(".","").replace(".","").replace("-","") + "%");
            preparedStatement.setBoolean(3, true);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaClientes == null) {
                    listaClientes = new ArrayList<Clientes>();
                }
                //Cria uma instância de Cliente e popula com os valores do BD
                Clientes cliente = new Clientes();

                cliente.setId(result.getInt("id"));
                cliente.setNome(result.getString("Nome"));
                cliente.setSexo(result.getString("Sexo"));
                cliente.setCpf(result.getString("Cpf"));
                cliente.setRg(result.getString("Rg"));
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                java.sql.Date data = new java.sql.Date(format.parse(result.getString("DataNasc").replace("-","/").replace("-","/")).getTime());
                cliente.setDataNasc(data);
                cliente.setCep(result.getString("Cep"));
                cliente.setEndereco(result.getString("endereco"));
                cliente.setNumero(Integer.parseInt(result.getString("Numero")));
                cliente.setComplemento(result.getString("Complemento"));
                cliente.setCidade(result.getString("Cidade"));
                cliente.setUF(result.getString("UF"));
                cliente.setTelefone(result.getString("Telefone"));
                cliente.setHabilitado(true);

                //Adiciona a instância na lista
                listaClientes.add(cliente);
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
        //Retorna a lista de clientes do banco de dados
        return listaClientes;
    }

    //Obtém uma instância da classe "Cliente" através de dados do
    //banco de dados, de acordo com o ID fornecido como parâmetro
    public static Clientes obter(Integer id)
            throws SQLException, Exception {
        //Compõe uma String de consulta que considera apenas o cliente
        //com o ID informado e que esteja ativo ("enabled" com "true")
        String sql = "SELECT * FROM Cliente WHERE (cliente_id=? AND enabled=?)";

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
                //Cria uma instância de Cliente e popula com os valores do BD
                Clientes cliente = new Clientes();
                cliente.setId(result.getInt("id"));
                cliente.setNome(result.getString("Nome"));
                cliente.setSexo(result.getString("Sexo"));
                cliente.setCpf(result.getString("Cpf"));
                cliente.setRg(result.getString("Rg"));
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                java.sql.Date data = new java.sql.Date(format.parse(result.getString("DataNasc").replace("-","/").replace("-","/")).getTime());
                cliente.setDataNasc(data);
                cliente.setCep(result.getString("Cep"));
                cliente.setEndereco(result.getString("Endereco"));
                cliente.setNumero(Integer.parseInt(result.getString("Numero")));
                cliente.setComplemento(result.getString("Complemento"));
                cliente.setCidade(result.getString("Cidade"));
                cliente.setUF(result.getString("UF"));
                cliente.setTelefone(result.getString("Telefone"));
                cliente.setHabilitado(Boolean.parseBoolean(result.getString("Habilitado")));
                //Retorna o resultado
                return cliente;
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
