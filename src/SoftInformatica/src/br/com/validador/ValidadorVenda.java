/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.validador;

import br.com.model.ItemDeVenda;
import br.com.model.Venda;

/**
 *
 * @author Mario
 */
public class ValidadorVenda {

    
    public static String validarVenda (Venda venda){
        
        //Validando o cliente
        if (venda.getCliente() == null){
            return "Não foi informado um cliente";
        }
        
        //Validando de todos os itens da lista estão de acordo      
        for(ItemDeVenda item : venda.getItemVenda()){            
            
            if (item == null){
                return "Não foi informado nenhum item de venda";
            }
            
            if (item.getQtdProduto() == null){
                return "Não foi informado uma quantidade";
            }
            
            //Validar se a quantidade é maior do que 0 na própria tela
            if(item.getProduto() == null){
                return "não foi informado nenhum produto";
            }
            
            //Validando se a quantidade em estoque é maior do que a quantidade desejada
            //Um tipo de dado contém informação, e essa info é outro tipo de dado, que no meu caso 
            //é um tipo Produto e dentro do produto tem a quantidade
            if (item.getQtdProduto() < item.getProduto().getQuantidade()){
                
            }
        }
        
        return null;
    }
    
}
