public class PlayerLinkedList {
    private PlayerNode head;
    private int size;

    public void addToFront(Player player) {
        PlayerNode newNode = new PlayerNode(player);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public Player removeFirst() {
        if (head == null) {
            return null; // empty list
        }
        Player removed = head.getPlayer();
        head = head.getNext();
        size--;
        return removed;
    }

    public int size() {
        return size;
    }

    public boolean contains(Player player) {
        return indexOf(player) != -1;
    }

    public int indexOf(Player player) {
        PlayerNode current = head;
        int index = 0;
        while (current != null) {
            if (current.getPlayer().equals(player)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1; // not found
    }

    public void printList() {
        PlayerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current.getPlayer() + " -> ");
            current = current.getNext();
        }
        System.out.println("NULL");
    }
}
