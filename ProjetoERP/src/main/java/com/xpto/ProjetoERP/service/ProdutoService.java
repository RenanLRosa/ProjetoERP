package com.xpto.ProjetoERP.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xpto.ProjetoERP.Entity.Produto;
import com.xpto.ProjetoERP.dto.PedidoMovimentacaoDTO;
import com.xpto.ProjetoERP.dto.ProdutoDTO;



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

    public static boolean cadastrar(ProdutoDTO dto){
        System.out.println("Cadastrando Produto");
        Produto produto = new Produto(dto);
        lista.add(produto);
        return true;
    }

    public boolean debitar(){
        return true;
    }

    public static boolean verificarDebitar(PedidoMovimentacaoDTO dto){
        if(verificarSku(dto)){
            System.out.println("Sku Existe");
        }else {
            return false;
        }
        if(verificarDisponibilidade(dto)){
            System.out.println("Tem estoque");
        }else{
            return false;
        }
        return true;
    }

    //Vai para o utilitarios

        public static Produto buscarProduto(PedidoMovimentacaoDTO dto) {
    for (Produto produto : lista) {
        if (produto.infos().getSku().equals(dto.getSkuProduto())) {
            return produto; 
        }
    }

        return null;
    }

    public static boolean verificarDisponibilidade(PedidoMovimentacaoDTO dto) {
        for (Produto produto : lista) {
            if (produto.infos().getSku().equals(dto.getSkuProduto())) {
                if (produto.infos().getQuantidadeEstoque() >= dto.getQuantidade()) {
                    return true;
                }
                return false; // Se achou o SKU mas não tem estoque, já retorna false direto
            }
    }
    return false; // Se rodou a lista inteira e não achou o SKU, retorna false

    
}
        /**Verifica o sku passado.
     * @return Retorna true se encontrar e false se não encontrar */
    public static boolean verificarSku(PedidoMovimentacaoDTO dto){ //Vai pra um utilitário de teste
        for (Produto produto : lista) {
            if(produto.infos().getSku().equals(dto.getSkuProduto())){
                return true;
            }
        }
        return false;
    }


}
