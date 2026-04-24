package TP5;

/**
 * Classe abstraite représentant un abonnement de base
 */
public abstract class Abonnement {
    private String nom;
    private double prixBase;
    private int nbProfils;

    /**
     * Constructeur paramétré
     * @param nom Nom de l'abonnement
     * @param prixBase Prix de base (doit être > 0, sinon 9.99 par défaut)
     * @param nbProfils Nombre de profils (doit être > 0, sinon 1 par défaut)
     */
    public Abonnement(String nom, double prixBase, int nbProfils) {
        this.nom = nom;
        this.prixBase = prixBase <= 0 ? 9.99 : prixBase;
        this.nbProfils = nbProfils <= 0 ? 1 : nbProfils;
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrixBase() {
        return prixBase;
    }

    public void setPrixBase(double prixBase) {
        this.prixBase = prixBase <= 0 ? 9.99 : prixBase;
    }

    public int getNbProfils() {
        return nbProfils;
    }

    public void setNbProfils(int nbProfils) {
        this.nbProfils = nbProfils <= 0 ? 1 : nbProfils;
    }

    /**
     * Vérifie si l'abonnement est un partage familial
     * @return true si le nombre de profils >= 3, false sinon
     */
    public boolean estPartageFamilial() {
        return nbProfils >= 3;
    }

    /**
     * Affiche les informations de l'abonnement
     */
    public void afficherInfos() {
        System.out.println("========== Informations Abonnement ==========");
        System.out.println("Nom: " + nom);
        System.out.println("Prix de base: " + prixBase + " DH");
        System.out.println("Nombre de profils: " + nbProfils);
        System.out.println("Partage familial: " + (estPartageFamilial() ? "Oui" : "Non"));
        System.out.println("===========================================");
    }

    /**
     * Calcule le coût mensuel de l'abonnement (méthode abstraite)
     * @return Le coût mensuel
     */
    public abstract double calculerCoutMensuel();

    /**
     * Calcule le score de satisfaction (méthode abstraite)
     * @return Le score de satisfaction (0-100)
     */
    public abstract int calculerScoreSatisfaction();
}
