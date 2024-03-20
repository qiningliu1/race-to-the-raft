package comp1110.ass2;

/**
 * The Cat class represents a cat in the game.
 * It includes the location of the cat on the island and methods for moving the cat.
 */
public class Cat {

    private Location location; // Represents the location of the cat on the island
    private boolean exhausted; // Indicates whether the cat has moved in the current round

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
     * The Direction enum represents the directions in which a cat can move.
     */
    public enum Direction {
        NORTH, // Represents north direction
        SOUTH, // Represents south direction
        EAST,  // Represents east direction
        WEST   // Represents west direction
    }
    /**
     * Moves the cat to the specified direction on the island.
     * @param direction the direction to move the cat
     */
    public void move(Direction direction) {
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

