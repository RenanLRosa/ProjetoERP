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

    public boolean VerificarDebitar(float qtd, String sku){
        if (verificarSku(sku)){
            lista.get

            if(quantidadeEstoque < qtd){
                System.err.println("Estoque insuficiente"); //Passar esse teste para o service -> diexar um static final nos movimentações e só puxar um utilitário de teste, que idnica com base nesse código o teste certo.
                return false;
            } else{
                quantidadeEstoque = quantidadeEstoque - qtd; //Produto faz só isso
                
                return true;
            }
        }
    }

    /**Verifica o sku passado. 
     * @return Retorna true se encontrar e false se não encontrar */  
    public static boolean verificarSku(String sku){ //Vai pra um utilitário de teste
        for (Produto produto : lista) {
            if(produto.infos().getSku().equals(sku)){
                return true;
            }
        }
        return false;
    }

    public static boolean verificarDisponibilidade(float qtd){ //Vai pra um utilitário depois


    }

}
