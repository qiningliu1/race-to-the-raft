package comp1110.ass2;

public class Cards {

    private char ID;
    private TileType[][] card = new TileType[3][3];


    /**
     * converts a string of length 9 into a char[3][3] (our basic grid for cards).
     * @param cardString the string representing the card.
     * @return a 3 by 3 array of char.
     **/
    public static char[][] characterArrayFromString(String cardString) {
        char[][] charArray = new char[3][3];
        int index = 0;
        if (cardString.length()==9) {
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
    public static TileType[][] getTileTypeArray(char[][] charArray){
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

    public Cards(String cardString){
        this.ID = cardString.charAt(0);
        this.card=cardFromString(cardString);
    }

    public Cards(char ID, TileType[][] card){
        this.ID = ID;
        this.card = card;
    }

    public char getID() {
        return ID;
    }

    public TileType[][] getCard() {
        return card;
    }
}
