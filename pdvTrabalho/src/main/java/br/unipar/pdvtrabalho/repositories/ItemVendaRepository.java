package br.unipar.pdvtrabalho.repositories;

import br.unipar.pdvtrabalho.models.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {
}
