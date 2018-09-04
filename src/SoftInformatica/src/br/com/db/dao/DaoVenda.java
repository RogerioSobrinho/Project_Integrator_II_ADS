package br.com.db.dao;

import br.com.db.utils.ConnectionUtils;
import br.com.model.ItemDeVenda;
import br.com.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class DaoVenda {
    
    public static void inserirVenda(Venda venda, Float valorTotal) throws SQLException, Exception {
        //o IDVENDA e a Data serão gerados direto no banco
        String sqlVenda = "INSERT INTO Vendas (idCliente, total, dataVenda) VALUES (?, ?, Now())";
         //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sqlVenda, PreparedStatement.RETURN_GENERATED_KEYS);
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setInt(1, venda.getCliente().getId());
            
            //*TO*DO*: Necessário gerar o valor total, disponivel apenas no projeto completo
            preparedStatement.setFloat(2, valorTotal);
            //Executa o comando no banco de dados
            preparedStatement.execute();
            
            //Retorna o id gerado da ultima venda inserida no banco de dados
            Integer ultimaChave = null;
            ResultSet chaveGeradaVenda = preparedStatement.getGeneratedKeys();
            if (chaveGeradaVenda.next()) {
                ultimaChave = chaveGeradaVenda.getInt(1);
            }
            
            //executa um for each para add item por item da lista de Item de Venda
            for (ItemDeVenda item : venda.getItemVenda()) {
                inserirItemVenda(item, ultimaChave);
                decrementarEstoque(item);
            }

        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
     public static void inserirItemVenda(ItemDeVenda itemVenda, int chaveVenda) 
        throws SQLException, Exception {
        String sqlItemVenda = "INSERT INTO ItemVendas (idVenda, idProduto, qtde, precoVendido) VALUES (?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sqlItemVenda);
            
            //Configura os atributos do SQL do item de venda aqui
            preparedStatement.setInt(1, chaveVenda);
            preparedStatement.setInt(2, itemVenda.getProduto().getId());
            //*TO*DO*: O valor será capturado da TELA na classe do projeto final
            preparedStatement.setInt(3, itemVenda.getProduto().getQuantidade());
            //caso o valor do produto seja alterado, o valor tbm será alterado no banco?
            preparedStatement.setFloat(4, itemVenda.getProduto().getPrecoVenda());

            preparedStatement.execute();

        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    //decrementa a quantidade vendida do produto no estoque
    public static void decrementarEstoque(ItemDeVenda item) throws SQLException,
     Exception {
        String sql = "UPDATE Produto SET quantidade = (quantidade - ?) WHERE (id=?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);            
            preparedStatement.setInt(1, item.getQtdProduto());
            preparedStatement.setInt(2, item.getProduto().getId());
            //Configura os atributos do SQL do item de venda         
            
            preparedStatement.executeUpdate();
            
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
    //*TO*DO*: CRIAR UMA CLASSE DE TESTES CRIANDO UM CLIENTE NA MÃO, PRODUTO NA MÃO, e tentar efetivar a venda
    
}
