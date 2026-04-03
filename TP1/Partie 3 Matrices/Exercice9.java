import java.util.Scanner;

public class Exercice9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrice = new int[3][3];
        System.out.println("Entrez les éléments d'une matrice 3x3:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Élément [" + i + "][" + j + "]: ");
                matrice[i][j] = scanner.nextInt();
            }
        }
        int somme = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                somme += matrice[i][j];
            }
        }
        System.out.println("\nLa somme de tous les éléments de la matrice est: " + somme);
        scanner.close();
    }
}
