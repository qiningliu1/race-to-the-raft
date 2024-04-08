package comp1110.ass2;

import javax.swing.plaf.ColorUIResource;
import javax.swing.text.Position;
import java.awt.*;

/**
 * The Cat class represents a cat in the game.
 * It includes the location of the cat on the island and methods for moving the cat.
 */
public class Cat {
    private int ID;
    private Tiles tiles;
    private Location location; // Represents the location of the cat on the island
    private boolean exhausted; // Indicates whether the cat has moved in the current round

    public Cat(int ID){
        this.ID = ID;
    }
    public Cat(Tiles tiles){
        this.tiles = tiles;
    }
    /**
     * Constructs a Cat object with the specified location.
     * The cat is initially not exhausted.
     * @param location the initial location of the cat
     */
    public Cat(Location location) {
        this.location = location;
        this.exhausted = false;
    }

    /**
     * Moves the cat to the specified direction on the island.
     * @param direction the direction to move the cat
     */
    public void move(Orientation direction) {
        // Implementation to move the cat to the specified direction
    }

    /**
     * Checks if the cat is exhausted (has moved in the current round).
     * @return true if the cat is exhausted, false otherwise
     */
    public boolean isExhausted() {
        return exhausted;
    }

    // Other methods can be added as needed

}

