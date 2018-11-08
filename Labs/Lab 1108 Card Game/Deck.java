import java.util.ArrayList;
import java.util.Random;
/**
 * Lab 1108 Card Game
 *
 * @ Emma Chiu
 * @ 1108
 */

public class Deck {
    ArrayList<Card> deck = new ArrayList<Card>(); // new deck object
    public Deck() {
        for(int i = 1; i < 14; i ++) { // runs through ranks
            for(int j = 1; j < 5; j++) { // runs through suits
                // adds cards
                if(j == 1) {
                    deck.add(new Card(i, "Heart"));
                } else if (j == 2) {
                    deck.add(new Card(i, "Diamond"));
                } else if (j == 3) {
                    deck.add(new Card(i, "Spade"));
                } else {
                    deck.add(new Card(i, "Club"));
                }
            }
        }
    }
    
    public Card getCard() {
        int spot = (int)(Math.random()*52)+1; // random index of the deck
        return deck.get(spot); // returns the card at that index
    }
}
