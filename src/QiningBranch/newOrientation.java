package QiningBranch;

/**
 * Author : Qining Liu u7100555
 */

/**
 * This enumeration type represents the cardinal orientations.
 * <p>
 * Notice that this is an enumeration type,
 * so none of the fields change once the type is created (they are all declared final).
 * </p>
 */

public enum newOrientation {
    NORTH, EAST, SOUTH, WEST, ANY,NONE;


    /**
     * Given orientation like N,E,S,W,A in challenge String
     * @param orientation
     * @return  Correspondence Orientation
     */

    public static newOrientation fromChar(char orientation){
        return switch (orientation){
            case 'N' -> NORTH;
            case 'E' -> EAST;
            case 'S' -> SOUTH;
            case 'W' -> WEST;
            case 'A' -> ANY;
            default -> NONE;
        };
    }


    /**
     * transfer orientation type to char type
     *
     * @return char type of orientation
     */

    public char toChar(){
        return switch (this){
            case NORTH -> 'N';
            case EAST -> 'E';
            case SOUTH -> 'S';
            case WEST -> 'W';
            case ANY -> 'A';
            case NONE -> 'X';
        };
    }

    /**
     * Rotate this orientation 90 degrees clockwise
     * @return the rotated orientation
     */

    public newOrientation rotate() {
        return values()[(this.ordinal() + 1) % 4];
    }



}
