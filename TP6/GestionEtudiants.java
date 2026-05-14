package TP6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GestionEtudiants {
    public static void main(String[] args) {
        ArrayList<Etudiant> etudiants = new ArrayList<>();

        // 1. Add 5 students
        etudiants.add(new Etudiant(1, "Alice", 15.5));
        etudiants.add(new Etudiant(2, "Bob", 12.0));
        etudiants.add(new Etudiant(3, "Charlie", 18.5));
        etudiants.add(new Etudiant(4, "David", 10.5));
        etudiants.add(new Etudiant(5, "Eve", 14.0));

        // 2. Display all
        System.out.println("Liste des étudiants :");
        for (Etudiant e : etudiants) {
            System.out.println(e);
        }

        // 3. Search by name
        String searchName = "Charlie";
        System.out.println("\nRecherche de l'étudiant nommé '" + searchName + "' :");
        for (Etudiant e : etudiants) {
            if (e.getNom().equalsIgnoreCase(searchName)) {
                System.out.println("Trouvé : " + e);
            }
        }

        // 4. Delete by ID
        int idToDelete = 2;
        etudiants.removeIf(e -> e.getId() == idToDelete);
        System.out.println("\nAprès suppression de l'étudiant avec l'ID " + idToDelete + " :");
        etudiants.forEach(System.out::println);

        // 5. Sort by GPA (Moyenne) ascending
        Collections.sort(etudiants, Comparator.comparingDouble(Etudiant::getMoyenne));
        System.out.println("\nEtudiants triés par moyenne (croissant) :");
        etudiants.forEach(System.out::println);

        // 6. Display the best student
        if (!etudiants.isEmpty()) {
            Etudiant best = Collections.max(etudiants, Comparator.comparingDouble(Etudiant::getMoyenne));
            System.out.println("\nLe meilleur étudiant est : " + best);
        }
    }
}
