package br.com.blue.data;

public class ManagerData {

    public  ReadCSV csv = new ReadCSV();
    String[] nomeComprador;
    double[] preco;
    int[] quantia;
    int[] id;

    public int[] getQuantia(String nome){

        for (ObjectData massa : csv.objData){

            nomeComprador = massa.getNomeComprador();

            if(nomeComprador[0].equals(nome)) {
                quantia = massa.getQuantia();
                break;
            }
        }
        return quantia;

    }

    public double[] getPreco(String nome){

        for (ObjectData massa : csv.objData){

            nomeComprador = massa.getNomeComprador();

            if(nomeComprador[0].equals(nome)) {
                preco = massa.getPreco();
                break;
            }
        }
        return preco;

    }

    public int[] getID(String nome){

        for (ObjectData massa : csv.objData){

            nomeComprador = massa.getNomeComprador();

            if(nomeComprador[0].equals(nome)) {
                id = massa.getId();
                break;
            }
        }
        return id;

    }

}
