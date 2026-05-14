package TP6;

import java.util.Map;
import java.util.TreeMap;

public class ClassementEtudiants {
    public static void main(String[] args) {
        // 1. Use TreeMap<Integer, String> (ID -> Name)
        TreeMap<Integer, String> etudiants = new TreeMap<>();

        etudiants.put(105, "Zineb");
        etudiants.put(99, "Youssef");
        etudiants.put(150, "Salma");
        etudiants.put(42, "Imane");
        etudiants.put(110, "Hamza");

        // 2. Display the automatically sorted list (by ID)
        System.out.println("Liste des étudiants triée par ID :");
        etudiants.forEach((id, nom) -> System.out.println("ID: " + id + ", Nom: " + nom));

        // 3. Show first and last entries
        System.out.println("\nPremier étudiant (ID le plus bas) : " + etudiants.firstEntry());
        System.out.println("Dernier étudiant (ID le plus haut) : " + etudiants.lastEntry());

        // 4. Extract students with ID > 100
        System.out.println("\nÉtudiants avec ID > 100 :");
        Map<Integer, String> higherIds = etudiants.tailMap(101); // Keys strictly greater than 100
        higherIds.forEach((id, nom) -> System.out.println("ID: " + id + ", Nom: " + nom));
    }
}
