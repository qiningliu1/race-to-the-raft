package comp1110.ass2;

import java.util.ArrayList;

/**
 * Author: Ishaan Kapoor u7598889
 **/
public class Decks {
    private ArrayList<SingleDeck> fulldeck; //decks object is a list of all decks.


    /**
     *Author: Ishaan Kapoor u7598889
     *
     * all possible deck ids
     */
    public enum DECK_ID {
        A, B, C, D;
    }

    /**
     * Author: Ishaan Kapoor u7598889
     *
     * These are the string representation of full decks.
     */
    static String[] deckA = Utility.DECK_A;
    static String[] deckB = Utility.DECK_B;
    static String[] deckC = Utility.DECK_C;
    static String[] deckD = Utility.DECK_D;

    /**
     * Author: Ishaan Kapoor u7598889
     *
     * this function takes in a DECK_ID and returns the list of cards inside that deck.
     *
     * @param c DECK_ID to be retrieved.
     * @return all the cards that are inside that deck in the form of ArrayList.
     */
    public static ArrayList<Cards> getCardsListFromDeckName(DECK_ID c) { // singleDeck like Aabc

        ArrayList<Cards> deckACards = new ArrayList<>(25);
        ArrayList<Cards> deckBCards = new ArrayList<>(25);
        ArrayList<Cards> deckCCards = new ArrayList<>(25);
        ArrayList<Cards> deckDCards = new ArrayList<>(25);

        for (String s : deckA) {
            deckACards.add(new Cards(s));
        }

        for (String s : deckB) {
            deckBCards.add(new Cards(s));
        }

        for (String s : deckC) {
            deckCCards.add(new Cards(s));
        }

        for (String s : deckD) {
            deckDCards.add(new Cards(s));
        }

        ArrayList<Cards> requiredList = null;
        requiredList = switch (c) {
            case A -> deckACards;
            case B -> deckBCards;
            case C -> deckCCards;
            case D -> deckDCards;
        };
        return requiredList;

    }

    /**
     * Author: Ishaan Kapoor u7598889
     *
     * takes in a char id for a specific card in a deck, and gives us the index at which that card exists in the
     * respective deck.
     * @param c card id between a-y
     * @return index associated.
     */
    public static int cardIDtoIndex(char c) {
        int index = 0;
        index = switch (c) {
            case 'a' -> 0;
            case 'b' -> 1;
            case 'c' -> 2;
            case 'd' -> 3;
            case 'e' -> 4;
            case 'f' -> 5;
            case 'g' -> 6;
            case 'h' -> 7;
            case 'i' -> 8;
            case 'j' -> 9;
            case 'k' -> 10;
            case 'l' -> 11;
            case 'm' -> 12;
            case 'n' -> 13;
            case 'o' -> 14;
            case 'p' -> 15;
            case 'q' -> 16;
            case 'r' -> 17;
            case 's' -> 18;
            case 't' -> 19;
            case 'u' -> 20;
            case 'v' -> 21;
            case 'w' -> 22;
            case 'x' -> 23;
            case 'y' -> 24;
            default -> throw new IllegalStateException("Unexpected value: " + c);
        };
        return index;
    }

    /**
     * Author: Ishaan Kapoor u7598889
     *
     * takes in a deckString like AabBCdefD, and returns all the singleDecks that exists in that combined deck.
     * @param deckString string given in string representation.
     * @return ArrayList of singleDeck obejcts.
     */
    public ArrayList<SingleDeck> getSingleDecks(String deckString) {
        ArrayList<SingleDeck> req = new ArrayList<>(4);

        for(String s: deckString.split("(?=[A-Z])")) {
            req.add(new SingleDeck(s));
        }
        return req;
    }

    public Decks(String s) {
        this.fulldeck = getSingleDecks(s);
    }

    public ArrayList<SingleDeck> getFulldeck() {
        return fulldeck;
    }

    /**
     * Author: Ishaan Kapoor u7598889
     *
     * This nested class is designed to make and store individual decks like DECK_A and so on.
     * This class takes in a simple string like Aabc and converts it into an object with ID A and retrieves cards
     * a,b and c from Utility, and stores them in a ArrayList.
     */
    class SingleDeck {
        private Decks.DECK_ID ID;
        private ArrayList<Cards> cards;


        /**
         * Author: Ishaan Kapoor u7598889
         **/
        public static ArrayList<Cards> cardListFromCardIDs(String deckString) {
            ArrayList<Cards> required = new ArrayList<>(25);
            char[] IDs = deckString.substring(1).toCharArray();

            for (char c : IDs) {
                required.add(Decks.getCardsListFromDeckName(charToID(deckString.charAt(0))).get(Decks.cardIDtoIndex(c)));
            }
            return required;
        }

        public SingleDeck (DECK_ID ID, ArrayList<Cards> cards) {
            this.ID = ID;
            this.cards = cards;
        }


        public SingleDeck(String singleDeck) { // singleDeck like Aabc
            this.ID = charToID(singleDeck.charAt(0));
            this.cards = cardListFromCardIDs(singleDeck);
        }

        public ArrayList<Cards> getCards() {
            return cards;
        }

        /**
         * Author: Ishaan Kapoor u7598889.
         *
         * since we will retreive the ID from a string, we first need to convert it into a DECK_ID object.
         * @param c char which represents the ID
         * @return DECK_ID value based on that char.
         */
        public static Decks.DECK_ID charToID(char c) {
            Decks.DECK_ID ID = null;
            ID = switch (c) {
                case 'A' -> Decks.DECK_ID.A;
                case 'B' -> Decks.DECK_ID.B;
                case 'C' -> Decks.DECK_ID.C;
                case 'D' -> Decks.DECK_ID.D;
                default -> null;
            };
            return ID;
        }
    }
}













