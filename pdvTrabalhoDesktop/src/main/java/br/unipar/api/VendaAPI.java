package br.unipar.api;

import br.unipar.models.Produto;
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

public class VendaAPI {

    public static Venda insert(Venda venda) {
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

            if (code == HttpURLConnection.HTTP_CREATED){
                try(BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"))){
                    StringBuilder response = new StringBuilder();
                    String responseLine= null;

                    while((responseLine=br.readLine())!=null){
                        response.append(responseLine.trim());
                    }

                    ObjectMapper mapper = new ObjectMapper();
                    venda = mapper.readValue(response.toString(), Venda.class);
                }
            }

            conn.disconnect();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return venda;
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

            conn.disconnect();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
