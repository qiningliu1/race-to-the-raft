package QiningBranch;
/**
 * Author : Qining Liu u7100555
 */

import comp1110.ass2.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * This class will add some method to analyze and separate the string in Utility
 */


public class Challenge {
  private newBoard newBoard;
  private  newTileType[][] square;
  private newOrientation newOrientation;
  public static String randomDifficulty;

    public Challenge(newBoard newBoard, newTileType[][] square) {
        this.newBoard = newBoard;
        this.square = square;
    }
    public Challenge(){

    }
    public newBoard getBoard() {
        return newBoard;
    }
    public void setBoard(newBoard newBoard) {
        this.newBoard = newBoard;
    }
    public newTileType[][] getSquare() {
        return square;
    }
    public void setSquare(newTileType[][] square) {
        this.square = square;
    }



    //This method return island substring
    public static String selectIsland(int difficulty){

        //we need to use a static value to first record this string
        //this is the whole challenge substring include(L,F,C,R)
        randomDifficulty =chooseChallenge(difficulty);

        //Actually the difficulty should  decide by players
        //here need to be careful pick random difficulty, we transfer that static value
        //use challengeIsland substring to store this String
        //by this method we don't need to pick random difficulty by using chooseChallenge method, which will
        //cause error

        String islandSubchallengeString =randomDifficulty;

        if(islandSubchallengeString.substring(0,5).charAt(4)=='F'){
            return islandSubchallengeString.substring(0,4);//need to be careful here
        }
        else {return islandSubchallengeString.substring(0,8);}
    }

    public List<newOrientation> boardOrientation(String islandSubString) {
        List<newOrientation> newOrientations = new ArrayList<>();
        String randomIsland = islandSubString;
        //8 char substring case
        if (randomIsland.length() == 8) {
         for(int i = 1; i<randomIsland.length();i+=2){
             char temp =randomIsland.charAt(i);
             newOrientation singleBoard= newOrientation.fromChar(temp);
             newOrientations.add(singleBoard);
         }
         return newOrientations;
        }

        //4 char substring case
        else if (randomIsland.length() == 4) {
            for(int i = 1; i<randomIsland.length();i+=2){
                char temp =randomIsland.charAt(i);
                newOrientation singleBoard= newOrientation.fromChar(temp);
                newOrientations.add(singleBoard);
            }
            return newOrientations;
        }

        else {throw new IllegalStateException();}
    }


    public List<Character> sizeOfBoard(String islandSubString ){
        List<Character> boardSize= new ArrayList<>();
        if(islandSubString.length() == 8){
            for(int i = 0; i<islandSubString.length()-1 ; i+=2){
                char tempSize = islandSubString.charAt(i);
                boardSize.add(tempSize);
            }
            return  boardSize;
        }
        else if(islandSubString.length() == 4){
            for(int i = 0; i<islandSubString.length()-1 ; i+=2){
                char tempSize = islandSubString.charAt(i);
                boardSize.add(tempSize);
            }
            return  boardSize;
        }

        else{throw new IllegalStateException();}
    }



    public List<newTileType[][]> createBoard(List<newOrientation> newOrientations, List<Character> size) {
//don't do that to randomly select difficulty twice
//    orientations = boardOrientation(selectIsland(difficulty));
//    size = sizeOfBoard(selectIsland(difficulty));
    //List length judge

            List<newTileType[][]> boardList = new ArrayList<>();

            for(int i = 0; i< newOrientations.size(); i++){ //List size should be 2 or 4
                Random random= new Random();
                //here should be careful we need to use orientations.size() as bound
                // to flexible deal with different size
                int boardIndex = random.nextInt(newOrientations.size());
                if(size.get(i)=='L'&& newOrientations.get(i).equals(newOrientation.NORTH)){
                    newBoard board = new newBoard(Utility.SQUARE_BOARDS[boardIndex][0]);
                    if (board.board.length!=9){
                        System.out.println("problem at 1");
                    }
                    newTileType[][] newBoard = board.board;
                     boardList.add(newBoard);

                }
                else if (size.get(i)=='L'&& newOrientations.get(i).equals(newOrientation.ANY)) {
                    newBoard newBoard = new newBoard(Utility.SQUARE_BOARDS[boardIndex][1]);
                    if (newBoard.board.length!=9){
                        System.out.println("problem at 2");
                    }
                    boardList.add(newBoard.board);

                }
                else if (size.get(i)=='L'&&!newOrientations.get(i).equals(newOrientation.NORTH)) {
                    newBoard newBoard = new newBoard(Utility.SQUARE_BOARDS[boardIndex][0]);
                    if (newBoard.board.length!=9){
                        System.out.println("problem at 3");
                    }
                    if(newOrientations.get(i).equals(newOrientation.EAST)){
                       boardList.add(newBoard.rotate90clockwise(newBoard.board));

                    }
                    else if (newOrientations.get(i ).equals(newOrientation.SOUTH)) {
                       newTileType[][] temp= newBoard.rotate90clockwise(newBoard.board);
                       boardList.add(newBoard.rotate90clockwise(temp));

                    }
                    else if(newOrientations.get(i ).equals(newOrientation.WEST)){
                        newTileType[][] temp = newBoard.rotate90clockwise(newBoard.board);
                        newTileType[][] temp1 = newBoard.rotate90clockwise(temp);
                        boardList.add(newBoard.rotate90clockwise(temp1));

                    }
                }

                if(size.get(i)=='S'&& newOrientations.get(i).equals(newOrientation.NORTH)){
                    newBoard newBoard = new newBoard(Utility.RECTANGLE_BOARDS[boardIndex][0]);
                    if (6 != newBoard.board.length){
                        System.out.println("problem at 4");
                    }
                    boardList.add(newBoard.board);

                }
                else if (size.get(i)=='S'&& newOrientations.get(i).equals(newOrientation.SOUTH)) {
                    newBoard newBoard = new newBoard(Utility.RECTANGLE_BOARDS[boardIndex][0]);
                    if (newBoard.board.length!=6){
                        System.out.println("problem at 5");
                    }
                    newTileType[][] temp= newBoard.rotate90clockwise(newBoard.board);
                    boardList.add(newBoard.rotate90clockwise(temp));

                }
                else if (size.get(i)=='S'&& newOrientations.get(i).equals(newOrientation.ANY)) {
                    newBoard newBoard = new newBoard(Utility.RECTANGLE_BOARDS[boardIndex][1]);
                    if (newBoard.board.length!=6){
                        System.out.println("problem at 6");
                    }
                    boardList.add(newBoard.board);
                }
            }

                return boardList;
    }


    public static String chooseChallenge(int difficulty) {
        Random rand = new Random();
        int bound = 0;
        int origin = 0;
        if (difficulty == 0) {
            origin = 0;
            bound = 3;
        }
        if (difficulty == 1) {
            origin = 4;
            bound = 7;
        }
        if (difficulty == 2) {
            origin = 8;
            bound = 15;
        }
        if (difficulty == 3) {
            origin = 16;
            bound = 23;
        }
        if (difficulty == 4) {
            origin = 24;
            bound = 31;
        }
        if (difficulty == 5) {
            origin = 32;
            bound = 38;
        }
        int index = rand.nextInt(origin,bound);
        return Utility.CHALLENGES[index]; // FIXME TASK 6
    }


    @Override
    public String toString() {
        return "Challenge{" +
                "board=" + newBoard +
                ", square=" + Arrays.toString(square) +
                '}';
    }


}
