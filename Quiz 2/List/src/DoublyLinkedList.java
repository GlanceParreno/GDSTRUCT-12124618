public class DoublyLinkedList {
    private DoublyPlayerNode head;
    private DoublyPlayerNode tail;
    private int size;

    public void addToFront(Player player) {
        DoublyPlayerNode newNode = new DoublyPlayerNode(player);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        size++;
    }

    public void addToEnd(Player player) {
        DoublyPlayerNode newNode = new DoublyPlayerNode(player);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        size++;
    }

    public Player removeFirst() {
        if (head == null) return null;
        Player removed = head.getPlayer();
        head = head.getNext();
        if (head != null) {
            head.setPrevious(null);
        } else {
            tail = null; // list became empty
        }
        size--;
        return removed;
    }

    public Player removeLast() {
        if (tail == null) return null;
        Player removed = tail.getPlayer();
        tail = tail.getPrevious();
        if (tail != null) {
            tail.setNext(null);
        } else {
            head = null; // list became empty
        }
        size--;
        return removed;
    }

    public int size() {
        return size;
    }

    public void printList() {
        DoublyPlayerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current.getPlayer() + " <-> ");
            current = current.getNext();
        }
        System.out.println("NULL");
    }
}
