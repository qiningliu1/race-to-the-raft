package comp1110.ass2;

public class Board {

    private Tiles[][] islandBoard;
    private int totalTilesOnBoard;
    public static Tiles[][] getGameBoard(String boardString) {
        String[] lines = boardString.split("\n");

        Tiles[][] gameBoard = new Tiles[lines.length][lines[0].length()];
        for (int row = 0; row < lines.length; row++) {
            for (int col = 0; col < lines[0].length();col++){
                gameBoard[row][col] = Tiles.fromChar(lines[row].charAt(col));
            }
        }

        return gameBoard;
    }

    public Board (String boardString) {
        this.islandBoard = getGameBoard(boardString);
        this.totalTilesOnBoard = islandBoard.length * islandBoard[0].length;
    }
}
