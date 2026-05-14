package TP6;

import java.util.LinkedList;

public class FileAttenteChaleureuse {
    public static void main(String[] args) {
        LinkedList<Client> fileAttenteSouriante = new LinkedList<>();

        System.out.println("Bonjour ! Bienvenue dans votre banque préférée !");
        fileAttenteSouriante.add(new Client(1, "Aymane"));
        fileAttenteSouriante.add(new Client(2, "Sami"));
        fileAttenteSouriante.add(new Client(3, "Meryem"));

        System.out.println("\nActuellement dans la file :");
        fileAttenteSouriante.forEach(c -> System.out.println("  - " + c.getNom() + " (Ticket #" + c.getNumero() + ")"));

        Client clientServi = fileAttenteSouriante.poll();
        System.out.println("\nC'est au tour de " + clientServi.getNom() + " ! On s'occupe de vous...");

        fileAttenteSouriante.addLast(new Client(4, "Yassine"));
        System.out.println("Bienvenue à Yassine qui vient de nous rejoindre.");

        Client prochain = fileAttenteSouriante.peek();
        System.out.println("\nLe prochain petit client à servir sera : " + prochain.getNom());
    }
}
