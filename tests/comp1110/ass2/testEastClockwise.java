package comp1110.ass2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Author: Ishaan Kapoor u7598889
 */
public class testEastClockwise {

    @Test
    public void transposeTestUnequal() { // tests for rectangle board
        TileType[][] test1 = new TileType[2][3];
        test1[0][0] = TileType.Fire;
        test1[0][1] = TileType.RED;
        test1[0][2] = TileType.BLUE;
        test1[1][0] = TileType.GREEN;
        test1[1][1] = TileType.YELLOW;
        test1[1][2] = TileType.PURPLE;

        TileType[][] test2 = Board.transposeBoard(test1);
        Assertions.assertEquals(test2[0][0] , TileType.Fire);
        Assertions.assertEquals(test2[0][1] , TileType.GREEN);
        Assertions.assertEquals(test2[1][0] , TileType.RED);
        Assertions.assertEquals(test2[1][1] , TileType.YELLOW);
        Assertions.assertEquals(test2[2][0] , TileType.BLUE);
        Assertions.assertEquals(test2[2][1] , TileType.PURPLE);


    }

    @Test
   public void unequalRotate90clockwiseTest() { //tests for rectangle board
       TileType[][] test1 = new TileType[2][3];
       test1[0][0] = TileType.Fire;
       test1[0][1] = TileType.RED;
       test1[0][2] = TileType.BLUE;
       test1[1][0] = TileType.GREEN;
       test1[1][1] = TileType.YELLOW;
       test1[1][2] = TileType.PURPLE;


       TileType[][] test2 = Board.rotate90clockwise(test1);
       Assertions.assertEquals(test2[0][0] , TileType.GREEN);
       Assertions.assertEquals(test2[0][1] , TileType.Fire);
       Assertions.assertEquals(test2[1][0] , TileType.YELLOW);
       Assertions.assertEquals(test2[1][1] , TileType.RED);
       Assertions.assertEquals(test2[2][0] , TileType.PURPLE);
       Assertions.assertEquals(test2[2][1] , TileType.BLUE);


   }
   @Test
    public void transposeTestEqual() { // tests for square board
        TileType[][] test1 = new TileType[2][2];
        test1[0][0] = TileType.Fire;
        test1[0][1] = TileType.RED;
        test1[1][0] = TileType.GREEN;
        test1[1][1] = TileType.YELLOW;

        TileType[][] test2 = Board.transposeBoard(test1);
        Assertions.assertEquals(test2[0][0] , TileType.Fire);
        Assertions.assertEquals(test2[0][1] , TileType.GREEN);
        Assertions.assertEquals(test2[1][0] , TileType.RED);
        Assertions.assertEquals(test2[1][1] , TileType.YELLOW);
    }
    @Test
    public void rotate90ClockwiseEqualTest() { // tests for square board
        TileType[][] test1 = new TileType[2][2];
        test1[0][0] = TileType.Fire;
        test1[0][1] = TileType.RED;
        test1[1][0] = TileType.GREEN;
        test1[1][1] = TileType.YELLOW;

        TileType[][] test2 = Board.rotate90clockwise(test1);
        Assertions.assertEquals(test2[0][0] , TileType.GREEN);
        Assertions.assertEquals(test2[0][1] , TileType.Fire);
        Assertions.assertEquals(test2[1][0] , TileType.YELLOW);
        Assertions.assertEquals(test2[1][1] , TileType.RED);
    }

}

// authored by Ishaan Kapoor u7598889