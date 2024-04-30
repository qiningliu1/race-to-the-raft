package comp1110.ass2;

// we store boards as Tiles[][] which tells us where each tile is based on coordinates
/**
 * Author: Ishaan Kapoor u7598889
 **/
public class Board {

    private Tiles[][] board;
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
        this.board = getGameBoard(boardString);
        this.totalTilesOnBoard = board.length * board[0].length;
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







