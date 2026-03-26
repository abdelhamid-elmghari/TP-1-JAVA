import java.util.Scanner;

public class Exercice7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez la taille N du tableau: ");
        int n = scanner.nextInt();
        if (n < 1) {
            System.out.println("La taille doit être positive!");
            scanner.close();
            return;
        }
        int[] tableau = new int[n];
        System.out.println("\nEntrez " + n + " entiers:");
        for (int i = 0; i < n; i++) {
            System.out.print("Élément " + (i + 1) + ": ");
            tableau[i] = scanner.nextInt();
        }
        int max = tableau[0];
        for (int i = 1; i < n; i++) {
            if (tableau[i] > max) {
                max = tableau[i];
            }
        }
        System.out.println("\nLe plus grand élément du tableau est: " + max);
        scanner.close();
    }
}
