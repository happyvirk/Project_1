/**
 * SYST 17796 Project Base code.
 
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;


public abstract class Game {

    private final String name;//the title of the game
    private ArrayList<Player> players;// the players of the game

    public Game(String name) {
        this.name = name;
        players = new ArrayList();
    }

    
     //return the name
     
    public String getName() {
        return name;
    }

    
      //return the players of this game
     
    public ArrayList<Player> getPlayers() {
        return players;
    }

    
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

  
    public abstract void play();

    /*
      When the game is over display a winning player.
     */
    public abstract void declareWinner();

}
