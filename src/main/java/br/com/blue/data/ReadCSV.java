package br.com.blue.data;

import br.com.blue.factory.PropertiesFactory;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class ReadCSV {

    public static HashSet<ObjectData> objData;

    public ReadCSV() {

        try {

            File caminhoArquivoCSV = new File(PropertiesFactory.getProp().getProperty("prop.filecsv"));
            Scanner lercsv = new Scanner(caminhoArquivoCSV);
            objData = new HashSet<>();

            while (lercsv.hasNext()) {

                String linha = lercsv.nextLine();
                String[] coluna = linha.split(",");

                if (linha != null) {

                    String nome = coluna[0].trim();
                    String preco = coluna[1].trim();
                    String quantia = coluna[2].trim();

                    objData.add(new ObjectData(new String[]{nome},new double[]{Double.parseDouble(preco)},
                            new int[]{Integer.parseInt(quantia)}));
                }

            }

        }

        catch(Exception e){
            System.out.println("Arquivo não encontrado ou não pode ser lido !");
        }

    }
}
