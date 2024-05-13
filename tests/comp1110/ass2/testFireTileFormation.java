package comp1110.ass2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testFireTileFormation {
    @Test
    public void testFromString(){
        FireTile test = new FireTile("A0002112022");
        TileType[][] testArray = test.getFireTile();
        assertEquals('A', test.getTileID());
        assertEquals(TileType.None, testArray[1][0]);
        assertEquals(TileType.None, testArray[1][2]);
        assertEquals(TileType.Fire, testArray[0][0]);
        assertEquals(TileType.Fire, testArray[0][2]);
        assertEquals(TileType.Fire, testArray[1][1]);
        assertEquals(TileType.Fire, testArray[2][0]);
        assertEquals(TileType.Fire, testArray[2][2]);

    }

    @Test
    public void testFromString2(){
        FireTile test = new FireTile("l000111121322");
        TileType[][] testArray = test.getFireTile();
        assertEquals('l', test.getTileID());
        assertEquals(TileType.Fire, testArray[0][0]);
        assertEquals(TileType.Fire, testArray[0][1]);
        assertEquals(TileType.None, testArray[0][2]);
        assertEquals(TileType.None, testArray[0][3]);
        assertEquals(TileType.None, testArray[1][0]);
        assertEquals(TileType.Fire, testArray[1][1]);
        assertEquals(TileType.Fire, testArray[1][2]);
        assertEquals(TileType.Fire, testArray[1][3]);
        assertEquals(TileType.None, testArray[2][0]);
        assertEquals(TileType.None, testArray[2][1]);
        assertEquals(TileType.Fire, testArray[2][2]);
        assertEquals(TileType.None, testArray[2][3]);
        assertEquals(TileType.None, testArray[3][0]);
        assertEquals(TileType.None, testArray[3][1]);
        assertEquals(TileType.None, testArray[3][2]);
        assertEquals(TileType.None, testArray[3][3]);

    }


    @Test
    public void testInvalid(){
        FireTile test = new FireTile("A00021120221");
        assertEquals('A', test.getTileID());
        assertEquals(test.getFireTile(), null);


    }
}
