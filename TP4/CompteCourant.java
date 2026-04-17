/**
 * Classe dérivée : CompteCourant
 * Hérite de Compte et ajoute la gestion d'un découvert autorisé.
 */
public class CompteCourant extends Compte {

    // ── Attribut spécifique ────────────────────────────────────────────────────
    private double decouvertAutorise;

    // ── Constructeur ──────────────────────────────────────────────────────────
    public CompteCourant(String numero, String titulaire, double solde, double decouvertAutorise) {
        super(numero, titulaire, solde);
        this.decouvertAutorise = decouvertAutorise;
    }

    // ── Getter / Setter ────────────────────────────────────────────────────────
    public double getDecouvertAutorise()              { return decouvertAutorise; }
    public void   setDecouvertAutorise(double dec)    { this.decouvertAutorise = dec; }

    // ── Redéfinition de retirer() ──────────────────────────────────────────────
    /**
     * Autorise le solde à devenir négatif dans la limite du découvert autorisé.
     */
    @Override
    public void retirer(double montant) {
        if (montant <= 0) {
            System.out.println("  [ERREUR] Le montant du retrait doit être positif.");
            return;
        }
        if (montant > solde + decouvertAutorise) {
            System.out.printf(
                "  [REFUS] Dépasse le découvert autorisé (solde=%.2f €, découvert=%.2f €, demande=%.2f €).%n",
                solde, decouvertAutorise, montant
            );
        } else {
            solde -= montant;
            System.out.printf("  Retrait de %.2f € effectué. Nouveau solde : %.2f €%n", montant, solde);
        }
    }

    // ── Redéfinition de afficher() ─────────────────────────────────────────────
    @Override
    public void afficher() {
        System.out.println("  [Compte Courant]");
        super.afficher();
        System.out.printf("  Découvert autorisé : %.2f €%n", decouvertAutorise);
    }
}
