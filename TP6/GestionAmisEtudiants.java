package TP6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GestionAmisEtudiants {
    public static void main(String[] args) {
        ArrayList<Etudiant> listeAmisEtudiants = new ArrayList<>();
        listeAmisEtudiants.add(new Etudiant(1, "Alice", 15.5));
        listeAmisEtudiants.add(new Etudiant(2, "Bob", 12.0));
        listeAmisEtudiants.add(new Etudiant(3, "Charlie", 18.5));
        listeAmisEtudiants.add(new Etudiant(4, "David", 10.5));
        listeAmisEtudiants.add(new Etudiant(5, "Eve", 14.0));

        System.out.println("Bienvenue dans notre gestionnaire d'amis !");
        System.out.println("\nVoici la liste de nos chers étudiants :");
        listeAmisEtudiants.forEach(System.out::println);

        String nomRecherche = "Charlie";
        System.out.println("\nOn cherche notre ami " + nomRecherche + "...");
        listeAmisEtudiants.stream()
            .filter(e -> e.getNom().equalsIgnoreCase(nomRecherche))
            .findFirst()
            .ifPresent(e -> System.out.println("Trouvé ! " + e));

        int idSuppr = 2;
        listeAmisEtudiants.removeIf(e -> e.getId() == idSuppr);
        System.out.println("\nBob est parti vers de nouveaux horizons (ID " + idSuppr + ").");

        listeAmisEtudiants.sort(Comparator.comparingDouble(Etudiant::getMoyenne));
        System.out.println("\nVoici le classement par moyenne (ordre croissant) :");
        listeAmisEtudiants.forEach(System.out::println);

        Etudiant laStar = Collections.max(listeAmisEtudiants, Comparator.comparingDouble(Etudiant::getMoyenne));
        System.out.println("\nFélicitations à " + laStar.getNom() + " qui est la star du jour !");
    }
}
