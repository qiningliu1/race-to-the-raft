package comp1110.ass2;
import comp1110.ass2.CatCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CatCardTests {
    private String[] allPossibleCatCardStrings = Utility.CAT_CARDS;
@Test
    public void testCatCardFromString() {
        String catString = allPossibleCatCardStrings[3]; //"3gffgGfggg",
        Tiles[][] test1 = new Tiles[3][3];
        test1[0][0] = Tiles.GREEN;
        test1[0][1] = Tiles.Fire;
        test1[0][2] = Tiles.Fire;
        test1[1][0] = Tiles.GREEN;
        test1[1][1] = Tiles.GREEN_CAT;
        test1[1][2] = Tiles.Fire;
        test1[2][0] = Tiles.GREEN;
        test1[2][1] = Tiles.GREEN;
        test1[2][2] = Tiles.GREEN;

        CatCard test = new CatCard(catString);
        CatCard actual = new CatCard(3,test1);
        Assertions.assertEquals(test.getID(),actual.getID());
        Assertions.assertEquals(test.getCatCard()[0][0],actual.getCatCard()[0][0]);

    }
}
