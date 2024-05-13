package comp1110.ass2;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Cards> hand = new ArrayList<>();

    public boolean isEmpty(){
        if(hand.isEmpty()){
            return false;
        }
        return true;
    }
    public void addCards(Cards cards){
        hand.add(cards);
    }
    public void drawCards(Cards cards){
        if(cards!=null){
            hand.remove(cards);
        }
        else{System.out.println("you have no cards in hand");}
    }

    /**
        maybe we don't want players to change their cards
     */
    public void changeCards(int index,Cards cards){
        hand.set(index,cards);
    }



}
