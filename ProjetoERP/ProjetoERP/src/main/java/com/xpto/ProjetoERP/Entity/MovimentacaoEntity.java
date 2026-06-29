package com.xpto.ProjetoERP.Entity;

import com.xpto.ProjetoERP.dto.MovimentacaoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;


@Entity
@Table(name = "movimentacao")
@Getter
public class MovimentacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String skuProduto;
    private float qtd;
    private String data;
    private String tipo;

    protected MovimentacaoEntity(){
    }

    public MovimentacaoEntity(MovimentacaoDTO mov){
        this.skuProduto = mov.getSkuProduto();
        this.qtd = mov.getQuantidade();
        this.tipo = mov.getTipo();

    }

    public MovimentacaoDTO infos(){
        MovimentacaoDTO mov = new MovimentacaoDTO(skuProduto, data, qtd);
        mov.setTipo(tipo);
        return mov;
    }
}
