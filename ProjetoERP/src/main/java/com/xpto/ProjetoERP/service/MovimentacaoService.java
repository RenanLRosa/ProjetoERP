package com.xpto.ProjetoERP.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.xpto.ProjetoERP.service.ProdutoService;

import com.xpto.ProjetoERP.Entity.Movimentacao;
import com.xpto.ProjetoERP.Entity.MovimentacaoBaixa;
import com.xpto.ProjetoERP.dto.ProdutoDTO;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.xpto.ProjetoERP.dto.MovimentacaoDTO;


@Service
public class MovimentacaoService {
    

    public List<ProdutoDTO> listar(){
        return service.listar();
    }

    public boolean debitar(@RequestBody MovimentacaoDTO dto){
        if (ProdutoService.verificarDebitar()){ 
            
        };
        
        return true;
    }
  
    public boolean repor(String sku, float qtd){
        return true;
    }

    private boolean verificarSku(String sku){
        return ProdutoService.verificarSku(sku); 
    }

}
