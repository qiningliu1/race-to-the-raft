package comp1110.ass2;

import java.util.ArrayList;

/**
 * Author: Ishaan Kapoor u7598889
 */

public class FireTile {

    private TileType[][] fireTile;
    private char tileID;

    /**
     * Author: Ishaan Kapoor u7598889
     * <p>
     * Construct a firetile using its ID and array of fireTiles based on location.
     *
     * @param ID
     * @param tile multidimensional array that represents the fire locations on the tile.
     */
    public FireTile(char ID, TileType[][] tile) {
        this.fireTile = tile;
        this.tileID = ID;
    }

    /**
     * Author: Ishaan Kapoor u7598889
     * <p>
     * generated a 2d array of TileType.Fire and TileType.None, based on the location of fire on the FireTile.
     * if a space is emplty i.e., does not contain any fire, it is filled by TileType.None
     *
     * @param fireString the fireString as per assignment Utility specification.
     * @return TileType[][] representing the FireTile.
     */
    public static TileType[][] getFireTileArray(String fireString) { //"u000102101213"
        if (fireString.length() < 3 || fireString.length() > 19 || fireString.length() % 2 == 0) {
            // at least 1 fire block or at max 9 of them. 2 char represent 1 location
            return null;
        }
//         ArrayList<Integer> locations = splitIntoPairs(fireString.substring(1));
        int[] locations = stringToIntArray(fireString.substring(1));
        int max = findLargest(locations) + 1;
        TileType[][] required = new TileType[max][max]; //max by max card
        for (int row = 0; row < locations.length; row = row + 2) {
            //set Fire to the locations given
            required[locations[row]][locations[row + 1]] = TileType.Fire;
        }
        for (int row = 0; row < max; row = row + 1) { // fill up the void with None
            for (int col = 0; col < max; col = col + 1) {
                if (required[row][col] == TileType.Fire) {
                } else {
                    required[row][col] = TileType.None;
                }
            }
        }
        return required;
    }

    /**
     * Author: Ishaan Kapoor u7598889
     * <p>
     * Breaks a string of numbers into an array of numbers. Will be used later to get the array of locations of
     * the fire on the FireTile, using the String notation.
     *
     * @param numberString for example, "12345"
     * @return Array of int, for example, [1,2,3,4,5]
     */
    public static int[] stringToIntArray(String numberString) { // "1234" to [1,2,3,4] helper
        int[] intArray = new int[numberString.length()];
        for (int i = 0; i < numberString.length(); i++) {
            intArray[i] = Character.getNumericValue(numberString.charAt(i));
        }
        return intArray;
    }

    /**
     * Author: Ishaan Kapoor u7598889
     * <p>
     * Find the largest int out of an array of int.
     *
     * @param array for example, [1,2,3,4,5]
     * @return largest int value, for example, 5
     */
    public static int findLargest(int[] array) { // [1,2,3,5,6] -> 6   helper
        int max = Integer.MIN_VALUE; // Initialize max to the smallest possible integer value
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i]; // Update max if current element is greater
            }
        }
        return max;
    }

    /**
     * Author: Ishaan Kapoor u7598889
     * <p>
     * Construct a fireTile using the String representation as per the assignment.
     *
     * @param fireString like ,  "l000111121322".
     */
    public FireTile(String fireString) {
        this.tileID = fireString.charAt(0);
        this.fireTile = getFireTileArray(fireString);
    }

    /**
     * Author: Ishaan Kapoor u7598889
     *
     * @return ID of the FireTile
     */
    public char getTileID() {
        return tileID;
    }

    /**
     * Author: Ishaan Kapoor u7598889
     *
     * @return TileType[][] of the FireTile
     */
    public TileType[][] getFireTile() {
        return fireTile;
    }

    /**
     * Author: Ishaan Kapoor u7598889
     * <p>
     * Set the fireTile based on input.
     *
     * @param fireTile that needs to be the new value.
     */
    public void setFireTile(TileType[][] fireTile) {
        this.fireTile = fireTile;
    }

    /**
     * Author: Ishaan Kapoor u7598889
     * <p>
     * Rotate the FireTile towards the orientation we need.
     *
     * @param initialFireTile the FireTile that needs to be rotated.
     * @param orientation     final Orientation we need the tile to be in.
     * @return
     */
    public static FireTile rotateFireTile(FireTile initialFireTile, Orientation orientation) {
        FireTile ft = initialFireTile;
        ft = switch (orientation) {
            case NORTH, ANY -> initialFireTile;
            case EAST -> eastFireTileGenerator(initialFireTile);
            case SOUTH -> southFireTileGenerator(initialFireTile);
            case WEST -> up(rotate90FireTile(rotate90FireTile(rotate90FireTile(initialFireTile))));
            case NONE -> null;
        };

        return ft;
    }

    public static FireTile up(FireTile fireTile){
        TileType[][] temp = fireTile.getFireTile();
        int len = temp.length;
        int k = 0;
        for(int i=0;i<len;i++){
            boolean f = true;
            for(int j=0;j<len;j++){
                if(temp[i][j]!=TileType.None){
                    f = false;
                    break;
                }
            }
            if(f) k++;
            else break;
        }
        if(k==0) return fireTile;
        for(int i=k;i<len;i++){
            for(int j=0;j<len;j++){
                temp[i-k][j] = temp[i][j];
                temp[i][j] = TileType.None;
            }
        }

        return new FireTile(fireTile.getTileID(), temp);
    }
    /**
     * Author: Ishaan Kapoor u7598889
     * <p>
     * Rotate the FireTile clockwise.
     *
     * @param card the FireTile that needs to be rotated.
     * @return a new FireTile in East orientation.
     */

    public static FireTile rotate90FireTile(FireTile card) {
        TileType[][] transposedCard = Board.transposeBoard(card.getFireTile());
        Board.swapColumns(transposedCard);
        FireTile rotatedCard = new FireTile(card.getTileID(), transposedCard);
        return rotatedCard;
    }

    /**
     * Author: Ishaan Kapoor u7598889
     * <p>
     * Flip the fireTile of the FireTile, which is in North/South orientation initially.
     *
     * @param array fireTile (TileType[][]) that needs to be flipped.
     */
    public static void flipFireTileNorthSouth(TileType[][] array) {
        int columns = array[0].length; // Assuming all rows have the same number of columns
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < columns / 2; j++) {
                // Swap elements from left to right
                TileType temp = array[i][j];
                array[i][j] = array[i][columns - j - 1];
                array[i][columns - j - 1] = temp;
            }
        }
    }

    /**
     * Author: Ishaan Kapoor u7598889
     * <p>
     * Flip the fireTile of the FireTile, which is in East/West orientation initially.
     *
     * @param array fireTile (TileType[][]) that needs to be flipped.
     */
    public static void flipFireTileEastWest(TileType[][] array) {
        int numRows = array.length;
        int numCols = array[0].length;

        for (int i = 0; i < numRows / 2; i++) {
            // Swap row i with row numRows - 1 - i
            TileType[] temp = array[i];
            array[i] = array[numRows - 1 - i];
            array[numRows - 1 - i] = temp;
        }
    }

    /**
     * Author: Ishaan Kapoor u7598889
     * <p>
     * shift all rows of TileType[][] up by one row. required for flipping
     */
    public static void shiftRowsUp(TileType[][] array) {
        int numRows = array.length;
        int numCols = array[0].length;

        // Save the first row to a temporary array
        TileType[] temp = array[0];

        // Shift each row up by one position
        for (int i = 0; i < numRows - 1; i++) {
            array[i] = array[i + 1];
        }

        // Move the saved first row to the last position
        array[numRows - 1] = temp;
    }

    /**
     * Author: Ishaan Kapoor u7598889
     * <p>
     * shift all columns of TileType[][] left by one column. required for flipping
     */
    public static void shiftColumnsLeft(TileType[][] array) {
        int numRows = array.length;
        int numCols = array[0].length;

        // Shift each column to the left by one position
        for (int i = 0; i < numRows; i++) {
            TileType firstElement = array[i][0]; // Store the first element of the current row
            for (int j = 0; j < numCols - 1; j++) {
                array[i][j] = array[i][j + 1]; // Shift elements to the left
            }
            array[i][numCols - 1] = firstElement; // Move the first element to the last position
        }
    }

    /**
     * returns the Firetile in South orientation.
     *
     * @param fireTile the fireTile needed to be converted to south orientation.
     * @return new Firetile in South orientation.
     */
    public static FireTile southFireTileGenerator(FireTile fireTile) {
        FireTile initial = rotate90FireTile(rotate90FireTile(fireTile));
        TileType[][] initialArray = initial.getFireTile();
        TileType[][] temp = initialArray;
        shiftRowsUp(temp);

        initial.setFireTile(temp);

        return initial;

    }

    /**
     * returns the Firetile in East orientation.
     *
     * @param fireTile the fireTile needed to be converted to East orientation.
     * @return new Firetile in East orientation.
     */
    public static FireTile eastFireTileGenerator(FireTile fireTile) {
        FireTile initial = rotate90FireTile(fireTile);
        TileType[][] initialArray = initial.getFireTile();
        TileType[][] temp = initialArray;
        shiftColumnsLeft(temp);

        initial.setFireTile(temp);

        return initial;

    }

    /**
     * Author: Ishaan Kapoor u7598889
     * <p>
     * Apply the FireTile on the given Board, based on the location (row , column), Orientation of the tile and
     * after flipping it(if specified)
     *
     * @param ID          of the FireTile we need to apply on the board.
     * @param board       the board that needs to be modified.
     * @param row         int describing the row coordinate of the top left block of the FireTile.
     * @param column      int describing the column coordinate of the top left block of the FireTile.
     * @param flip        flip the tile if this is True.
     * @param orientation Orientation in which we need to place the tile.
     */
    public static void applyFireTileOnBoard(char ID, Board board, int row, int column, Boolean flip, Orientation orientation) { //{ID}{row}{column}{flipped}{orientation} l0003TW
        String requiredFireString = null;
        TileType[][] requiredBoard = board.getBoard();
        for (String s : Utility.FIRE_TILES) {
            if (s.charAt(0) == ID) {
                requiredFireString = s;
            }
        }

        FireTile fireTileInitial = new FireTile(requiredFireString);
        FireTile fireTile = rotateFireTile(fireTileInitial, orientation);

        if (flip && (orientation == Orientation.NORTH || orientation == Orientation.SOUTH)) {
            TileType[][] temp = fireTile.getFireTile();
            flipFireTileNorthSouth(temp);
            fireTile.setFireTile(temp);
        } else if (flip && (orientation == Orientation.EAST || orientation == Orientation.WEST)) {
            TileType[][] temp = fireTile.getFireTile();
            flipFireTileEastWest(temp);
            fireTile.setFireTile(temp);
        }


        TileType[][] requiredTileTypeArray = fireTile.getFireTile();
        for (int i = 0; i < requiredTileTypeArray.length; i++) {
            for (int j = 0; j < requiredTileTypeArray[0].length; j++) {
                if (requiredTileTypeArray[i][j] != TileType.None) {
                    requiredBoard[row + i][column + j] = requiredTileTypeArray[i][j];
                }
            }
        }

        board.setBoard(requiredBoard);

    }

    public static String[] placeFireTileOnBoard(String[] gameState, String firePlacementString) {
        //{ID}{row}{column}{flipped}{orientation}
        //l0003TW
        GameState game = new GameState(gameState);
        Board board = game.getBoard();
        ArrayList<FireTile> bag = game.getFireTileBag();
        if (firePlacementString.length() == 7) {
            char ID = firePlacementString.charAt(0);
            Boolean flip = firePlacementString.charAt(5) == 'T';
            Orientation orientation = Orientation.fromChar(firePlacementString.charAt(6));
            int row = Integer.parseInt(firePlacementString.substring(1, 3));
            int col = Integer.parseInt(firePlacementString.substring(3, 5));
            applyFireTileOnBoard(ID, board, row, col, flip, orientation);

            for(FireTile f:bag) {
                if(f.getTileID() == ID) {
                    bag.remove(f);
                }
            }
            game.setBoard(board);
            game.setFireTileBag(bag);

            gameState[0] = board.toString();
            gameState[4] = fireTileBagToString(bag);

        }

        return gameState;
    }

    public static ArrayList<FireTile> allFireTilesGenerator(String[] stringArray){
        ArrayList<FireTile> req = new ArrayList<>(stringArray.length);
        for (String s:stringArray) {
            req.add(new FireTile(s));
        }
        return req;
    }

    public static final ArrayList<FireTile> allFireTiles = allFireTilesGenerator(Utility.FIRE_TILES);

    public static ArrayList<FireTile> fireTileBagFromString(String firebagString){
        ArrayList<FireTile> req = new ArrayList<>(firebagString.length());
        for (char c : firebagString.toCharArray()){
            for(FireTile f:allFireTiles) {
                if(f.getTileID() == c) {
                    req.add(f);
                }
            }
        }
        return req;
    }

    @Override
    public String toString() {
        String ss = null;
        for(String s:Utility.FIRE_TILES){
            if (s.charAt(0) == tileID) {
                ss=s;
            }
        }
        return ss;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static String fireTileBagToString(ArrayList<FireTile> bag) {
        String req = "";
        for(FireTile f:bag) {
            req = req+ (f.getTileID());
        }
        return req;
    }

}
