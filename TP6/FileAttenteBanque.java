package TP6;

import java.util.LinkedList;

public class FileAttenteBanque {
    public static void main(String[] args) {
        LinkedList<Client> fileAttente = new LinkedList<>();

        // 1. Add clients to the list
        fileAttente.add(new Client(101, "Aymane"));
        fileAttente.add(new Client(102, "Sami"));
        fileAttente.add(new Client(103, "Yassine"));

        // 2. Display the queue
        System.out.println("File d'attente actuelle :");
        fileAttente.forEach(System.out::println);

        // 3. Serve the first client (remove from head)
        Client servi = fileAttente.poll();
        System.out.println("\nClient servi : " + servi);

        // 4. Add client to the end
        fileAttente.addLast(new Client(104, "Meryem"));
        System.out.println("\nAprès ajout d'un nouveau client à la fin :");
        fileAttente.forEach(System.out::println);

        // 5. Peek at the first client
        Client premier = fileAttente.peek();
        System.out.println("\nProchain client à servir (peek) : " + premier);
    }
}
