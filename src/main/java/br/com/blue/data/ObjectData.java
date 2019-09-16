package br.com.blue.data;

public class ObjectData implements Data{

    private int[] id;
    private String[] nomeComprador;
    private double[] preco;
    private int[] quantia;

    public ObjectData(int[] id,String[] nome, double[] preco, int[] quantia) {

        this.id = id;
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

    public int[] getId() {
        return id;
    }
}
