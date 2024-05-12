package comp1110.ass2;
import comp1110.ass2.gui.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Author: Qining Liu u7100555 and Ishaan Kapoor u7598889
 */
public class GameState {

    private Board board;
    private Decks decks;
    private Decks hand;  // hand is also a type of deck
    private ArrayList<TileType> exhaustedCats;
    private ArrayList<FireTiles> fireTileBag;




    public GameState (String[] GameState) {
        this.board = new Board(GameState[0]);
        this.decks = new Decks(GameState[1]);
        this.hand = new Decks(GameState[2]);
        this.exhaustedCats = null;
        this.fireTileBag = null;
    }

    public Board getBoard() {
        return board;
    }

    public Decks getDecks() {
        return decks;
    }

    public Decks getHand() {
        return hand;
    }

    public void setHand(Decks hand) {
        this.hand = hand;
    }
}
















//    /**
//     * Built a constructor to transfer GameState string
//     * Initialize objects state
//     */
//
//public GameState(String gameState[]){
//    //Board board = new Board(gameState[0]);
//    //board = new Board(gameState[0]);
//    this.board = new Board(gameState[0]);
//    //decks = new Decks(gameState[1]);
//    this.hand = new Hand(gameState[2]);
//    this.ExCats = new ExhaustedCat(gameState[3]);
//    this.FireTiles = new FireTiles(gameState[4]);
//}
//
//
//
//
//public String[] gameState (){
//
//    return null;
//}
//
//
//
//public Object[] getGameState()
//    {
//        Object[] gameState = new Object[4];
//        gameState[0] = board;
//        gameState[1] = decks;
//        gameState[2] = ExCats;
//        return gameState;
//
//    }
//
//}
//
