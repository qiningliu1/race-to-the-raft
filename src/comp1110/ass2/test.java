package comp1110.ass2;

public class test {
    public static int[][] transposeMatrix(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] transposedMatrix = new int[n][m];

        for(int x = 0; x < n; x++) {
            for(int y = 0; y < m; y++) {
                transposedMatrix[x][y] = matrix[y][x];
            }
        }

        return transposedMatrix;
    }

    public static void main(String[] args) {
        Tiles[][] test1 = new Tiles[2][3];
        test1[0][0] = Tiles.Fire;
        test1[0][1] = Tiles.RED;
        test1[0][2] = Tiles.BLUE;
        test1[1][0] = Tiles.GREEN;
        test1[1][1] = Tiles.YELLOW;
        test1[1][2] = Tiles.PURPLE;

        Tiles[][] test2 = Board.rotate90clockwise(test1);
        System.out.println(test2[0][0]);
        System.out.println(test2[0][1]);
        System.out.println(test2[1][0]);
        System.out.println(test2[1][1]);
        System.out.println(test2[2][0]);
        System.out.println(test2[2][1]);



    }
}
