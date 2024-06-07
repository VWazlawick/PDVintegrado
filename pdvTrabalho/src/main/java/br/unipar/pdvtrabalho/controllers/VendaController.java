package br.unipar.pdvtrabalho.controllers;

import br.unipar.pdvtrabalho.dtos.VendaRequest;
import br.unipar.pdvtrabalho.models.Venda;
import br.unipar.pdvtrabalho.services.VendaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Tag(name = "Venda")
@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<Venda> insert(@RequestBody VendaRequest dtoVenda, UriComponentsBuilder builder){
        Venda venda = vendaService.insert(Venda.requestToVenda(dtoVenda));

        URI uri = builder.path("/venda/{id}").buildAndExpand(venda.getId()).toUri();

        return  ResponseEntity.created(uri).body(venda);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Venda> update(@PathVariable Long id, @RequestBody Venda venda){
        venda.setId(id);
        vendaService.update(venda);

        return ResponseEntity.ok(venda);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        vendaService.delete(id);

        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Venda> findById(@PathVariable Long id){
        return ResponseEntity.ok(vendaService.findById(id));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Venda>> findAll(){
        return ResponseEntity.ok(vendaService.findAll());
    }
}
