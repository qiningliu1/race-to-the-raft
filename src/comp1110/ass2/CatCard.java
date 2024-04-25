package comp1110.ass2;

public class CatCard {
    private int ID;
    private char[][] layout;

    public CatCard(int ID, String layoutString) {
        this.ID = ID;
        this.layout = new char[3][3];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.layout[i][j] = layoutString.charAt(index);
                index++;
            }
        }
    }

    public int getID() {
        return ID;
    }

    public char[][] getLayout() {
        return layout;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cat Card ").append(ID).append(":\n");
        for (char[] row : layout) {
            for (char square : row) {
                sb.append(square).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] CAT_CARDS = {
                "0rrfrRfrrf",
                "1fffbBbbbb",
                "2fffbBbbbY",
                "3gffgGfggg",
                "4ffyfYyyyy",
                "5fppfPpfpp",
                "6fppfPpfpR"
        };

        CatCard[] catCards = new CatCard[CAT_CARDS.length];
        for (int i = 0; i < CAT_CARDS.length; i++) {
            catCards[i] = new CatCard(i, CAT_CARDS[i]);
        }


    }
}
