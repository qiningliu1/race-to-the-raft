package QiningBranch.test;

import QiningBranch.HandCard;
import QiningBranch.newDecks;
import QiningBranch.newTileType;

import java.util.List;

public class DecksTest {
    public static void main(String[] args) {
        newDecks newDecks = new newDecks();
        newDecks.initializeDecks();


      List<HandCard> handCardListA = newDecks.getDecksA();
        System.out.println(handCardListA);
        newDecks.drawRequestFromDeck('A');
        System.out.println("======================");
        System.out.println(handCardListA);

      HandCard handCard2 =  handCardListA.get(2);
    newTileType[][] Tile = handCard2.getCardLayOut();
        System.out.println(Tile[0][0]);

    }
}
