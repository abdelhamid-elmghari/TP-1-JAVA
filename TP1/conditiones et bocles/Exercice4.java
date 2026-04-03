import java.util.Scanner;

public class Exercice4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez un nombre N pour calculer la somme des N premiers entiers: ");
        int n = scanner.nextInt();
        if (n < 1) {
            System.out.println("Veuillez entrer un nombre positif!");
            scanner.close();
            return;
        }
        int somme = 0;
        int i = 1;
        while (i <= n) {
            somme += i;
            i++;
        }
        System.out.println("\nLa somme des " + n + " premiers entiers est: " + somme);
        scanner.close();
    }
}
