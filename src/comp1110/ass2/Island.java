package comp1110.ass2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Island {

    private Board island;


    public static Board getInitialIsland(String challengeString) {
        String[] challengeArray = challengeString.split("(?=[F,C,R])");
        String[] islandStringArray = challengeArray[0].split("(?=[L,S])");

        if (islandStringArray.length == 4) {

        } else if (islandStringArray.length == 2) {

        }


        return null;
    }














    public static void applyFireTiles(Board board, String challengeString) {
        TileType[][] boardTiles = board.getBoard();

        String[] challengeArray = challengeString.split("(?=[F,C,R])");
        String fireString = challengeArray[1];
        int[] rowLocations = splitIntArray(stringToIntArrayCombines2(fireString.substring(1)))[0];
        int[] colLocations = splitIntArray(stringToIntArrayCombines2(fireString.substring(1)))[1];


        for (int row: rowLocations) {
            for (int col : colLocations) {
                boardTiles[row][col] = TileType.Fire;
            }
        }

        board.setBoard(boardTiles);
    }

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












    public static int[] stringToIntArrayCombines2(String input) {
        int[] result = new int[input.length() / 2];
        for (int i = 0; i < input.length(); i += 2) {
            String substring = input.substring(i, i + 2);
            result[i / 2] = Integer.parseInt(substring);
        }
        return result;
    }

    public static int[][] splitIntArray(int[] input) {
        int[] array1 = new int[input.length / 2];
        int[] array2 = new int[input.length / 2];

        for (int i = 0; i < input.length; i++) {
            if (i % 2 == 0) {
                array1[i / 2] = input[i];
            } else {
                array2[i / 2] = input[i];
            }
        }

        return new int[][] {array1, array2};
    }
}

//    Random rand = new Random();
//    int boardSelector1 = rand.nextInt(0,3); //select a random board for location 1
//    int boardSelector2 = rand.nextInt(0,3); //select a random board for location 2
//    int boardSelector3 = rand.nextInt(0,3); //select a random board for location 3
//    int boardSelector4 = rand.nextInt(0,3); //select a random board for location 4
//
//    ArrayList<Board> boardsForIsland = new ArrayList<>(4);
//
//        if (islandStringArray[0].charAt(0) == 'L') {
//                if (islandStringArray[0].charAt(1) == 'A') {
//                boardsForIsland.add(new Board(Utility.RECTANGLE_BOARDS[boardSelector1][1]));
//                } else {
//                boardsForIsland.add(new Board(Utility.RECTANGLE_BOARDS[boardSelector1][0]));
//                }
//                } else {
//                if (islandStringArray[0].charAt(1) == 'A') {
//                boardsForIsland.add(new Board(Utility.SQUARE_BOARDS[boardSelector1][1]));
//                } else {
//                boardsForIsland.add(new Board(Utility.SQUARE_BOARDS[boardSelector1][0]));
//                }
//                }
//
//                if (islandStringArray[1].charAt(0) == 'L') {
//                if (islandStringArray[1].charAt(1) == 'A') {
//                boardsForIsland.add(new Board(Utility.RECTANGLE_BOARDS[boardSelector2][1]));
//                } else {
//                boardsForIsland.add(new Board(Utility.RECTANGLE_BOARDS[boardSelector2][0]));
//                }
//                } else {
//                if (islandStringArray[1].charAt(1) == 'A') {
//                boardsForIsland.add(new Board(Utility.SQUARE_BOARDS[boardSelector2][1]));
//                } else {
//                boardsForIsland.add(new Board(Utility.SQUARE_BOARDS[boardSelector2][0]));
//                }
//                }
//
//                if (islandStringArray[2].charAt(0) == 'L') {
//                if (islandStringArray[2].charAt(1) == 'A') {
//                boardsForIsland.add(new Board(Utility.RECTANGLE_BOARDS[boardSelector3][1]));
//                } else {
//                boardsForIsland.add(new Board(Utility.RECTANGLE_BOARDS[boardSelector3][0]));
//                }
//                } else {
//                if (islandStringArray[2].charAt(1) == 'A') {
//                boardsForIsland.add(new Board(Utility.SQUARE_BOARDS[boardSelector3][1]));
//                } else {
//                boardsForIsland.add(new Board(Utility.SQUARE_BOARDS[boardSelector3][0]));
//                }
//                }
//
//                if (islandStringArray[3].charAt(0) == 'L') {
//                if (islandStringArray[3].charAt(1) == 'A') {
//                boardsForIsland.add(new Board(Utility.RECTANGLE_BOARDS[boardSelector4][1]));
//                } else {
//                boardsForIsland.add(new Board(Utility.RECTANGLE_BOARDS[boardSelector4][0]));
//                }
//                } else {
//                if (islandStringArray[3].charAt(1) == 'A') {
//                boardsForIsland.add(new Board(Utility.SQUARE_BOARDS[boardSelector4][1]));
//                } else {
//                boardsForIsland.add(new Board(Utility.SQUARE_BOARDS[boardSelector4][0]));
//                }
//                }
//
//                Orientation board1Orientation = Orientation.fromChar(islandStringArray[0].charAt(1));
//                Orientation board2Orientation = Orientation.fromChar(islandStringArray[1].charAt(1));
//                Orientation board3Orientation = Orientation.fromChar(islandStringArray[2].charAt(1));
//                Orientation board4Orientation = Orientation.fromChar(islandStringArray[3].charAt(1));
//
//                boardsForIsland.set(0,Board.rotateBoard(boardsForIsland.get(0),board1Orientation));
//                boardsForIsland.set(1,Board.rotateBoard(boardsForIsland.get(1),board2Orientation));
//                boardsForIsland.set(2,Board.rotateBoard(boardsForIsland.get(2),board3Orientation));
//                boardsForIsland.set(3,Board.rotateBoard(boardsForIsland.get(3),board4Orientation));
//
//                int islandLength = boardsForIsland.get(0).getBoard().length + boardsForIsland.get(1).getBoard().length;
//                int islandWidth = boardsForIsland.get(0).getBoard()[0].length + boardsForIsland.get(2).getBoard()[0].length;
//
//                TileType[][] islandBoardTiles = new TileType[islandLength][islandWidth];
//
//                TileType[][] board1Tiles = boardsForIsland.get(0).getBoard();
//                TileType[][] board2Tiles = boardsForIsland.get(1).getBoard();
//                TileType[][] board3Tiles = boardsForIsland.get(2).getBoard();
//                TileType[][] board4Tiles = boardsForIsland.get(3).getBoard();
//
//
//                for (int row1=0 ; row1 < board1Tiles.length; row1++) {
//        for(int col1 = 0; col1 < board1Tiles[0].length; col1++) {
//        islandBoardTiles[row1][col1] = board1Tiles[row1][col1];
//        }
//        }
//
//        for (int row2=0 ; row2 < board2Tiles.length; row2++) {
//        for (int col2 = 0; col2 < board2Tiles[0].length; col2++) {
//        islandBoardTiles[board1Tiles.length+row2][col2] = board2Tiles[row2][col2];
//        }
//        }
//
//        for (int row3=0 ; row3 < board2Tiles.length; row3++) {
//        for (int col3 = 0; col3 < board2Tiles[0].length; col3++) {
//        islandBoardTiles[row3][board1Tiles[0].length + col3] = board3Tiles[row3][col3];
//        }
//        }
//
//        for (int row4=0 ; row4 < board2Tiles.length; row4++) {
//        for (int col4 = 0; col4 < board2Tiles[0].length; col4++) {
//        islandBoardTiles[board1Tiles.length+row4][board1Tiles[0].length + col4] = board4Tiles[row4][col4];
//        }
//        }
//
////"LNSNLASAF00030006030306030606060909030906C000123000940015R31203"
//
//        return new Board(islandBoardTiles);

