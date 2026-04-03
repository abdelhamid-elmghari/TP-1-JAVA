import java.util.Scanner;

public class Exercice11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez une chaîne de caractères: ");
        String chaine = scanner.nextLine();
        int longueur = chaine.length();
        System.out.println("La longueur de la chaîne est: " + longueur);
        scanner.close();
    }
}
