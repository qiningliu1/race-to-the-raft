package comp1110.ass2;

/**
 * The Card class represents a card in the game.
 * It contains information about the type of card and any other relevant properties.
 */

/**
 * This class would be the super class for Pathway and Raft cards.
 */
public class Card {
    private Tiles tiles;
    private int row;
    private int column;
    public Card(Tiles tiles/* //int row, int column*/) {
        this.tiles = tiles;
        this.row=row;
        this.column=column;
    }
    public Card(String target){
        this.tiles = Tiles.fromChar(target.charAt(0));
    }
    public Tiles getTiles() {
        return this.tiles;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setTiles(Tiles tiles) {
        this.tiles = tiles;
    }

}
