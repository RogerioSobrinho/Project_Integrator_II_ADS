package br.com.db.dao;

import br.com.db.utils.ConnectionUtils;
import br.com.model.Relatorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DaoRelatorio {
      //Insere um produto na tabela "produto" do banco de dados
    public static List<Relatorio> buscar(String data1, String data2)
            throws SQLException, Exception {
        //Monta a string de inserção de um produto no BD,
        //utilizando os dados do produto passados como parâmetro
        String sql = "SELECT idVenda, Nome, dataVenda, total FROM Vendas v inner join Cliente c on v.idCliente = c.id where (dataVenda >= ? AND dataVenda <= ?)";
        List<Relatorio> listaVendas = null;
        //Conexão para abertura e fechamento
        Connection connection = null;
        ResultSet result = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, data1);
            preparedStatement.setString(2, data2);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();
            while (result.next()) {
                if (listaVendas == null) {
                    listaVendas = new ArrayList<Relatorio>();
                }
                //Cria uma instância de Produto e popula com os valores do BD
                Relatorio relatorioVenda = new Relatorio();
                relatorioVenda.setIdVenda(Integer.parseInt(result.getString("idVenda")));
                relatorioVenda.setNomeCliente(result.getString("Nome"));
                relatorioVenda.setTotal(Integer.parseInt(result.getString("total")));
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                java.sql.Date data = new java.sql.Date(format.parse(result.getString("dataVenda").replace("-","/").replace("-","/")).getTime());
                relatorioVenda.setDataVenda(data);
                
                //Adiciona a instância na lista
                listaVendas.add(relatorioVenda);
            }
            
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
        
        return listaVendas;
    }
    
     public static List<Relatorio> listarTodos()
            throws SQLException, Exception {
        //Monta a string de inserção de um produto no BD,
        //utilizando os dados do produto passados como parâmetro
        String sql = "SELECT idVenda, Nome, dataVenda, total FROM Vendas v inner join Cliente c on v.idCliente = c.id";
        List<Relatorio> listaVendas = null;
        //Conexão para abertura e fechamento
        Connection connection = null;
        ResultSet result = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();
            while (result.next()) {
                if (listaVendas == null) {
                    listaVendas = new ArrayList<Relatorio>();
                }
                //Cria uma instância de Produto e popula com os valores do BD
                Relatorio relatorioVenda = new Relatorio();
                relatorioVenda.setIdVenda(Integer.parseInt(result.getString("idVenda")));
                relatorioVenda.setNomeCliente(result.getString("Nome"));
                relatorioVenda.setTotal(Float.parseFloat(result.getString("total")));
                SimpleDateFormat format = new SimpleDateFormat("yyyy/mm/dd");
                java.sql.Date data = new java.sql.Date(format.parse(result.getString("dataVenda").replace("-","/").replace("-","/")).getTime());
                relatorioVenda.setDataVenda(data);
                
                //Adiciona a instância na lista
                listaVendas.add(relatorioVenda);
            }
            
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
        
        return listaVendas;
    }
}
