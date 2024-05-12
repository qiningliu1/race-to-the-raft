package comp1110.ass2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Island {

    private Board island;


    public static Board getInitialIsland(String challengeString) {
        String[] challengeArray = challengeString.split("(?=[F,C,R])");
        String[] islandStringArray = challengeArray[0].split("(?=[L,S])");

        Random rand = new Random();
        int boardSelector1 = rand.nextInt(0,3); //select a random board for location 1
        int boardSelector2 = rand.nextInt(0,3); //select a random board for location 2
        int boardSelector3 = rand.nextInt(0,3); //select a random board for location 3
        int boardSelector4 = rand.nextInt(0,3); //select a random board for location 4

        ArrayList<Board> boardsForIsland = new ArrayList<>(4);

        if (islandStringArray[0].charAt(0) == 'L') {
            if (islandStringArray[0].charAt(1) == 'A') {
                boardsForIsland.add(new Board(Utility.RECTANGLE_BOARDS[boardSelector1][1]));
            } else {
                boardsForIsland.add(new Board(Utility.RECTANGLE_BOARDS[boardSelector1][0]));
            }
            } else {
            if (islandStringArray[0].charAt(1) == 'A') {
                boardsForIsland.add(new Board(Utility.SQUARE_BOARDS[boardSelector1][1]));
            } else {
                boardsForIsland.add(new Board(Utility.SQUARE_BOARDS[boardSelector1][0]));
            }
        }

        if (islandStringArray[1].charAt(0) == 'L') {
            if (islandStringArray[1].charAt(1) == 'A') {
                boardsForIsland.add(new Board(Utility.RECTANGLE_BOARDS[boardSelector2][1]));
            } else {
                boardsForIsland.add(new Board(Utility.RECTANGLE_BOARDS[boardSelector2][0]));
            }
        } else {
            if (islandStringArray[1].charAt(1) == 'A') {
                boardsForIsland.add(new Board(Utility.SQUARE_BOARDS[boardSelector2][1]));
            } else {
                boardsForIsland.add(new Board(Utility.SQUARE_BOARDS[boardSelector2][0]));
            }
        }

        if (islandStringArray[2].charAt(0) == 'L') {
            if (islandStringArray[2].charAt(1) == 'A') {
                boardsForIsland.add(new Board(Utility.RECTANGLE_BOARDS[boardSelector3][1]));
            } else {
                boardsForIsland.add(new Board(Utility.RECTANGLE_BOARDS[boardSelector3][0]));
            }
        } else {
            if (islandStringArray[2].charAt(1) == 'A') {
                boardsForIsland.add(new Board(Utility.SQUARE_BOARDS[boardSelector3][1]));
            } else {
                boardsForIsland.add(new Board(Utility.SQUARE_BOARDS[boardSelector3][0]));
            }
        }

        if (islandStringArray[3].charAt(0) == 'L') {
            if (islandStringArray[3].charAt(1) == 'A') {
                boardsForIsland.add(new Board(Utility.RECTANGLE_BOARDS[boardSelector4][1]));
            } else {
                boardsForIsland.add(new Board(Utility.RECTANGLE_BOARDS[boardSelector4][0]));
            }
        } else {
            if (islandStringArray[3].charAt(1) == 'A') {
                boardsForIsland.add(new Board(Utility.SQUARE_BOARDS[boardSelector4][1]));
            } else {
                boardsForIsland.add(new Board(Utility.SQUARE_BOARDS[boardSelector4][0]));
            }
        }

        Orientation board1Orientation = Orientation.fromChar(islandStringArray[0].charAt(1));
        Orientation board2Orientation = Orientation.fromChar(islandStringArray[1].charAt(1));
        Orientation board3Orientation = Orientation.fromChar(islandStringArray[2].charAt(1));
        Orientation board4Orientation = Orientation.fromChar(islandStringArray[3].charAt(1));

        boardsForIsland.set(0,Board.rotateBoard(boardsForIsland.get(0),board1Orientation));
        boardsForIsland.set(1,Board.rotateBoard(boardsForIsland.get(1),board2Orientation));
        boardsForIsland.set(2,Board.rotateBoard(boardsForIsland.get(2),board3Orientation));
        boardsForIsland.set(3,Board.rotateBoard(boardsForIsland.get(3),board4Orientation));

        int islandLength = boardsForIsland.get(0).getBoard().length + boardsForIsland.get(1).getBoard().length;
        int islandWidth = boardsForIsland.get(0).getBoard()[0].length + boardsForIsland.get(2).getBoard()[0].length;

        TileType[][] islandBoardTiles = new TileType[islandLength][islandWidth];

        TileType[][] board1Tiles = boardsForIsland.get(0).getBoard();
        TileType[][] board2Tiles = boardsForIsland.get(1).getBoard();
        TileType[][] board3Tiles = boardsForIsland.get(2).getBoard();
        TileType[][] board4Tiles = boardsForIsland.get(3).getBoard();


        for (int b1=0 ; b1 < board1Tiles[0].length; b1++) {

        }











//"LNSNLASAF00030006030306030606060909030906C000123000940015R31203"



        return null;
    }
}
