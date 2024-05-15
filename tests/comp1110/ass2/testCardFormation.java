package comp1110.ass2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class testCardFormation {
    @Test
    public void cardFromString() { //tests for rectangle board
        TileType[][] test1 = new TileType[3][3];
        test1[0][0] = TileType.YELLOW;
        test1[0][1] = TileType.YELLOW;
        test1[0][2] = TileType.YELLOW;
        test1[1][0] = TileType.BLUE;
        test1[1][1] = TileType.YELLOW;
        test1[1][2] = TileType.RED;
        test1[2][0] = TileType.BLUE;
        test1[2][1] = TileType.YELLOW;
        test1[2][2] = TileType.RED;

        Cards testCard = new Cards("ayyybyrbyr");
        TileType[][] cardTiles = testCard.getCard();
        Assertions.assertEquals(cardTiles[0][0],test1[0][0]);
        Assertions.assertEquals(cardTiles[0][1],test1[0][1]);
        Assertions.assertEquals(cardTiles[0][2],test1[0][2]);
        Assertions.assertEquals(cardTiles[1][0],test1[1][0]);
        Assertions.assertEquals(cardTiles[1][1],test1[1][1]);
        Assertions.assertEquals(cardTiles[1][2],test1[1][2]);
        Assertions.assertEquals(cardTiles[2][0],test1[2][0]);
        Assertions.assertEquals(cardTiles[2][1],test1[2][1]);
        Assertions.assertEquals(cardTiles[2][2],test1[2][2]);




    }

}
