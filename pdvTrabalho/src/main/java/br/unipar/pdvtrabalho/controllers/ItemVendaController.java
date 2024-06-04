package br.unipar.pdvtrabalho.controllers;

import br.unipar.pdvtrabalho.dtos.ItemVendaRequest;
import br.unipar.pdvtrabalho.models.ItemVenda;
import br.unipar.pdvtrabalho.services.ItemVendaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Tag(name = "ItemVenda")
@RestController
@RequestMapping("/itemVenda")
public class ItemVendaController {

    @Autowired
    private ItemVendaService  itemVendaService;

    @PostMapping
    public ResponseEntity<ItemVenda> insert(@RequestBody ItemVendaRequest dto, UriComponentsBuilder builder){
        ItemVenda itemVenda = itemVendaService.insert(ItemVenda.requestToItemVenda(dto));

        URI uri = builder.path("/itemvenda/{id}").buildAndExpand(itemVenda.getId()).toUri();

        return ResponseEntity.created(uri).body(itemVenda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemVenda> update(@PathVariable Long id, @RequestBody ItemVenda itemVenda){
        try {
            itemVenda.setId(id);
            itemVendaService.update(itemVenda);

            return ResponseEntity.ok(itemVenda);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        itemVendaService.delete(id);

        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ItemVenda> findById(@PathVariable Long id){
        return ResponseEntity.ok(itemVendaService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ItemVenda>> findAll(){
        return ResponseEntity.ok(itemVendaService.findAll());
    }
}
