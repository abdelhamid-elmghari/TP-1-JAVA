/**
 * Classe dérivée : CompteEpargne
 * Hérite de Compte et ajoute un taux d'intérêt.
 * Le retrait est interdit si le solde est insuffisant.
 */
public class CompteEpargne extends Compte {

    // ── Attribut spécifique ────────────────────────────────────────────────────
    private double tauxInteret; // ex. 0.03 pour 3 %

    // ── Constructeur ──────────────────────────────────────────────────────────
    public CompteEpargne(String numero, String titulaire, double solde, double tauxInteret) {
        super(numero, titulaire, solde);
        this.tauxInteret = tauxInteret;
    }

    // ── Getter / Setter ────────────────────────────────────────────────────────
    public double getTauxInteret()            { return tauxInteret; }
    public void   setTauxInteret(double taux) { this.tauxInteret = taux; }

    // ── Méthode spécifique : calculerInteret() ────────────────────────────────
    /**
     * Calcule et ajoute les intérêts au solde.
     */
    public void calculerInteret() {
        double interet = solde * tauxInteret;
        solde += interet;
        System.out.printf("  Intérêts calculés : %.2f € (taux=%.1f %%). Nouveau solde : %.2f €%n",
                          interet, tauxInteret * 100, solde);
    }

    // ── Redéfinition de retirer() ──────────────────────────────────────────────
    /**
     * Interdit le retrait si le solde est insuffisant (pas de découvert possible).
     */
    @Override
    public void retirer(double montant) {
        if (montant <= 0) {
            System.out.println("  [ERREUR] Le montant du retrait doit être positif.");
            return;
        }
        if (montant > solde) {
            System.out.printf(
                "  [REFUS] Retrait interdit : solde insuffisant (solde=%.2f €, demande=%.2f €).%n",
                solde, montant
            );
        } else {
            solde -= montant;
            System.out.printf("  Retrait de %.2f € effectué. Nouveau solde : %.2f €%n", montant, solde);
        }
    }

    // ── Redéfinition de afficher() ─────────────────────────────────────────────
    @Override
    public void afficher() {
        System.out.println("  [Compte Épargne]");
        super.afficher();
        System.out.printf("  Taux d'intérêt : %.1f %%%n", tauxInteret * 100);
    }
}
