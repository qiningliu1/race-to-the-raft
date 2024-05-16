//package comp1110.ass2;
//
//import java.util.*;
//
//public class Deck {
//
//    private static final String[] DECK_A = Utility.DECK_A;
//    private static final String[] DECK_B = Utility.DECK_B;
//    private static final String[] DECK_C = Utility.DECK_C;
//    private static final String[] DECK_D = Utility.DECK_D;
//
//    private final Map<Character, List<String>> decks;
//
//    public Deck() {
//        this.decks = new HashMap<>();
//        initializeDeck(DECK_A, 'A');
//        initializeDeck(DECK_B, 'B');
//        initializeDeck(DECK_C, 'C');
//        initializeDeck(DECK_D, 'D');
//    }
//
//    private void initializeDeck(String[] cardsInDeck, char deckID) {
//        List<String> deck = new ArrayList<>(Arrays.asList(cardsInDeck));
//        Collections.shuffle(deck);
//        decks.put(deckID, deck);
//    }
//
//    // 从指定的牌堆中随机抽取一张牌
//    public String drawCard(char deckID) {
//        List<String> deck = decks.get(deckID);
//        if (deck != null && !deck.isEmpty()) {
//            int randomNumber = new Random().nextInt(deck.size());
//            return deck.remove(randomNumber);
//        } else {
//            return null; // 牌堆为空，返回 null
//        }
//    }
//
//    // 从指定的牌堆中根据指定的卡牌 ID 抽取一张牌
//    public String drawCard(char deckID, char cardID) {
//        List<String> deck = decks.get(deckID);
//        if (deck != null) {
//            for (int i = 0; i < deck.size(); i++) {
//                String card = deck.get(i);
//                if (card.charAt(0) == cardID) {
//                    return deck.remove(i);
//                }
//            }
//            return ""; // 没有找到对应的卡牌，返回空字符串
//        } else {
//            System.out.println("Deck with ID " + deckID + " does not exist");
//            return ""; // 指定的牌堆不存在，返回空字符串
//        }
//    }
//
//    // 获取指定牌堆的牌数
//    public int getDeckSize(char deckID) {
//        List<String> deck = decks.get(deckID);
//        return deck != null ? deck.size() : 0;
//    }
//
//    // 打印指定牌堆的所有卡牌
//    public void getDeckCards(char deckID) {
//        List<String> deck = decks.get(deckID);
//        if (deck != null) {
//            Collections.sort(deck);
//            for (String card : deck) {
//                System.out.println(card);
//            }
//        } else {
//            System.out.println("Deck with ID " + deckID + " does not exist");
//        }
//    }
//}
//
