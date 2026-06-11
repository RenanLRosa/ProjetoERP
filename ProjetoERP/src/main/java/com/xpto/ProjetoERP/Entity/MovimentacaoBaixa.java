package com.xpto.ProjetoERP.Entity;

public class MovimentacaoBaixa implements Movimentacao{

    @Override
    public boolean executar(float qtd) {
        ProdutoService.debitar(qtd);
    }

}
