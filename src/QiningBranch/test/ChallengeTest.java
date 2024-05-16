package QiningBranch.test;

import QiningBranch.Challenge;
import QiningBranch.newOrientation;
import QiningBranch.newTileType;

import java.util.List;

import static QiningBranch.Challenge.chooseChallenge;

public class ChallengeTest {
    public static void main(String[] args) {
        int difficulty1 = 4;
        String cha =chooseChallenge(difficulty1);
        String s = "";
        if(cha.substring(0,5).charAt(4)=='F'){
            s= cha.substring(0,4);//need to be careful here
        }
        System.out.println(s);

        /**
         * Pick a challenge for test
         *
         */

//        //Test challenge Island Substring
//        Challenge challenge = new Challenge();
//        //here difficulty actually should be decided by players
//        String randomIsland=Challenge.selectIsland(4);
//        System.out.println(randomIsland);
//
//        //Test picked orientations
//        List<Orientation> orientations =challenge.boardOrientation(randomIsland);
//        System.out.println(orientations);
//        Orientation orientation= orientations.get(0);
//        System.out.println(orientation);
//
//        //Test size of Board
//        System.out.println(challenge.sizeOfBoard(randomIsland));



        //Create Random List of Board based on different challenge Test
        Challenge challenge1 = new Challenge();
        int difficulty = 1;
        String IslandSubstring =Challenge.selectIsland(difficulty);
        System.out.println(IslandSubstring);
        List<newOrientation> newOrientationList = challenge1.boardOrientation(IslandSubstring);
        System.out.println(newOrientationList);
        List<Character> sizeList = challenge1.sizeOfBoard(IslandSubstring);
        System.out.println(sizeList);
        List<newTileType[][]> createBoard = challenge1.createBoard(newOrientationList,sizeList);
        newTileType[][] board0 =  createBoard.get(3);
        System.out.println(newTileType.toString(board0));


    }
}
