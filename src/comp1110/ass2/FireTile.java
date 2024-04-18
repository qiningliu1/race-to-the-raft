package comp1110.ass2;

/**
 * The FireTile class represents a fire tile in the game.
 * It includes the location of the fire tile on the island and methods for placing the fire tile.
 */
public class FireTile {

    private char ID;
    /**
     * The orientation of this card.
     */
    private Orientation orientation;

    private Location location; // Represents the location of the fire tile on the island

    /**
     * Constructs a FireTile object with the specified size, orientation and shape.
     */
    public void FireTile(int size , Orientation orientation ) {
       // we are yet to think of an idea to how to implement shape of the fire tiles.
    }

    /**
     * Places the fire tile on the island at the specified position.
     */
    public void placeFire(Location location) {
        // Implementation to place the fire tile on the island
    }


    /**
     * @return The orientation of this tile
     */
    public Orientation getOrientation() {
        return orientation;
    }
    /**
     * @return The locations on island, that are occupied by this tile.
     */
    public Location[] getLocations (FireTile tileF) {
        return null; // implementation to be defined as per requirement
    }

    // Other methods can be added as needed

    public static final FireTile[] FIRE_TILES=new FireTile[]{
    };
    public static FireTile newFireTile(char ID){

        if(ID >= 'a' && ID <= 'z') {
            return FIRE_TILES[ID-'a'];
        }else if (ID>='A'&&ID<='E') {
            return FIRE_TILES[ID - 'A' + 26];
        } else {
            System.out.println("FireTile ID is error");
            return null;
        }
        }
}
