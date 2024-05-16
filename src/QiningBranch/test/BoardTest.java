package QiningBranch.test;

import QiningBranch.newBoard;
import QiningBranch.newTileType;
import comp1110.ass2.RaceToTheRaft;
import comp1110.ass2.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static QiningBranch.newBoard.rotate90clockwise;

public class BoardTest {


    public static void main(String[] args) {
        List<newTileType[][]> boardList = new ArrayList<>();
        //Test Board formed based on Utility

        int[][] a = {{1},{2},{3}};
        System.out.println(a.length);

       boolean test1 =RaceToTheRaft.isBoardStringWellFormed(Utility.RECTANGLE_BOARDS[2][0]);
        System.out.println(test1);

        newBoard newBoardTest = new newBoard(Utility.RECTANGLE_BOARDS[2][0]);

        String boardString= newBoardTest.toString(newBoardTest.board);

        System.out.println(boardString);


        newTileType[][] newBoard = newBoardTest.board;

        boardList.add(newBoard);
        System.out.println(newTileType.toString(boardList.get(0)));




        Random random= new Random();

        QiningBranch.newBoard b = new newBoard(""" 
            fffgygbyr
            fffgygpby
            fffrrbrgp
            fffbgypbr
            fffpbrpgy
            fffyrygyp
            fffgbbrpb
            fffpggbyg
            fffpypgrr
            """);
        b.toString(b.board);
        // Regular Board
        System.out.println(b.toString(b.board));
        // Transpose Board
        //System.out.println(b.toString(transposeBoard(b.board)));



        //Test rotate 90 degree
        b.board=rotate90clockwise(b.board);
        System.out.println(b.toString(b.board));



    }
}
