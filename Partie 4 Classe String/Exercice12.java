import java.util.Scanner;

public class Exercice12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez une chaîne de caractères: ");
        String chaine = scanner.nextLine();
        int nombreVoyelles = 0;
        String voyelles = "aeiouAEIOU";
        for (int i = 0; i < chaine.length(); i++) {
            char caractere = chaine.charAt(i);
            if (voyelles.indexOf(caractere) != -1) {
                nombreVoyelles++;
            }
        }
        System.out.println("Nombre de voyelles: " + nombreVoyelles);
        scanner.close();
    }
}
