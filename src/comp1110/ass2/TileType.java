package comp1110.ass2;
/**
 * Author: Lujin Sun u7897414
 **/


/**
 * this enum defined all the possible colours/tiles the board can be made of.
 * Further, this provides the foundation for building all the cards
 * required for the game to work.
 */
public enum TileType {
    BLUE, GREEN, RED, YELLOW, PURPLE, WILD, Fire, BLUE_CAT, GREEN_CAT,PURPLE_CAT,RED_CAT,YELLOW_CAT, Object, None;

    public static TileType fromChar(char tiles) {
        return switch (tiles) {
            case 'b' -> BLUE;
            case 'g' -> GREEN;
            case 'r' -> RED;
            case 'y' -> YELLOW;
            case 'p' -> PURPLE;
            case 'f' -> Fire;
            case 'w' -> WILD;
            case 'o' -> Object;
            case 'B' -> BLUE_CAT;
            case 'G' -> GREEN_CAT;
            case 'P' -> PURPLE_CAT;
            case 'R' -> RED_CAT;
            case 'Y' -> YELLOW_CAT;
            default -> None;
        };
    }

    /**
     * convert the tile into a char that symbolises it. For example,
     * RED can be symbolised by 'r'.
     *
     * @return char representing the colour/tile.
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
            case BLUE_CAT -> 'B';
            case GREEN_CAT -> 'G';
            case PURPLE_CAT -> 'P';
            case RED_CAT -> 'R';
            case YELLOW_CAT -> 'Y';
            default -> 'x';
        };
    }

    @Override
    public String toString() {
        return super.toString();
    }



}



