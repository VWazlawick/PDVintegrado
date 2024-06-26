package br.unipar.api;

import br.unipar.models.Cliente;
import br.unipar.models.Log;
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

public class ClienteAPI {

    public static Cliente insert(Cliente cliente) {
        try {
            URL url = new URL("http://localhost:8080/cliente");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");

            String json = Cliente.marshallToJson(cliente);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int code = conn.getResponseCode();

            System.out.println("Code : " + code);

            if(code == HttpURLConnection.HTTP_CREATED){
                try(BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"))){
                    StringBuilder response = new StringBuilder();
                    String responseLine= null;

                    while((responseLine=br.readLine())!=null){
                        response.append(responseLine.trim());
                    }

                    ObjectMapper mapper = new ObjectMapper();
                    cliente = mapper.readValue(response.toString(), Cliente.class);
                }
            }
            Log log = new Log(new Date(), "Criar Cliente", code);
            log.gerarLog(log);
            conn.disconnect();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return cliente;
    }

    public static Cliente update(Cliente cliente){
        try {
           String url = "http://localhost:8080/cliente/{id}";
           URI uri = new URI(url.replace("{id}", String.valueOf(cliente.getId())));

            HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();

            conn.setRequestMethod("PUT");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");

            String json = Cliente.marshallToJson(cliente);

            try(OutputStream os = conn.getOutputStream()){
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int code = conn.getResponseCode();

            System.out.println("Response code: " + code);

            Log log = new Log(new Date(), "Atualizar Cliente", code);
            log.gerarLog(log);

            conn.disconnect();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return cliente;
    }

    public static void delete(int id){
        try {
            String url = "http://localhost:8080/cliente/{id}";
            URI uri = new URI(url.replace("{id}", String.valueOf(id)));

            HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();

            conn.setRequestMethod("DELETE");

            int code = conn.getResponseCode();
            System.out.println("Response code: " + code);

            Log log = new Log(new Date(), "Excluir Cliente", code);
            log.gerarLog(log);

            conn.disconnect();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static Cliente findById(int id){
        Cliente cliente = null;
        try {
            String url = "http://localhost:8080/cliente/{id}";
            URI uri = new URI(url.replace("{id}", String.valueOf(id)));

            HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();

            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder response = new StringBuilder();

            String inputLine;

            while((inputLine=in.readLine())!=null){
                response.append(inputLine);
            }
            in.close();

            cliente = Cliente.fromJson(response.toString());

            int code = conn.getResponseCode();

            System.out.println("Response code: " + code);

            Log log = new Log(new Date(), "Buscar Cliente: " + id, code);
            log.gerarLog(log);

            conn.disconnect();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return cliente;
    }

    public static List<Cliente> findAll(){
        List<Cliente> lista = new ArrayList<>();
        try{
            URL url = new URL("http://localhost:8080/cliente/all");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;

            String result = "";

            while ((inputLine = in.readLine()) != null) {
                result += inputLine;
            }
            in.close();

            lista = Cliente.unmarshallFromJson(result);

            int code = conn.getResponseCode();

            System.out.println("Response Code : " + code);

            Log log = new Log(new Date(), "Buscar Clientes", code);
            log.gerarLog(log);

            conn.disconnect();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return lista;
    }

    public static List<Cliente> findByNome(String nome){
        List<Cliente> lista = new ArrayList<>();
        try {
            URL url = new URL("http://localhost:8080/cliente/nome?nome=" +  java.net.URLEncoder.encode(nome, "UTF-8"));

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;
            String result  = "";

            while((inputLine = in.readLine())!= null){
                result += inputLine;
            }
            in.close();

            lista = Cliente.unmarshallFromJson(result);

            int code = conn.getResponseCode();
            System.out.println("Response code: " + code);

            Log log = new Log(new Date(), "Buscar Cliente: " + nome, code);
            log.gerarLog(log);

            conn.disconnect();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return lista;
    }
}
