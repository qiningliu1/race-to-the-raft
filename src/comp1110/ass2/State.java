package comp1110.ass2;
import java.util.List;

/**
 * The State class represents the current state of the game.
 * It includes descriptions of all the cards in the game, such as the number of cards in the deck,
 * the number of cards in hand, and the positions of placed cards.
 */
public class State {

    private int deckSize; // The number of cards in the deck
    private int handSize; // The number of cards in hand
    private Card[] placedCards; // The list of placed cards and their positions

    /**
     * Constructs a State object with the specified deck size, hand size, and list of placed cards.
     * @param deckSize the number of cards in the deck
     * @param handSize the number of cards in hand
     * @param placedCards the list of placed cards and their positions
     */
    public State(int deckSize, int handSize, Card[] placedCards) {
        this.deckSize = deckSize;
        this.handSize = handSize;
        this.placedCards = placedCards;
    }

    // Getters and setters for deckSize, handSize, and placedCards

}

