package TP5;

/**
 * Classe représentant un abonnement vidéo
 */
public class AbonnementVideo extends Abonnement implements Reducible {
    private boolean optionHD;
    private boolean option4K;
    private double reductionTotale;

    /**
     * Constructeur
     * @param nom Nom de l'abonnement
     * @param prixBase Prix de base
     * @param nbProfils Nombre de profils
     * @param optionHD Activation de l'option HD
     * @param option4K Activation de l'option 4K
     */
    public AbonnementVideo(String nom, double prixBase, int nbProfils, 
                          boolean optionHD, boolean option4K) {
        super(nom, prixBase, nbProfils);
        this.optionHD = optionHD;
        this.option4K = option4K;
        this.reductionTotale = 0;
    }

    // Getters et Setters
    public boolean isOptionHD() {
        return optionHD;
    }

    public void setOptionHD(boolean optionHD) {
        this.optionHD = optionHD;
    }

    public boolean isOption4K() {
        return option4K;
    }

    public void setOption4K(boolean option4K) {
        this.option4K = option4K;
    }

    /**
     * Calcule le coût mensuel
     * Coût = prixBase + 10 (si HD) + 20 (si 4K)
     * @return Le coût mensuel
     */
    @Override
    public double calculerCoutMensuel() {
        double cout = getPrixBase();
        if (optionHD) {
            cout += 10;
        }
        if (option4K) {
            cout += 20;
        }
        return cout - reductionTotale;
    }

    /**
     * Calcule le score de satisfaction pour un abonnement vidéo
     * Score de base: 70
     * + 10 si HD
     * + 15 si 4K
     * + 5 si partage familial
     * @return Le score de satisfaction (0-100)
     */
    @Override
    public int calculerScoreSatisfaction() {
        int score = 70;
        if (optionHD) {
            score += 10;
        }
        if (option4K) {
            score += 15;
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
        System.out.println("Type: Abonnement Vidéo");
        System.out.println("Option HD: " + (optionHD ? "Activée" : "Désactivée"));
        System.out.println("Option 4K: " + (option4K ? "Activée" : "Désactivée"));
        System.out.println("Coût mensuel: " + calculerCoutMensuel() + " DH");
        System.out.println("Score de satisfaction: " + calculerScoreSatisfaction() + "/100");
        System.out.println("Réduction appliquée: " + reductionTotale + " DH");
    }
}
