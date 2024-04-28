package comp1110.ass2;
import comp1110.ass2.gui.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameState {
    String [] gameState;
    private Board board;
    private Decks[][] decks;
    private ExhaustedCat[] ExCats;
    private FireTiles[][] FireBag;

public GameState(Board board,Decks[][] decks, ExhaustedCat[] ExCats,FireTiles[][] FireBag){
    this.board= board;
    this.decks = decks;
    this.ExCats = ExCats;
    this.FireBag = FireBag;
}

public String[] gameState (){





    return null;
}



public Object[] getGameState()
    {
        Object[] gameState = new Object[4];
        gameState[0] = board;
        gameState[1] = decks;
        gameState[2] = ExCats;
        gameState[3] = FireBag;
        return gameState;

    }

}

