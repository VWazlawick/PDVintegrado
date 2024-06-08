package br.unipar.updaters;

import br.unipar.api.ProdutoAPI;
import br.unipar.models.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ProdutoUpdater {

    private List<Produto> lista;

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    private final ReentrantLock lock = new ReentrantLock();

    public ProdutoUpdater() {
        this.lista = new ArrayList<>();
    }

    public List<Produto> getLista() {
        return this.lista;
    }

    public CompletableFuture<List<Produto>> startUpdating() {
        CompletableFuture<List<Produto>> future = new CompletableFuture<>();

        final Runnable updater = () -> {
            try {
                lock.lock();
                try {
                    lista.clear();
                    List<Produto> produtos = findProdutos();

                    lista.addAll(produtos);
                    future.complete(new ArrayList<>(lista));
                }
                finally {
                    lock.unlock();
                }
            }
            catch (Exception ex){
                future.completeExceptionally(ex);
            }
        };
        scheduler.scheduleAtFixedRate(updater, 0, 5, TimeUnit.MINUTES);
        return future;
    }

    public void stopUpdating(int timeout){
        scheduler.shutdown();
        try {
            if(!scheduler.awaitTermination(timeout, TimeUnit.SECONDS)){
                scheduler.shutdownNow();
            }
        }
        catch (Exception ex){
            scheduler.shutdownNow();
        }
    }

    private List<Produto> findProdutos(){
        ProdutoAPI dao = new ProdutoAPI();
        return dao.findAll();
    }

    private void printString(){
        final Runnable print = new Runnable() {
            @Override
            public void run() {
                for(Produto produto : lista){
                    System.out.println(produto.toString());
                }
                stopUpdating(1);
            }
        };
        scheduler.scheduleAtFixedRate(print, 0, 10, TimeUnit.SECONDS);
    }
}
