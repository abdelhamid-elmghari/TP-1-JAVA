import java.util.Scanner;

public class Exercice8 {
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
        System.out.println("\nLa matrice est:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrice[i][j] + "\t");
            }
            System.out.println();
        }
        scanner.close();
    }
}
