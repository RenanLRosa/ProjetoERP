package com.xpto.ProjetoERP.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpto.ProjetoERP.dto.UsuarioDTO;
import com.xpto.ProjetoERP.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/usuarios")
@RestController
@RequiredArgsConstructor

public class UsuarioController {
    private final UsuarioService service;

    @GetMapping
    public List<UsuarioDTO> listar(){
        return service.listar();
    }

    @PostMapping
    public boolean salvar(@RequestBody UsuarioDTO dto){
        return service.salvar(dto); 
    }
}
 