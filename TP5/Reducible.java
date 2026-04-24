package TP5;

/**
 * Interface pour les abonnements qui peuvent être réduits
 */
public interface Reducible {
    /**
     * Applique une réduction en pourcentage
     * @param pourcentage Le pourcentage de réduction (0-100)
     * @return Le prix avec réduction appliquée
     */
    double appliquerReduction(double pourcentage);

    /**
     * Applique une réduction fixe
     * @param montant Le montant fixe à réduire
     * @return Le prix après réduction fixe
     */
    double appliquerReductionFixe(double montant);

    /**
     * Obtient la réduction totale appliquée
     * @return La réduction totale en DH
     */
    double getReductionTotale();
}
