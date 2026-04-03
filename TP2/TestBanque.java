public class TestBanque {
    public static void main(String[] args) {
        Banque banque = new Banque("MarocBank", 1500);
        
        CompteBancaire c1 = new CompteBancaire("Ahmed Benali", 5000, 1000);
        CompteBancaire c2 = new CompteBancaire("Fatima Alami", 3000, 500);
        CompteBancaire c3 = new CompteBancaire("Mohamed Hassan", 2000, 800);
        
        banque.ajouterCompte(c1);
        banque.ajouterCompte(c2);
        banque.ajouterCompte(c3);
        
        c1.deposer(1000);
        c1.retirer(2000);
        
        c2.virementVers(c3, 1500);
        
        banque.afficherTous();
        
        c2.calculerSoldeAvecInterets();
        c2.calculerSoldeAvecInterets(0.015);
        
        System.out.println("Total comptes : " + CompteBancaire.getNbComptes());
        System.out.println("Taux d'intérêt : " + (CompteBancaire.getTauxInteretAnnuel() * 100) + "%");
    }
}
