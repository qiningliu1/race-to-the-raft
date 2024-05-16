package QiningBranch;

import comp1110.ass2.Utility;

import java.util.*;
/**
 * Author : Qining Liu u7100555
 */
public class newDecks {

    char deckID;
    HandCard handCard;
    Map<Character,List<HandCard>> DecksCard;
    List<HandCard> decksA;
    List<HandCard> decksB;
    List<HandCard> decksC;
    List<HandCard> decksD;


    /**
     * Initialize Each DecksCard
     */
    public newDecks(){

    }

    public List<HandCard> getDecksA() {
        this.decksA = this.DecksCard.get('A');
        return this.decksA;
    }

    public List<HandCard> getDecksB() {
        this.decksA = this.DecksCard.get('B');
        return this.DecksCard.get('B');
    }

    public List<HandCard> getDecksC() {
        this.decksA = this.DecksCard.get('C');
        return this.DecksCard.get('C');
    }

    public List<HandCard> getDecksD() {
        this.decksA = this.DecksCard.get('D');
        return this.DecksCard.get('D');
    }

    public  Map<Character,List<HandCard>> initializeDecks (){
        this.DecksCard = new HashMap<>();
        String[] deckA = Utility.DECK_A;
        List<HandCard> handCardListA = new ArrayList<>();
        for (int indexDeckA = 0; indexDeckA < deckA.length; indexDeckA++) {
          String handCardA = deckA[indexDeckA];
          handCardListA.add(new HandCard(handCardA));
        }
        String[] deckB = Utility.DECK_B;
        List<HandCard> handCardListB = new ArrayList<>();
        for (int indexDeckB = 0; indexDeckB < deckB.length; indexDeckB++) {
            String handCardB = deckB[indexDeckB];
            handCardListB.add(new HandCard(handCardB));
        }

        String[] deckC = Utility.DECK_C;
        List<HandCard> handCardListC = new ArrayList<>();
        for (int indexDeckC = 0; indexDeckC < deckC.length; indexDeckC++) {
            String handCardC = deckC[indexDeckC];
            handCardListC.add(new HandCard(handCardC));
        }
        String[] deckD = Utility.DECK_D;
        List<HandCard> handCardListD = new ArrayList<>();
        for (int indexDeckD = 0; indexDeckD < deckD.length; indexDeckD++) {
            String handCardD = deckD[indexDeckD];
            handCardListD.add(new HandCard(handCardD));
        }

        this.DecksCard.put('A', handCardListA);
        this.DecksCard.put('B', handCardListB);
        this.DecksCard.put('C', handCardListC);
        this.DecksCard.put('D', handCardListD);

        return this.DecksCard;
    }

    public HandCard drawRequestFromDeck(char deckID){
        Random random = new Random();

        if (deckID == 'A'&& this.decksA.size()!=0){
            int randomIndex = random.nextInt(this.decksA.size());
            return this.decksA.remove(randomIndex);
        }
        else if (deckID == 'B' && this.decksB.size() != 0) {
            int randomIndex = random.nextInt(this.decksB.size());
            return this.decksB.remove(randomIndex);
        }

        else if (deckID == 'C' && this.decksC.size() != 0) {
            int randomIndex = random.nextInt(this.decksC.size());
            return this.decksC.remove(randomIndex);
        }

        else if (deckID == 'D' && this.decksD.size() != 0) {
            int randomIndex = random.nextInt(this.decksD.size());
            return this.decksD.remove(randomIndex);
        }

        else{
            System.out.println("Wrong Decks selection");
            return null;
        }

    }








}
