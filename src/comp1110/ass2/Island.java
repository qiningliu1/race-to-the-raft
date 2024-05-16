package comp1110.ass2;

/**
 * Author: Ishaan Kapoor u7598889
 **/


import java.util.ArrayList;
import java.util.Random;

public class Island {

    public static final String[] longAnyStrings = {
            Utility.SQUARE_BOARDS[0][1],
            Utility.SQUARE_BOARDS[1][1],
            Utility.SQUARE_BOARDS[2][1],
            Utility.SQUARE_BOARDS[3][1],

    };

    public static final String[] longFireStrings = {
            Utility.SQUARE_BOARDS[0][0],
            Utility.SQUARE_BOARDS[1][0],
            Utility.SQUARE_BOARDS[2][0],
            Utility.SQUARE_BOARDS[3][0],

    };

    public static final String[] shortFireStrings = {
            Utility.RECTANGLE_BOARDS[0][0],
            Utility.RECTANGLE_BOARDS[1][0],
            Utility.RECTANGLE_BOARDS[2][0],
            Utility.RECTANGLE_BOARDS[3][0],

    };
    public static final String[] shortAnyStrings = {
            Utility.RECTANGLE_BOARDS[0][1],
            Utility.RECTANGLE_BOARDS[1][1],
            Utility.RECTANGLE_BOARDS[2][1],
            Utility.RECTANGLE_BOARDS[3][1],

    };

    /**
     * chooses 4 random boards based on  String like LNSNLASA
     * @param boardString string representing the boards needed
     * @return list of boards.
     */
    public static ArrayList<Board> chooseBoardFromString (String[] boardString) {  //string like [SN,LA]

        ArrayList<Board> required = new ArrayList<>();
        ArrayList<Board> longAny = new ArrayList<>(4);
        ArrayList<Board> shortAny = new ArrayList<>(4);
        ArrayList<Board> longFire = new ArrayList<>(4);
        ArrayList<Board> shortFire = new ArrayList<>(4);

        for (String s: Island.longAnyStrings) {
            longAny.add(new Board(s));
        }
        for (String s: Island.longFireStrings) {
            longFire.add(new Board(s));
        }
        for (String s: Island.shortAnyStrings) {
            shortAny.add(new Board(s));
        }
        for (String s: Island.shortFireStrings) {
            shortFire.add(new Board(s));
        }



        Random rand = new Random();

        for (String s: boardString) {
            Board temp = null;

            if (s.charAt(0) == 'S') {
                if (s.charAt(1) == 'A') {
                    temp = shortAny.get(rand.nextInt(0, shortAny.size()));
                    required.add(temp);
                    shortAny.remove(temp);

                } else if (s.charAt(1) == 'N' || s.charAt(1) == 'E' || s.charAt(1) == 'S' || s.charAt(1) == 'W') {
                    temp = shortFire.get(rand.nextInt(0, shortFire.size()));
                    required.add(Board.rotateBoard(temp, Orientation.fromChar(s.charAt(1))));
                    shortFire.remove(temp);
                }
            } else if (s.charAt(0) == 'L') {
                if (s.charAt(1) == 'A') {
                    temp = longAny.get(rand.nextInt(0, longAny.size()));
                    required.add(temp);
                    longAny.remove(temp);

                } else if (s.charAt(1) == 'N' || s.charAt(1) == 'E' || s.charAt(1) == 'S' || s.charAt(1) == 'W') {
                    temp = longFire.get(rand.nextInt(0, longFire.size()));
                    required.add(Board.rotateBoard(temp, Orientation.fromChar(s.charAt(1))));
                    longFire.remove(temp);
                }

            }
        }

        return required;

    }

    /**
     * Author: Ishaan Kapoor u7598889
     * Otputs an initial challenge board, based on the boards that we need as per the challenge string.
     * @param challengeString string representing the initial challenge
     * @return
     */
    public static Board getInitialIsland(String challengeString) {
        String[] challengeArray = challengeString.split("(?=[F,C,R])");
        String[] islandStringArray = challengeArray[0].split("(?=[L,S])");
        ArrayList<Board> requiredBoards = chooseBoardFromString(islandStringArray);
        if (islandStringArray.length == 2) {
            return combine2boards(requiredBoards.get(0) , requiredBoards.get(1));
        } else if (islandStringArray.length == 4) {
            return combine4boards(requiredBoards.get(0) , requiredBoards.get(1), requiredBoards.get(2), requiredBoards.get(3));
        } else {
            return null;
        }
    }


    /**
     * Author: Ishaan Kapoor u7598889
     *
     * combines 2 boards to make a larger board.
     * @param board1
     * @param board2
     * @return the large combined board
     */
    public static Board combine2boards (Board board1, Board board2){
        TileType[][] board1tiles = board1.getBoard();
        TileType[][] board2tiles = board2.getBoard();

        TileType[][] finalBoard = new TileType[board1tiles.length + board2tiles.length][board1tiles[0].length];

       for (int col = 0 ; col < board1tiles[0].length; col++) {
           for (int row = 0; row < board1tiles.length; row++){
               finalBoard[row][col] = board1tiles[row][col];
           }
       }
        for (int col = 0 ; col < board1tiles[0].length; col++) {
            for (int row2 =0; row2 < board2tiles.length; row2++) {
                finalBoard[row2+board1tiles.length][col] = board2tiles[row2][col];
            }
        }
        return new Board(finalBoard);
    }

    /**
     * Author: Ishaan Kapoor u7598889
     *
     * combines 4 boards to make a larger board.
     * @param board1
     * @param board2
     * @param board3
     * @param board4
     * @return the large combined board
     */
    public static Board combine4boards(Board board1, Board board2, Board board3, Board board4) {
        Board boardLeft = combine2boards(board1,board2);
        Board boardRight = combine2boards(board3,board4);

        TileType[][] boardLtiles = boardLeft.getBoard();
        TileType[][] boardRtiles = boardRight.getBoard();

        TileType[][] finalBoard = new TileType[boardLtiles.length][boardLtiles[0].length + boardRtiles[0].length];

        for (int row = 0; row < boardLtiles.length; row++) {
            for (int col = 0; col < boardLtiles[0].length; col++){
                finalBoard[row][col] = boardLtiles[row][col];
            }
        }
        for (int row = 0; row < boardRtiles.length; row++) {
            for (int col = 0; col < boardRtiles[0].length; col++){
                finalBoard[row][col + boardLtiles[0].length] = boardRtiles[row][col];
            }
        }
        return new Board(finalBoard);
    }

    /**
     * Author: Ishaan Kapoor u7598889
     *
     * applies raftCard on the board, as per the given challenge String
     * @param board initial board without raft
     * @param challengeString describing the challenge
     */
    public static void applyRaft(Board board, String challengeString) {
        TileType[][] boardTiles = board.getBoard();

        String[] challengeArray = challengeString.split("(?=[F,C,R])");
        String raftString = challengeArray[3]; //R31203
        int row = Integer.parseInt(raftString.substring(2,4));
        int col = Integer.parseInt(raftString.substring(4,6));

        ArrayList<RaftCards> allRafts = new ArrayList<>();
        for (String s:Utility.RAFT_CARDS) {
            allRafts.add(new RaftCards(s));
        }

        RaftCards req = allRafts.get(Character.getNumericValue(raftString.charAt(1)));
        TileType[][] reqRaftTiles = req.getRaftCard();

        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3 ; j++) {
                boardTiles[row+i][col+j] = reqRaftTiles[i][j];
            }
        }

        board.setBoard(boardTiles);
    }

    /**
     * Author: Ishaan Kapoor u7598889
     *
     * applies fire cards on the board, as per the given challenge String
     * @param board initial board without fire cards
     * @param challengeString describing the challenge
     */
    public static void applyFireCard(Board board, String challengeString) {
        String[] challengeArray = challengeString.split("(?=[F,C,R])");
        String fireString = challengeArray[1];
        int[] locationArray = stringToIntArrayDoubles(fireString.substring(1));
        for (int index =0; index < locationArray.length; index=index+2) {
            applyFire(board,locationArray[index],locationArray[index+1]);
        }

    }
    /**
     * Author: Ishaan Kapoor u7598889
     * applies fire card on the board based on the row and col specified.
     * helper for applyFireCard method.
     */
    public static void applyFire(Board board, int row, int column) {
        TileType[][] boardTiles = board.getBoard();
        for (int i=0; i<3;i++) {
            for(int c=0; c<3;c++ ) {
                boardTiles[row+i][column+c] = TileType.Fire;
            }
        }
        board.setBoard(boardTiles);
    }
    /**
     * Author: Ishaan Kapoor u7598889
     *
     * applies cat cards on the board, as per the given challenge String
     * @param board initial board without cat cards
     * @param challengeString describing the challenge
     */
    public static void applyCatCard(Board board,String challengeString) {
        TileType[][] boardTiles = board.getBoard();
        String[] challengeArray = challengeString.split("(?=[F,C,R])");
        String catString = challengeArray[2].substring(1); //C 0:00,09 3:03,03 4:12,03

        ArrayList<Integer> ids = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        for (int i =0 ; i < catString.length(); i = i + 5) {
            ids.add(Integer.parseInt(catString.substring(i,i+1)));
        }
        for (int i = 1; i < catString.length(); i = i+5) {
            row.add(Integer.parseInt(catString.substring(i,i+2)));
        }
        for (int i = 3; i < catString.length()+1; i = i+5) {
            col.add(Integer.parseInt(catString.substring(i,i+2)));
        }

        for (int index = 0; index < ids.size(); index++) {
            int r = row.get(index);
            int c = col.get(index);
            CatCard req = CatCard.CAT_CARD_OBJECTS[ids.get(index)];

            applyCard(boardTiles,req.getCard(),r,c);
        }

        board.setBoard(boardTiles);
    }

    /**
     *  Author=: Ishaan Kapoor u7598889
     *
     * applies the TilesType in card onot the board
     * @param board tiles of board
     * @param card tiles of card
     * @param row row coordinate of top left card tile.
     * @param col column coordinate of top left card tile.
     */
    public static void applyCard(TileType[][] board, TileType[][] card, Integer row, Integer col) {
        // Iterate over the small matrix
        for (Integer i = 0; i < card.length; i++) {
            for (Integer j = 0; j < card[i].length; j++) {
                // Place each element of the small matrix into the corresponding position in the big matrix
                board[row + i][col + j] = card[i][j];
            }
        }
    }

    public static int[] stringToIntArrayDoubles(String input) {
        // Calculate the length of the result array
        int length = input.length() / 2;
        int[] result = new int[length];

        // Iterate over the input string and extract pairs of characters
        for (int i = 0; i < length; i++) {
            // Parse the pair of characters into an integer and store it in the result array
            result[i] = Integer.parseInt(input.substring(2 * i, 2 * i + 2));
        }

        return result;
    }


}


//    public static int[] stringToIntArrayCombines2(String input) {
//        int[] result = new int[input.length() / 2];
//        for (int i = 0; i < input.length(); i += 2) {
//            String substring = input.substring(i, i + 2);
//            result[i / 2] = Integer.parseInt(substring);
//        }
//        return result;
//    }
//
//    public static int[][] splitIntArray(int[] input) {
//        int[] array1 = new int[input.length / 2];
//        int[] array2 = new int[input.length / 2];
//
//        for (int i = 0; i < input.length; i++) {
//            if (i % 2 == 0) {
//                array1[i / 2] = input[i];
//            } else {
//                array2[i / 2] = input[i];
//            }
//        }
//
//        return new int[][] {array1, array2};
//    }


// ArrayList<String> longAny = new ArrayList<>();
//        ArrayList<String> shortAny = new ArrayList<>();
//        ArrayList<String> longFire = new ArrayList<>();
//        ArrayList<String> shortFire = new ArrayList<>();
//
//        for (int row = 0; row < 4; row++) { //because there are 4 boards in the game
//            longAny.add(Utility.RECTANGLE_BOARDS[row][1]);
//            shortAny.add(Utility.SQUARE_BOARDS[row][1]);
//            longFire.add(Utility.RECTANGLE_BOARDS[row][0]);
//            shortFire.add(Utility.SQUARE_BOARDS[row][0]);
//        }
//
//        Random rand = new Random();
//        ArrayList<Board> required = new ArrayList<>();
//
//        for (String s : boardString) {
//            String temp = null;
//            if (s.charAt(0) == 'L') {
//                if (s.charAt(1) == 'A') {
//                    temp = longAny.get(rand.nextInt(0, longAny.size()));
//                    required.add(new Board(temp));
//                    longAny.remove(temp);
//                } else {
//                    temp = longFire.get(rand.nextInt(0, longFire.size()));
//                    required.add(Board.rotateBoard(new Board(temp), Orientation.fromChar(s.charAt(1))));
//                    longFire.remove(temp);
//                }
//            } else if (s.charAt(0) == 'S') {
//                if (s.charAt(1) == 'A') {
//                    temp = shortAny.get(rand.nextInt(0, shortAny.size()));
//                    required.add(new Board(temp));
//                    shortAny.remove(temp);
//                } else {
//                    temp = shortFire.get(rand.nextInt(0, shortFire.size()));
//                    required.add(Board.rotateBoard(new Board(temp), Orientation.fromChar(s.charAt(1))));
//                    shortFire.remove(temp);
//                }
//            }
//        }
//        return required;
