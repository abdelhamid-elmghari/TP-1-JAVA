package TP5;

/**
 * Classe de test pour les abonnements
 */
public class TestAbonnements {
    public static void main(String[] args) {
        System.out.println("========== TEST DES ABONNEMENTS ==========\n");

        // Test 1: AbonnementVideo
        System.out.println("--- TEST 1: ABONNEMENT VIDEO ---");
        AbonnementVideo video1 = new AbonnementVideo("Netflix Premium", 99, 4, true, true);
        video1.afficherInfos();
        System.out.println();

        // Test 2: AbonnementVideo avec HD actif, 4K désactivé
        System.out.println("--- TEST 2: ABONNEMENT VIDEO SIMPLE ---");
        AbonnementVideo video2 = new AbonnementVideo("Netflix Standard", 69, 2, true, false);
        video2.afficherInfos();
        System.out.println();

        // Test 3: AbonnementMusique
        System.out.println("--- TEST 3: ABONNEMENT MUSIQUE ---");
        AbonnementMusique musique1 = new AbonnementMusique("Spotify Family", 49.99, 5, 
                                                            true, true);
        musique1.afficherInfos();
        System.out.println();

        // Test 4: AbonnementJeux
        System.out.println("--- TEST 4: ABONNEMENT JEUX ---");
        AbonnementJeux jeux1 = new AbonnementJeux("Xbox Game Pass", 84.99, 4, 
                                                  true, true);
        jeux1.afficherInfos();
        System.out.println();

        // Test 5: Réductions - AbonnementVideo
        System.out.println("--- TEST 5: RÉDUCTIONS VIDEO ---");
        System.out.println("Coût avant réduction: " + video1.calculerCoutMensuel() + " DH");
        video1.appliquerReduction(10); // 10% de réduction
        System.out.println("Après réduction 10%: " + video1.calculerCoutMensuel() + " DH");
        video1.appliquerReductionFixe(5); // 5 DH de réduction supplémentaire
        System.out.println("Après réduction fixe de 5 DH: " + video1.calculerCoutMensuel() + " DH");
        System.out.println("Réduction totale: " + video1.getReductionTotale() + " DH\n");

        // Test 6: Réductions - AbonnementMusique
        System.out.println("--- TEST 6: RÉDUCTIONS MUSIQUE ---");
        System.out.println("Coût avant réduction: " + musique1.calculerCoutMensuel() + " DH");
        musique1.appliquerReduction(15); // 15% de réduction
        System.out.println("Après réduction 15%: " + musique1.calculerCoutMensuel() + " DH");
        System.out.println("Réduction totale: " + musique1.getReductionTotale() + " DH\n");

        // Test 7: Partage familial
        System.out.println("--- TEST 7: PARTAGE FAMILIAL ---");
        AbonnementVideo video3 = new AbonnementVideo("Disney+", 49.99, 2, 
                                                    false, false);
        System.out.println("Abonnement avec 2 profils:");
        System.out.println("Partage familial: " + (video3.estPartageFamilial() ? "Oui" : "Non"));
        
        AbonnementVideo video4 = new AbonnementVideo("Disney+", 49.99, 5, 
                                                    false, false);
        System.out.println("\nAbonnement avec 5 profils:");
        System.out.println("Partage familial: " + (video4.estPartageFamilial() ? "Oui" : "Non"));
        System.out.println();

        // Test 8: Abonnement avec prix invalide (devrait utiliser valeur par défaut)
        System.out.println("--- TEST 8: VALEURS PAR DÉFAUT ---");
        AbonnementMusique musique2 = new AbonnementMusique("Apple Music", -10, -5, 
                                                          false, false);
        System.out.println("Prix de base (saisi: -10): " + musique2.getPrixBase() + " DH");
        System.out.println("Nombre de profils (saisi: -5): " + musique2.getNbProfils());
        System.out.println();

        // Test 9: Modification des attributs
        System.out.println("--- TEST 9: MODIFICATION D'ATTRIBUTS ---");
        AbonnementJeux jeux2 = new AbonnementJeux("PlayStation Plus", 49.99, 1, 
                                                  false, false);
        System.out.println("Avant modification:");
        System.out.println("Accès complet: " + (jeux2.isAccesFull() ? "Oui" : "Non"));
        System.out.println("Jeux exclusifs: " + (jeux2.isJeuExclusifs() ? "Oui" : "Non"));
        System.out.println("Coût: " + jeux2.calculerCoutMensuel() + " DH");
        
        jeux2.setAccesFull(true);
        jeux2.setJeuExclusifs(true);
        jeux2.setNbProfils(3);
        
        System.out.println("\nAprès modification:");
        System.out.println("Accès complet: " + (jeux2.isAccesFull() ? "Oui" : "Non"));
        System.out.println("Jeux exclusifs: " + (jeux2.isJeuExclusifs() ? "Oui" : "Non"));
        System.out.println("Nombre de profils: " + jeux2.getNbProfils());
        System.out.println("Partage familial: " + (jeux2.estPartageFamilial() ? "Oui" : "Non"));
        System.out.println("Coût: " + jeux2.calculerCoutMensuel() + " DH");
        System.out.println("Score de satisfaction: " + jeux2.calculerScoreSatisfaction() + "/100");
        System.out.println();

        // Test 10: Résumé comparative
        System.out.println("--- TEST 10: RÉSUMÉ COMPARATIF ---");
        afficherResume(video1);
        afficherResume(musique1);
        afficherResume(jeux1);
    }

    /**
     * Affiche un résumé d'un abonnement
     * @param abonnement L'abonnement à afficher
     */
    private static void afficherResume(Abonnement abonnement) {
        System.out.println("- " + abonnement.getNom() + ": " + 
                          String.format("%.2f", abonnement.calculerCoutMensuel()) + " DH | " + 
                          "Score: " + abonnement.calculerScoreSatisfaction() + "/100");
    }
}
