package br.unipar.pdvtrabalho.services;

import br.unipar.pdvtrabalho.models.ItemVenda;
import br.unipar.pdvtrabalho.models.Venda;
import br.unipar.pdvtrabalho.repositories.ItemVendaRepository;
import br.unipar.pdvtrabalho.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    public Venda insert(Venda venda){
        vendaRepository.save(venda);
        for(ItemVenda itemVenda : venda.getListaProdutos()){
            itemVenda.setVenda(venda);
            itemVendaRepository.save(itemVenda);
        }
        return venda;
    }

    public Venda update(Venda venda){
        vendaRepository.save(venda);
        return venda;
    }

    public void delete(Long id){
        vendaRepository.deleteById(id);
    }

    public Venda findById(Long id){
        Optional<Venda> venda = vendaRepository.findById(id);
        return venda.orElse(null);
    }

    public List<Venda> findAll(){
        return vendaRepository.findAll();
    }
}
