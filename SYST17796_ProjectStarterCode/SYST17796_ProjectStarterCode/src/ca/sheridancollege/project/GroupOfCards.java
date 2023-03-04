/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Harpreet Harpreet 3 March, 2023
 */
public class GroupOfCards {
    private ArrayList<Player> players;
    private Card topCard;
    private ArrayList<Card> deck;
    private String currentColor;
    private int currentPlayerIndex;
    private int direction;

    public UnoGame(ArrayList<Player> players, Card topCard, ArrayList<Card> deck) {
        this.players = players;
        this.topCard = topCard;
        this.deck = deck;
        this.currentColor = topCard.getColor();
        this.currentPlayerIndex = 0;
        this.direction = 1;
    }

    public void playGame() {
        System.out.println("Starting UNO game!");
        while (true) {
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println("\n" + currentPlayer.getName() + "'s turn:");

            // Check if the current player has a valid card to play
            if (currentPlayer.hasCardInHand(currentColor, topCard.getValue())) {
                int cardIndex = currentPlayer.chooseCardIndexToPlay(currentColor, topCard.getValue());
                Card playedCard = currentPlayer.playCard(cardIndex);
                topCard = playedCard;
                currentColor = playedCard.getColor();
                System.out.println(currentPlayer.getName() + " played " + playedCard);
            } else {
                System.out.println(currentPlayer.getName() + " does not have a valid card to play and draws a card.");
                currentPlayer.drawCard(deck.remove(0));
            }

            // Check if the current player has won
            if (currentPlayer.getHand().isEmpty()) {
                System.out.println("\n" + currentPlayer.getName() + " has won the game!");
                break;
            }

            // Check for special cards
            switch (topCard.getValue()) {
                case "Skip":
                    System.out.println(currentPlayer.getName() + " has skipped the next player.");
                    currentPlayerIndex = getNextPlayerIndex(2);
                    break;
                case "Reverse":
                    System.out.println("The direction of play has been reversed.");
                    direction *= -1;
                    currentPlayerIndex = getNextPlayerIndex(1);
                    break;
                case "Draw Two":
                    System.out.println(currentPlayer.getName() + " has drawn two cards and skipped the next player.");
                    currentPlayer.drawCard(deck.remove(0));
                    currentPlayer.drawCard(deck.remove(0));
                    currentPlayerIndex = getNextPlayerIndex(2);
                    break;
                case "Draw Four":
                    System.out.println(currentPlayer.getName() + " has played a wild draw four card.");
                    System.out.print("Choose a color to play: ");
                    Scanner scanner = new Scanner(System.in);
                    String color = scanner.nextLine();
                    currentColor = color;
                    currentPlayer.drawCard(deck.remove(0));
                    currentPlayer.drawCard(deck.remove(0));
                    currentPlayer.drawCard(deck.remove(0));
                    currentPlayer.drawCard(deck.remove(0));
                    currentPlayerIndex = getNextPlayerIndex(2);
                    break;
                case "Wild Card":
                    System.out.println(currentPlayer.getName() + " has played a wild card.");
                    System.out.print("Choose a color to play: ");
                    Scanner scanner2 = new Scanner(System.in);
                    String color2 = scanner2.nextLine();
                    currentColor = color2;
                    currentPlayerIndex = getNextPlayerIndex(1);
                    break;
                default:
                    currentPlayerIndex = getNextPlayerIndex(1);
                    break;
            }
        }
    }

    private int getNextPlayerIndex(int offset) {
        int nextPlayerIndex = currentPlayerIndex + direction * offset;
        if (nextPlayerIndex < 0) {
            nextPlayerIndex = players.size() - 1;
        } else if (nextPlayerIndex >= players.size()) {
nextPlayerIndex = 0;
}
return nextPlayerIndex;
}
   
   

}//end class
