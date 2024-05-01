package comp1110.ass2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author: Lujin Sun u789414
 **/

@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
public class TilesTest {
    @Test
    public void testFromChar_ValidChars(){
        assertEquals(TileType.BLUE, TileType.fromChar('b'));
        assertEquals(TileType.GREEN, TileType.fromChar('g'));
        assertEquals(TileType.RED, TileType.fromChar('r'));
        assertEquals(TileType.YELLOW, TileType.fromChar('y'));
        assertEquals(TileType.PURPLE, TileType.fromChar('p'));
        assertEquals(TileType.Fire, TileType.fromChar('f'));
        assertEquals(TileType.WILD, TileType.fromChar('w'));
        assertEquals(TileType.Object, TileType.fromChar('o'));
        assertEquals(TileType.None, TileType.fromChar('x')); // Assuming 'x' represents an invalid char
    }

    @Test
    public void testFromChar_InvalidChar() {
        assertEquals(TileType.None, TileType.fromChar('z')); // Assuming 'z' is an invalid char
    }

    @Test
    public void testToChar() {
        assertEquals('b', TileType.BLUE.toChar());
        assertEquals('g', TileType.GREEN.toChar());
        assertEquals('r', TileType.RED.toChar());
        assertEquals('y', TileType.YELLOW.toChar());
        assertEquals('p', TileType.PURPLE.toChar());
        assertEquals('f', TileType.Fire.toChar());
        assertEquals('w', TileType.WILD.toChar());
        assertEquals('o', TileType.Object.toChar());
        assertEquals('x', TileType.None.toChar()); // Assuming 'x' is the default char for invalid enum constant
        
    }

}
