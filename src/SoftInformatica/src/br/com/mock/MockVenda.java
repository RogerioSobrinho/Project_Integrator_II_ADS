package br.com.mock;

import br.com.model.Venda;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockVenda {
        private static int sequenciaIdVendas = 0;
    
    //Armazena a lista de vendas inseridos para manipulação em memória
    //PRINCIPAL ITEM DA FONTE DE DADOS
    private static List<Venda> listaVendas = new ArrayList<Venda>();

    //Insere uma venda no mock "venda"
    public static void inserirVenda(Venda venda)
            throws Exception {
        
        //Configura um ID para o cliente usando a variável de sequência de
        //clientes e a incrementando em seguida
        venda.setIdVenda(sequenciaIdVendas++);
        //Armazenando a data atual
        venda.setDataVenda(new Date());
        
        //Adiciona o cliente na lista em memória
        listaVendas.add(venda);

    }
}
