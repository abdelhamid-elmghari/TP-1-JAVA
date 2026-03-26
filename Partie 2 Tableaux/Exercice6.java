import java.util.Scanner;

public class Exercice6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tableau = new int[10];
        System.out.println("Entrez 10 entiers:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Élément " + (i + 1) + ": ");
            tableau[i] = scanner.nextInt();
        }
        System.out.print("\nEntrez le nombre à rechercher: ");
        int nombre = scanner.nextInt();
        int position = -1;
        for (int i = 0; i < 10; i++) {
            if (tableau[i] == nombre) {
                position = i;
                break;
            }
        }
        if (position != -1) {
            System.out.println("Le nombre " + nombre + " se trouve à la position: " + position);
        } else {
            System.out.println("Le nombre " + nombre + " n'a pas été trouvé dans le tableau.");
        }
        scanner.close();
    }
}
