package comp1110.ass2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testPlaceFireTileOnNewBoard {
    @Test
    public void testSquareBoard() { // tests for square board
        String[] gameState = new String[5];
        gameState[0] = Utility.SQUARE_BOARDS[0][0];
        gameState[1] = "AabcdBCfghDafh";
        gameState[2] = "AfhkBCDahw";
        gameState[3] = "B0204G1300";
        gameState[4] = "abcdefghijklmnopqrstuvwxyzABCDE";

//        String updated = FireTile.placeFireTileOnBoard(gameState,"l0003FW");
//        Assertions.assertEquals(updated, gameState[0]);
    }
}

