//package comp1110.ass2;
//
///**
// * The PathwayCard class represents a pathway card in the game.
// * It includes information about the position where the card is placed and methods for combining pathway cards.
// */
//public class PathwayCard extends Card{
//
//    /**
//     * ID of the raft card.
//     */
//    private final char charId;
//
//    /**
//     * Location of the raft card on island.
//     */
//    private Location location;
//
//    /**
//     * The orientation of this card.
//     */
//    private Orientation orientation;
//
//    /**
//     * this 2d array represents a pathway card. The card is made up of different tiles
//     * on all the available blocks on the card (9 or 6). The indexes of this array represent
//     * the row and column coordinate of the tile placement.
//     */
//    private Tiles[][] layout;
//
//
//    /**
//     * Constructs a PathwayCard object with the specified layout.
//     *
//     * @param charId
//     * @param layout the layout of the pathway card represented as a 2D array
//     */
//    public PathwayCard(char charId, Tiles[][] layout) {
//        this.charId = charId;
//        this.layout = layout;
//    }
//
//
//    /**
//     * Rotates the pathway card clockwise by 90 degrees.
//     */
//    public void rotateClockwise() {
//        // Implementation to rotate the pathway card clockwise
//    }
//
//    /**
//     * Flips the pathway card horizontally.
//     */
//    public void flipHorizontal() {
//        // Implementation to flip the pathway card horizontally
//    }
//
//    /**
//     * Flips the pathway card vertically.
//     */
//    public void flipVertical() {
//        // Implementation to flip the pathway card vertically
//    }
//
//
//    /**
//     * @return The orientation of this tile
//     */
//    public Orientation getOrientation() {
//        return orientation;
//    }
//
//    /**
//     * @return The ID of this tile
//     */
//    public int getID() {
//        return charId;
//    }
//    /**
//     * @return The locations on island, that are occupied by the card.
//     */
//    public Location[] getLocations (Raft card) {
//        return null; // implementation to be defined as per requirement
//    }
//
//}
