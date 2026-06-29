package com.xpto.ProjetoERP.dto;

import lombok.Data;

@Data
public class ProdutoDTO {

    private String sku;
    private String nome;
    private float valorUnitario;
    private String dataCadastro;
    private float quantidadeEstoque;


    public ProdutoDTO(String sku, String nome, float valorUnitario, String dataCadastro, float quantidadeEstoque) {
        this.sku = sku;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.dataCadastro = dataCadastro;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String nome(){
        return this.nome;
    }

    public String sku(){
        return this.sku;
    }

    public String dataCadastro(){
        return this.dataCadastro;
    }

    public float valorUnitario(){
        return this.valorUnitario;
    }

    public float quantidadeEstoque(){
        return this.quantidadeEstoque;
    }
}
