package br.unipar.api;

import br.unipar.models.ItemVenda;
import br.unipar.models.Venda;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ItemVendaAPI {
    public static ItemVenda insert(ItemVenda itemVenda) {
        try {
            URL url = new URL("http://localhost:8080/itemVenda");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String json = ItemVenda.marshallToJson(itemVenda);

            try(OutputStream os = conn.getOutputStream()) {
                byte[] input = json.getBytes();
                os.write(input, 0, input.length);
            }

            int code = conn.getResponseCode();
            System.out.println("Response Code : " + code);

            if(code == HttpURLConnection.HTTP_CREATED) {
                try(BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"))){
                    StringBuilder response = new StringBuilder();
                    String responseLine= null;

                    while((responseLine=br.readLine())!=null){
                        response.append(responseLine.trim());
                    }

                    ObjectMapper mapper = new ObjectMapper();
                    itemVenda = mapper.readValue(response.toString(), ItemVenda.class);
                }
            }

            conn.disconnect();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return itemVenda;
    }

    public static ItemVenda update(ItemVenda itemVenda) {
        try {
            String url = "http://localhost:8080/itemVenda/{id}";
            URI uri = new URI(url.replace("{id}", String.valueOf(itemVenda.getId())));

            HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content Type", "application/json");

            String json = ItemVenda.marshallToJson(itemVenda);

            try(OutputStream os = conn.getOutputStream()){
                byte[] input = json.getBytes();
                os.write(input, 0, input.length);
            }

            int code = conn.getResponseCode();
            System.out.println("Response code: " + code);

            conn.disconnect();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return itemVenda;
    }

    public static void delete(int id){
        try {
            String url = "http://localhost:8080/itemVenda/{id}";
            URI uri = new URI(url.replace("{id}", String.valueOf(id)));

            HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
            conn.setRequestMethod("DELETE");

            int code = conn.getResponseCode();
            System.out.println("Response code: " + code);

            conn.disconnect();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static ItemVenda findByid(int id){
        ItemVenda itemVenda = null;
        try {
            String url = "http://localhost:8080/itemVenda/{id}";
            URI uri = new URI(url.replace("{id}", String.valueOf(id)));

            HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine=in.readLine())!=null){
                response.append(inputLine.trim());
            }
            in.close();

            itemVenda = ItemVenda.fromJson(response.toString());

            int code = conn.getResponseCode();
            System.out.println("Response code: " + code);

            conn.disconnect();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return itemVenda;
    }

    public static List<ItemVenda> findAll(){
        List<ItemVenda> lista = new ArrayList<>();
        try {
            URL url = new URL("http://localhost:8080/itemVenda/all");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            String result = "";

            while((inputLine=in.readLine())!=null){
                result += inputLine.trim();
            }
            in.close();

            lista = ItemVenda.unmarshallFromJson(result);

            int code = conn.getResponseCode();
            System.out.println("Response code: " + code);

            conn.disconnect();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return lista;
    }
}
