package comp1110.ass2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class testCombineBoards {
    @Test
    public void testCombine2Boards(){
        TileType[][] test1 = new TileType[2][3];
        test1[0][0] = TileType.Fire;
        test1[0][1] = TileType.RED;
        test1[0][2] = TileType.BLUE;
        test1[1][0] = TileType.GREEN;
        test1[1][1] = TileType.YELLOW;
        test1[1][2] = TileType.PURPLE;

        TileType[][] test2 = new TileType[2][3];
        test2[0][0] = TileType.Fire;
        test2[0][1] = TileType.Fire;
        test2[0][2] = TileType.PURPLE;
        test2[1][0] = TileType.GREEN;
        test2[1][1] = TileType.BLUE;
        test2[1][2] = TileType.YELLOW;

        Board board1 = new Board(test1);
        Board board2 = new Board(test2);

        Board testBoard = Island.combine2boards(board1,board2);

        Assertions.assertEquals(TileType.Fire,testBoard.getBoard()[2][0]);
        Assertions.assertEquals(TileType.YELLOW,testBoard.getBoard()[1][1]);
        Assertions.assertEquals(TileType.Fire,testBoard.getBoard()[2][1]);
        Assertions.assertEquals(TileType.Fire,testBoard.getBoard()[0][0]);
        Assertions.assertEquals(TileType.BLUE,testBoard.getBoard()[0][2]);
    }

    @Test
    public void testCombine4Boards(){
        TileType[][] test1 = new TileType[2][3];
        test1[0][0] = TileType.Fire;
        test1[0][1] = TileType.RED;
        test1[0][2] = TileType.BLUE;
        test1[1][0] = TileType.GREEN;
        test1[1][1] = TileType.YELLOW;
        test1[1][2] = TileType.PURPLE;

        TileType[][] test2 = new TileType[2][3];
        test2[0][0] = TileType.Fire;
        test2[0][1] = TileType.Fire;
        test2[0][2] = TileType.PURPLE;
        test2[1][0] = TileType.GREEN;
        test2[1][1] = TileType.BLUE;
        test2[1][2] = TileType.YELLOW;

        TileType[][] test3 = new TileType[2][3];
        test3[0][0] = TileType.PURPLE;
        test3[0][1] = TileType.PURPLE;
        test3[0][2] = TileType.GREEN;
        test3[1][0] = TileType.RED;
        test3[1][1] = TileType.GREEN;
        test3[1][2] = TileType.Fire;

        TileType[][] test4 = new TileType[2][3];
        test4[0][0] = TileType.Fire;
        test4[0][1] = TileType.RED;
        test4[0][2] = TileType.RED;
        test4[1][0] = TileType.Fire;
        test4[1][1] = TileType.GREEN;
        test4[1][2] = TileType.Fire;

        Board board1 = new Board(test1);
        Board board2 = new Board(test2);
        Board board3 = new Board(test3);
        Board board4 = new Board(test4);

        Board testBoard = Island.combine4boards(board1,board2,board3,board4);

        Assertions.assertEquals(TileType.Fire,testBoard.getBoard()[2][0]);
        Assertions.assertEquals(TileType.YELLOW,testBoard.getBoard()[1][1]);
        Assertions.assertEquals(TileType.Fire,testBoard.getBoard()[2][1]);
        Assertions.assertEquals(TileType.Fire,testBoard.getBoard()[0][0]);
        Assertions.assertEquals(TileType.BLUE,testBoard.getBoard()[0][2]);
        Assertions.assertEquals(TileType.GREEN,testBoard.getBoard()[0][5]);
        Assertions.assertEquals(TileType.YELLOW,testBoard.getBoard()[3][2]);
        Assertions.assertEquals(TileType.Fire,testBoard.getBoard()[3][5]);
        Assertions.assertEquals(TileType.RED,testBoard.getBoard()[1][3]);
        Assertions.assertEquals(TileType.RED,testBoard.getBoard()[2][4]);
    }
}


