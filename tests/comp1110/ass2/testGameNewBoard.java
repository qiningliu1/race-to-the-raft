package comp1110.ass2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testGameNewBoard {
    @Test
    public void testBoardFromString() { // tests for square board
        String boardString = Utility.SQUARE_BOARDS[0][0];
        Board testBoard = new Board(boardString);
        TileType[][] testArray = testBoard.getBoard();
        assertEquals(TileType.Fire, testArray[0][0]);
        assertEquals(TileType.GREEN, testArray[0][3]);
        assertEquals(TileType.BLUE, testArray[2][5]);
        assertEquals(TileType.GREEN, testArray[8][6]);


    }
}
//"""
//            fffg ygbyr
//            fffgygpby
//            fffrrb rgp
//            fffbgypbr
//            fffpbrpgy
//            fffyrygyp
//            fffgbbrpb
//            fffpggbyg
//            fffpyp grr
//            """
