package com.xpto.ProjetoERP.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xpto.ProjetoERP.Entity.Usuario;
import com.xpto.ProjetoERP.Repository.UsuarioRepository;
import com.xpto.ProjetoERP.dto.UsuarioDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public List<UsuarioDTO> listar(){
        List<UsuarioDTO> lista = new ArrayList<>();

        for (Usuario usuario : repository.findAll()) {
            lista.add(usuario.infos());
        }

        return lista;
    }

    public boolean salvar(UsuarioDTO dto){
        Usuario usuario = new Usuario(dto);
        repository.save(usuario);
        return true;
    }

}
