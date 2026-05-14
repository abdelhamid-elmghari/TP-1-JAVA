package TP6;

public class Etudiant {
    private int id;
    private String nom;
    private double moyenne;

    public Etudiant(int id, String nom, double moyenne) {
        this.id = id;
        this.nom = nom;
        this.moyenne = moyenne;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", moyenne=" + moyenne +
                '}';
    }
}
