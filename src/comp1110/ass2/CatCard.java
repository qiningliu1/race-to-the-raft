package comp1110.ass2;
/**
 * Author: Ishaan Kapoor u7598889 and Lujin Sun u7897414
 */

import jdk.jshell.execution.Util;

public class CatCard {
    private int ID;
    private Tiles[][] catCard;

    /**
     * Author: Lujin Sun u7897414
     */
    public char[][] catStringToArrayOfChar(String layoutString) {

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
    /**
     * Author: Ishaan Kapoor u7598889
     */
    public Tiles[][] catCardFromCharArray(char[][] catCharArray) {
        Tiles[][] catCardTilesArray = new Tiles[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                catCardTilesArray[i][j] = Tiles.fromChar(catCharArray[i][j]);
            }
        }
        return catCardTilesArray;
    }
    /**
     * Author: Ishaan Kapoor u7598889
     */
    public Tiles[][] catCardFromString (String catString) {
       return catCardFromCharArray(catStringToArrayOfChar(catString.substring(1)));
    }
    /**
     * Author: Ishaan Kapoor u7598889
     */
    public CatCard(int ID, Tiles[][] catCard) {

        this.ID = ID;
        this.catCard = catCard;
    }
    /**
     * Author: Ishaan Kapoor u7598889
     */
    public CatCard(String catString) {

        this.ID = catString.charAt(0);
        this.catCard = catCardFromString(catString);
    }
    /**
     * Author: Lujin Sun u7897414
     */
    public int getID() {
        return ID;
    }
    /**
     * Author: Ishaan Kapoor u7598889
     */
    public Tiles[][] getCatCard() {
        return catCard;
    }
    /**
     * Author: Lujin Sun u7897414
     */
    private String[] allPossibleCatCardStrings = Utility.CAT_CARDS;


    /**
     * Author: Ishaan Kapoor u7598889
     */
    public CatCard[] allPossibleCatCardObjects(String[] allPossibleCatCardStrings) {
        int i =0;
        CatCard[] catCards = new CatCard[allPossibleCatCardStrings.length];
        for(String s: allPossibleCatCardStrings) {
            catCards[i] = new CatCard(s.charAt(0),catCardFromString(s));
            i++;
        }
        return catCards;
    }
    /**
     * Author: Ishaan Kapoor u7598889
     */
    private CatCard[] allPossibleCatCards = allPossibleCatCardObjects(allPossibleCatCardStrings);


}

//
//    public int getID() {
//        return ID;
//
//
//    public char[][] getLayout() {
//        return layout;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("Cat Card ").append(ID).append(":\n");
//        for (char[] row : layout) {
//            for (char square : row) {
//                sb.append(square).append(" ");
//            }
//            sb.append("\n");
//        }
//        return sb.toString();
//    }
//
//    public static void main(String[] args) {
//        String[] CAT_CARDS = {
//                "0rrfrRfrrf",
//                "1fffbBbbbb",
//                "2fffbBbbbY",
//                "3gffgGfggg",
//                "4ffyfYyyyy",
//                "5fppfPpfpp",
//                "6fppfPpfpR"
//        };
//
//        CatCard[] catCards = new CatCard[CAT_CARDS.length];
//        for (int i = 0; i < CAT_CARDS.length; i++) {
//            catCards[i] = new CatCard(i, CAT_CARDS[i]);
//        }
//
//
//    }
//}
