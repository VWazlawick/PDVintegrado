package br.unipar.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Log {
    private Date data;
    private String operacao;
    private int status;

    public void gerarLog(Log dados){
        File pasta = new File("C://LOGS");
        File log = new File(pasta.getAbsolutePath()+"//logs.txt");

        if(pasta.exists()){
            System.out.println("Pasta já criado");
        }
        else {
            pasta.mkdir();
            System.out.println("Pasta criado");

            if(log.exists()){
                System.out.println("Arquivo de log já existente");
            }
            else {
                try {
                    log.createNewFile();
                    System.out.println("Arquivo de log criado");
                }
                catch (Exception ex){
                    System.out.println("Error a criar novo arquivo: " + ex.getMessage());
                }
            }
        }
        if (log.exists()){
            try(FileWriter escritor = new FileWriter(log, true);
            BufferedWriter bw = new BufferedWriter(escritor)) {



                bw.write("\nData: " + dados.getData() +
                        " Tipo: " + dados.getOperacao() +
                        " Status: " + dados.getStatus() + ";");
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }


    }

}
