package br.com.controller;

import br.com.db.dao.DaoRelatorio;
import br.com.model.Relatorio;
import java.util.List;

public class ServicoRelatorio {
       //Realiza a pesquisa de um cliente por nome/sobrenome na fonte de dados
    public static List<Relatorio> consultar(String data1, String data2) {

        //Declara uma variável para armazenar a resposta da fonte de dados
        List<Relatorio> listaResposta = null;

        try {

            //Verifica se um parâmetro de pesquisa não foi informado.
            if ((data1 == null || "".equals(data1)) && (data2 == null || "".equals(data2)) ) {
                //listaResposta = MockCliente.listar();
                listaResposta = DaoRelatorio.buscar(data1, data2);
            }

        } catch (Exception e) {

            //Imprime qualquer erro técnico no console
            e.printStackTrace();

        }

        //Retorna a lista de clientes encontrados
        return listaResposta;
    }
    
    public static List<Relatorio> listarTodos() {

        //Declara uma variável para armazenar a resposta da fonte de dados
        List<Relatorio> listaResposta = null;

        try {

            listaResposta = DaoRelatorio.listarTodos();

        } catch (Exception e) {

            //Imprime qualquer erro técnico no console
            e.printStackTrace();

        }

        //Retorna a lista de clientes encontrados
        return listaResposta;
    }
}
