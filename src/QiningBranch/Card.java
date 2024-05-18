package QiningBranch;
/**
 * Author : Qining Liu u7100555
 */
import comp1110.ass2.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class Card {

    private Location location;

    private newOrientation newOrientation;



    public Card(Location location, newOrientation newOrientation) {
        this.location = location;
        this.newOrientation = newOrientation;
    }
    public Card(){

    }



    /**
     * The card has their own Location within 3*3 grid
     * @return
     */

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    /**
     * Each card should be defined placement Orientation before put on the board
     * @return
     */
    public newOrientation getOrientation() {
        return newOrientation;
    }

    public void setOrientation(newOrientation newOrientation) {
        this.newOrientation = newOrientation;
    }


    public void deckCardsInitialization(){
        Random random = new Random();
        random.nextInt(0,4);

        List<Card> cardList = new ArrayList<>();
        Card card1 = new HandCard();
        cardList.add(card1);


        List<List<String>> AllDecks=new ArrayList<>();//for all decks set
        AllDecks.add(new ArrayList<>(Arrays.asList(Utility.DECK_A)));
        //ArrayList<>(Arrays.asList(Utility.DECK_A))
        // is type of List<String>

        AllDecks.add(new ArrayList<>(Arrays.asList(Utility.DECK_B)));
        AllDecks.add(new ArrayList<>(Arrays.asList(Utility.DECK_C)));
        AllDecks.add(new ArrayList<>(Arrays.asList(Utility.DECK_D)));

    }



    /**
     * This method is to implement action string placement method
     */
    public abstract void performAction();


}
