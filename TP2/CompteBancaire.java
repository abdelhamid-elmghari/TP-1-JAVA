public class CompteBancaire {
    private int numero;
    private String titulaire;
    private double solde;
    private double decouvertAutorise;
    
    private static int nbComptes = 0;
    private static double tauxInteretAnnuel = 0.03;
    private static int compteur = 1000;
    
    public CompteBancaire() {
        this.numero = ++compteur;
        this.titulaire = "Client";
        this.solde = 0;
        this.decouvertAutorise = 0;
        nbComptes++;
    }
    
    public CompteBancaire(String titulaire, double solde, double decouvertAutorise) {
        this.numero = ++compteur;
        this.titulaire = titulaire;
        this.solde = solde;
        this.decouvertAutorise = decouvertAutorise;
        nbComptes++;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public String getTitulaire() {
        return titulaire;
    }
    
    public double getSolde() {
        return solde;
    }
    
    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }
    
    public static int getNbComptes() {
        return nbComptes;
    }
    
    public static double getTauxInteretAnnuel() {
        return tauxInteretAnnuel;
    }
    
    public void setTitulaire(String titulaire) {
        if (titulaire != null && !titulaire.isEmpty()) {
            this.titulaire = titulaire;
        } else {
            System.out.println("Erreur : le titulaire ne peut pas être vide.");
        }
    }
    
    public void setDecouvertAutorise(double decouvertAutorise) {
        if (decouvertAutorise >= 0) {
            this.decouvertAutorise = decouvertAutorise;
        } else {
            System.out.println("Erreur : le découvert autorisé ne peut pas être négatif.");
        }
    }
    
    public static void setTauxInteretAnnuel(double taux) {
        if (taux >= 0) {
            tauxInteretAnnuel = taux;
        } else {
            System.out.println("Erreur : le taux d'intérêt ne peut pas être négatif.");
        }
    }
    
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Dépôt réussi : " + montant + " MAD. Nouveau solde : " + solde + " MAD.");
        } else {
            System.out.println("Montant de dépôt invalide.");
        }
    }
    
    public void retirer(double montant) {
        if (montant <= 0) {
            System.out.println("Retrait refusé.");
            return;
        }
        
        if (montant <= solde + decouvertAutorise) {
            solde -= montant;
            System.out.println("Retrait réussi : " + montant + " MAD. Nouveau solde : " + solde + " MAD.");
        } else {
            System.out.println("Retrait refusé.");
        }
    }
    
    public void virementVers(CompteBancaire autre, double montant) {
        if (montant <= 0) {
            System.out.println("Virement impossible : montant ou solde insuffisant.");
            return;
        }
        
        if (montant > solde + decouvertAutorise) {
            System.out.println("Virement impossible : montant ou solde insuffisant.");
            return;
        }
        
        this.solde -= montant;
        autre.solde += montant;
        System.out.println("Virement de " + montant + " MAD du compte " + this.numero + 
                         " vers le compte " + autre.numero + " réussi.");
    }
    
    public double calculerSoldeAvecInterets() {
        double interets = solde * tauxInteretAnnuel;
        solde += interets;
        System.out.println("Intérêts calculés (" + tauxInteretAnnuel * 100 + "%) : " + interets + 
                         " MAD. Nouveau solde : " + solde + " MAD.");
        return solde;
    }
    
    public double calculerSoldeAvecInterets(double bonus) {
        double tauxTotal = tauxInteretAnnuel + bonus;
        double interets = solde * tauxTotal;
        solde += interets;
        System.out.println("Intérêts calculés (" + (tauxInteretAnnuel + bonus) * 100 + 
                         "%) : " + interets + " MAD. Nouveau solde : " + solde + " MAD.");
        return solde;
    }
    
    public void afficher() {
        System.out.println("========== COMPTE BANCAIRE ==========");
        System.out.println("Numéro du compte : " + numero);
        System.out.println("Titulaire : " + titulaire);
        System.out.println("Solde : " + solde + " MAD");
        System.out.println("Découvert autorisé : " + decouvertAutorise + " MAD");
        System.out.println("=====================================");
    }
}
