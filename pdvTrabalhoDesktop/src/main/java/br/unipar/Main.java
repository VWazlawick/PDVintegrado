package br.unipar;

import br.unipar.api.ClienteAPI;
import br.unipar.models.Cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        ClienteAPI api = new ClienteAPI();

        System.out.println(api.findById(2).toString());
    }
}