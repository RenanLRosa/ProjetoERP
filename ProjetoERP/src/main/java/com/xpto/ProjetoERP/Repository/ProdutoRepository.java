package com.xpto.ProjetoERP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xpto.ProjetoERP.Entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

}
