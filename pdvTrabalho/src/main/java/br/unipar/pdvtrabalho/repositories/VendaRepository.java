package br.unipar.pdvtrabalho.repositories;

import br.unipar.pdvtrabalho.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
}
