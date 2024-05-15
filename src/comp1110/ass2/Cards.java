package comp1110.ass2;

import java.util.ArrayList;

/**
 * Author: Ishaan Kapoor u7598889
 */
public class Cards {

    private char ID;
    private TileType[][] card; //tileType[3][3]


    /**
     * Author Ishaan Kapoor u7598889 and Lujin Sun u7897414*
     * converts a string of length 9 into a char[3][3] (our basic grid for cards).
     *
     * @param cardString the string representing the card.
     * @return a 3 by 3 array of char.
     **/
    public static char[][] characterArrayFromString(String cardString) {
        char[][] charArray = new char[3][3];
        int index = 0;
        if (cardString.length() == 9) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    charArray[i][j] = cardString.charAt(index);
                    index++;
                }
            }
        }
        return charArray;
    }

    /**
     * Author: Ishaan Kapoor u7598889
     */
    public static TileType[][] getTileTypeArray(char[][] charArray) {
        TileType[][] tilesArray = new TileType[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tilesArray[i][j] = TileType.fromChar(charArray[i][j]);
            }
        }
        return tilesArray;
    }

    /**
     * Author: Ishaan Kapoor u7598889
     */
    public static TileType[][] cardFromString(String cardString) {
        return getTileTypeArray(characterArrayFromString(cardString.substring(1)));
    }

    /**
     * Author: Ishaan Kapoor u7598889
     */
    public Cards(String cardString) {
        this.ID = cardString.charAt(0);
        this.card = cardFromString(cardString);
    }

    /**
     * Author: Ishaan Kapoor u7598889
     */
    public Cards(char ID, TileType[][] card) {
        this.ID = ID;
        this.card = card;
    }

    /**
     * Author: Ishaan Kapoor u7598889
     */
    public char getID() {
        return ID;
    }

    /**
     * Author: Ishaan Kapoor u7598889
     */
    public TileType[][] getCard() {
        return card;
    }


    public static Cards rotateCard(Cards initialCard, Orientation orientation) {
        return switch (orientation) {
            case NORTH, ANY -> initialCard;
            case EAST -> rotate90Card(initialCard);
            case SOUTH -> rotate90Card(rotate90Card(initialCard));
            case WEST -> rotate90Card(rotate90Card(rotate90Card(initialCard)));
            case NONE -> null;
        };
    }

    public static Cards rotate90Card(Cards card) {
        TileType[][] transposedCard = Board.transposeBoard(card.getCard());
        Board.swapColumns(transposedCard);

        Cards rotatedCard = new Cards(card.getID(), transposedCard);

        return rotatedCard;
    }

    public static void applyCardOnBoard(Board board, Cards card, int row, int column, Orientation orientation) {
        TileType[][] boardTiles = board.getBoard();
        TileType[][] cardTiles = Cards.rotateCard(card, orientation).getCard();
        Island.applyCard(boardTiles, cardTiles, row, column);
        board.setBoard(boardTiles);

    }

    public static String[] placeCardOnBoard(String[] gameState, String placementString) {
        //{Deck}{ID}{row}{column}{orientation}       pathwayCard      "Ab1208S"
        GameState game = new GameState(gameState);
        Board gameBoardInitial = game.getBoard();
        Decks hand = game.getHand();

        Decks.DECK_ID deckID = Decks.SingleDeck.charToID(placementString.charAt(0));
        Cards requiredCardInitial = Decks.getCardFromIDs(deckID,placementString.charAt(1)); //card we need to place
        Cards requiredCard = rotateCard(requiredCardInitial,Orientation.fromChar(placementString.charAt(6)));

//        ArrayList<Decks.SingleDeck> handListOfDecks = hand.getFulldeck(); // lists of all lists of cards
//        ArrayList<Decks.SingleDeck> deckListOfDecks = deck.getFulldeck();

        int deckIndex = 0;
        deckIndex = switch (deckID) { //choose which singledeck we need
                case A -> 0;
                case B -> 1;
                case C -> 2;
                case D -> 3;
                };
        TileType[][] boardTiles = gameBoardInitial.getBoard();
        TileType[][] cardTiles = requiredCard.card;

        int row = Integer.parseInt(placementString.substring(2,4));
        int col = Integer.parseInt(placementString.substring(4,6));

        Island.applyCard(boardTiles,cardTiles,row,col);
        gameBoardInitial.setBoard(boardTiles); //placing done
        game.setBoard(gameBoardInitial); // gameStateUpdated


        ArrayList<Decks.SingleDeck> singleDeckHand = hand.getFulldeck();
        Decks.SingleDeck required = singleDeckHand.get(deckIndex);
        ArrayList<Cards> finalCards = required.getCards();
        finalCards.remove(requiredCard);
        required.setCards(finalCards);
        singleDeckHand.set(deckIndex,required);
        Decks finalHand = new Decks(singleDeckHand);
        game.setHand(finalHand);
        gameState[0] = gameBoardInitial.toString();
        gameState[1] = finalHand.toString();


        return gameState;
    }

    @Override
    public String toString() {
        String req = "";
        TileType[][] array = card;
        for (int i = 0; i < card.length; i++) {
            for (TileType t : card[i]) {
                req = req + t.toChar();
            }
            req = req + '\n';
        }
        return req;
    }
}

//
//int deckIndex = 0;
//        deckIndex = switch (req) { //choose which singledeck we need
//                case A -> 0;
//                case B -> 1;
//                case C -> 2;
//                case D -> 3;
//                };
//
//                Decks.SingleDeck requiredHandDeck = handInitial.getFulldeck().get(deckIndex);
//                ArrayList<Cards> requiredCards = requiredHandDeck.getCards();   //cards of the single deck that we need
//        Cards requiredCard = null;   //the card that we need
//
//        for (Cards c: requiredCards) {
//        if (c.getID() == placementString.charAt(1)) {
//        requiredCard = c;
//        requiredCards.remove(c); //remove the card from the single deck
//        }
//        }
//
//        ArrayList<Decks.SingleDeck> singleDecks = handInitial.getFulldeck(); //list of singledecks in hand
//        singleDecks.set(deckIndex,new Decks.SingleDeck(req,requiredCards)); // reset the single deck using the deck id and list of cards
//
//        game.setHand(new Decks(singleDecks)); //hand set to new
//        applyCardOnBoard(gameBoardInitial, requiredCard, Integer.parseInt(placementString.substring(2,3)) , Integer.parseInt(placementString.substring(4,5)) , Orientation.fromChar(placementString.charAt(6)));
//
//        StringBuilder f = new StringBuilder("");
//
//        for (int i =0; i < gameBoardInitial.getBoard().length; i++) {
//        for (int j = 0; j < gameBoardInitial.getBoard()[0].length; j++) {
//        f.append(gameBoardInitial.getBoard()[i][j]);
//        }
//        }
//
//        return f.toString();