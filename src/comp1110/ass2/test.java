package comp1110.ass2;

import comp1110.ass2.gui.Viewer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: Ishaan Kapoor u7598889
 */
public class test {
    public static int[][] transposeMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] transposedMatrix = new int[n][m];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                transposedMatrix[x][y] = matrix[y][x];
            }
        }

        return transposedMatrix;
    }

    private static String boardstate = """
            fffffffffffffffrrf
            fffffffffbbbfffrRf
            fffffffffbbbfffrrf
            ffffffyfffypfffpbr
            ffffffffffgffbrpgy
            ffffffbfffffyrygyp
            ffffppgyybbbbybrpb
            ffffppppyyggbygbyg
            ffffppppPbbgbbpgrr
            ffffffffgbyyybgbbp
            fffffffbybpybbpryg
            fffffffrfrgyybgyby
            fffffffyppryyBpprp
            fffbBbygggbprygbow
            fffbbbbryygbygybyg
            """;

    public static int[] stringToIntArray(String input) {
        int[] result = new int[input.length() / 2];
        for (int i = 0; i < input.length(); i += 2) {
            String substring = input.substring(i, i + 2);
            result[i / 2] = Integer.parseInt(substring);
        }
        return result;
    }

    public static void main(String[] args) {
//"LNSNLASAF00030006030306030606060909030906C000123000940015R31203"

        String test = "LNSNLASAF00030006030306030606060909030906C000123000940015R31203";
        String[] challengeArray = test.split("(?=[F,C,R])");
        String[] islandStringArray = challengeArray[0].split("(?=[L,S])");

        for (String s: islandStringArray) {
            System.out.println(s);
        }

        System.out.println(challengeArray[2]);
        int row = Integer.parseInt(challengeArray[3].substring(4,6));
        System.out.println(row);

        int[] arayy = Island.stringToIntArrayCombines2(challengeArray[1].substring(1));
        int[][] aray = Island.splitIntArray(arayy);
        for (int i = 0; i < aray[0].length;i++) {
            System.out.println(aray[0][i]);
            System.out.println(aray[1][i]);
        }



//00 03 00 06 03 03 06 03 06 06 06 09 09 03 09 06

        ArrayList<RaftCards> allRafts = new ArrayList<>();
        for (String s : Utility.RAFT_CARDS) {
            allRafts.add(new RaftCards(s));
        }
        for (RaftCards r: allRafts) {
            System.out.println(r);
        }

        System.out.println("".length());

    }
}


//        String test = "afffbBbggg";
//        TileType[][] testing = Cards.cardFromString(test);
//        System.out.println(testing[0][0]);
//        System.out.println(testing[1][2]);
//        System.out.println(testing[2][0]);
//        System.out.println(testing[2][0]);
//        System.out.println(testing[2][2]);
//        System.out.println(testing[1][1]);




//        TileType[][] test1 = new TileType[2][3];
//        test1[0][0] = TileType.Fire;
//        test1[0][1] = TileType.RED;
//        test1[0][2] = TileType.BLUE;
//        test1[1][0] = TileType.GREEN;
//        test1[1][1] = TileType.YELLOW;
//        test1[1][2] = TileType.PURPLE;
//
//        TileType[][] test2 = Board.rotate90clockwise(test1);
//        System.out.println(test2[0][0]);
//        System.out.println(test2[0][1]);
//        System.out.println(test2[1][0]);
//        System.out.println(test2[1][1]);
//        System.out.println(test2[2][0]);
//        System.out.println(test2[2][1]);
//
//        System.out.println(Utility.CAT_CARDS[3].charAt(0) == 3);

//        TileType[][] te = FireTile.getFireTileArray("A0002112022");
//    //        System.out.println(te[1][1]);
//
//            int[] max = {1,2,3,4,5,4,3,2,1};
//            System.out.println(FireTile.findLargest(max));
//
//            FireTile testft = new FireTile("l000111121322");
//            TileType[][] testtt = FireTile.rotateFireTile(testft,Orientation.SOUTH).getFireTile();
//            for (int i =0;i< testtt.length; i++) {
//                for (int j = 0 ; j<testtt[0].length; j++) {
//                    System.out.println(testtt[i][j]);
//                }
//
//            }

//    String s = "AabcnBCcdDd";
//        Decks ss = new Decks(s);
//
//        Cards test = ss.getFulldeck().get(0).getCards().get(3);
//        System.out.println(test.getCard()[2][1]);
//
//
//        String testing = "LNSNLASAF000300060012001506030903C000093030341203R11215";
//        String[] testingarray = testing.split("(?=[F,C,R])");
//        String[] islandStringArray = testingarray[0].split("(?=[L,S])");
//
//        for(String st:islandStringArray) {
//            System.out.println(st);
//        }
//
//        String[] testArray = new String[1];
//        testArray[0] = "Ishaan";
//        System.out.println(testArray[0]);
//
//        testArray[0] = "kapoor";
//        System.out.println(testArray[0]);
//
//       char[][] testt = new char[2][2];
//       testt[0][0] = 'a';
//       testt[1][1] = 'b';
