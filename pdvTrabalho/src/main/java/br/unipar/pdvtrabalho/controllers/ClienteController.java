package br.unipar.pdvtrabalho.controllers;

import br.unipar.pdvtrabalho.dtos.ClienteRequest;
import br.unipar.pdvtrabalho.models.Cliente;
import br.unipar.pdvtrabalho.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Tag(name = "Cliente")
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> insert(@RequestBody ClienteRequest dto, UriComponentsBuilder builder){
        Cliente cliente = clienteService.insert(Cliente.requestToCliente(dto));
        URI uri = builder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return  ResponseEntity.created(uri).body(cliente);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente){
        cliente.setId(id);
        clienteService.update(cliente);
        return ResponseEntity.ok(cliente);
    }

    @ApiResponse(responseCode = "204", description = "Excluido com sucesso")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @Operation(description = "Buscar os Cliente ordenado pelo ID")
    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> findAll(){
        return ResponseEntity.ok(clienteService.findAll());
    }

    @Operation(description = "Buscar os Clientes pelo Nome")
    @GetMapping("/nome")
    public ResponseEntity<List<Cliente>> findByNome(@RequestParam String nome){
        return ResponseEntity.ok(clienteService.findByNome(nome));
    }
}
