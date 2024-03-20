package comp1110.ass2;
/**
 * this enum defined all the possible colours/tiles the board can be made of.
 * Further, this provides the foundation for building all the cards
 * required for the game to work.
 */
public enum Tiles {
            BLUE, GREEN, YELLOW, RED, PURPLE,FIRE,CAT;

    /**
     * convert the tile into a char that symbolises it. For example,
     * RED can be symbolised by 'r'.
     * @return char representing the colour/tile.
     *
     */
    public char toChar() {
        return 'x'; //just an example implementation
        }

    /**
     * convert the char into the tile it symbolises. For example,
     * 'r' would be converted to RED.
     * @return tile represented by the char.
     *
     */
    public Tiles tilesFromChar() {
        return RED; //just an example implementation
    }
}
