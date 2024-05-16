package QiningBranch;
/**
 * Author : Qining Liu u7100555
 */
public class newraftCard extends Card {
    public int raftID;

    public newraftCard(Location location, newOrientation newOrientation, int raftID) {
        super(location, newOrientation);
        this.raftID = raftID;
    }

    public newraftCard(int raftID) {
        this.raftID = raftID;
    }

    /**
     * Set and get RaftCardID
     * @return
     */

    public int getRaftID() {
        return raftID;
    }

    public void setRaftID(int raftID) {
        this.raftID = raftID;
    }

    public static newTileType getRaftTileTypeById(int raftID) {
        switch (raftID) {
            case 0:
            case 1:
            case 2:
            case 3:
                return newTileType.Object;
            default:
                throw new IllegalArgumentException("Invalid Cat ID: " + raftID);
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
    public void performAction() {

    }




}
