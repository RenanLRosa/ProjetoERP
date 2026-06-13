package com.xpto.ProjetoERP.Entity;

import com.xpto.ProjetoERP.dto.MovimentacaoDTO;
import com.xpto.ProjetoERP.dto.PedidoMovimentacaoDTO;

public class MovimentacaoBaixa implements Movimentacao{
    private static int idContador;
    
    private String skuProduto;
    private float qtd;
    private int idMovimentacao;
    private String data;
    private Produto produto;


    public MovimentacaoBaixa(PedidoMovimentacaoDTO dto, Produto produto){
        this.skuProduto = dto.getSkuProduto();
        this.qtd = dto.getQuantidade();
        this.idMovimentacao = idContador;
        idContador += 1;

        this.produto = produto;
    }

    @Override
    public MovimentacaoDTO executar() {
        produto.debitar(qtd);

        return new MovimentacaoDTO(skuProduto, data, qtd, idMovimentacao);

    }

}

