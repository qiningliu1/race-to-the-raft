package comp1110.ass2;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class GameState {
    private Decks decks;
    private FireTiles firetiles;


    public GameState(String[] gameState) {
        this.decks = new Decks(gameState);
        this.firetiles= new FireTiles(gameState[4]);
    }


}

