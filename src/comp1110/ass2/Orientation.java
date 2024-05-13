package comp1110.ass2;

/**
 * Author: Ishaan Kapoor u7598889
 **/

public enum Orientation {
    NORTH,EAST,WEST,SOUTH,ANY, NONE;
    /**
     * Author: Ishaan Kapoor u7598889
     *
     * @param c char that defines the orientation.
     * @return the orientation oboject the char did represent.
     **/
    public static Orientation fromChar(char c) {
        return switch (c) {
            case 'N' -> NORTH;
            case 'E' -> EAST;
            case 'W' -> WEST;
            case 'S' -> SOUTH;
            case 'A' -> ANY;
            default -> NONE;
        };
        }

    public char toChar(Orientation o) {
        return switch (o) {
            case NORTH -> 'N';
            case EAST -> 'E';
            case WEST-> 'W';
            case SOUTH -> 'S';
            case ANY -> 'A';
            default -> ' ';
        };
    }


}