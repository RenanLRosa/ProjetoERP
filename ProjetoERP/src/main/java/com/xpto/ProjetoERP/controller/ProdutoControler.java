package com.xpto.ProjetoERP.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpto.ProjetoERP.dto.ProdutoDTO;
import com.xpto.ProjetoERP.service.ProdutoService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/produtos")
@RestController
@RequiredArgsConstructor

public class ProdutoControler {
    private final ProdutoService service;

    @GetMapping
    public List<ProdutoDTO> listar(){
        return service.listar();
    }

    @PostMapping
    public boolean cadastrar(@RequestBody ProdutoDTO dto){
        return service.cadastrar(dto); 
    }

}
