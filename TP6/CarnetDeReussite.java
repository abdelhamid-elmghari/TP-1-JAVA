package TP6;

import java.util.HashMap;

public class CarnetDeReussite {
    public static void main(String[] args) {
        HashMap<String, Double> notreCarnetDeNotes = new HashMap<>();

        System.out.println("Ouverture du carnet de réussite...");
        notreCarnetDeNotes.put("Amine", 16.5);
        notreCarnetDeNotes.put("Sara", 18.0);
        notreCarnetDeNotes.put("Omar", 14.0);

        String ami = "Sara";
        System.out.println("\nQuelle est la note de " + ami + " ? C'est " + notreCarnetDeNotes.get(ami) + "/20 ! Bien joué !");

        notreCarnetDeNotes.put("Omar", 15.0);
        System.out.println("Omar a fait des progrès ! Sa nouvelle note est : " + notreCarnetDeNotes.get("Omar"));

        double total = 0;
        for (double note : notreCarnetDeNotes.values()) total += note;
        System.out.println("\nLa moyenne de cette belle classe est de : " + (total / notreCarnetDeNotes.size()));
    }
}
