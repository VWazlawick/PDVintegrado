package br.unipar.api;

import br.unipar.models.Log;
import br.unipar.models.Produto;
import br.unipar.models.Venda;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VendaAPI {

    public static void insert(Venda venda) {
        new Thread(()->{
            try {
                URL url = new URL("http://localhost:8080/venda");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setDoOutput(true);

                String json = Venda.marshallToJson(venda);

                try(OutputStream os = conn.getOutputStream()) {
                    byte[] input = json.getBytes();
                    os.write(input, 0, input.length);
                }

                int code = conn.getResponseCode();
                System.out.println("Response Code : " + code);

                Log log = new Log(new Date(), "Criar Venda", code);
                log.gerarLog(log);

                conn.disconnect();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        },"Finalizado venda").start();

        JOptionPane.showMessageDialog(null, "Venda Inserido com sucesso!");
    }

    public static Venda update(Venda venda) {
        try {
            String url = "http://localhost:8080/venda/{id}";

            URI uri = new URI(url.replace("{id}", String.valueOf(venda.getId())));
            HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String json = Venda.marshallToJson(venda);
            try(OutputStream os = conn.getOutputStream()) {
                byte[] input = json.getBytes();
                os.write(input, 0, input.length);
            }

            int code = conn.getResponseCode();
            System.out.println("Response Code : " + code);

            Log log = new Log(new Date(), "Atualizar Venda", code);
            log.gerarLog(log);

            conn.disconnect();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return venda;
    }

    public static void delete(int id) {
        try {
            String url = "http://localhost:8080/venda/{id}";
            URI uri = new URI(url.replace("{id}", String.valueOf(id)));

            HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
            conn.setRequestMethod("DELETE");

            int code = conn.getResponseCode();
            System.out.println("Response Code : " + code);

            Log log = new Log(new Date(), "Excluir Venda", code);
            log.gerarLog(log);

            conn.disconnect();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Venda findById(int id) {
        Venda venda = null;
        try {
            String url = "http://localhost:8080/venda/{id}";
            URI uri = new URI(url.replace("{id}", String.valueOf(id)));

            HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine.trim());
            }
            in.close();

            venda = Venda.fromJson(response.toString());

            int code = conn.getResponseCode();
            System.out.println("Response Code : " + code);

            Log log = new Log(new Date(), "Buscar Venda: " + id, code);
            log.gerarLog(log);

            conn.disconnect();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return venda;
    }

    public static List<Venda> findAll() {
        List<Venda> lista = new ArrayList<>();

        try {
            URL url = new URL("http://localhost:8080/venda/all");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            String result = "";

            while ((inputLine = in.readLine()) != null) {
                result += inputLine.trim();
            }
            in.close();

            lista = Venda.unmarshallFromJson(result);

            int code = conn.getResponseCode();
            System.out.println("Response Code : " + code);

            Log log = new Log(new Date(), "Buscar Vendas", code);
            log.gerarLog(log);

            conn.disconnect();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
