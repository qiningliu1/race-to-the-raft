package QiningBranch.test;

import QiningBranch.HandCard;
import QiningBranch.newOrientation;
import comp1110.ass2.Orientation;
import comp1110.ass2.Utility;

public class HandTest {

    public static void main(String[] args) {
        String handString = Utility.DECK_A[0];
        //initialization
        HandCard handCard = new HandCard(handString);

       String testHandCard= handCard.toString();
        System.out.println(testHandCard);

        //Rotate 90

        HandCard rotate90Card = HandCard.rotate90Card(handCard);
        String rotateCard = rotate90Card.toString();
        System.out.println(rotateCard);

        //Rotate based on different orientation
        HandCard randomRotate = HandCard.rotateCard(handCard, newOrientation.WEST);
        String randomRotationString = randomRotate.toString();
        System.out.println(randomRotationString);


    }


}
