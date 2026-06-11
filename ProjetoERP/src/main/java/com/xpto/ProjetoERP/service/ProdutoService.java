package com.xpto.ProjetoERP.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xpto.ProjetoERP.Entity.Produto;
import com.xpto.ProjetoERP.dto.ProdutoDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@Service
public class ProdutoService {
    private static List<Produto> lista = new ArrayList<>();


    public List<ProdutoDTO> listar(){
        List<ProdutoDTO> listaDTO = new ArrayList<>();
        for (Produto produto : lista) {
            listaDTO.add(produto.infos());
        }


        return listaDTO;
    }

    public static boolean cadastrar(@RequestBody ProdutoDTO dto){
        System.out.println("Cadastrando Produto");
        Produto produto = new Produto(dto);
        lista.add(produto);
        return true;
    }

    public boolean debitar(float qtd, String sku){
        if (verificarSku(sku)){
            lista.get

            if(quantidadeEstoque < qtd){
                System.err.println("Estoque insuficiente"); //Passar esse teste para o service
                return false;
            } else{
                quantidadeEstoque = quantidadeEstoque - qtd; //Produto faz só isso
                
                return true;
            }
        }
    }

    public static boolean verificarSku(String sku){
        for (Produto produto : lista) {
            if(produto.infos().getSku().equals(sku)){
                return true; //Se achar o produto retorna true
            }
        }
        return false; //Se não achar o produto retorna false
    }


}
