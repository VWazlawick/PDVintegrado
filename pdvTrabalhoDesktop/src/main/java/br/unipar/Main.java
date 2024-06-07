package br.unipar;

import br.unipar.api.ClienteAPI;
import br.unipar.models.Cliente;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main{
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.setVisible(true);
    }


}