package comp1110.ass2;

import gittest.B;

import java.util.ArrayList;

/**
 * Author: Ishaan Kapoor u7598889
 */
public class test {
    public static void main(String[] args) {


        Board board1= new Board(Utility.RECTANGLE_BOARDS[0][0]);
        Board board2= new Board(Utility.SQUARE_BOARDS[0][0]);
        Board board3= new Board(Utility.RECTANGLE_BOARDS[0][1]);
        Board board4= new Board(Utility.SQUARE_BOARDS[0][1]);
        Board testboard = Island.combine4boards(board1,board2,board3,board4);
        String challengeString = "LNSNLASAF000300060012001506030903C000093030341203R11215";
        Island.applyFireCard(testboard,challengeString);
        System.out.println(testboard);
        Island.applyRaft(testboard,challengeString);
        Island.applyCatCard(testboard,challengeString);
        System.out.println(testboard);

        String[] challengeArray = challengeString.split("(?=[F,C,R])");
        String[] islandStringArray = challengeArray[0].split("(?=[L,S])");


        ArrayList<Board> ss = Island.chooseBoardFromString(islandStringArray);
        for (Board b : ss) {
            System.out.println(b);
        }

        Board b1 = ss.get(0);
        Board b2 = ss.get(1);
        Board b3 = ss.get(2);
        Board b4 = ss.get(3);

        Board testBig = Island.combine4boards(b1,b2,b3,b4);
        System.out.println(testBig);

    }
}

