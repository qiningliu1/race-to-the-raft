package comp1110.ass2;

import java.util.ArrayList;

public class CatCard {
    private int ID;
    private Location catLocation;
    private Orientation orientation;
    private Card[][] cards;

    public static final CatCard[] CAT_CARDS = new CatCard[]{
            new CatCard(0, "rrfrRfrrf"),
            new CatCard(1, "fffbBbbbb"),
            new CatCard(2, "fffbBbbbY"),
            new CatCard(3, "gffgGfggg"),
            new CatCard(4, "ffyfYyyyy"),
            new CatCard(5, "fppfPpfpp"),
            new CatCard(6, "fppfPpfpR")
    };

    public CatCard(int ID, String cardString) {
        this.ID = ID;
        this.orientation = Orientation.NORTH;
        this.cards = new Card[3][3];
        initializeSquares(cardString);
    }

    private void initializeSquares(String cardString) {
        int charIndex = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char character = cardString.charAt(charIndex++);
                if (Character.isUpperCase(character)) {
                    catLocation = new Location(row, col);
                    character = Character.toLowerCase(character);
                }
                cards[row][col] = new Card(Tiles.fromChar(character));
            }
        }
    }

    public static CatCard newCatCard(int ID) {
        if (ID < 0 || ID >= CAT_CARDS.length) {
            System.out.println("Invalid cat card ID: " + ID);
            return null;
        }
        return CAT_CARDS[ID];
    }

    public int getID() {
        return ID;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public Location getCatLocation() {
        return catLocation;
    }

    public Tiles getCatTiles() {
        return cards[catLocation.getRow()][catLocation.getColumn()].getTiles();
    }

    public Card getcard(int row, int column) {
        return cards[row][column];
    }

    public void placeCatCard() {
        // Implement placing the cat card on the board
    }

    public void rotateCatCard(Orientation orientation) {
        // Implement rotating the cat card
    }
}

