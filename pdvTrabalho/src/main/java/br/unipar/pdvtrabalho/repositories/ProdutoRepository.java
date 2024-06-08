package br.unipar.pdvtrabalho.repositories;

import br.unipar.pdvtrabalho.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public List<Produto> findAllByOrderByDescricao();

    public List<Produto> findByDescricaoContainingIgnoreCaseOrderByDescricao(String descricao);

    public List<Produto> findByCategoriaContainingIgnoreCaseOrderByDescricao(String categoria);

}
