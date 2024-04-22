package comp1110.ass2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

//u7897414 + Lujin Sun

@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
public class TilesTest {
    @Test
    public void testFromChar_ValidChars(){
        assertEquals(Tiles.BLUE, Tiles.fromChar('b'));
        assertEquals(Tiles.GREEN, Tiles.fromChar('g'));
        assertEquals(Tiles.RED, Tiles.fromChar('r'));
        assertEquals(Tiles.YELLOW, Tiles.fromChar('y'));
        assertEquals(Tiles.PURPLE, Tiles.fromChar('p'));
        assertEquals(Tiles.Fire, Tiles.fromChar('f'));
        assertEquals(Tiles.WILD, Tiles.fromChar('w'));
        assertEquals(Tiles.Object, Tiles.fromChar('o'));
        assertEquals(Tiles.None, Tiles.fromChar('x')); // Assuming 'x' represents an invalid char
    }

    @Test
    public void testFromChar_InvalidChar() {
        assertEquals(Tiles.None, Tiles.fromChar('z')); // Assuming 'z' is an invalid char
    }

    @Test
    public void testToChar() {
        assertEquals('b', Tiles.BLUE.toChar());
        assertEquals('g', Tiles.GREEN.toChar());
        assertEquals('r', Tiles.RED.toChar());
        assertEquals('y', Tiles.YELLOW.toChar());
        assertEquals('p', Tiles.PURPLE.toChar());
        assertEquals('f', Tiles.Fire.toChar());
        assertEquals('w', Tiles.WILD.toChar());
        assertEquals('o', Tiles.Object.toChar());
        assertEquals('x', Tiles.None.toChar()); // Assuming 'x' is the default char for invalid enum constant
        
    }

}
