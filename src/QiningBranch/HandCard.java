package QiningBranch;

/**
 * Author : Qining Liu u7100555
 */

import java.util.ArrayList;
import java.util.List;

public class HandCard extends Card{

    private char ID;
    private newTileType[][] cardSquare;


    public HandCard(char ID, newTileType[][] cardSquare) {
        this.ID = ID;
        this.cardSquare = cardSquare;
    }

    public HandCard(){

    }

    public char getCardID() {
        return ID;
    }


    public newTileType[][] getCardLayOut(){
        return this.cardSquare;
    }


    /**
     * Initialize 3*3 HandCard
     * @param cardString
     */

    public HandCard (String cardString){

        this.ID = cardString.charAt(0);
        this.cardSquare = new newTileType[3][3];
        String layoutString = cardString.substring(1);

        for (int rowSquare = 0; rowSquare < 3; rowSquare++) {

          String rowString = layoutString.substring(3*rowSquare,3*rowSquare +3);

            for (int colSquare = 0; colSquare < 3; colSquare++) {

               if (rowString.charAt(colSquare) == 'b'){
                 cardSquare[rowSquare][colSquare] = newTileType.BLUE;
                 continue;
               }
               else if (rowString.charAt(colSquare) == 'r') {
                   cardSquare[rowSquare][colSquare] = newTileType.RED;
                   continue;
               }
               else if (rowString.charAt(colSquare) == 'y') {
                   cardSquare[rowSquare][colSquare] = newTileType.YELLOW;
                   continue;
               }
               else if (rowString.charAt(colSquare) == 'p') {
                   cardSquare[rowSquare][colSquare] = newTileType.PURPLE;
                   continue;
               }
               else if (rowString.charAt(colSquare) == 'g') {
                   cardSquare[rowSquare][colSquare] = newTileType.GREEN;
                   continue;
               }
            }
        }

    }



  public List<HandCard> handCardList (HandCard randomHandCard){
    List<HandCard> handCardList = new ArrayList<>();
    handCardList.add(randomHandCard);
    return handCardList;
  }



    public static HandCard rotateCard(HandCard initialCard, newOrientation orientation) {
        return switch (orientation) {
            case NORTH,ANY-> initialCard;
            case EAST -> rotate90Card(initialCard);
            case SOUTH -> rotate90Card(rotate90Card(initialCard));
            case WEST -> rotate90Card(rotate90Card(rotate90Card(initialCard)));
            case NONE -> null;
        };
    }




    public static HandCard rotate90Card(HandCard card) {
        newTileType[][] transposedCard = newBoard.transposeBoard(card.getCardLayOut());
        newBoard.swapColumns(transposedCard);

        HandCard rotatedCard = new HandCard(card.getCardID(), transposedCard);

        return rotatedCard;
    }








    @Override
    public String toString() {
        return "HandCard{" +
                "ID=" + ID +
                ", cardSquare=" + newTileType.toString(cardSquare) +
                '}';
    }

    @Override
    public void performAction() {

    }
}
