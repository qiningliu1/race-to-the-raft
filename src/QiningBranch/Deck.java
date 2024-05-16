package QiningBranch;
/**
 * Author : Qining Liu u7100555
 */
import comp1110.ass2.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Deck<T> {
    private List<T> cards;

    public Deck(List<T> initialCards) {
        this.cards = new ArrayList<>(initialCards);//initialized Array list
    }

    /**
     * Default constructor I used
     */
    public Deck(){
        this.cards = new ArrayList<>();//empty decks
    }

    /**
     *
     * @return a "List of" List<String>,List<String> can be acquired from asList function by Utility
     */
    public static List<List<String>> initializeDeck(){
        List<List<String>> AllDecks=new ArrayList<>();//for all decks set
        AllDecks.add(new ArrayList<>(Arrays.asList(Utility.DECK_A)));
        //ArrayList<>(Arrays.asList(Utility.DECK_A))
        // is type of List<String>

        AllDecks.add(new ArrayList<>(Arrays.asList(Utility.DECK_B)));
        AllDecks.add(new ArrayList<>(Arrays.asList(Utility.DECK_C)));
        AllDecks.add(new ArrayList<>(Arrays.asList(Utility.DECK_D)));
        return AllDecks;
    }

    /**
     *
     * @return In this case, return string of each Card with {CardID}{CardInfo}
     */

    public T drawRandomCards(){
        this.cards = cards;
        Random random = new Random();
        int index = random.nextInt(cards.size());
        if(cards.isEmpty()){
            throw new IllegalStateException("Can not draw card from empty decks");
        }
        return cards.remove(index);//this return is important
    }

    public static List<String> getDeckByIndex (int Index){
        List<List<String>> deck=  initializeDeck();//static method
        if(Index > deck.size()){
            throw new IndexOutOfBoundsException();
        }

        return deck.get(Index);
    }

    public List<String> showClear(int Index) {
        List<String> show= getDeckByIndex(Index);
        return show;
    }

    public static void main(String[] args) {
        //Example
        // String a = "a";
        //Deck<String> cards = new Deck<>(a);
        /**
         * here is the example of DecKA
         */
//        String[] a=  Utility.DECK_A;
//
//        //By this way our List go in to-> Deck
//        List<String> list=new ArrayList<>(Arrays.asList(a));
//        Deck<List> cards = new Deck<>(list);
//
//
//        System.out.println(cards);//return address
//        System.out.println(cards.cards);
//
//        //Find something difference between this two
//        List<List> c=cards.get();
//        System.out.println(c);
//
//        /**
//         * now compare whole List,we can get all cards by this method
//         */
//        Deck<List> whole = new Deck<>();
//        List<List> wholeDecks=whole.initializeDeck();
//        System.out.println(wholeDecks);
//
//        List<String> temp = new ArrayList<>();
//        temp =wholeDecks.get(0);//这个赋值匹配说明get取到的T是List
//        System.out.println(temp);

        /**
         * Test for all Methods
         * First for deckA
         */
        //test static method
        Deck<String> deckA = new Deck<>(getDeckByIndex(0));
        System.out.println(deckA);
        System.out.println(deckA.showClear(0));
        System.out.println(deckA.drawRandomCards());

        /**
         * Test for all Methods
         * For deckB
         */
        Deck<String> deckB = new Deck<>(getDeckByIndex(1));
        System.out.println(deckB);
        System.out.println(deckB.showClear(1));

        //So draw card method in this case return a string
        String drawRandom=deckB.drawRandomCards();
        System.out.println(drawRandom);


        // this method get ID
        char charID = drawRandom.charAt(0);
        System.out.println(charID);

        //then get CardInfo
        String cardInfo = drawRandom.substring(1,drawRandom.length());
        System.out.println(cardInfo);

    }

}
