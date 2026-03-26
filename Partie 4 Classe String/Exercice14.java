import java.util.Scanner;

public class Exercice14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez une chaîne de caractères: ");
        String chaine = scanner.nextLine();
        String chaineTraitee = chaine.toLowerCase().replaceAll(" ", "");
        String chaineInversee = new StringBuilder(chaineTraitee).reverse().toString();
        if (chaineTraitee.equals(chaineInversee)) {
            System.out.println("La chaîne \"" + chaine + "\" est un palindrome.");
        } else {
            System.out.println("La chaîne \"" + chaine + "\" n'est pas un palindrome.");
        }
        scanner.close();
    }
}
