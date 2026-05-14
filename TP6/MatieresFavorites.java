package TP6;

import java.util.HashSet;
import java.util.TreeSet;

public class MatieresFavorites {
    public static void main(String[] args) {
        HashSet<String> nosMatieresCheries = new HashSet<>();
        
        System.out.println("Préparons notre sac d'école...");
        nosMatieresCheries.add("Java");
        nosMatieresCheries.add("Python");
        nosMatieresCheries.add("SQL");
        
        boolean ajoutDouble = nosMatieresCheries.add("Java");
        if (!ajoutDouble) {
            System.out.println("Oh ! 'Java' est déjà dans le sac, on ne peut pas le doubler !");
        }

        TreeSet<String> rangementAlphabetique = new TreeSet<>(nosMatieresCheries);
        
        System.out.println("\nVoici nos matières bien rangées par ordre alphabétique :");
        for (String m : rangementAlphabetique) {
            System.out.println("  * " + m);
        }
    }
}
