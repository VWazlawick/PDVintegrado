package br.unipar.pdvtrabalho.services;

import br.unipar.pdvtrabalho.models.Cliente;
import br.unipar.pdvtrabalho.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente insert(Cliente cliente){
        clienteRepository.save(cliente);
        return cliente;
    }

    public Cliente update(Cliente cliente){
        clienteRepository.save(cliente);
        return cliente;
    }

    public void delete(Long id){
        clienteRepository.deleteById(id);
    }

    public Cliente findById(Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }





}
