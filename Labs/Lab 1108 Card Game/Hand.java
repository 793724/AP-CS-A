import java.util.ArrayList;
/**
 * Lab 1108 Card Game
 *
 * @ Emma Chiu
 * @ 1108
 */

public class Hand {
    ArrayList<Card> hand = new ArrayList<Card>(); // new hand object
    public Hand(Deck deck) {
        for(int i = 0; i < 5; i++) {
            hand.add(deck.getCard()); // adds five cards to the hand
        }
    }

    public boolean sameSuit() {
        boolean changed = false; // if the suit changed throughout the hand
        String currentSuit = hand.get(0).getSuit(); // sets the initial suit
        for(int i = 0; i < 5; i++) {
            if(hand.get(i).getSuit() != currentSuit) {
                changed = true; // any of the cards aren't of the same suit
            }
        }
        return changed; // whether or not the suit changed
    }
    
    public int onePair() {
        int pairCount = -5; // number of pairs; -5 because it will count each card with itself once
        int value = 0;
        for(int i = 0; i < 5; i++) {
            if(hand.get(i).getRank() == hand.get(0).getRank()
            || hand.get(i).getRank() == hand.get(1).getRank()
            || hand.get(i).getRank() == hand.get(2).getRank()
            || hand.get(i).getRank() == hand.get(3).getRank()
            || hand.get(i).getRank() == hand.get(4).getRank()) {
                pairCount++; // checks if any of the ranks are equal to the others; if so increase pair count
                value = hand.get(i).getRank(); // sets the value of the pair
            }
        }
        if(pairCount == 1) {
            return value; // returns the value if there's one pair
        }
        return -1; // returns -1 if there isn't one pair
    }
}
