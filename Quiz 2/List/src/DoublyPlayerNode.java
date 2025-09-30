public class DoublyPlayerNode {
    private Player player;
    private DoublyPlayerNode next;
    private DoublyPlayerNode previous;

    public DoublyPlayerNode(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public DoublyPlayerNode getNext() {
        return next;
    }

    public DoublyPlayerNode getPrevious() {
        return previous;
    }

    public void setNext(DoublyPlayerNode next) {
        this.next = next;
    }

    public void setPrevious(DoublyPlayerNode previous) {
        this.previous = previous;
    }
}
