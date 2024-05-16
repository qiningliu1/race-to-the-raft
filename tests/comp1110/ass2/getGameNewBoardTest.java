package comp1110.ass2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;
@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
/**
 * Author: Ishaan Kapoor u7598889
 */

public class getGameNewBoardTest {
    private String wellFormedboardString = """
            fffffffffffffffrrf
            fffffffffbbbfffrRf
            fffffffffbbbfffrrf
            ffffffyfffypfffpbr
            ffffffffffgffbrpgy
            ffffffbfffffyrygyp
            ffffppgyybbbbybrpb
            ffffppppyyggbygbyg
            ffffppppPbbgbbpgrr
            ffffffffgbyyybgbbp
            fffffffbybpybbpryg
            fffffffrfrgyybgyby
            fffffffyppryyBpprp
            fffbBbygggbprygbow
            fffbbbbryygbygybyg
            """;
    private String notWellFormed = """
            fff
            ffd
            g
            o
            w""";
    private TileType[][] boardTiles = Board.getGameBoard(wellFormedboardString);

    @Test
    public void testWellFormed() {
        Assertions.assertEquals(TileType.Fire, boardTiles[0][0]);
        Assertions.assertEquals(TileType.Fire, boardTiles[2][5]);
        Assertions.assertEquals(TileType.BLUE, boardTiles[14][11]);
        Assertions.assertEquals(TileType.PURPLE, boardTiles[8][7]);

    }
}



// this test was developed by Ishaan U7598889