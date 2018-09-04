package br.com.model;

import java.util.Date;
import java.util.List;

public class Venda {
    private Integer IdVenda;
    private Clientes cliente;
    private List<ItemDeVenda> itemVenda;
    private Date DataVenda;

    public Integer getIdVenda() {
        return IdVenda;
    }    
    public void setIdVenda(Integer IdVenda) {
        this.IdVenda = IdVenda;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public List<ItemDeVenda> getItemVenda() {
        return itemVenda;
    }

    public void setItemVenda(List<ItemDeVenda> itemVenda) {
        this.itemVenda = itemVenda;
    }

    public Date getDataVenda() {
        return DataVenda;
    }
    public void setDataVenda (Date DataVenda){
        this.DataVenda = DataVenda;
    }
}
