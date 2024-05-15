package comp1110.ass2;

/**
 * Author: Ishaan Kapoor u7598889 and Lujin Sun u7897414
 */

public class CatCard extends Cards {

    public CatCard(int ID, TileType[][] card) {
        super((char) ID, card);
    }
    public CatCard(String catString) {
        super(catString);
    }

    public static CatCard[] CAT_CARD_OBJECTS = {
            new CatCard(Utility.CAT_CARDS[0]),
            new CatCard(Utility.CAT_CARDS[1]),
            new CatCard(Utility.CAT_CARDS[2]),
            new CatCard(Utility.CAT_CARDS[3]),
            new CatCard(Utility.CAT_CARDS[4]),
            new CatCard(Utility.CAT_CARDS[5]),
            new CatCard(Utility.CAT_CARDS[6])
    };
}

























/*   //private int ID;
   private TileType[][] catCard;

    *//**
//     * Author: Lujin Sun u7897414
//     *//*
    public static char[][] catStringToArrayOfChar(String layoutString) {

        char[][] catCharArray = new char[3][3];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                catCharArray[i][j] = layoutString.charAt(index);
                index++;
            }
        }
        return catCharArray;
    }

    *//**
     * Author: Ishaan Kapoor u7598889
     *//*
    public static TileType[][] catCardFromCharArray(char[][] catCharArray) {
        TileType[][] catCardTilesArray = new TileType[3][3];
       for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                catCardTilesArray[i][j] = TileType.fromChar(catCharArray[i][j]);
            }
        }
        return catCardTilesArray;
    }

    *//**
     * Author: Ishaan Kapoor u7598889
     *//*
    public static TileType[][] catCardFromString(String catString) {
        return catCardFromCharArray(catStringToArrayOfChar(catString.substring(1)));
    }

    *//**
     * Author: Ishaan Kapoor u7598889
     *//*
    public CatCard(int ID, TileType[][] catCard) {

       this.ID = ID;
        this.catCard = catCard;
    }

    *//**
     * Author: Ishaan Kapoor u7598889
     *//*
    public CatCard(String catString) {

        this.ID = Character.getNumericValue(catString.charAt(0));
        this.catCard = catCardFromString(catString);
    }

    *//**
     * Author: Lujin Sun u7897414
     *//*
   public int getID() {
       return ID;

    }
    *//**
    * Author: Ishaan Kapoor u7598889
     *//*
    public TileType[][] getCatCard() {
        return catCard;
    }
}
    *//**
   * Author: Lujin Sun u7897414
     *//*
    private String[] allPossibleCatCardStrings = Utility.CAT_CARDS;


    *//**
     * Author: Ishaan Kapoor u7598889
     *
     * return a list of catCard objects based on the string array that we have.
     * @param allPossibleCatCardStrings is the string array that contains multiple cat strings.
     * @return A array of all possible catCard objecys possible from the strings.
     *//*
    public CatCard[] allPossibleCatCardObjects(String[] allPossibleCatCardStrings) {
        int i =0;
        CatCard[] catCards = new CatCard[allPossibleCatCardStrings.length];
        for(String s: allPossibleCatCardStrings) {
            catCards[i] = new CatCard(s.charAt(0),catCardFromString(s));
            i++;
        }
        return catCards;
    }
    *//**
     * Author: Ishaan Kapoor u7598889
     *//*
    private CatCard[] allPossibleCatCards = allPossibleCatCardObjects(allPossibleCatCardStrings);


}


    public int getID() {
        return ID;


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
}*/
