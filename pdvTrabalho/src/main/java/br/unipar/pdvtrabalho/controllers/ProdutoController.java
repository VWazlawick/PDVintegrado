package br.unipar.pdvtrabalho.controllers;

import br.unipar.pdvtrabalho.dtos.ProdutoRequest;
import br.unipar.pdvtrabalho.models.Produto;
import br.unipar.pdvtrabalho.services.ProdutoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Tag(name = "Produto")
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> insert(@RequestBody ProdutoRequest dto, UriComponentsBuilder builder){
            Produto produto = produtoService.insert(Produto.requestToProduto(dto));
            URI uri =builder.path("produto/{id}").buildAndExpand(produto.getId()).toUri();

            return ResponseEntity.created(uri).body(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto){
        produto.setId(id);
        produtoService.update(produto);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        return ResponseEntity.ok(produtoService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Produto>> findAll(){
        return ResponseEntity.ok(produtoService.findAll());
    }
}
