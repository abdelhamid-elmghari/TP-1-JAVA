/**
 * Classe dérivée : ComptePremium
 * Hérite de Compte et ajoute un plafond de retrait par opération.
 */
public class ComptePremium extends Compte {

    // ── Attribut spécifique ────────────────────────────────────────────────────
    private double plafondRetrait;

    // ── Constructeur ──────────────────────────────────────────────────────────
    public ComptePremium(String numero, String titulaire, double solde, double plafondRetrait) {
        super(numero, titulaire, solde);
        this.plafondRetrait = plafondRetrait;
    }

    // ── Getter / Setter ────────────────────────────────────────────────────────
    public double getPlafondRetrait()              { return plafondRetrait; }
    public void   setPlafondRetrait(double plafond){ this.plafondRetrait = plafond; }

    // ── Redéfinition de retirer() ──────────────────────────────────────────────
    /**
     * Refuse le retrait si le montant dépasse le plafond par opération.
     */
    @Override
    public void retirer(double montant) {
        if (montant <= 0) {
            System.out.println("  [ERREUR] Le montant du retrait doit être positif.");
            return;
        }
        if (montant > plafondRetrait) {
            System.out.printf(
                "  [REFUS] Montant dépasse le plafond de retrait autorisé (plafond=%.2f €, demande=%.2f €).%n",
                plafondRetrait, montant
            );
        } else if (montant > solde) {
            System.out.printf(
                "  [REFUS] Solde insuffisant (solde=%.2f €, demande=%.2f €).%n",
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
        System.out.println("  [Compte Premium]");
        super.afficher();
        System.out.printf("  Plafond de retrait : %.2f €%n", plafondRetrait);
    }
}
