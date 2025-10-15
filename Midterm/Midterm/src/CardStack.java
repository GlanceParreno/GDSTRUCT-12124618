import java.util.ArrayList;
import java.util.List;

public class CardStack {
    private List<Card> cards;

    public CardStack() {
        cards = new ArrayList<>();
    }

    public void push(Card card) {
        cards.add(card);
    }

    public Card pop() {
        if (isEmpty()) return null;
        return cards.remove(cards.size() - 1);
    }

    public Card peek() {
        if (isEmpty()) return null;
        return cards.get(cards.size() - 1);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int size() {
        return cards.size();
    }

    public void display() {
        if (cards.isEmpty()) {
            System.out.println("Empty");
            return;
        }
        for (Card c : cards) {
            System.out.print(c + " | ");
        }
        System.out.println();
    }
}
