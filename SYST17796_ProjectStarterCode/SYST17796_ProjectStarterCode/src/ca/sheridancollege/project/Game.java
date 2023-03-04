/*
 *SYST 17796 Project.
 
 * the author of this class : Sara AbuLehyeh
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
* @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Sara AbuLehyeh 3 March, 2023
 */

public class Game {
    public static void main(String[] args) {
        ArrayList<Card> deck = new ArrayList<>();

        String[] colors = {"Red", "Yellow", "Green", "Blue"};
        String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Skip", "Reverse", "Draw Two"};

        // Generate the deck
        for (String color : colors) {
            for (String value : values) {
                deck.add(new Card(color, value));
                if (!value.equals("0")) {
                    deck.add(new Card(color, value));
                }
            }
        }

        // Add the wild cards
        for (int i = 0; i < 4; i++) {
            deck.add(new Card("Wild", "Wild Card"));
            deck.add(new Card("Wild", "Draw Four"));
        }

        // Shuffle the deck
        Collections.shuffle(deck);

        // Create the players
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Abdul"));
        players.add(new Player("Sara"));
        players.add(new Player("Harbeet"));
        players.add(new Player("Abhay"));

        // Deal the cards to the players
        for (int i = 0; i < 7; i++) {
            for (Player player : players) {
                Card card = deck.remove(0);
                player.drawCard(card);
            }
        }

        // Initialize the game state
        Card topCard = deck.remove(0);
        UnoGame game = new UnoGame(players, topCard, deck);

        // Start the game
        game.playGame();
    }
}
