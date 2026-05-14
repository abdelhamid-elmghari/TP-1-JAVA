package TP6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SystemeBibliotheque {
    // Utiliser un rayonLivres (ArrayList) pour stocker tous les ouvrages
    private ArrayList<Livre> rayonLivres = new ArrayList<>();
    
    // Gérer les thématiques sans répétition dans un setCategories (HashSet)
    private HashSet<String> setCategories = new HashSet<>();
    
    // Créer une carteEmprunts (HashMap) pour savoir quel humain a emprunté quel livre
    private HashMap<String, String> carteEmprunts = new HashMap<>(); // Nom Humain -> Titre du Livre

    public void ajouterLivre(Livre l) {
        rayonLivres.add(l);
    }

    public void ajouterCategorie(String cat) {
        setCategories.add(cat);
    }

    public void enregistrerEmprunt(String humain, String titreLivre) {
        carteEmprunts.put(humain, titreLivre);
    }

    // Rechercher un livre pour un lecteur pressé
    public void rechercherLivrePresse(String titre) {
        System.out.println("\n--- Recherche rapide pour un lecteur pressé ---");
        boolean trouve = false;
        for (Livre l : rayonLivres) {
            if (l.getTitre().equalsIgnoreCase(titre)) {
                System.out.println("Livre trouvé : " + l);
                trouve = true;
                break; // On s'arrête dès qu'on trouve pour le lecteur pressé
            }
        }
        if (!trouve) System.out.println("Désolé, le livre '" + titre + "' n'est pas en rayon.");
    }

    // Retirer un livre abîmé ou perdu de la collection
    public void retirerLivrePerdu(String isbn) {
        boolean retire = rayonLivres.removeIf(l -> l.getIsbn().equals(isbn));
        if (retire) {
            System.out.println("\nLe livre avec l'ISBN " + isbn + " (abîmé ou perdu) a été retiré des rayons.");
        }
    }

    // Afficher fièrement tous les livres disponibles dans les rayons
    public void afficherLivresDisponibles() {
        System.out.println("\n--- Livres fièrement exposés dans nos rayons ---");
        if (rayonLivres.isEmpty()) {
            System.out.println("Les rayons sont vides...");
        } else {
            rayonLivres.forEach(System.out::println);
        }
    }

    // Générer un rapport final pour faire le point sur la vie de la bibliothèque
    public void genererRapportFinal() {
        System.out.println("\n========================================");
        System.out.println("      RAPPORT FINAL DE LA BIBLIOTHÈQUE");
        System.out.println("========================================");
        System.out.println("Nombre total d'ouvrages : " + rayonLivres.size());
        System.out.println("Thématiques proposées   : " + setCategories);
        System.out.println("\nÉtat des emprunts (Humain -> Livre) :");
        if (carteEmprunts.isEmpty()) {
            System.out.println("Aucun emprunt en cours.");
        } else {
            carteEmprunts.forEach((humain, livre) -> 
                System.out.println("- " + humain + " a emprunté : " + livre));
        }
        System.out.println("========================================\n");
    }

    public static void main(String[] args) {
        SystemeBibliotheque maBiblio = new SystemeBibliotheque();

        // Initialisation
        maBiblio.ajouterLivre(new Livre("978-01", "Le Petit Prince", "Saint-Exupéry", 1943));
        maBiblio.ajouterLivre(new Livre("978-02", "L'Étranger", "Albert Camus", 1942));
        maBiblio.ajouterLivre(new Livre("978-03", "1984", "George Orwell", 1949));
        
        maBiblio.ajouterCategorie("Littérature");
        maBiblio.ajouterCategorie("Science-Fiction");
        maBiblio.ajouterCategorie("Philosophie");

        // Actions
        maBiblio.afficherLivresDisponibles();
        
        maBiblio.enregistrerEmprunt("Jean Dupont", "Le Petit Prince");
        maBiblio.rechercherLivrePresse("1984");
        
        maBiblio.retirerLivrePerdu("978-02"); // L'Étranger est perdu
        
        maBiblio.genererRapportFinal();
    }
}
