package com.xpto.ProjetoERP.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpto.ProjetoERP.dto.MovimentacaoDTO;
import com.xpto.ProjetoERP.dto.PedidoMovimentacaoDTO;
import com.xpto.ProjetoERP.service.MovimentacaoService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/Movimentacao")
@RestController
@RequiredArgsConstructor

public class MovimentacaoController {
    
    private final MovimentacaoService service;

    @GetMapping("/listar")
    public List<MovimentacaoDTO> listar(){
        return service.listar();
    }

    @PostMapping("/debitar")
    public boolean debitar(@RequestBody PedidoMovimentacaoDTO dto){
        return service.debitar(dto);
    }

    @PostMapping("/repor")
    public boolean repor(@RequestBody PedidoMovimentacaoDTO dto){
        return service.repor(dto); 
    }
}
