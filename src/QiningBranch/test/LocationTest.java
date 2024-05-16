package QiningBranch.test;

import QiningBranch.Location;

import java.util.Arrays;

public class LocationTest {
    public static void main(String[] args) {
        /**
         * Test Challenge String split method
         */
        String a= "SASNSNSAF0000001206090903C2000630300R20015";
        String[] aString = a.split("F|C|R");

        String aSplit= Arrays.toString(aString);
        System.out.println(aSplit);

     int anInt =  Integer.parseInt(aString[1]);
        System.out.println(anInt);

        String aTest = "0000";
       int b= Integer.parseInt(aTest.substring(0,2));
        System.out.println(b);



        String aSplit0 =  aString[0];
        String aSplit1 = aString[1];
        System.out.println(aSplit1);


        //This part for test LocationString
        String actionPlacementHandCard = "Ab1208S";
        Location handCardlocation = new Location();
        handCardlocation.pathwayCardPlacement(actionPlacementHandCard);
       int handCardlocationRow =handCardlocation.getRow();
        int handCardlocationColumn=handCardlocation.getColumn();
        System.out.println("Row "+handCardlocationRow + " Column" +handCardlocationColumn);




    }


}
