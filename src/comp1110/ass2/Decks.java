package comp1110.ass2;
/**
 * Author: Ishaan Kapoor u7598889
 **/
public class Decks {
    private String deckString;
    private String[] decksArray;

    public Decks(String[] gameState) {
        this.deckString = gameState[1];
        this.decksArray = deckString.split("(?=[A-Z])");
    }
    public String[] returnDecksArray() {
        return decksArray;
    }
}
