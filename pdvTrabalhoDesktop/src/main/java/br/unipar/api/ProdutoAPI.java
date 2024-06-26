package br.unipar.api;

import br.unipar.models.Log;
import br.unipar.models.Produto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProdutoAPI {

    public static Produto insert(Produto produto) {
        try {
            URL url = new URL("http://localhost:8080/produto");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String json = Produto.marshallToJson(produto);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = json.getBytes("UTF-8");
                os.write(input, 0, input.length);
            }

            int code = conn.getResponseCode();
            System.out.println("Response Code : " + code);

            if(code == HttpURLConnection.HTTP_CREATED){
                try(BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"))){
                    StringBuilder response = new StringBuilder();
                    String responseLine= null;

                    while((responseLine=br.readLine())!=null){
                        response.append(responseLine.trim());
                    }

                    ObjectMapper mapper = new ObjectMapper();
                    produto = mapper.readValue(response.toString(), Produto.class);
                }
            }

            Log log = new Log(new Date(), "Criar Produto", code);
            log.gerarLog(log);

            conn.disconnect();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return produto;
    }

    public static Produto update(Produto produto) {
        try {
            String url = "http://localhost:8080/produto/{id}";

            URI uri = new URI(url.replace("{id}", String.valueOf(produto.getId())));

            HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();

            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String json = Produto.marshallToJson(produto);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = json.getBytes("UTF-8");
                os.write(input, 0, input.length);
            }

            int code = conn.getResponseCode();
            System.out.println("Response Code : " + code);

            Log log = new Log(new Date(), "Atualizar Produto", code);
            log.gerarLog(log);

            conn.disconnect();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return produto;
    }

    public static void delete(int id) {
        try {
            String url = "http://localhost:8080/produto/{id}";

            URI uri = new URI(url.replace("{id}", String.valueOf(id)));

            HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
            conn.setRequestMethod("DELETE");

            int code = conn.getResponseCode();
            System.out.println("Response Code : " + code);

            Log log = new Log(new Date(), "Excluir Produto", code);
            log.gerarLog(log);

            conn.disconnect();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static Produto findById(int id) {
        Produto produto = null;
        try {
            String url = "http://localhost:8080/produto/{id}";
            URI uri = new URI(url.replace("{id}", String.valueOf(id)));

            HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            produto = Produto.fromJson(response.toString());

            int code = conn.getResponseCode();
            System.out.println("Response Code : " + code);

            Log log = new Log(new Date(), "Buscar Produto: " + id, code);
            log.gerarLog(log);

            conn.disconnect();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return produto;
    }

    public static List<Produto> findAll(){
        List<Produto> lista = new ArrayList<Produto>();
        try {
            URL url = new URL("http://localhost:8080/produto/all");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            String result = "";

            while ((inputLine = in.readLine()) != null) {
                result += inputLine;
            }
            in.close();

            lista = Produto.unmarshallFromJson(result);

            int code = conn.getResponseCode();
            System.out.println("Response Code : " + code);

            Log log = new Log(new Date(), "Buscar Produtos", code);
            log.gerarLog(log);

            conn.disconnect();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return lista;
    }

    public static List<Produto> findByDescricao(String descricao){
        List<Produto> lista = new ArrayList<>();
        try {
            URL url = new URL("http://localhost:8080/produto/descricao?descricao=" + java.net.URLEncoder.encode(descricao, "UTF-8"));

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            String result = "";

            while((inputLine = in.readLine())!=null){
                result+=inputLine;
            }
            in.close();

            lista = Produto.unmarshallFromJson(result);

            int code = conn.getResponseCode();;
            System.out.println("Response Code: " + code);

            Log log = new Log(new Date(), "Buscar Produtos: " + descricao, code);
            log.gerarLog(log);

            conn.disconnect();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return lista;
    }

    public static List<Produto> findByCategoria(String categoria){
        List<Produto> lista = new ArrayList<>();
        try {
            URL url = new URL("http://localhost:8080/produto/categoria?categoria=" + java.net.URLEncoder.encode(categoria, "UTF-8"));

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            String result = "";

            while((inputLine = in.readLine())!=null){
                result+=inputLine;
            }
            in.close();

            lista = Produto.unmarshallFromJson(result);

            int code = conn.getResponseCode();;
            System.out.println("Response Code: " + code);

            Log log = new Log(new Date(), "Buscar Produtos: " + categoria, code);
            log.gerarLog(log);

            conn.disconnect();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return lista;
    }
}
