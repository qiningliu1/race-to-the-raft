package comp1110.ass2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.annotation.processing.SupportedAnnotationTypes;

public class testRotateBoard {
    @Test
    public void testRotateBoardEast() { // tests for rectangle board
        TileType[][] test1 = new TileType[2][3];
        test1[0][0] = TileType.Fire;
        test1[0][1] = TileType.Fire;
        test1[0][2] = TileType.RED;
        test1[1][0] = TileType.GREEN;
        test1[1][1] = TileType.BLUE;
        test1[1][2] = TileType.YELLOW;

        Board eastBoard = Board.rotateBoard(new Board(test1) , Orientation.EAST);
        TileType[][] test2 = eastBoard.getBoard();
        Assertions.assertEquals(test2[0][0] , TileType.GREEN);
        Assertions.assertEquals(test2[0][1] , TileType.Fire);
        Assertions.assertEquals(test2[1][0] , TileType.BLUE);
        Assertions.assertEquals(test2[1][1] , TileType.Fire);
        Assertions.assertEquals(test2[2][0] , TileType.YELLOW);
        Assertions.assertEquals(test2[2][1] , TileType.RED);
    }

    @Test
    public void testRotateBoardWest() { // tests for rectangle board
        TileType[][] test1 = new TileType[2][3];
        test1[0][0] = TileType.Fire;
        test1[0][1] = TileType.Fire;
        test1[0][2] = TileType.RED;
        test1[1][0] = TileType.GREEN;
        test1[1][1] = TileType.BLUE;
        test1[1][2] = TileType.YELLOW;

        Board westBoard = Board.rotateBoard(new Board(test1) , Orientation.WEST);
        TileType[][] test2 = westBoard.getBoard();
        Assertions.assertEquals(test2[0][0] , TileType.RED);
        Assertions.assertEquals(test2[0][1] , TileType.YELLOW);
        Assertions.assertEquals(test2[1][0] , TileType.Fire);
        Assertions.assertEquals(test2[1][1] , TileType.BLUE);
        Assertions.assertEquals(test2[2][0] , TileType.Fire);
        Assertions.assertEquals(test2[2][1] , TileType.GREEN);
    }
    @Test
    public void testRotateBoardSouth() { // tests for rectangle board
        TileType[][] test1 = new TileType[2][3];
        test1[0][0] = TileType.Fire;
        test1[0][1] = TileType.Fire;
        test1[0][2] = TileType.RED;
        test1[1][0] = TileType.GREEN;
        test1[1][1] = TileType.BLUE;
        test1[1][2] = TileType.YELLOW;

        Board westBoard = Board.rotateBoard(new Board(test1) , Orientation.SOUTH);
        TileType[][] test2 = westBoard.getBoard();
        Assertions.assertEquals(test2[0][0] , TileType.YELLOW);
        Assertions.assertEquals(test2[0][1] , TileType.BLUE);
        Assertions.assertEquals(test2[0][2] , TileType.GREEN);
        Assertions.assertEquals(test2[1][0] , TileType.RED);
        Assertions.assertEquals(test2[1][1] , TileType.Fire);
        Assertions.assertEquals(test2[1][2] , TileType.Fire);
    }
@Test
    public void testRotateBoardEastSquare() { // tests for square board
        TileType[][] test1 = new TileType[3][3];
        test1[0][0] = TileType.Fire;
        test1[0][1] = TileType.Fire;
        test1[0][2] = TileType.RED;
        test1[1][0] = TileType.GREEN;
        test1[1][1] = TileType.BLUE;
        test1[1][2] = TileType.YELLOW;
        test1[2][0] = TileType.Fire;
        test1[2][1] = TileType.Fire;
        test1[2][2] = TileType.RED;


        Board westBoard = Board.rotateBoard(new Board(test1) , Orientation.EAST);
        TileType[][] test2 = westBoard.getBoard();
        Assertions.assertEquals(test2[0][0] , TileType.Fire);
        Assertions.assertEquals(test2[0][1] , TileType.GREEN);
        Assertions.assertEquals(test2[0][2] , TileType.Fire);
        Assertions.assertEquals(test2[1][0] , TileType.Fire);
        Assertions.assertEquals(test2[1][1] , TileType.BLUE);
        Assertions.assertEquals(test2[1][2] , TileType.Fire);
        Assertions.assertEquals(test2[2][0] , TileType.RED);
        Assertions.assertEquals(test2[2][1] , TileType.YELLOW);
        Assertions.assertEquals(test2[2][2] , TileType.RED);
    }


    @Test
    public void testRotateBoardSouthSquare() { // tests for square board
        TileType[][] test1 = new TileType[3][3];
        test1[0][0] = TileType.Fire;
        test1[0][1] = TileType.Fire;
        test1[0][2] = TileType.RED;
        test1[1][0] = TileType.GREEN;
        test1[1][1] = TileType.BLUE;
        test1[1][2] = TileType.YELLOW;
        test1[2][0] = TileType.Fire;
        test1[2][1] = TileType.Fire;
        test1[2][2] = TileType.RED;


        Board westBoard = Board.rotateBoard(new Board(test1) , Orientation.SOUTH);
        TileType[][] test2 = westBoard.getBoard();
        Assertions.assertEquals(test2[0][0] , TileType.RED);
        Assertions.assertEquals(test2[0][1] , TileType.Fire);
        Assertions.assertEquals(test2[0][2] , TileType.Fire);
        Assertions.assertEquals(test2[1][0] , TileType.YELLOW);
        Assertions.assertEquals(test2[1][1] , TileType.BLUE);
        Assertions.assertEquals(test2[1][2] , TileType.GREEN);
        Assertions.assertEquals(test2[2][0] , TileType.RED);
        Assertions.assertEquals(test2[2][1] , TileType.Fire);
        Assertions.assertEquals(test2[2][2] , TileType.Fire);
    }





}
