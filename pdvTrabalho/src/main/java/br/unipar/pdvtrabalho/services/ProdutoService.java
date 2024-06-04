package br.unipar.pdvtrabalho.services;

import br.unipar.pdvtrabalho.models.Produto;
import br.unipar.pdvtrabalho.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto insert(Produto produto){
        produtoRepository.save(produto);
        return produto;
    }

    public Produto update(Produto produto){
        produtoRepository.save(produto);
        return produto;
    }

    public void delete(Long id){
        produtoRepository.deleteById(id);
    }

    public Produto findById(Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }
}
