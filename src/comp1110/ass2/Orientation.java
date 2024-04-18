package comp1110.ass2;
/**
 * this enum defined all the possible colours/tiles the board can be made of.
 * Further, this provides the foundation for building all the cards
 * required for the game to work.
 */
public enum Orientation {
    NORTH ,EAST, WEST ,SOUTH ,NONE;
    public static Orientation fromChar(char orientation) {
        return switch (orientation) {
            case 'N' -> NORTH;
            case 'S' -> SOUTH;
            case 'E' -> EAST;
            case 'W' -> WEST;
            default -> NONE;
        };
    }
    public char toChar() {
        return switch (this) {
            case NORTH -> 'N';
            case EAST -> 'E';
            case SOUTH -> 'S';
            case WEST -> 'W';
            default ->'x';
        };
    }
    public Orientation rotate() {
        return values()[(this.ordinal() + 1) % 4];
    }

}
