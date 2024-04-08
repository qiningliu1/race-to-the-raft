package comp1110.ass2;

import static comp1110.ass2.Utility.RECTANGLE_BOARDS;
import static comp1110.ass2.Utility.SQUARE_BOARDS;

public class Challenge {
    private int difficulty;
    private int width = 18;
    private int height;
    private String islandBoard;
    private String fireCard;
    private String catCard;
    private String raftCard;
    private Card[][] cards;
    private IslandBoard[] boards = new IslandBoard[4];
    private Location[] catLocations;
    public static Challenge[] challenges;

    // Create challenges based on the given array of challenge strings
    public static Challenge[] createChallenges(String[] CHALLENGES) {
        Challenge[] challenges = new Challenge[CHALLENGES.length];
        for (int c = 0; c < CHALLENGES.length; c++) {
            challenges[c] = new Challenge(CHALLENGES[c]);
            if (c >= 0 && c < 4) {
                challenges[c].difficulty = 0;
            } else if (c >= 4 && c < 8) {
                challenges[c].difficulty = 1;
            } else if (c >= 8 && c < 16) {
                challenges[c].difficulty = 2;
            } else if (c >= 16 && c < 24) {
                challenges[c].difficulty = 3;
            } else if (c >= 24 && c < 32) {
                challenges[c].difficulty = 4;
            } else if (c >= 32 && c < 39) {
                challenges[c].difficulty = 5;
            } else {
                challenges[c].difficulty = -1;
            }
        }
        return challenges;
    }

    // Constructor for Challenge class
    public Challenge(String challenge) {
        String[] challengeText = challenge.split("F|C|R");
        this.islandBoard = challengeText[0];
        this.fireCard = challengeText[1];
        this.catCard = challengeText[2];
        this.raftCard = challengeText[3];
        initializeBoards();
        initializeSquares();
        placeFireCards();
        placeCatCards();
        placeRaftCard();
    }

    // Initialize IslandBoard objects based on the challenge
    private void initializeBoards() {
        for (int i = 0; i < this.islandBoard.length(); i += 2) {
            String boardString = this.islandBoard.substring(i, i + 2);
            Orientation orientation = Orientation.fromChar(boardString.charAt(1));
            char boardSize = boardString.charAt(0);
            this.boards[i / 2] = IslandBoard.newBoard(boardSize, orientation);
            this.boards[i / 2].setOrientation(orientation);
        }
    }

    // Initialize squares array
    private void initializeSquares() {
        this.height = this.boards[0].getHeight() + this.boards[1].getHeight();
        this.cards = new Card[this.height][this.width];
        for (int index = 0; index < this.height; index++) {
            for (int jack = 0; jack < this.width; jack++) {
                this.cards[index][jack] = new Card(Tiles.None);
            }
        }
    }

    // Place fire cards on the squares array
    private void placeFireCards() {
        for (int fire = 0; fire < this.fireCard.length(); fire += 4) {
            int row = Integer.parseInt(this.fireCard.substring(fire, fire + 2));
            int col = Integer.parseInt(this.fireCard.substring(fire + 2, fire + 4));
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    this.cards[row + j][col + k].setTiles(Tiles.Fire);
                }
            }
        }
    }

    // Place cat cards on the squares array
    private void placeCatCards() {
        this.catLocations = new Location[this.catCard.length() / 5];
        for (int cat = 0; cat < this.catCard.length(); cat += 5) {
            String catString = this.catCard.substring(cat, cat + 5);
            CatCard catCard = CatCard.newCatCard(catString.charAt(0) - '0');
            int catRow = Integer.parseInt(this.catCard.substring(cat + 1, cat + 3));
            int catCol = Integer.parseInt(this.catCard.substring(cat + 3, cat + 5));
            for (int l = 0; l < 3; l++) {
                for (int m = 0; m < 3; m++) {
                    this.cards[catRow + l][catCol + m] = catCard.getcard(l, m);
                }
            }
            this.catLocations[cat / 5] = new Location(catCard.getCatLocation().getRow() + catRow,
                    catCard.getCatLocation().getColumn() + catCol);
        }
    }

    // Place raft card on the squares array
    private void placeRaftCard() {
        RaftCard raftCard = RaftCard.newRaftCard(this.raftCard.charAt(0) - '0');
        int raftRow = Integer.parseInt(this.raftCard.substring(1, 3));
        int raftCol = Integer.parseInt(this.raftCard.substring(3, 5));
        for (int p = 0; p < 3; p++) {
            for (int q = 0; q < 3; q++) {
                this.cards[raftRow + p][raftCol + q] = raftCard.getCard(p, q);
            }
        }
    }

    public int getDifficulty() {
        return difficulty;
    }
}
