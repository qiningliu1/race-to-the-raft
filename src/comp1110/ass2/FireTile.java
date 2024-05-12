package comp1110.ass2;

public class FireTile {

    private TileType[][] fireTile;
    private char tileID;



    public static final String[] FIRE_TILES = {
            "a000110111221",
            "b000102102021",
            "c000102031121",
            "d000102121314",
            "e000111122021",
            "f000102101120",
            "g000102111213",
            "h0001021121",
            "i011011121321",
            "j001011121322",
            "k0001021020",
            "l000111121322",
            "m00011112",
            "n0001112021",
            "o000102101121",
            "p0001111213",
            "q000102031112",
            "r0001111222",
            "s000110111222",
            "t0001020310",
            "u000102101213",
            "v000102031012",
            "w0010111222",
            "x0110111221",
            "y0001111221",
            "z00101120",
            "A0001020311",
            "B000102112122",
            "C0001021011",
            "D000102031011",
            "E000102121323",
    };



    public FireTile(char ID, TileType[][] tile) {
        this.fireTile = tile;
        this.tileID = ID;
    }

    public static TileType[][] getFireTileArray(String fireString) {
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


    public static int[] stringToIntArray(String numberString) { // "1234" to [1,2,3,4]
        int[] intArray = new int[numberString.length()];
        for (int i = 0; i < numberString.length(); i++) {
            intArray[i] = Character.getNumericValue(numberString.charAt(i));
        }
        return intArray;
    }

    public static int findLargest(int[] array) { // [1,2,3,5,6] -> 6
        int max = Integer.MIN_VALUE; // Initialize max to the smallest possible integer value
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i]; // Update max if current element is greater
            }
        }
        return max;
    }

    public FireTile(String fireString) {
        this.tileID = fireString.charAt(0);
        this.fireTile = getFireTileArray(fireString);
    }

    public char getTileID() {
        return tileID;
    }

    public TileType[][] getFireTile() {
        return fireTile;
    }

    public void setFireTile(TileType[][] fireTile) {
        this.fireTile = fireTile;
    }

    public void setTileID(char tileID) {
        this.tileID = tileID;
    }

    public static TileType[][] flipTile(TileType[][] tileArray, Orientation orientation) {
        return null;
    }


    public static void applyFireTileOnBoard(char ID, Board board, int row, int column, Boolean flip ,Orientation orientation) { //{ID}{row}{column}{flipped}{orientation} l0003TW
        String requiredFireString = null;
        TileType[][] requiredBoard = board.getBoard();
        for(String s:FIRE_TILES) {
            if (s.charAt(0) == ID) {
                requiredFireString = s;
            }
        }

        FireTile fireTileInitial = new FireTile(requiredFireString);
        FireTile fireTile = rotateFireTile(fireTileInitial,orientation);

        if(flip && (orientation == Orientation.NORTH || orientation == Orientation.SOUTH)) {
            TileType[][] temp = fireTile.getFireTile();
            flipFireTileNorthSouth(temp);
            fireTile.setFireTile(temp);
        } else if (flip && (orientation == Orientation.EAST || orientation == Orientation.WEST)){
            TileType[][] temp = fireTile.getFireTile();
            flipFireTileEastWest(temp);
            fireTile.setFireTile(temp);
        }


        TileType[][] requiredTileTypeArray = fireTile.getFireTile();
        for (int i = 0; i < requiredTileTypeArray.length; i++) {
            for (int j =0; j< requiredTileTypeArray[0].length; j++) {
                if(requiredTileTypeArray[i][j] != TileType.None) {
                    requiredBoard[row+i][column+j] = requiredTileTypeArray[i][j];
                }
            }
        }

        board.setBoard(requiredBoard);

    }





    public static FireTile rotateFireTile(FireTile initialFireTile, Orientation orientation) {
        FireTile ft = initialFireTile;
        ft =  switch(orientation) {
            case NORTH, ANY -> initialFireTile;
            case EAST -> eastFireTileGenerator(initialFireTile) ;
            case SOUTH -> southFireTileGenerator(initialFireTile);
            case WEST -> rotate90FireTile(rotate90FireTile(rotate90FireTile(initialFireTile)));
            case NONE -> null;
        };

        return ft;
    }
// rotate90FireTile(initialFireTile) east
//rotate90FireTile(rotate90FireTile(initialFireTile)) south
    public static FireTile rotate90FireTile(FireTile card){
        TileType[][] transposedCard = Board.transposeBoard(card.getFireTile());
        Board.swapColumns(transposedCard);
        FireTile rotatedCard = new FireTile(card.getTileID(),transposedCard);
        return rotatedCard;
    }

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

    public static FireTile southFireTileGenerator(FireTile fireTile) {
        FireTile initial = rotate90FireTile(rotate90FireTile(fireTile));
        TileType[][] initialArray = initial.getFireTile();
        TileType[][] temp = initialArray;
        shiftRowsUp(temp);

        initial.setFireTile(temp);

        return initial;

    }

    public static FireTile eastFireTileGenerator(FireTile fireTile) {
        FireTile initial = rotate90FireTile(fireTile);
        TileType[][] initialArray = initial.getFireTile();
        TileType[][] temp = initialArray;
        shiftColumnsLeft(temp);

        initial.setFireTile(temp);

        return initial;

    }
}



