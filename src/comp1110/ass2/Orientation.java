package comp1110.ass2;

public enum Orientation {
    NORTH,EAST,WEST,SOUTH,ANY, NONE;

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
