package br.com.blue.data;

public class ObjectData implements Data{

    private String[] nomeComprador;
    private double[] preco;
    private int[] quantia;

    public ObjectData(String[] nome, double[] preco, int[] quantia) {

        this.nomeComprador = nome;
        this.preco = preco;
        this.quantia = quantia;
    }

    public String[] getNomeComprador() {
        return nomeComprador;
    }

    public double[] getPreco() {
        return preco;
    }

    public int[] getQuantia() {
        return quantia;
    }

}
