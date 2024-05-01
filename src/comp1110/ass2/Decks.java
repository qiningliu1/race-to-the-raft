package comp1110.ass2;

import java.util.*;
import java.util.Random;
/**
 * Author: Qining Liu u7100555
 **/
public class Decks {

/*
    private static String[] CIRCLE = Utility.DECK_A;
    private static String[] CROSS = Utility.DECK_B;
    private static String[] SQUARE = Utility.DECK_C;
    private static String[] TRIANGLE = Utility.DECK_D;

 */

    /** Part1:
     * I applied Map to storage the data of deck
     * Key is First char of Decks like: A,B,C,D
     * Value is stored in LinkedList
     * I applied constructor to initialize the Decks state with accept a String of gameState;

     */

    private Map<Character, LinkedList<String>> deckMap = new HashMap<>();

    public Decks(String[] gameState) {
        //gameState[1] correspond to first element in String array[Board,decks,hand,Exhausted Cats, FireTiles]
        this.initializeDecks(gameState[1]);
    }


    /** Part2:
     * Initialize method receive a decksString to allocate Deck with ID
     * Allocate cards with the string follow each ID
     * Now the initializeDeck data is stored in the Map

     */

    private void initializeDecks(String decksString) {
        for (String deckInfo : decksString.split("(?=[A-Z])")) {
            char deckId = deckInfo.charAt(0);
            LinkedList<String> cards = deckInfo.length() > 1
                    ? new LinkedList<>(Arrays.asList(deckInfo.substring(1).split("")))
                    : new LinkedList<>();
            deckMap.put(deckId, cards);
        }
    }

    /** Part3:
     * This process showing how to draw cards
     * Judgement is by two part:
     * 1. when there is no card in decks
     * 2. or players asked to draw more cards than the cards in the deck
     * we return false in above two case
     * else we will allocate cards to players

     */

    public boolean drawCards(char deckId, int count, StringBuilder hand) {
        LinkedList<String> deck = deckMap.get(deckId);
        if (deck == null || deck.size() < count) {
            return false; // Not enough cards or deck does not exist
        }
        for (int i = 0; i < count; i++) {
            hand.append(deck.poll());
        }
        return true;
    }

    /** Part4:
     * After we draw our cards from the Decks, we need to update our data for decks
     * We call map to show the cards exist and return the id with their string
     *

     */

    public String getUpdatedDecks() {
        StringBuilder sb = new StringBuilder();
        char[] deckIds = new char[]{'A', 'B', 'C', 'D'};
        for (char deckId : deckIds) {
            LinkedList<String> deck = deckMap.get(deckId);
            sb.append(deckId);
            deck.forEach(sb::append); // Add cards to the string
        }
        return sb.toString();
    }

}