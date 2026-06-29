package com.xpto.ProjetoERP.Entity;

import com.xpto.ProjetoERP.dto.UsuarioDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String login;
    private String senha;

    protected Usuario() {
    }

    public Usuario(UsuarioDTO dto) {
        this.nome = dto.getNome();
        this.login = dto.getLogin();
        this.senha = dto.getSenha();
    }

    public UsuarioDTO infos() {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId((int) this.id);
        dto.setNome(this.nome);
        dto.setLogin(this.login);

        return dto;
    }
}
