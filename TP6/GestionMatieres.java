package TP6;

import java.util.HashSet;
import java.util.TreeSet;

public class GestionMatieres {
    public static void main(String[] args) {
        // 1. Add subjects to HashSet
        HashSet<String> matieres = new HashSet<>();
        matieres.add("Java");
        matieres.add("Python");
        matieres.add("SQL");
        matieres.add("HTML/CSS");
        
        // 2. Verify no duplicates exist
        boolean addedDuplicate = matieres.add("Java");
        System.out.println("Ajout d'un doublon 'Java' réussi ? " + addedDuplicate);

        // 3. Display subjects
        System.out.println("\nMatières dans le HashSet (pas d'ordre garanti) :");
        matieres.forEach(System.out::println);

        // 4. Copy to TreeSet
        TreeSet<String> matieresTriees = new TreeSet<>(matieres);

        // 5. Display subjects sorted alphabetically
        System.out.println("\nMatières dans le TreeSet (triées par ordre alphabétique) :");
        matieresTriees.forEach(System.out::println);
    }
}
