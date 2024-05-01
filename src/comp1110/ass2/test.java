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
    public static TileType[][] boardTiles = Board.getGameBoard(boardstate);
    public static String test = Viewer.getImagepath(boardTiles[1][16]);

    public static void main(String[] args) {
        String s = "AabcnBCcdDd";
        Decks ss = new Decks(s);

        Cards test = ss.getFulldeck().get(0).getCards().get(3);
        System.out.println(test.getCard()[2][1]);

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
