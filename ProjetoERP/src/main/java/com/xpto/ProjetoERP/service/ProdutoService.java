package com.xpto.ProjetoERP.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.xpto.ProjetoERP.Entity.Produto;
import com.xpto.ProjetoERP.Repository.ProdutoRepository;
import com.xpto.ProjetoERP.dto.PedidoMovimentacaoDTO;
import com.xpto.ProjetoERP.dto.ProdutoDTO;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public List<ProdutoDTO> listar(){
        List<ProdutoDTO> listaDTO = new ArrayList<>();
        for (Produto produto : repository.findAll()) {
            listaDTO.add(produto.infos());
        }


        return listaDTO;
    }

    public boolean cadastrar(ProdutoDTO dto){
        System.out.println("Cadastrando Produto");
        Produto produto = new Produto(dto);

        repository.save(produto);
        return true;
    }

    public boolean verificarDebitar(PedidoMovimentacaoDTO dto){
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

    public void salvar(Produto produto){ //Achar um jeito de jogar um salvar() para os utilitários, como um genérico para salvar qualquer objeto
        repository.save(produto);
    }

    public Produto buscarProduto(PedidoMovimentacaoDTO dto) {
        Optional<Produto> resultado = repository.findById(dto.getSkuProduto());
        return resultado.orElse(null);
    }

    public boolean verificarDisponibilidade(PedidoMovimentacaoDTO dto) {
        Optional<Produto> resultado = repository.findById(dto.getSkuProduto());
        if (resultado.isEmpty()){
            return false;
        }
        Produto produto = resultado.get();
        return produto.infos().getQuantidadeEstoque() >= dto.getQuantidade();

    }


        /**Verifica o sku passado.
     * @return Retorna true se encontrar e false se não encontrar */
    public boolean verificarSku(PedidoMovimentacaoDTO dto){ //Vai pra um utilitário de teste
        return repository.existsById(dto.getSkuProduto());
    }


}
