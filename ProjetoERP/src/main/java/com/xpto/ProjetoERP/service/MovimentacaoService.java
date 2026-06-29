package com.xpto.ProjetoERP.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xpto.ProjetoERP.Entity.MovimentacaoBaixa;
import com.xpto.ProjetoERP.Entity.MovimentacaoEntity;
import com.xpto.ProjetoERP.Entity.MovimentacaoReposicao;
import com.xpto.ProjetoERP.Entity.Produto;
import com.xpto.ProjetoERP.Repository.MovimentacaoRepository;
import com.xpto.ProjetoERP.dto.MovimentacaoDTO;
import com.xpto.ProjetoERP.dto.PedidoMovimentacaoDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class MovimentacaoService {

    private final ProdutoService produtoService;
    private final MovimentacaoRepository repository;

    public List<MovimentacaoDTO> listar(){
        List<MovimentacaoDTO> lista = new ArrayList<>();
        for (MovimentacaoEntity mov : repository.findAll()){
            lista.add(mov.infos());
        }
        return lista;
    }


    public boolean debitar(PedidoMovimentacaoDTO dto){
        if (produtoService.verificarDebitar(dto)){
            MovimentacaoEntity baixaEntity;

            Produto produto = produtoService.buscarProduto(dto);
            MovimentacaoBaixa baixa = new MovimentacaoBaixa(dto, produto);
            baixaEntity = new MovimentacaoEntity(baixa.executar());
            produtoService.salvar(produto); //Não gostei dessa implementação, resolver depois(Provavelmente como observer de debitar e salvar)

            repository.save(baixaEntity);

        }
        
        return true;
    }
  
    public boolean repor(@RequestBody PedidoMovimentacaoDTO dto){
        if (produtoService.verificarSku(dto)){
            MovimentacaoEntity reposicaoEntity;

            Produto produto = produtoService.buscarProduto(dto);
            MovimentacaoReposicao reposicao = new MovimentacaoReposicao(dto, produto);
            reposicaoEntity = new MovimentacaoEntity(reposicao.executar());
            produtoService.salvar(produto); //Não gostei dessa implementação, resolver depois

            
            repository.save(reposicaoEntity);

        }
        return true;
    }

}
