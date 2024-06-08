package br.unipar.updaters;

import br.unipar.api.ClienteAPI;
import br.unipar.models.Cliente;
import br.unipar.models.ItemVenda;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ClienteUpdater {
    private List<Cliente> lista;

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    private final ReentrantLock lock = new ReentrantLock();

    public ClienteUpdater() {
        this.lista = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return lista;
    }

    public CompletableFuture<List<Cliente>> startUpdating(){
        CompletableFuture<List<Cliente>> future = new CompletableFuture<>();

        final Runnable updater = () -> {
            try {
                lock.lock();
                try {
                    lista.clear();
                    List<Cliente> clientes = findCliente();
                    lista.addAll(clientes);

                    future.complete(lista);
                }
                finally {
                    lock.unlock();
                }
            }
            catch (Exception ex){
                future.completeExceptionally(ex);
            }

        };
        scheduler.schedule(updater, 30, TimeUnit.SECONDS);
        return future;
    }

    public void stopUpdating(int timeout){
        scheduler.shutdown();
        try {
            if(!scheduler.awaitTermination(timeout, TimeUnit.SECONDS)){
                scheduler.shutdownNow();
            }
        }
        catch (InterruptedException ex){
            scheduler.shutdownNow();
        }
    }

    private List<Cliente> findCliente() throws MalformedURLException {
        ClienteAPI dao = new ClienteAPI();
        List<Cliente> lista = dao.findAll();

        return lista;
    }

    private void printString(){
        final Runnable print = new Runnable() {
            @Override
            public void run() {
                for(Cliente cliente : lista){
                    System.out.println(cliente.toString());
                }
                stopUpdating(1);
            }
        };
        scheduler.schedule(print, 30, TimeUnit.SECONDS);
    }
}
