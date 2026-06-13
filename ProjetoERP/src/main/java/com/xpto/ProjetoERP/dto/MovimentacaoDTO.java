package com.xpto.ProjetoERP.dto;

import lombok.Data;

@Data
public class MovimentacaoDTO {

    private String skuProduto;
    private String dataMovimentacao;
    private float quantidade;


    public MovimentacaoDTO(String sku, String data, float quantidade) {
        this.skuProduto = sku;
        this.dataMovimentacao = data;
        this.quantidade = quantidade;
    }
}