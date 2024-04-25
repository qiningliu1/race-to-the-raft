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
    /**
     * Author: Ishaan Kapoor u7598889
     *
     * Given a board in form of Tiles[][], this function rotates it into the orientation specified.
     * @param initialBoard the board that needs to be rotated.
     * @param orientation the orientation we want to rotate towards.
     * @return a new board in the form of Tiles[][] in the new orientation.
     *
     */
    public Tiles[][] rotateBoard(Tiles[][] initialBoard, Orientation orientation) {
        return switch(orientation) {
            case NORTH -> initialBoard;
            case EAST -> Board.rotate90clockwise(initialBoard);
            case SOUTH -> Board.rotate90clockwise(Board.rotate90clockwise(initialBoard));
            case WEST -> Board.rotate90clockwise(Board.rotate90clockwise(Board.rotate90clockwise(initialBoard)));
            case ANY -> Board.rotate90clockwise(initialBoard);
            case NONE -> null;
        };
    }

}