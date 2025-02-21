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
    private ArrayList<FireTile> fireTileBag;




    public GameState (String[] gameState) {
        this.board = new Board(gameState[0]);
        this.decks = new Decks(gameState[1]);
        this.hand = new Decks(gameState[2]);
        this.exhaustedCats = null;
        this.fireTileBag = FireTile.fireTileBagFromString(gameState[4]);
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

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<FireTile> getFireTileBag() {
        return fireTileBag;
    }

    public void setFireTileBag(ArrayList<FireTile> fireTileBag) {
        this.fireTileBag = fireTileBag;
    }
}














