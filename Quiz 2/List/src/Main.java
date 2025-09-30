import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player(1, "Saitama", 999));
        playerList.add(new Player(2, "Goku", 500));
        playerList.add(new Player(1, "Deku", 100));

        // initial contents of the list
        System.out.println("Initial contents of list");
        for (Player player : playerList){
            System.out.println(player);
        }

        System.out.println("\nAfter adding a player at index 2");
        for (Player player : playerList){
            System.out.println(player);
        }

        System.out.println("\nPlayer at index 2 " + playerList.get(2));

        // remove a player at index 1
        System.out.println("\nAfter removing a player at index 1");
        playerList.remove(1);
        for (Player player : playerList){
            System.out.println(player);
        }

        //check if player object is in list
        boolean contains = playerList.contains(new Player(1, "Saitama", 999));
        System.out.println("\nList has Saitama?: " + contains);

        //List Demo
        System.out.println("\n=== PlayerLinkedList Demo ===");

        PlayerLinkedList linkedList = new PlayerLinkedList();
        linkedList.addToFront(new Player(1, "Saitama", 999));
        linkedList.addToFront(new Player(2, "Goku", 500));
        linkedList.addToFront(new Player(3, "Deku", 100));

        linkedList.printList();   // should print 3 nodes
        System.out.println("\nSize: " + linkedList.size()); // Q2

        System.out.println("\nRemoved first: " + linkedList.removeFirst()); // Q1
        linkedList.printList();
        System.out.println("\nSize after remove: " + linkedList.size()); // Q2 again

        System.out.println("\nList contains Goku? " +
                linkedList.contains(new Player(2, "Goku", 500))); // Q3
        System.out.println("Index of Saitama: " +
                linkedList.indexOf(new Player(1, "Saitama", 999))); // Q3
    }
}
