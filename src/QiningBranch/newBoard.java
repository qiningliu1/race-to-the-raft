package QiningBranch;

/**
 * Author : Qining Liu u7100555
 */

import comp1110.ass2.RaceToTheRaft;

public class newBoard {
        public newTileType[][] board;
        private int totalTilesOnBoard;

    /**
     *
      * @return a String format of Board element by using toString method
     * we add parameter to this toString method because we need to test different board transpose
     */

    public String toString(newTileType[][] board) {
        StringBuilder s = new StringBuilder();
        for (int r=0; r<board.length; r++) {
            for (int c=0; c<board[0].length; c++) {
                s.append(board[r][c]);
            }
            s.append("\n");
        }
        return s.toString();
    }

    /**
     * Convert the String board in the given test to the "Tile" Board
     * @param boardString
     * @return TileTypeBoard[][]
     */

    public static newTileType[][] getGameBoard(String boardString) {
//            if (!RaceToTheRaft.isBoardStringWellFormed(boardString)) {
//                return null;
//            } else {
                String[] lines = boardString.split("\n");

                newTileType[][] gameBoard = new newTileType[lines.length][lines[0].length()];
                for (int row = 0; row < lines.length; row++) {
                    for (int col = 0; col < lines[0].length(); col++) {
                        gameBoard[row][col] = newTileType.fromChar(lines[row].charAt(col));
                    }
                }
                return gameBoard;
            }




        //Pick a board String follow the challenge, from 4 SquareBoard in the Utilities
        // and also from 4 Rectangle Board, this picked board String can be used in getGameBoard
        public String pickBoardString(){
        //here is an example
        return """ 
            fffgygbyr
            fffgygpby
            fffrrbrgp
            fffbgypbr
            fffpbrpgy
            fffyrygyp
            fffgbbrpb
            fffpggbyg
            fffpypgrr
            """;
        }


        public newBoard(String boardString) {
            this.board = getGameBoard(boardString);
            System.out.println("this.board: " + this.board);
            // The number of total Tiles
            //this.totalTilesOnBoard = board.length * board[0].length;
        }

    /**
     * In this part Transpose Board to different orientation
     * @param board
     * @return TileTypeBoard[][]
     */

    public static newTileType[][] transposeBoard(newTileType[][] board) {
            int row = board.length;
            int col = board[0].length;

            newTileType[][] newBoard = new newTileType[col][row];

            for (int i = 0; i < col; i++) {
                for (int j = 0; j < row; j++) {
                    newBoard[i][j] = board[j][i];
                }
            }
            return newBoard;
        }

        public static void swapColumns(newTileType[][] transposedBoard){
            int last = transposedBoard[0].length-1;
            int first = 0;

            while (last > first) {
                for (int i = 0; i < transposedBoard.length;i++) {
                    newTileType temp = transposedBoard[i][first];
                    transposedBoard[i][first] = transposedBoard[i][last];
                    transposedBoard[i][last] = temp;
                }
                last--;
                first++;
            }
        }

        public static newTileType[][] rotate90clockwise(newTileType[][] board){
            newTileType[][] transposedBoard = transposeBoard(board);
            swapColumns(transposedBoard);
            return transposedBoard;
        }






    }