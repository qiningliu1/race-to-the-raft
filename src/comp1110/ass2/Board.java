package comp1110.ass2;

// we store boards as TileType[][] which tells us where each tile is based on coordinates

import java.util.ArrayList;

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
    public static void applyCardOnBoard(Board board, Cards card, int row, int column, Orientation orientation) {
        TileType[][] boardTiles = board.getBoard();
        TileType[][] cardTiles = Cards.rotateCard(card,orientation).getCard();

        for (int i = 0; i < cardTiles.length; i++) {
            for (int j =0; j< cardTiles[0].length; j++) {
                boardTiles[row+i][column+j] = cardTiles[i][j];
            }
        }

        board.setBoard(boardTiles);

    }


    public static String placeCardOnBoard(String[] gameState, String placementString) {
        GameState game = new GameState(gameState);
        Board gameBoardInitial = new Board(gameState[0]);
        Decks handInitial = game.getHand();

        Decks.DECK_ID req = Decks.SingleDeck.charToID(placementString.charAt(0));

        int deckIndex = 0;
        deckIndex = switch (req) { //choose which singledeck we need
            case A -> 0;
            case B -> 1;
            case C -> 2;
            case D -> 3;
        };

        Decks.SingleDeck requiredHandDeck = handInitial.getFulldeck().get(deckIndex);
        ArrayList<Cards> requiredCards = requiredHandDeck.getCards();   //cards of the single deck that we need
        Cards requiredCard = null;   //the card that we need

        for (Cards c: requiredCards) {
            if (c.getID() == placementString.charAt(1)) {
                requiredCard = c;
                requiredCards.remove(c); //remove the card from the single deck
            }
        }

        ArrayList<Decks.SingleDeck> singleDecks = handInitial.getFulldeck(); //list of singledecks in hand
        singleDecks.set(deckIndex,new Decks.SingleDeck(req,requiredCards)); // reset the single deck using the deck id and list of cards

        game.setHand(new Decks(singleDecks)); //hand set to new
        Board.applyCardOnBoard(gameBoardInitial, requiredCard, Integer.parseInt(placementString.substring(2,3)) , Integer.parseInt(placementString.substring(4,5)) , Orientation.fromChar(placementString.charAt(6)));

        StringBuilder f = new StringBuilder("");

        for (int i =0; i < gameBoardInitial.getBoard().length; i++) {
            for (int j = 0; j < gameBoardInitial.getBoard()[0].length; j++) {
                f.append(gameBoardInitial.getBoard()[i][j]);
            }
        }

        return f.toString();


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
}







