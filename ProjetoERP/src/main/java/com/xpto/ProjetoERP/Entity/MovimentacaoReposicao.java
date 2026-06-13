package com.xpto.ProjetoERP.Entity;

import com.xpto.ProjetoERP.dto.MovimentacaoDTO;
import com.xpto.ProjetoERP.dto.PedidoMovimentacaoDTO;
import com.xpto.ProjetoERP.Utilitarios.GeradorIdMovimentacao;

public class MovimentacaoReposicao implements Movimentacao{    
    private String skuProduto;
    private float qtd;
    private int idMovimentacao;
    private String data;
    private Produto produto;


    public MovimentacaoReposicao(PedidoMovimentacaoDTO dto, Produto produto){
        this.skuProduto = dto.getSkuProduto();
        this.qtd = dto.getQuantidade();
        this.idMovimentacao = GeradorIdMovimentacao.gerarId();

        this.produto = produto;
    }

    @Override
    public MovimentacaoDTO executar() {
        produto.repor(qtd);

        return new MovimentacaoDTO(skuProduto, data, qtd, idMovimentacao);

    }

}
