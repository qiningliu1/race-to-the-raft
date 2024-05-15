package comp1110.ass2;

/**
 * Author: Ishaan Kapoor u7598889
 **/

public class RaftCards {

    private int raftID;
    private TileType[][] raftCard;

    public RaftCards(int raftID, TileType[][] raftCard) {
        this.raftCard = raftCard;
        this.raftID = raftID;
    }

    public RaftCards(String raftString) {
        this.raftID = Character.getNumericValue(raftString.charAt(0));
        this.raftCard = Cards.cardFromString(raftString);
    }

    public TileType[][] getRaftCard() {
        return raftCard;
    }

    public void setRaftID(int raftID) {
        this.raftID = raftID;
    }

    public void setRaftCard(TileType[][] raftCard) {
        this.raftCard = raftCard;
    }

    @Override
    public String toString() {
        String ss = null;
        for(String s:Utility.RAFT_CARDS){
            if (Character.getNumericValue(s.charAt(0)) == raftID ) {
                ss=s;
            }
        }
        return ss;
    }
}
