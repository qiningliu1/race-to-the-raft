package QiningBranch;
/**
 * Author : Qining Liu u7100555
 */
public enum newTileType {
    BLUE, GREEN, RED, YELLOW, PURPLE, WILD, Fire, BLUE_CAT, GREEN_CAT,PURPLE_CAT,RED_CAT,YELLOW_CAT, Object, None,Cat;
    public static newTileType fromChar(char tiles) {
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
            case 'C' -> Cat;
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
            case Cat -> 'C';
            default -> 'x';
        };
    }


    public static String toString(newTileType[][] tiles) {
        StringBuilder sb = new StringBuilder();
        for (newTileType[] row : tiles) {
            for (newTileType tile : row) {
                sb.append(tile).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        newTileType type = newTileType.fromChar('b');
        System.out.println(type); // "BLUE"

        newTileType[][] b = new newTileType[3][3];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = Cat;
            }
        }


        System.out.println(newTileType.toString(b));

    }



}
