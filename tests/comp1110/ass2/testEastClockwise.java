package comp1110.ass2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testEastClockwise {

    @Test
    public void transposeTestUnequal() { // tests for rectangle board
        Tiles[][] test1 = new Tiles[2][3];
        test1[0][0] = Tiles.Fire;
        test1[0][1] = Tiles.RED;
        test1[0][2] = Tiles.BLUE;
        test1[1][0] = Tiles.GREEN;
        test1[1][1] = Tiles.YELLOW;
        test1[1][2] = Tiles.PURPLE;

        Tiles[][] test2 = Board.transposeBoard(test1);
        Assertions.assertEquals(test2[0][0] , Tiles.Fire);
        Assertions.assertEquals(test2[0][1] , Tiles.GREEN);
        Assertions.assertEquals(test2[1][0] , Tiles.RED);
        Assertions.assertEquals(test2[1][1] , Tiles.YELLOW);
        Assertions.assertEquals(test2[2][0] , Tiles.BLUE);
        Assertions.assertEquals(test2[2][1] , Tiles.PURPLE);


    }

    @Test
   public void unequalRotate90clockwiseTest() { //tests for rectangle board
       Tiles[][] test1 = new Tiles[2][3];
       test1[0][0] = Tiles.Fire;
       test1[0][1] = Tiles.RED;
       test1[0][2] = Tiles.BLUE;
       test1[1][0] = Tiles.GREEN;
       test1[1][1] = Tiles.YELLOW;
       test1[1][2] = Tiles.PURPLE;


       Tiles[][] test2 = Board.rotate90clockwise(test1);
       Assertions.assertEquals(test2[0][0] , Tiles.GREEN);
       Assertions.assertEquals(test2[0][1] , Tiles.Fire);
       Assertions.assertEquals(test2[1][0] , Tiles.YELLOW);
       Assertions.assertEquals(test2[1][1] , Tiles.RED);
       Assertions.assertEquals(test2[2][0] , Tiles.PURPLE);
       Assertions.assertEquals(test2[2][1] , Tiles.BLUE);


   }
   @Test
    public void transposeTestEqual() { // tests for square board
        Tiles[][] test1 = new Tiles[2][2];
        test1[0][0] = Tiles.Fire;
        test1[0][1] = Tiles.RED;
        test1[1][0] = Tiles.GREEN;
        test1[1][1] = Tiles.YELLOW;

        Tiles[][] test2 = Board.transposeBoard(test1);
        Assertions.assertEquals(test2[0][0] , Tiles.Fire);
        Assertions.assertEquals(test2[0][1] , Tiles.GREEN);
        Assertions.assertEquals(test2[1][0] , Tiles.RED);
        Assertions.assertEquals(test2[1][1] , Tiles.YELLOW);
    }
    @Test
    public void rotate90ClockwiseEqualTest() { // tests for square board
        Tiles[][] test1 = new Tiles[2][2];
        test1[0][0] = Tiles.Fire;
        test1[0][1] = Tiles.RED;
        test1[1][0] = Tiles.GREEN;
        test1[1][1] = Tiles.YELLOW;

        Tiles[][] test2 = Board.rotate90clockwise(test1);
        Assertions.assertEquals(test2[0][0] , Tiles.GREEN);
        Assertions.assertEquals(test2[0][1] , Tiles.Fire);
        Assertions.assertEquals(test2[1][0] , Tiles.YELLOW);
        Assertions.assertEquals(test2[1][1] , Tiles.RED);
    }

}

// authored by Ishaan Kapoor u7598889