/**
 * Classe de test : TestBanque
 * 
 * Démontre :
 *  - Tableau polymorphe (Compte[])
 *  - Appels polymorphes de deposer(), retirer(), afficher()
 *  - Filtrage par type avec instanceof
 *  - Downcasting et ClassCastException
 */
public class TestBanque {

    // ════════════════════════════════════════════════════════════════════════════
    public static void main(String[] args) {

        // ── 5. Tableau polymorphe ────────────────────────────────────────────
        Compte[] comptes = new Compte[4];

        comptes[0] = new CompteCourant ("CC-001", "Alice Martin",   1500.0, 500.0);
        comptes[1] = new CompteEpargne ("CE-002", "Bob Dupont",     3000.0, 0.03);
        comptes[2] = new ComptePremium ("CP-003", "Claire Bernard", 8000.0, 2000.0);
        comptes[3] = new CompteCourant ("CC-004", "David Leroy",     200.0, 300.0);

        // ── Parcours polymorphe ───────────────────────────────────────────────
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║         OPÉRATIONS SUR TOUS LES COMPTES     ║");
        System.out.println("╚══════════════════════════════════════════════╝");

        for (Compte c : comptes) {
            System.out.println("\n──────────────────────────────────────────────");
            c.afficher();

            System.out.println("  → Dépôt de 500 €");
            c.deposer(500.0);

            System.out.println("  → Retrait de 300 €");
            c.retirer(300.0);

            System.out.println("  → Retrait de 5000 € (test limite)");
            c.retirer(5000.0);

            System.out.println("  --- État final ---");
            c.afficher();
        }

        // ── 6. Filtrage par type : instanceof ─────────────────────────────────
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║         COMPTES ÉPARGNE SEULEMENT           ║");
        System.out.println("╚══════════════════════════════════════════════╝");

        for (Compte c : comptes) {
            if (c instanceof CompteEpargne) {
                System.out.println("\n  Compte épargne trouvé :");
                c.afficher();

                // Downcasting sûr (après vérification instanceof)
                CompteEpargne ce = (CompteEpargne) c;
                System.out.println("  → Calcul des intérêts :");
                ce.calculerInteret();
                System.out.println("  --- Solde après intérêts ---");
                ce.afficher();
            }
        }

        // ── 7. Downcasting incorrect – démonstration de ClassCastException ────
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║         DÉMONSTRATION DU DOWNCASTING        ║");
        System.out.println("╚══════════════════════════════════════════════╝");

        /*
         * ANALYSE DU CODE SUIVANT :
         *
         *   Compte c = new CompteEpargne(...);
         *   CompteCourant cc = (CompteCourant) c;
         *
         * ▸ Ce code compile-t-il ?  OUI – le compilateur voit que les deux types
         *   appartiennent à la même hiérarchie (Compte), donc il l'accepte.
         *
         * ▸ S'exécute-t-il correctement ? NON – à l'exécution, la JVM lève une
         *   java.lang.ClassCastException car l'objet réel est un CompteEpargne,
         *   pas un CompteCourant. Ces deux classes sont sœurs (même parent Compte)
         *   mais elles n'ont aucune relation d'héritage entre elles.
         *
         * ▸ Pourquoi ? Le polymorphisme permet de monter dans la hiérarchie
         *   (upcasting, toujours sûr). Redescendre vers un type incompatible
         *   (downcasting incorrect) provoque une ClassCastException à l'exécution.
         *
         * ▸ Solution correcte : vérifier avec instanceof avant de caster.
         */

        System.out.println("\n  Cas 1 – Downcasting CORRECT (CompteEpargne → CompteEpargne) :");
        Compte ref1 = new CompteEpargne("CE-099", "Test Correct", 1000.0, 0.05);
        if (ref1 instanceof CompteEpargne) {
            CompteEpargne ceOk = (CompteEpargne) ref1; // sûr !
            System.out.println("  Cast réussi !");
            ceOk.afficher();
        }

        System.out.println("\n  Cas 2 – Downcasting INCORRECT (CompteEpargne → CompteCourant) :");
        Compte ref2 = new CompteEpargne("CE-100", "Test Incorrect", 1000.0, 0.05);
        try {
            CompteCourant cc = (CompteCourant) ref2; // ClassCastException !
            cc.afficher();
        } catch (ClassCastException e) {
            System.out.println("  [EXCEPTION ATTRAPÉE] " + e.getMessage());
            System.out.println("  → Conclusion : impossible de caster un CompteEpargne en CompteCourant");
            System.out.println("    car ce sont deux sous-classes différentes de Compte (classes sœurs).");
        }

        System.out.println("\n[FIN DU TEST BANQUE]");
    }
}
