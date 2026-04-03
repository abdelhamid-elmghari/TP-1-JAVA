import java.util.Scanner;

public class Exercice13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez une chaîne de caractères: ");
        String chaine = scanner.nextLine();
        String chaineInversee = new StringBuilder(chaine).reverse().toString();
        System.out.println("La chaîne inversée est: " + chaineInversee);
        scanner.close();
    }
}
