package QiningBranch;

import comp1110.ass2.Utility;

import java.util.*;
/**
 * Author : Qining Liu u7100555
 */
public class newDecks {
    public Map<Character, List<HandCard>> DecksCard;
    public List<HandCard> decksA;
    public List<HandCard> decksB;
    public List<HandCard> decksC;
    public List<HandCard> decksD;

    /**
     * Initialize Each DecksCard
     */
    public newDecks() {
        initializeDecks();
    }

    public List<HandCard> getDecksA() {
        return this.decksA;
    }

    public List<HandCard> getDecksB() {
        return this.decksB;
    }

    public List<HandCard> getDecksC() {
        return this.decksC;
    }

    public List<HandCard> getDecksD() {
        return this.decksD;
    }

    public void initializeDecks() {
        this.DecksCard = new HashMap<>();

        this.decksA = new ArrayList<>();
        for (String handCardA : Utility.DECK_A) {
            this.decksA.add(new HandCard(handCardA));
        }

        this.decksB = new ArrayList<>();
        for (String handCardB : Utility.DECK_B) {
            this.decksB.add(new HandCard(handCardB));
        }

        this.decksC = new ArrayList<>();
        for (String handCardC : Utility.DECK_C) {
            this.decksC.add(new HandCard(handCardC));
        }

        this.decksD = new ArrayList<>();
        for (String handCardD : Utility.DECK_D) {
            this.decksD.add(new HandCard(handCardD));
        }

        this.DecksCard.put('A', this.decksA);
        this.DecksCard.put('B', this.decksB);
        this.DecksCard.put('C', this.decksC);
        this.DecksCard.put('D', this.decksD);
    }

    public HandCard drawRequestFromDeck(char deckID) {
        Random random = new Random();
        List<HandCard> selectedDeck = this.DecksCard.get(deckID);

        if (selectedDeck != null && !selectedDeck.isEmpty()) {
            int randomIndex = random.nextInt(selectedDeck.size());
            return selectedDeck.remove(randomIndex);
        } else {
            System.out.println("Wrong Decks selection or Deck is empty");
            return null;
        }
    }

}
