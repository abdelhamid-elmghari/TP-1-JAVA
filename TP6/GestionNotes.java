package TP6;

import java.util.HashMap;
import java.util.Map;

public class GestionNotes {
    public static void main(String[] args) {
        // 1. Use HashMap<String, Double>
        HashMap<String, Double> notes = new HashMap<>();

        // 2. Add students and grades
        notes.put("Amine", 16.5);
        notes.put("Sara", 18.0);
        notes.put("Omar", 14.0);
        notes.put("Layla", 15.5);

        // 3. Search for a specific grade
        String searchStudent = "Sara";
        if (notes.containsKey(searchStudent)) {
            System.out.println("Note de " + searchStudent + " : " + notes.get(searchStudent));
        }

        // 4. Modify a grade
        notes.put("Omar", 15.0);
        System.out.println("\nNote de Omar modifiée : " + notes.get("Omar"));

        // 5. Remove a student
        notes.remove("Layla");
        System.out.println("\nLayla a été supprimée. Liste actuelle :");
        notes.forEach((nom, note) -> System.out.println(nom + " : " + note));

        // 6. Calculate class average
        double sum = 0;
        for (double note : notes.values()) {
            sum += note;
        }
        double average = notes.isEmpty() ? 0 : sum / notes.size();
        System.out.println("\nMoyenne de la classe : " + average);
    }
}
