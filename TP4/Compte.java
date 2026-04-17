/**
 * Classe mère représentant un compte bancaire générique.
 * TP4 - Héritage et Polymorphisme - SmartBank
 */
public class Compte {

    // ── Attributs ──────────────────────────────────────────────────────────────
    protected String numero;
    protected String titulaire;
    protected double solde;

    // ── Constructeur paramétré ─────────────────────────────────────────────────
    public Compte(String numero, String titulaire, double solde) {
        this.numero    = numero;
        this.titulaire = titulaire;
        this.solde     = solde;
    }

    // ── Getters ────────────────────────────────────────────────────────────────
    public String getNumero()    { return numero; }
    public String getTitulaire() { return titulaire; }
    public double getSolde()     { return solde; }

    // ── Setters ────────────────────────────────────────────────────────────────
    public void setNumero(String numero)       { this.numero    = numero; }
    public void setTitulaire(String titulaire) { this.titulaire = titulaire; }
    public void setSolde(double solde)         { this.solde     = solde; }

    // ── Méthodes métier ────────────────────────────────────────────────────────

    /**
     * Ajoute le montant au solde.
     */
    public void deposer(double montant) {
        if (montant <= 0) {
            System.out.println("  [ERREUR] Le montant du dépôt doit être positif.");
            return;
        }
        solde += montant;
        System.out.printf("  Dépôt de %.2f € effectué. Nouveau solde : %.2f €%n", montant, solde);
    }

    /**
     * Retrait simple : autorisé uniquement si le solde est suffisant.
     */
    public void retirer(double montant) {
        if (montant <= 0) {
            System.out.println("  [ERREUR] Le montant du retrait doit être positif.");
            return;
        }
        if (montant > solde) {
            System.out.printf("  [REFUS] Solde insuffisant (solde=%.2f €, demande=%.2f €).%n", solde, montant);
        } else {
            solde -= montant;
            System.out.printf("  Retrait de %.2f € effectué. Nouveau solde : %.2f €%n", montant, solde);
        }
    }

    /**
     * Affiche les informations du compte.
     */
    public void afficher() {
        System.out.printf("  Numéro    : %s%n", numero);
        System.out.printf("  Titulaire : %s%n", titulaire);
        System.out.printf("  Solde     : %.2f €%n", solde);
    }
}
