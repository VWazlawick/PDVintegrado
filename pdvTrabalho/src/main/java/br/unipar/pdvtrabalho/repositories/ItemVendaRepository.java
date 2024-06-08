package br.unipar.pdvtrabalho.repositories;

import br.unipar.pdvtrabalho.models.ItemVenda;
import br.unipar.pdvtrabalho.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {

    public List<ItemVenda> findByVenda(Venda venda);
}
