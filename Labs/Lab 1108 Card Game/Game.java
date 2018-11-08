/**
 * Lab 1108 Card Game
 *
 * @ Emma Chiu
 * @ 1108
 */

public class Game {
    public Game() {
        Deck deck = new Deck(); // creates a new deck object
        Hand hand = new Hand(deck); // creates a new hand object based on the deck
    }
}