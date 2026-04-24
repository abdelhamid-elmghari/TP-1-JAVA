package TP5;

/**
 * Classe représentant un abonnement jeux
 */
public class AbonnementJeux extends Abonnement implements Reducible {
    private boolean accesFull;
    private boolean jeuExclusifs;
    private double reductionTotale;

    /**
     * Constructeur
     * @param nom Nom de l'abonnement
     * @param prixBase Prix de base
     * @param nbProfils Nombre de profils
     * @param accesFull Accès complet à la bibliothèque
     * @param jeuExclusifs Accès aux jeux exclusifs
     */
    public AbonnementJeux(String nom, double prixBase, int nbProfils, 
                         boolean accesFull, boolean jeuExclusifs) {
        super(nom, prixBase, nbProfils);
        this.accesFull = accesFull;
        this.jeuExclusifs = jeuExclusifs;
        this.reductionTotale = 0;
    }

    // Getters et Setters
    public boolean isAccesFull() {
        return accesFull;
    }

    public void setAccesFull(boolean accesFull) {
        this.accesFull = accesFull;
    }

    public boolean isJeuExclusifs() {
        return jeuExclusifs;
    }

    public void setJeuExclusifs(boolean jeuExclusifs) {
        this.jeuExclusifs = jeuExclusifs;
    }

    /**
     * Calcule le coût mensuel
     * Coût = prixBase + 15 (si accès complet) + 12 (si jeux exclusifs)
     * @return Le coût mensuel
     */
    @Override
    public double calculerCoutMensuel() {
        double cout = getPrixBase();
        if (accesFull) {
            cout += 15;
        }
        if (jeuExclusifs) {
            cout += 12;
        }
        return cout - reductionTotale;
    }

    /**
     * Calcule le score de satisfaction pour un abonnement jeux
     * Score de base: 80
     * + 12 si accès complet
     * + 10 si jeux exclusifs
     * + 8 si partage familial
     * @return Le score de satisfaction (0-100)
     */
    @Override
    public int calculerScoreSatisfaction() {
        int score = 80;
        if (accesFull) {
            score += 12;
        }
        if (jeuExclusifs) {
            score += 10;
        }
        if (estPartageFamilial()) {
            score += 8;
        }
        return Math.min(score, 100);
    }

    @Override
    public double appliquerReduction(double pourcentage) {
        double reduction = (calculerCoutMensuel() + reductionTotale) * (pourcentage / 100);
        reductionTotale += reduction;
        return calculerCoutMensuel();
    }

    @Override
    public double appliquerReductionFixe(double montant) {
        reductionTotale += montant;
        if (calculerCoutMensuel() < 0) {
            reductionTotale = getPrixBase();
        }
        return calculerCoutMensuel();
    }

    @Override
    public double getReductionTotale() {
        return reductionTotale;
    }

    @Override
    public void afficherInfos() {
        super.afficherInfos();
        System.out.println("Type: Abonnement Jeux");
        System.out.println("Accès complet: " + (accesFull ? "Oui" : "Non"));
        System.out.println("Jeux exclusifs: " + (jeuExclusifs ? "Oui" : "Non"));
        System.out.println("Coût mensuel: " + calculerCoutMensuel() + " DH");
        System.out.println("Score de satisfaction: " + calculerScoreSatisfaction() + "/100");
        System.out.println("Réduction appliquée: " + reductionTotale + " DH");
    }
}
