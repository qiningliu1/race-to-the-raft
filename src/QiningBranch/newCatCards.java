package QiningBranch;
/**
 * Author : Qining Liu u7100555
 */
public class newCatCards extends Card{
    public int catID;
    private newTileType[][] layout;

    public newCatCards(Location location, newOrientation newOrientation, int catID, newTileType[][] layout) {
        super( location, newOrientation);
        this.catID = catID;
        this.layout = layout;
    }

    public newCatCards() {
    }

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }


    public static newTileType getCatTileTypeById(int catID) {
        switch (catID) {
            case 0:
                return newTileType.RED_CAT;
            case 1:
            case 2:
                return newTileType.BLUE_CAT;
            case 3:
                return newTileType.GREEN_CAT;
            case 4:
                return newTileType.YELLOW_CAT;
            case 5:
            case 6:
                return newTileType.PURPLE_CAT;
            default:
                throw new IllegalArgumentException("Invalid Cat ID: " + catID);
        }
    }



    @Override
    public newOrientation getOrientation() {
        return super.getOrientation();
    }

    @Override
    public void setOrientation(newOrientation newOrientation) {
        super.setOrientation(newOrientation);
    }

    @Override
    public Location getLocation() {
        return super.getLocation();
    }

    @Override
    public void setLocation(Location location) {
        super.setLocation(location);
    }

    /**
     * This method is used to achieve special movement of cat
     * for example move the exhausted cat
     *
     */

    @Override
    public void performAction() {

    }
}
