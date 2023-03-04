/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Abhay Abhay
 * @author Paul Bonenfant Jan 2020
 */
import java.util.ArrayList;
import java.util.Scanner;



public class Player {
    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void drawCard(Card card) {
        hand.add(card);
    }

    public Card playCard(int index) {
        return hand.remove(index);
    }

    public boolean hasCardInHand(String color, String value) {
        for (Card card : hand) {
            if (card.getColor().equals(color) && card.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public int chooseCardIndexToPlay(String color, String value) {
        Scanner scanner = new Scanner(System.in);
        int index;
        do {
            System.out.print(name + ", choose a card index to play (or enter -1 to draw a card): ");
            index = scanner.nextInt();
        } while (index != -1 && (index < 0 || index >= hand.size() || !isValidCard(index, color, value)));
        return index;
    }

    private boolean isValidCard(int index, String color, String value) {
        Card card = hand.get(index);
        return card.getColor().equals(color) || card.getValue().equals(value);
    }
}
