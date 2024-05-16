package comp1110.ass2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testFlipFireTile {

    @Test
    public void testFlipNorth(){
        FireTile test1 = new FireTile("l000111121322");
        FireTile test = FireTile.rotateFireTile(test1, Orientation.NORTH);
        TileType[][] testArray = test.getFireTile();
        FireTile.flipFireTileNorthSouth(testArray);
        assertEquals(TileType.None, testArray[0][0]);
        assertEquals(TileType.None, testArray[0][1]);
        assertEquals(TileType.Fire, testArray[0][2]);
        assertEquals(TileType.Fire, testArray[0][3]);
        assertEquals(TileType.Fire, testArray[1][0]);
        assertEquals(TileType.Fire, testArray[1][1]);
        assertEquals(TileType.Fire, testArray[1][2]);
        assertEquals(TileType.None, testArray[1][3]);
        assertEquals(TileType.None, testArray[2][0]);
        assertEquals(TileType.Fire, testArray[2][1]);
        assertEquals(TileType.None, testArray[2][2]);
        assertEquals(TileType.None, testArray[2][3]);
        assertEquals(TileType.None, testArray[3][0]);
        assertEquals(TileType.None, testArray[3][1]);
        assertEquals(TileType.None, testArray[3][2]);
        assertEquals(TileType.None, testArray[3][3]);
    }
    @Test
    public void testFlipWest(){
        FireTile test1 = new FireTile("l000111121322");
        FireTile test = FireTile.rotateFireTile(test1, Orientation.WEST);
        TileType[][] testArray = test.getFireTile();
        FireTile.flipFireTileEastWest(testArray);
        assertEquals(TileType.Fire, testArray[0][0]);
        assertEquals(TileType.None, testArray[0][1]);
        assertEquals(TileType.None, testArray[0][2]);
        assertEquals(TileType.None, testArray[0][3]);
        assertEquals(TileType.Fire, testArray[1][0]);
        assertEquals(TileType.Fire, testArray[1][1]);
        assertEquals(TileType.None, testArray[1][2]);
        assertEquals(TileType.None, testArray[1][3]);
        assertEquals(TileType.None, testArray[2][0]);
        assertEquals(TileType.Fire, testArray[2][1]);
        assertEquals(TileType.Fire, testArray[2][2]);
        assertEquals(TileType.None, testArray[2][3]);
        assertEquals(TileType.None, testArray[3][0]);
        assertEquals(TileType.Fire, testArray[3][1]);
        assertEquals(TileType.None, testArray[3][2]);
        assertEquals(TileType.None, testArray[3][3]);
    }
    @Test
    public void testFlipSouth(){
        FireTile test1 = new FireTile("l000111121322");
        FireTile test = FireTile.rotateFireTile(test1, Orientation.SOUTH);
        TileType[][] testArray = test.getFireTile();
        FireTile.flipFireTileNorthSouth(testArray);
        assertEquals(TileType.None, testArray[0][0]);
        assertEquals(TileType.None, testArray[0][1]);
        assertEquals(TileType.Fire, testArray[0][2]);
        assertEquals(TileType.None, testArray[0][3]);
        assertEquals(TileType.None, testArray[1][0]);
        assertEquals(TileType.Fire, testArray[1][1]);
        assertEquals(TileType.Fire, testArray[1][2]);
        assertEquals(TileType.Fire, testArray[1][3]);
        assertEquals(TileType.Fire, testArray[2][0]);
        assertEquals(TileType.Fire, testArray[2][1]);
        assertEquals(TileType.None, testArray[2][2]);
        assertEquals(TileType.None, testArray[2][3]);
        assertEquals(TileType.None, testArray[3][0]);
        assertEquals(TileType.None, testArray[3][1]);
        assertEquals(TileType.None, testArray[3][2]);
        assertEquals(TileType.None, testArray[3][3]);
    }

    @Test
    public void testFlipEast(){
        FireTile test1 = new FireTile("l000111121322");
        FireTile test = FireTile.rotateFireTile(test1, Orientation.EAST);
        TileType[][] testArray = test.getFireTile();
        FireTile.flipFireTileEastWest(testArray);
        assertEquals(TileType.None, testArray[0][0]);
        assertEquals(TileType.Fire, testArray[0][1]);
        assertEquals(TileType.None, testArray[0][2]);
        assertEquals(TileType.None, testArray[0][3]);
        assertEquals(TileType.Fire, testArray[1][0]);
        assertEquals(TileType.Fire, testArray[1][1]);
        assertEquals(TileType.None, testArray[1][2]);
        assertEquals(TileType.None, testArray[1][3]);
        assertEquals(TileType.None, testArray[2][0]);
        assertEquals(TileType.Fire, testArray[2][1]);
        assertEquals(TileType.Fire, testArray[2][2]);
        assertEquals(TileType.None, testArray[2][3]);
        assertEquals(TileType.None, testArray[3][0]);
        assertEquals(TileType.None, testArray[3][1]);
        assertEquals(TileType.Fire, testArray[3][2]);
        assertEquals(TileType.None, testArray[3][3]);
    }
}
