package comp1110.ass2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class testApplyFireTile {
    @Test
    public void testApplyFireTileWestFlipped(){
       Board testBoard = new Board(Utility.SQUARE_BOARDS[0][0]);
       FireTile.applyFireTileOnBoard('l',testBoard,0,5,Boolean.TRUE,Orientation.WEST);
       TileType[][] testArray = testBoard.getBoard();
        Assertions.assertEquals(TileType.Fire,   testArray[0][5]);
        Assertions.assertEquals(TileType.BLUE,   testArray[0][6]);
        Assertions.assertEquals(TileType.YELLOW, testArray[0][7]);
        Assertions.assertEquals(TileType.RED,    testArray[0][8]);
        Assertions.assertEquals(TileType.Fire,   testArray[1][5]);
        Assertions.assertEquals(TileType.Fire,   testArray[1][6]);
        Assertions.assertEquals(TileType.BLUE,   testArray[1][7]);
        Assertions.assertEquals(TileType.YELLOW, testArray[1][8]);
        Assertions.assertEquals(TileType.BLUE,   testArray[2][5]);
        Assertions.assertEquals(TileType.Fire,   testArray[2][6]);
        Assertions.assertEquals(TileType.Fire,   testArray[2][7]);
        Assertions.assertEquals(TileType.PURPLE, testArray[2][8]);
        Assertions.assertEquals(TileType.YELLOW, testArray[3][5]);
        Assertions.assertEquals(TileType.Fire,   testArray[3][6]);
        Assertions.assertEquals(TileType.BLUE,   testArray[3][7]);
        Assertions.assertEquals(TileType.RED,    testArray[3][8]);

    }



    @Test
    public void testApplyFireTileSouthFlipped(){
        Board testBoard = new Board(Utility.SQUARE_BOARDS[0][0]);
        FireTile.applyFireTileOnBoard('l',testBoard,0,5,Boolean.TRUE,Orientation.SOUTH);
        TileType[][] testArray = testBoard.getBoard();
        Assertions.assertEquals(TileType.GREEN,  testArray[0][5]);
        Assertions.assertEquals(TileType.BLUE,   testArray[0][6]);
        Assertions.assertEquals(TileType.Fire,   testArray[0][7]);
        Assertions.assertEquals(TileType.RED,    testArray[0][8]);
        Assertions.assertEquals(TileType.GREEN,   testArray[1][5]);
        Assertions.assertEquals(TileType.Fire,   testArray[1][6]);
        Assertions.assertEquals(TileType.Fire,   testArray[1][7]);
        Assertions.assertEquals(TileType.Fire, testArray[1][8]);
        Assertions.assertEquals(TileType.Fire,   testArray[2][5]);
        Assertions.assertEquals(TileType.Fire,   testArray[2][6]);
        Assertions.assertEquals(TileType.GREEN,   testArray[2][7]);
        Assertions.assertEquals(TileType.PURPLE, testArray[2][8]);
        Assertions.assertEquals(TileType.YELLOW, testArray[3][5]);
        Assertions.assertEquals(TileType.PURPLE, testArray[3][6]);
        Assertions.assertEquals(TileType.BLUE,   testArray[3][7]);
        Assertions.assertEquals(TileType.RED,    testArray[3][8]);

    }

    @Test
    public void testApplyFireTileEastFlipped(){
        Board testBoard = new Board(Utility.SQUARE_BOARDS[0][0]);
        FireTile.applyFireTileOnBoard('l',testBoard,0,5,Boolean.TRUE,Orientation.EAST);
        TileType[][] testArray = testBoard.getBoard();
        Assertions.assertEquals(TileType.GREEN,   testArray[0][5]);
        Assertions.assertEquals(TileType.Fire,   testArray[0][6]);
        Assertions.assertEquals(TileType.YELLOW, testArray[0][7]);
        Assertions.assertEquals(TileType.RED,    testArray[0][8]);
        Assertions.assertEquals(TileType.Fire,   testArray[1][5]);
        Assertions.assertEquals(TileType.Fire,   testArray[1][6]);
        Assertions.assertEquals(TileType.BLUE,   testArray[1][7]);
        Assertions.assertEquals(TileType.YELLOW, testArray[1][8]);
        Assertions.assertEquals(TileType.BLUE,   testArray[2][5]);
        Assertions.assertEquals(TileType.Fire,   testArray[2][6]);
        Assertions.assertEquals(TileType.Fire,   testArray[2][7]);
        Assertions.assertEquals(TileType.PURPLE, testArray[2][8]);
        Assertions.assertEquals(TileType.YELLOW, testArray[3][5]);
        Assertions.assertEquals(TileType.PURPLE,   testArray[3][6]);
        Assertions.assertEquals(TileType.Fire,   testArray[3][7]);
        Assertions.assertEquals(TileType.RED,    testArray[3][8]);

    }
}
//        """
//             fffgy gbyr
//             fffgy gpby
//             fffrr brgp
//             fffbg ypbr
//             fffpbrpgy
//             fffyrygyp
//             fffgbbrpb
//             fffpggbyg
//             fffpypgrr
//             """