/*
 * SYST 17796 Project.
 auther name: Abdul Rahman Fatouhe
 this class done by Abdul Rahman
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project.
 */
/**
* @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Abdul Rahman Fatouhe 3 March, 2023
 */

public class Card {
    private String color;
    private String value;

    public Card(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return color + " " + value;
    }
}
