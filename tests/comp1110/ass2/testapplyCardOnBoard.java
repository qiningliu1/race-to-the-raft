package comp1110.ass2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class testApplyCardOnBoard {

    @Test
    public void testSquareBoard() { // tests for square board
        TileType[][] test1 = new TileType[4][4];
        test1[0][0] = TileType.Fire;
        test1[0][1] = TileType.RED;
        test1[0][2] = TileType.GREEN;
        test1[0][3] = TileType.BLUE;
        test1[1][0] = TileType.YELLOW;
        test1[1][1] = TileType.BLUE;
        test1[1][2] = TileType.PURPLE;
        test1[1][3] = TileType.GREEN;
        test1[2][0] = TileType.GREEN;
        test1[2][1] = TileType.RED;
        test1[2][2] = TileType.RED;
        test1[2][3] = TileType.PURPLE;
        test1[3][0] = TileType.PURPLE;
        test1[3][1] = TileType.PURPLE;
        test1[3][2] = TileType.RED;
        test1[3][3] = TileType.Fire;

        TileType[][] card = new TileType[3][3];
        card[0][0] = TileType.Fire;
        card[0][1] = TileType.RED;
        card[0][2] = TileType.GREEN;
        card[1][0] = TileType.YELLOW;
        card[1][1] = TileType.Fire;
        card[1][2] = TileType.BLUE;
        card[2][0] = TileType.PURPLE;
        card[2][1] = TileType.RED;
        card[2][2] = TileType.PURPLE;

        Board board = new Board(test1);
        Cards cards = new Cards('A',card);
        Board.applyCardOnBoard(board,cards,1,1,Orientation.EAST);
        TileType[][] test2 = board.getBoard();
        Assertions.assertEquals(test2[1][1] , TileType.PURPLE);
        Assertions.assertEquals(test2[1][2] , TileType.YELLOW);
        Assertions.assertEquals(test2[1][3] , TileType.Fire);
        Assertions.assertEquals(test2[2][1] , TileType.RED);
        Assertions.assertEquals(test2[2][2] , TileType.Fire);
        Assertions.assertEquals(test2[2][3] , TileType.RED);
        Assertions.assertEquals(test2[3][1] , TileType.PURPLE);
        Assertions.assertEquals(test2[3][2] , TileType.BLUE);
        Assertions.assertEquals(test2[3][3] , TileType.GREEN);
    }
}
