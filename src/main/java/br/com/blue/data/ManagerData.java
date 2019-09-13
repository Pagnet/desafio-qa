package br.com.blue.data;

public class ManagerData {

    public  ReadCSV csv = new ReadCSV();
    String[] nomeComprador;
    double[] preco;
    int[] quantia;

    public int[] getQuantia(String nome){

        for (ObjectData massa : csv.objData){
            if(massa.getNomeComprador().equals(nome)) {
                quantia = massa.getQuantia();
            }
        }
        return quantia;

    }

    public double[] getPreco(String nome){

        for (ObjectData massa : csv.objData){
            if(massa.getNomeComprador().equals(nome)) {
                preco = massa.getPreco();
            }
        }
        return preco;

    }

    public String[] getNomeComprador(){

        for (ObjectData massa : csv.objData) {
            return nomeComprador = massa.getNomeComprador();
        }
        return nomeComprador;
    }

}
