package QiningBranch;
/**
 * Author : Qining Liu u7100555
 */
import java.util.List;

public class GenericTest<T,R> {
    private List<Deck> HandCards;
    private List<FireTilesBag> FireTiles;
    public List<String> getHandCards(int index) {
        Deck<T> HandCards = new Deck<>();

        List<List<String>> deckCards =HandCards.initializeDeck();

        if(index >= deckCards.size()){
            throw new IndexOutOfBoundsException();
        }
        return deckCards.get(index);
    }
    public void setHandCards(List<Deck> handCards) {
        HandCards = handCards;
    }

    public static void main(String[] args) {
       GenericTest<Deck, FireTilesBag> status1 = new GenericTest<>();

        System.out.println(status1.getHandCards(1));


    }




}
