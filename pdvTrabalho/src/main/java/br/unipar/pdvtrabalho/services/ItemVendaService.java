package br.unipar.pdvtrabalho.services;

import br.unipar.pdvtrabalho.models.ItemVenda;
import br.unipar.pdvtrabalho.models.Venda;
import br.unipar.pdvtrabalho.repositories.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemVendaService {

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    public ItemVenda insert(ItemVenda itemVenda){
        itemVendaRepository.save(itemVenda);
        return itemVenda;
    }

    public ItemVenda update(ItemVenda itemVenda){
        itemVendaRepository.save(itemVenda);
        return itemVenda;
    }

    public void delete(Long id){
        itemVendaRepository.deleteById(id);
    }

    public ItemVenda findById(Long id){
        Optional<ItemVenda> itemVenda = itemVendaRepository.findById(id);
        return itemVenda.orElse(null);
    }

    public List<ItemVenda> findAll(){
        return itemVendaRepository.findAll();
    }

    public List<ItemVenda> findByVenda(Venda venda){return itemVendaRepository.findByVenda(venda);}
}
