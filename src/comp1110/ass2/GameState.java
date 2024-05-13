package comp1110.ass2;
import comp1110.ass2.gui.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameState<T> {
    private GameState<T> board;
    private GameState<T> decks;
    private GameState<T> hand;
    private GameState<T> ExhaustedCat;
    private GameState<T> FireTiles;


    /**
     * Built a constructor to transfer GameState string
     * Initialize objects state
     */

public static void initialize(){

    GameState<Decks> decks = new GameState<>();
    GameState<List<Hand>> hand = new GameState<>();

}

public void getHand(){
    GameState.initialize();
    List<Hand> hand= new ArrayList<>();
    if(hand.isEmpty()){
        System.out.println("There is no cards in Players hand");
    }
    hand.get(0);
}








}

