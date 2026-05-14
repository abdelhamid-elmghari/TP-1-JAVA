package TP6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MaBibliothequeBonheur {
    private ArrayList<Livre> notreRayonDeBonheur = new ArrayList<>();
    private HashSet<String> setCategories = new HashSet<>();
    private HashMap<String, String> carteEmprunts = new HashMap<>();

    public void demarrer() {
        System.out.println("Bienvenue dans la Bibliothèque !");
        notreRayonDeBonheur.add(new Livre("978-01", "Le Petit Prince", "Saint-Exupéry", 1943));
        setCategories.add("Littérature");

        String amiLecteur = "Jean Dupont";
        carteEmprunts.put(amiLecteur, "Le Petit Prince");
        System.out.println("\n" + amiLecteur + " a emprunté un livre avec joie.");

        System.out.println("\n--- Rapport de fin de journée ---");
        System.out.println("Livres en rayon : " + notreRayonDeBonheur.size());
        System.out.println("Catégories : " + setCategories);
        System.out.println("Emprunts en cours : " + carteEmprunts.size());
        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {
        new MaBibliothequeBonheur().demarrer();
    }
}
