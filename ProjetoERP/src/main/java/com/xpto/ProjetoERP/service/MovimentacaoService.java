package com.xpto.ProjetoERP.service;

import com.xpto.ProjetoERP.Entity.Produto;
import com.xpto.ProjetoERP.dto.PedidoMovimentacaoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.xpto.ProjetoERP.service.ProdutoService;

import com.xpto.ProjetoERP.Entity.Movimentacao;
import com.xpto.ProjetoERP.Entity.MovimentacaoBaixa;
import com.xpto.ProjetoERP.dto.ProdutoDTO;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.xpto.ProjetoERP.dto.PedidoMovimentacaoDTO;
import com.xpto.ProjetoERP.dto.MovimentacaoDTO;

import java.util.List;


@Service
public class MovimentacaoService {

    public boolean debitar(@RequestBody PedidoMovimentacaoDTO dto, Produto produto){
        if (ProdutoService.verificarDebitar(dto)){
            MovimentacaoBaixa baixa = new MovimentacaoBaixa(dto, produto);

        };
        
        return true;
    }
  
    public boolean repor(@RequestBody PedidoMovimentacaoDTO dto){
        return true;
    }

}
