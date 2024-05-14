package comp1110.ass2;

import org.junit.jupiter.api.Test;

public class testApplyFireTile {
    @Test
    public void testApplyFireTileWestFlipped(){
       Board testBoard = new Board(Utility.SQUARE_BOARDS[0][0]);
       FireTile.applyFireTileOnBoard('l',testBoard,0,5,Boolean.TRUE,Orientation.WEST);
       TileType[][] testArray = testBoard.getBoard();
        assertEquals(TileType.Fire,   testArray[0][5]);
        assertEquals(TileType.BLUE,   testArray[0][6]);
        assertEquals(TileType.YELLOW, testArray[0][7]);
        assertEquals(TileType.RED,    testArray[0][8]);
        assertEquals(TileType.Fire,   testArray[1][5]);
        assertEquals(TileType.Fire,   testArray[1][6]);
        assertEquals(TileType.BLUE,   testArray[1][7]);
        assertEquals(TileType.YELLOW, testArray[1][8]);
        assertEquals(TileType.BLUE,   testArray[2][5]);
        assertEquals(TileType.Fire,   testArray[2][6]);
        assertEquals(TileType.Fire,   testArray[2][7]);
        assertEquals(TileType.PURPLE, testArray[2][8]);
        assertEquals(TileType.YELLOW, testArray[3][5]);
        assertEquals(TileType.Fire,   testArray[3][6]);
        assertEquals(TileType.BLUE,   testArray[3][7]);
        assertEquals(TileType.RED,    testArray[3][8]);

    }

    private void assertEquals(TileType fire, TileType tileType) {
    }

    @Test
    public void testApplyFireTileSouthFlipped(){
        Board testBoard = new Board(Utility.SQUARE_BOARDS[0][0]);
        FireTile.applyFireTileOnBoard('l',testBoard,0,5,Boolean.TRUE,Orientation.SOUTH);
        TileType[][] testArray = testBoard.getBoard();
        assertEquals(TileType.GREEN,  testArray[0][5]);
        assertEquals(TileType.BLUE,   testArray[0][6]);
        assertEquals(TileType.Fire,   testArray[0][7]);
        assertEquals(TileType.RED,    testArray[0][8]);
        assertEquals(TileType.GREEN,   testArray[1][5]);
        assertEquals(TileType.Fire,   testArray[1][6]);
        assertEquals(TileType.Fire,   testArray[1][7]);
        assertEquals(TileType.Fire, testArray[1][8]);
        assertEquals(TileType.Fire,   testArray[2][5]);
        assertEquals(TileType.Fire,   testArray[2][6]);
        assertEquals(TileType.GREEN,   testArray[2][7]);
        assertEquals(TileType.PURPLE, testArray[2][8]);
        assertEquals(TileType.YELLOW, testArray[3][5]);
        assertEquals(TileType.PURPLE, testArray[3][6]);
        assertEquals(TileType.BLUE,   testArray[3][7]);
        assertEquals(TileType.RED,    testArray[3][8]);

    }

    @Test
    public void testApplyFireTileEastFlipped(){
        Board testBoard = new Board(Utility.SQUARE_BOARDS[0][0]);
        FireTile.applyFireTileOnBoard('l',testBoard,0,5,Boolean.TRUE,Orientation.EAST);
        TileType[][] testArray = testBoard.getBoard();
        assertEquals(TileType.GREEN,   testArray[0][5]);
        assertEquals(TileType.Fire,   testArray[0][6]);
        assertEquals(TileType.YELLOW, testArray[0][7]);
        assertEquals(TileType.RED,    testArray[0][8]);
        assertEquals(TileType.Fire,   testArray[1][5]);
        assertEquals(TileType.Fire,   testArray[1][6]);
        assertEquals(TileType.BLUE,   testArray[1][7]);
        assertEquals(TileType.YELLOW, testArray[1][8]);
        assertEquals(TileType.BLUE,   testArray[2][5]);
        assertEquals(TileType.Fire,   testArray[2][6]);
        assertEquals(TileType.Fire,   testArray[2][7]);
        assertEquals(TileType.PURPLE, testArray[2][8]);
        assertEquals(TileType.YELLOW, testArray[3][5]);
        assertEquals(TileType.PURPLE,   testArray[3][6]);
        assertEquals(TileType.Fire,   testArray[3][7]);
        assertEquals(TileType.RED,    testArray[3][8]);

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