package QiningBranch;
/**
 * Author : Qining Liu u7100555
 */
import java.util.Collections;
import java.util.List;

/**
 * This Class include the state of the game and supporting methods
 * that allow the game to be solved
 */

public class GameState {

    /**
     * The challenge represents the current case include Island,Fire,Cat,Raft status
     */

    private Challenge challenge;
    private newBoard newBoard;
    private List<Deck> decks;
    private Card pathwayCards;
    private newCatCards exhaustCat;
    private List<FireTilesBag> FireTiles;

    private List<Location> locationList;
    /**
     * Given a challenge and initialise the game challenge
     * @param challenge
     */
    public GameState(Challenge challenge){
        this.challenge = challenge;

        Collections.sort(locationList);
    }

    public GameState(){

    }

    /**
     * Initialise the state with the board
     */
    public void initialiseBoard(String boardString){
        newBoard.getGameBoard(boardString);
    }

    /**
     * Initialise the Decks of pathway cards for this game
     */
    public void initialiseDecks(){

    }

    /**
     * This method is for initialize total decks and get a card from the decks players choose
     *
     *
     * @param index
     * @return
     */
    public List<String> getHandCards(int index) {
      Deck<String> HandCards = new Deck<>();

      List<List<String>> deckCards =HandCards.initializeDeck();

      if(index >= deckCards.size()){
          throw new IndexOutOfBoundsException();
      }
      return deckCards.get(index);
    }

    public void setHandCards(List<Deck> handCards) {
        decks = handCards;
    }

    /**
     * This Method is for placement of card and FireTiles
     * @param type
     * @param placementDetails
     */
    public void placeCardOrTiles(String type,String placementDetails){
        //True for pathwayCards(a method to return a string at here)
        if(type.equals(pathwayCards)){
            updateBoardForPathwayCard(placementDetails);
        }
        else if (type.equals(FireTiles)) {
            updateBoardForFireTile(placementDetails);
        }

    }

    // This method can updateBoard to place pathwayCard
    public void updateBoardForPathwayCard(String placementDetails) {
        // updateDetails
    }

    // This method can updateBoard to place FireTiles
    public void updateBoardForFireTile(String placementDetails) {
        // updateDetails
    }


}
