package br.com.alura.loja.modelo;

import java.time.LocalDate;

public class RelatoriodeVendasVo {

    private  String nomeProduto;
    private  Long quantidadeVendida;
    private LocalDate dataUltimaVenda;


    public RelatoriodeVendasVo(String nomeProduto, Long quantidadeVendida, LocalDate dataUltimaVenda) {
        this.nomeProduto = nomeProduto;
        this.quantidadeVendida = quantidadeVendida;
        this.dataUltimaVenda = dataUltimaVenda;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public Long getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public LocalDate getDataUltimaVenda() {
        return dataUltimaVenda;
    }

    @Override
    public String toString(){
        return "nome do produto: "+this.getNomeProduto()+" data da ultima venda: "+ this.getDataUltimaVenda() + " quantidade vendida: " + this.getQuantidadeVendida();
    }
}
