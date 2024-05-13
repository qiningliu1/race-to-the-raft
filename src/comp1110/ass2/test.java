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

    public static void main(String[] args) {


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
