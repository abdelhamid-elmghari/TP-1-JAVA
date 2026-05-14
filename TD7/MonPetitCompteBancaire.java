package TD7;

class SoldeInsuffisantException extends Exception {
    public SoldeInsuffisantException(String message) {
        super(message);
    }
}

public class MonPetitCompteBancaire {
    private double solde;

    public MonPetitCompteBancaire(double soldeInitial) {
        this.solde = soldeInitial;
    }

    public void achatPlaisir(double montant) throws SoldeInsuffisantException {
        System.out.println("Tentative d'achat de " + montant + " euros...");
        if (montant > solde) {
            throw new SoldeInsuffisantException("Oh non ! Il manque " + (montant - solde) + " euros pour ce plaisir...");
        }
        solde -= montant;
        System.out.println("Achat réussi ! Il vous reste " + solde + " euros de bonheur.");
    }

    public static void main(String[] args) {
        MonPetitCompteBancaire monCompte = new MonPetitCompteBancaire(100.0);
        System.out.println("Solde actuel : 100.0 euros");

        try {
            monCompte.achatPlaisir(40.0);
        } catch (SoldeInsuffisantException e) {
            System.out.println("Attention : " + e.getMessage());
        }

        try {
            monCompte.achatPlaisir(150.0);
        } catch (SoldeInsuffisantException e) {
            System.out.println("Attention : " + e.getMessage());
            System.out.println("Conseil : Epargnons un peu plus pour la prochaine fois !");
        }
    }
}
