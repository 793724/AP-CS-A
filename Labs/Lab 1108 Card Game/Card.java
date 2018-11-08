/**
 * Lab 1108 Card Game
 *
 * @ Emma Chiu
 * @ 1108
 */

public class Card {
    // instance variables
    int rank;
    String suit;
    public Card(int r, String s) { // initializes the variables
        int rank = r;
        String suit = s;
    }
    
    public String getSuit() { // gets the card's suit
        return suit;
    }
    
    public int getRank() { // gets the card's rank
        return rank;
    }
}