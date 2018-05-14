/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

/**
 *
 * @author Mario
 */
public class ItemDeVenda {
    private Integer qtdProduto;
    private Produto produto;

    public Integer getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(Integer qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}