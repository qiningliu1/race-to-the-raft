package comp1110.ass2;

public class RaftCard {
    private int ID;
    private Card[][] cards;

    public static final RaftCard[] RAFT_CARDS = new RaftCard[]{
            new RaftCard(0, "wwwwowwww"),
            new RaftCard(1, "gyprowbww"),
            new RaftCard(2, "prpbowbyg"),
            new RaftCard(3, "pbyrorgwg")
    };

    public RaftCard(int ID, String raftcard) {
        this.ID = ID;
        this.cards = new Card[3][3];
        initializeSquares(raftcard);
    }

    private void initializeSquares(String raftcard) {
        int charIndex = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char character = raftcard.charAt(++charIndex);
                cards[row][col] = new Card(Tiles.fromChar(character));
            }
        }
    }

    public static RaftCard newRaftCard(int ID) {
        if (ID < 0 || ID >= RAFT_CARDS.length) {
            System.out.println("Invalid raft card ID: " + ID);
            return null;
        }
        return RAFT_CARDS[ID];
    }

    public int getID() {
        return ID;
    }

    public Card getCard(int row, int column) {
        return cards[row][column];
    }
}


