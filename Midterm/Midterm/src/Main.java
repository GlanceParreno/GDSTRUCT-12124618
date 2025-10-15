import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CardStack deck = new CardStack();
        CardStack hand = new CardStack();
        CardStack discard = new CardStack();

        // --- Initialize the deck with 30 cards ---
        for (int i = 1; i <= 30; i++) {
            deck.push(new Card("Card " + i));
        }

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("=== CARD GAME START ===");

        while (!deck.isEmpty()) {
            System.out.println("\n--- NEW TURN ---");
            int command = rand.nextInt(3); // 0 = draw, 1 = discard, 2 = get from discard
            int x = rand.nextInt(5) + 1;   // random 1–5

            switch (command) {
                case 0:
                    System.out.println("Command: DRAW " + x + " cards");
                    for (int i = 0; i < x; i++) {
                        if (deck.isEmpty()) break;
                        Card drawn = deck.pop();
                        hand.push(drawn);
                    }
                    break;

                case 1:
                    System.out.println("Command: DISCARD " + x + " cards");
                    for (int i = 0; i < x; i++) {
                        if (hand.isEmpty()) break;
                        Card toDiscard = hand.pop();
                        discard.push(toDiscard);
                    }
                    break;

                case 2:
                    System.out.println("Command: GET " + x + " cards from discard pile");
                    for (int i = 0; i < x; i++) {
                        if (discard.isEmpty()) break;
                        Card retrieved = discard.pop();
                        hand.push(retrieved);
                    }
                    break;
            }

            // --- Show status ---
            System.out.println("\nYour Hand:");
            hand.display();

            System.out.println("Deck: " + deck.size() + " cards remaining");
            System.out.println("Discard Pile: " + discard.size() + " cards");

            System.out.println("\nPress Enter to continue...");
            sc.nextLine();
        }

        System.out.println("\n=== GAME OVER: Deck is empty! ===");
    }
}
