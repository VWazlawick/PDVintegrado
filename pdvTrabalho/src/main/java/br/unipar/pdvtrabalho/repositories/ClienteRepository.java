package br.unipar.pdvtrabalho.repositories;

import br.unipar.pdvtrabalho.models.Cliente;
import ch.qos.logback.core.net.server.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public List<Cliente> findAllByOrderById();

    public List<Cliente> findByNomeContainingIgnoreCaseOrderByNomeAsc(String nome);
}
