import java.util.Scanner;

public class Exercice3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez un nombre pour afficher sa table de multiplication: ");
        int nombre = scanner.nextInt();
        System.out.println("\nTable de multiplication de " + nombre + ":");
        System.out.println("================================");
        for (int i = 1; i <= 10; i++) {
            int resultat = nombre * i;
            System.out.println(nombre + " x " + i + " = " + resultat);
        }
        scanner.close();
    }
}
