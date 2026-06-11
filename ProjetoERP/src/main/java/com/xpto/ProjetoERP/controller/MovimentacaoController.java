package com.xpto.ProjetoERP.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpto.ProjetoERP.dto.MovimentacaoDTO;
import com.xpto.ProjetoERP.dto.ProdutoDTO;
import com.xpto.ProjetoERP.service.MovimentacaoService;
import com.xpto.ProjetoERP.service.ProdutoService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/produtos")
@RestController
@RequiredArgsConstructor

public class MovimentacaoController {
    
    private final MovimentacaoService service;

    @GetMapping
    public List<MovimentacaoDTO> listar(){
        return service.listar();
    }

    @PostMapping
    public boolean debitar(String sku){
        service.debitar(sku);
    }

    @PostMapping
    public boolean repor(ProdutoDTO dto){
        return ProdutoService.cadastrar(dto); 
    }
}
