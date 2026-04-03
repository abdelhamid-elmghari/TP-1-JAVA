public class Banque {
    private String nom;
    private CompteBancaire[] comptes;
    private int nbActuels;
    
    public Banque(String nom, int capacite) {
        this.nom = nom;
        this.comptes = new CompteBancaire[capacite];
        this.nbActuels = 0;
    }
    
    public String getNom() {
        return nom;
    }
    
    public int getNbActuels() {
        return nbActuels;
    }
    
    public int getCapacite() {
        return comptes.length;
    }
    
    public void ajouterCompte(CompteBancaire c) {
        if (nbActuels < comptes.length) {
            comptes[nbActuels] = c;
            nbActuels++;
            System.out.println("Compte " + c.getNumero() + " ajouté avec succès à " + nom + ".");
        } else {
            System.out.println("Erreur : la banque a atteint sa capacité maximale.");
        }
    }
    
    public void afficherTous() {
        System.out.println("\n========== BANQUE : " + nom + " ==========");
        System.out.println("Nombre de comptes : " + nbActuels);
        System.out.println("============================================\n");
        
        if (nbActuels == 0) {
            System.out.println("Aucun compte dans la banque.");
            return;
        }
        
        for (int i = 0; i < nbActuels; i++) {
            comptes[i].afficher();
        }
        
        System.out.println("\n============================================\n");
    }
}
