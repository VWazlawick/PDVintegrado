package br.unipar.updaters;

import br.unipar.models.Cliente;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ClienteUpdater {
    private List<Cliente> clientes;

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


}
