import java.util.Scanner;

public class Exercice10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nombre de lignes: ");
        int lignes = scanner.nextInt();
        System.out.print("Entrez le nombre de colonnes: ");
        int colonnes = scanner.nextInt();
        int[][] matrice = new int[lignes][colonnes];
        System.out.println("\nEntrez les éléments de la matrice:");
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                System.out.print("Élément [" + i + "][" + j + "]: ");
                matrice[i][j] = scanner.nextInt();
            }
        }
        int[][] transposee = new int[colonnes][lignes];
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                transposee[j][i] = matrice[i][j];
            }
        }
        System.out.println("\nMatrice originale:");
        afficherMatrice(matrice, lignes, colonnes);
        System.out.println("\nMatrice transposée:");
        afficherMatrice(transposee, colonnes, lignes);
        scanner.close();
    }
    static void afficherMatrice(int[][] matrice, int lignes, int colonnes) {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                System.out.print(matrice[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
