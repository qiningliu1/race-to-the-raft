package comp1110.ass2;

import java.awt.geom.NoninvertibleTransformException;
/**
 * this enum defined all the possible colours/tiles the board can be made of.
 * Further, this provides the foundation for building all the cards
 * required for the game to work.
 */
public enum Tiles {
    BLUE,GREEN,RED,YELLOW,PURPLE,WILD,Fire,Object,None;
    public static Tiles fromChar(char tiles){
        return switch (tiles) {
            case 'b' -> BLUE;
            case 'g' -> GREEN;
            case 'r' -> RED;
            case 'y' -> YELLOW;
            case 'p'-> PURPLE;
            case 'f'-> Fire;
            case 'w'-> WILD;
            case 'o'-> Object;
            default -> None;
        };
    }

    /**
     * convert the tile into a char that symbolises it. For example,
     * RED can be symbolised by 'r'.
     * @return char representing the colour/tile.
     *
     */
    public char toChar() {
        return switch (this) {
            case BLUE -> 'b';
            case GREEN -> 'g';
            case RED -> 'r';
            case YELLOW -> 'y';
            case PURPLE -> 'p';
            case Fire -> 'f';
            case WILD -> 'w';
            case Object -> 'o';
            default -> 'x';
        };
    }//just an example implementation


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
