package com.xpto.ProjetoERP.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.xpto.ProjetoERP.service.ProdutoService;

import com.xpto.ProjetoERP.Entity.Movimentacao;
import com.xpto.ProjetoERP.Entity.MovimentacaoBaixa;
import com.xpto.ProjetoERP.dto.ProdutoDTO;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.xpto.ProjetoERP.dto.PedidoMovimentacaoDTO;
import com.xpto.ProjetoERP.dto.MovimentacaoDTO;


@Service
public class MovimentacaoService {
    

    public List<ProdutoDTO> listar(){
        return service.listar();
    }

    public boolean debitar(@RequestBody PedidoMovimentacaoDTO dto){
        if (ProdutoService.VerificarDebitar(dto)){ 

            Movimentacao baixa = new MovimentacaoBaixa(dto);

        };
        
        return true;
    }
  
    public boolean repor(@RequestBody PedidoMovimentacaoDTO dto){
        return true;
    }

}
