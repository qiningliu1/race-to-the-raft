package comp1110.ass2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;
@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)

public class getGameBoardTest {
    private String wellFormedboardString = """ 
            fffgygbyr
            fffgygpby
            fffrrbrgp
            fffbgypbr
            fffpbrpgy
            fffyrygyp
            fffgbbrpb
            fffpggbyg
            fffpypgrr
            """;
    private Tiles[][] boardTiles = Board.getGameBoard(wellFormedboardString);

    @Test
    public void testWellFormed() {
        Assertions.assertEquals(Tiles.Fire, boardTiles[0][0]);
        Assertions.assertEquals(Tiles.BLUE, boardTiles[2][5]);
        Assertions.assertEquals(Tiles.GREEN, boardTiles[1][3]);
        Assertions.assertEquals(Tiles.RED, boardTiles[8][7]);

    }
}

// this test was developed by Ishaan U7598889