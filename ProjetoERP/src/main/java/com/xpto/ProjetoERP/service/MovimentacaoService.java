package com.xpto.ProjetoERP.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.xpto.ProjetoERP.dto.ProdutoDTO;

@Service
public class MovimentacaoService {
    

    public List<ProdutoDTO> listar(){
        return service.listar();
    }

    public boolean debitar(String sku){
        return true;
    }
  

    private boolean verificarSku(String sku){
        return ProdutoService.verificarSku(sku);
    };

}
