package comp1110.ass2;

import gittest.B;
import gittest.C;

import java.util.ArrayList;

/**
 * Author: Ishaan Kapoor u7598889
 */
public class test {
    public static void main(String[] args) {
        ArrayList<FireTile> testBag= new ArrayList<>();
        testBag = FireTile.fireTileBagFromString("abcdefghijklmnopqrstuvwxyzABCDE");
        FireTile tile = new FireTile("y0001111221");
        FireTile tileEast = FireTile.rotateFireTile(tile,Orientation.EAST);
        FireTile tileSouth = FireTile.rotateFireTile(tile,Orientation.SOUTH);
        FireTile tileWest = FireTile.rotateFireTile(tile,Orientation.WEST);
        TileType[][] testTiles = tile.getFireTile();
        FireTile.flipFireTileNorthSouth(testTiles);


        System.out.println(tile);
        System.out.println(new FireTile('1' , testTiles));



    }//flip and rotate working
}

//        int deckIndex = 1;
//        Cards requiredCard = Decks.getCardFromIDs(Decks.DECK_ID.B,'l');
//        Decks hand = new Decks("AwBaejlCDo");
//        ArrayList<Decks.SingleDeck> singleDeckHand = new ArrayList<>();
//
//        for(Decks.SingleDeck s: hand.getFulldeck()) {
//            singleDeckHand.add(s);
//        }
//
//        Decks.SingleDeck required = new Decks.SingleDeck(hand.getFulldeck().get(deckIndex).toString());
//
//
//
//        ArrayList<Cards> finalCards = new ArrayList<>();
//        for (Cards s : hand.getFulldeck().get(deckIndex).getCards()) {
//            finalCards.add(s);
//        }
//
//        finalCards.remove(requiredCard);
//
//        required.setCards(finalCards);
//
//        singleDeckHand.set(deckIndex,required);
//        Decks finalHand = new Decks(singleDeckHand);
//
//        ArrayList<Integer> ints = new ArrayList<>();
//        ints.add(0);
//        ints.add(1);
//        ints.add(2);
//        ints.add(3);
//
//        ints.remove(0);
//
//        System.out.println(finalHand);
//
//    }

