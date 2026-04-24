package TP5;

/**
 * Classe représentant un abonnement musique
 */
public class AbonnementMusique extends Abonnement implements Reducible {
    private boolean audioHD;
    private boolean sansPublicites;
    private double reductionTotale;

    /**
     * Constructeur
     * @param nom Nom de l'abonnement
     * @param prixBase Prix de base
     * @param nbProfils Nombre de profils
     * @param audioHD Activation de l'audio HD
     * @param sansPublicites Activation du mode sans publicités
     */
    public AbonnementMusique(String nom, double prixBase, int nbProfils, 
                            boolean audioHD, boolean sansPublicites) {
        super(nom, prixBase, nbProfils);
        this.audioHD = audioHD;
        this.sansPublicites = sansPublicites;
        this.reductionTotale = 0;
    }

    // Getters et Setters
    public boolean isAudioHD() {
        return audioHD;
    }

    public void setAudioHD(boolean audioHD) {
        this.audioHD = audioHD;
    }

    public boolean isSansPublicites() {
        return sansPublicites;
    }

    public void setSansPublicites(boolean sansPublicites) {
        this.sansPublicites = sansPublicites;
    }

    /**
     * Calcule le coût mensuel
     * Coût = prixBase + 5 (si audioHD) + 8 (si sans publicités)
     * @return Le coût mensuel
     */
    @Override
    public double calculerCoutMensuel() {
        double cout = getPrixBase();
        if (audioHD) {
            cout += 5;
        }
        if (sansPublicites) {
            cout += 8;
        }
        return cout - reductionTotale;
    }

    /**
     * Calcule le score de satisfaction pour un abonnement musique
     * Score de base: 75
     * + 8 si audioHD
     * + 12 si sans publicités
     * + 5 si partage familial
     * @return Le score de satisfaction (0-100)
     */
    @Override
    public int calculerScoreSatisfaction() {
        int score = 75;
        if (audioHD) {
            score += 8;
        }
        if (sansPublicites) {
            score += 12;
        }
        if (estPartageFamilial()) {
            score += 5;
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
        System.out.println("Type: Abonnement Musique");
        System.out.println("Audio HD: " + (audioHD ? "Activé" : "Désactivé"));
        System.out.println("Sans publicités: " + (sansPublicites ? "Oui" : "Non"));
        System.out.println("Coût mensuel: " + calculerCoutMensuel() + " DH");
        System.out.println("Score de satisfaction: " + calculerScoreSatisfaction() + "/100");
        System.out.println("Réduction appliquée: " + reductionTotale + " DH");
    }
}
