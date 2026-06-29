package com.xpto.ProjetoERP.Entity;

import com.xpto.ProjetoERP.dto.MovimentacaoDTO;
import com.xpto.ProjetoERP.dto.PedidoMovimentacaoDTO;

public class MovimentacaoBaixa implements Movimentacao{    
    private String skuProduto;
    private float qtd;
    private String data;
    private Produto produto;


    public MovimentacaoBaixa(PedidoMovimentacaoDTO dto, Produto produto){
        this.skuProduto = dto.getSkuProduto();
        this.qtd = dto.getQuantidade();

        this.produto = produto;
    }

    @Override
    public MovimentacaoDTO executar() {
        produto.debitar(qtd);
        MovimentacaoDTO dto = new MovimentacaoDTO(skuProduto, data, qtd);
        dto.setTipo("BAIXA");

        return dto;
    }

}

