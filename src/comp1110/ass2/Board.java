package comp1110.ass2;

public class Board {

    private Tiles[][] islandBoard;
    private int totalTilesOnBoard;

    public static Tiles[][] getGameBoard(String boardString) {
        if (!RaceToTheRaft.isBoardStringWellFormed(boardString)) {
            return null;
        } else {
            String[] lines = boardString.split("\n");

            Tiles[][] gameBoard = new Tiles[lines.length][lines[0].length()];
            for (int row = 0; row < lines.length; row++) {
                for (int col = 0; col < lines[0].length(); col++) {
                    gameBoard[row][col] = Tiles.fromChar(lines[row].charAt(col));
                }
            }

            return gameBoard;
        }
    }

    public Board(String boardString) {
        this.islandBoard = getGameBoard(boardString);
        this.totalTilesOnBoard = islandBoard.length * islandBoard[0].length;
    }


    public static Tiles[][] transposeBoard(Tiles[][] board) {
        int row = board.length;
        int col = board[0].length;

        Tiles[][] newBoard = new Tiles[col][row];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                newBoard[i][j] = board[j][i];
            }
        }
        return newBoard;
    }

    public static void swapColumns(Tiles[][] transposedBoard){
        int last = transposedBoard[0].length-1;
        int first = 0;

        while (last > first) {
            for (int i = 0; i < transposedBoard.length;i++) {
                Tiles temp = transposedBoard[i][first];
                transposedBoard[i][first] = transposedBoard[i][last];
                transposedBoard[i][last] = temp;

            }

            last--;
            first++;

        }

    }


    public static Tiles[][] rotate90clockwise(Tiles[][] board){
        Tiles[][] transposedBoard = transposeBoard(board);
        swapColumns(transposedBoard);

        return transposedBoard;
    }
}









//    public Tiles[][] rotate(Tiles[][] board, Orientation orientation) {
//        Tiles[][] newBoard = new Tiles[board[0].length][board.length];
//
////        for (int col = 0; col < board[0].length; col++) { // 0 to 2
////            for (int row = board.length - 1; row <= 0; row--) { // 2 to 0
////
////            }
//        newBoard =
//
//
//        return board;
//    }
//}


//abc
//xyz
//
//
//east
//
//xa
//yb
//zc
