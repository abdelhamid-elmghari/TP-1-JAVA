package TP6;

public class Client {
    private int numero;
    private String nom;

    public Client(int numero, String nom) {
        this.numero = numero;
        this.nom = nom;
    }

    public int getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Client{" +
                "numero=" + numero +
                ", nom='" + nom + '\'' +
                '}';
    }
}
