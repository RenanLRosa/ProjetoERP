package com.xpto.ProjetoERP.dto;

import lombok.Data;

@Data
public class PedidoMovimentacaoDTO {

    private String skuProduto;
    private float quantidade;


    public PedidoMovimentacaoDTO(String sku, float quantidade) {
        this.skuProduto = sku;
        this.quantidade = quantidade;
    }
}