package TP6;

import java.util.TreeMap;

public class ClassementDesEtoiles {
    public static void main(String[] args) {
        TreeMap<Integer, String> petitesEtoilesTriees = new TreeMap<>();

        System.out.println("Initialisation du classement...");
        petitesEtoilesTriees.put(150, "Salma");
        petitesEtoilesTriees.put(42, "Imane");
        petitesEtoilesTriees.put(110, "Hamza");

        System.out.println("\nListe triée par ID :");
        petitesEtoilesTriees.forEach((id, nom) -> System.out.println("  ID " + id + " : " + nom));

        System.out.println("\nLa première entrée est : " + petitesEtoilesTriees.firstEntry().getValue());
    }
}
