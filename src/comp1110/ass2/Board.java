package comp1110.ass2;

/**
 * Author: Ishaan Kapoor u7598889
 **/
public class Board {

    private TileType[][] board;
    private int totalTilesOnBoard;

    public static TileType[][] getGameBoard(String boardString) {
//        if (!RaceToTheRaft.isBoardStringWellFormed(boardString)) {
//            return null;
//        } else {
            String[] lines = boardString.split("\n");

            TileType[][] gameBoard = new TileType[lines.length][lines[0].length()];
            for (int row = 0; row < lines.length; row++) {
                for (int col = 0; col < lines[0].length(); col++) {
                    gameBoard[row][col] = TileType.fromChar(lines[row].charAt(col));
                }
            }
            return gameBoard;
        }
//    }

    public Board(String boardString) {
        this.board = getGameBoard(boardString);
        this.totalTilesOnBoard = board.length * board[0].length;
    }

    public Board(TileType[][] board) {
        this.board = board;
        this.totalTilesOnBoard = board.length * board[0].length;
    }


    public static TileType[][] transposeBoard(TileType[][] board) {
        int row = board.length;
        int col = board[0].length;

        TileType[][] newBoard = new TileType[col][row];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                newBoard[i][j] = board[j][i];
            }
        }
        return newBoard;
    }


    public static void swapColumns(TileType[][] transposedBoard){
        int last = transposedBoard[0].length-1;
        int first = 0;

        while (last > first) {
            for (int i = 0; i < transposedBoard.length;i++) {
                TileType temp = transposedBoard[i][first];
                transposedBoard[i][first] = transposedBoard[i][last];
                transposedBoard[i][last] = temp;
            }
            last--;
            first++;
        }
    }


    public TileType[][] getBoard() {
        return board;
    }

    public static Board rotate90Card(Board board){
        TileType[][] transposedBoard = transposeBoard(board.getBoard());
        swapColumns(transposedBoard);

        Board rotatedBoard = new Board(transposedBoard);

        return rotatedBoard;
    }

    /**
     * Author: Ishaan Kapoor u7598889
     *
     * Given a board in form of TileType[][], this function rotates it into the orientation specified.
     * @param initialBoard the board that needs to be rotated.
     * @param orientation the orientation we want to rotate towards.
     * @return a new board in the form of TileType[][] in the new orientation.
     *
     */
    public static Board rotateBoard(Board initialBoard, Orientation orientation) {
        return switch(orientation) {
            case NORTH, ANY -> initialBoard;
            case EAST -> Board.rotate90Card(initialBoard);
            case SOUTH -> Board.rotate90Card(Board.rotate90Card(initialBoard));
            case WEST -> Board.rotate90Card(Board.rotate90Card(Board.rotate90Card(initialBoard)));
            case NONE -> null;
        };
    }



    public void setBoard(TileType[][] board) {
        this.board = board;
    }

    @Override
    public String toString() {
        String req = "";
        TileType[][] array = board;
        for (int i = 0; i < board.length; i++){
            for(TileType t : board[i]) {
                req = req + t.toChar();
            } req = req + '\n';
        }
        return req;
    }

//    public static TileType[][] rotateMatrix(TileType[][] matrix) {
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//
//        // Create a new matrix to store the rotated values
//        TileType[][] rotatedMatrix = new TileType[cols][rows];
//
//        // Iterate over the original matrix and populate the rotated matrix
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                rotatedMatrix[j][rows - i - 1] = matrix[i][j];
//            }
//        }
//
//        return rotatedMatrix;
//    }
//
//    public static Board newRotate (Board board, Orientation orientation) {
//        TileType[][] matrix = board.getBoard();
//        return switch(orientation) {
//            case NORTH, ANY -> new Board(matrix);
//            case EAST -> new Board(rotateMatrix(matrix));
//            case SOUTH -> new Board(rotateMatrix(rotateMatrix(matrix)));
//            case WEST -> new Board(rotateMatrix(rotateMatrix(rotateMatrix(matrix))));
//            case NONE -> null;
//        };
//    }
}







