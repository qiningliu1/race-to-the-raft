package comp1110.ass2;

import java.util.*;


/**
 * This class is for testing purposes only. You should create and use your own objects to solve the tasks below
 * instead of directly using the strings provided. Note that Task 2 is the only task you are expected to use string
 * manipulation to solve.
 */
public class RaceToTheRaft {

    /**
     * Author: Lujin Sun u7897414 and Ishaan Kapoor u7598889
     *
     * Determine whether a boardState string is well-formed.
     * To be well-formed the string must satisfy all the following conditions:
     * <p>
     * 1. Each line is terminated by a newline character `\n`
     * 2. The number of printable (non-newline) characters in each line is equal AND is either 9 or 18.
     * 3. Each character (except the newline character) is one of the following:
     * - 'b' (blue)
     * - 'B' (blue with blue cat)
     * - 'f' (fire)
     * - 'g' (green)
     * - 'G' (green with green cat)
     * - 'n' (none)
     * - 'o' (objective)
     * - 'p' (purple)
     * - 'P' (purple with purple cat)
     * - 'r' (red)
     * - 'R' (red with red cat)
     * - 'w' (wild)
     * - 'W' (wild with a cat of any colour)
     * - 'y' (yellow)
     * - 'Y' (yellow with yellow cat)
     * 4. The number of lines is either 12, 15 or 18.
     * </p>
     *
     * @param boardString A string representing the boardState
     * @return True if the boardState is well-formed, otherwise false.
     */
    public static boolean isBoardStringWellFormed(String boardString) {
        String[] lines = boardString.split("\n");
        int numLines = lines.length;
        if (numLines != 12 && numLines != 15 && numLines != 18) {
            return false;
        }
        for (String line : lines) {
            if (line.length() != 9 && line.length() != 18) {
                return false;
            }
        }
        String validChars = "bBfgGnopPrRwWyY";
        for (String line : lines) {
            for (char c : line.toCharArray()) {
                if (validChars.indexOf(c) == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Author: Qining Liu u7100555, Ishaan Kapoor u7598889 and Lujin Sun u7897414
     *
     * Make Constructors for each of your objects.
     */
    // FIXME TASK 3

    /**
     * Author: Qining Liu u7100555
     *
     * Draws a random fire tile from those remaining in the bag.
     *
     * @param gameState the current state of the game, including the fire tile bag
     * @return a random fire tile from those remaining, in string form. If there are no tiles remaining, return the
     * empty string.
     */
    public static String drawFireTile(String[] gameState) {
        // Apply gameState[4] to crate GameState object
        FireTiles gameStateObj = new FireTiles(gameState[4]);
        String tileID = gameStateObj.drawFireTileID();

        // update gameState[4] to show draw fireTile ID
        gameState[4] = gameStateObj.getUpdateFireBagState();
        return tileID;
        // FIXME TASK 5
    }


    /**
     * Author: Ishaan Kapoor u7598889
     *
     * Chooses a random challenge from those available in the Utility class according
     * to the given difficulty.
     *
     * @param difficulty the desired difficulty of the challenge
     * @return a random challenge of the given difficulty
     */
    public static String chooseChallenge(int difficulty) {
        Random rand = new Random();
        int bound = 0;
        int origin = 0;
        if (difficulty == 0) {
            origin = 0;
            bound = 3;
        }
        if (difficulty == 1) {
            origin = 4;
            bound = 7;
        }
        if (difficulty == 2) {
            origin = 8;
            bound = 15;
        }
        if (difficulty == 3) {
            origin = 16;
            bound = 23;
        }
        if (difficulty == 4) {
            origin = 24;
            bound = 31;
        }
        if (difficulty == 5) {
            origin = 32;
            bound = 38;
        }
        int index = rand.nextInt(origin,bound);
        return Utility.CHALLENGES[index]; // FIXME TASK 6
    }

    /**
     * Author: Lujin Sun u7897414
     *
     *
     * Draw random cards from the specified decks.
     * The decks string denotes what decks to draw from and how many cards to draw from that deck.
     * <p>
     * For example the drawRequest string "A4B1D1" tells us that we should draw 4 cards from deck A, 1 card from deck B
     * and
     * 1 card from deck D.
     * <p>
     * If I draw cards a, b, d, l, from deck A, card a from deck B and card s from deck D, I would return the string:
     * "AabdlBaCDs".
     * Decks should be listed in alphabetical order, with cards drawn from that deck also listed in alphabetical order.
     * </p>
     * Recall the mapping between deck and char:
     * A -> CIRCLE;
     * B -> CROSS;
     * C -> SQUARE;
     * D -> TRIANGLE;
     *
     * @param gameState   the current state of the game, including the current state of the decks
     * @param drawRequest A string representing the decks to draw from and the number of cards to draw from each respective
     *                    deck.
     * @return The updated gameState array after the cards have been drawn. (Remove all cards drawn from decks and
     * add them to the Hand string). If it is not possible
     * to draw all the specified cards, you should return the original gameState.
     */
    public static String[] drawHand(String[] gameState, String drawRequest) {
        String decks = gameState[1];
        String[] deckStrings = decks.split("(?=[A-Z])");
        char[] deckNames = new char[deckStrings.length];
        String[] deckCards = new String[deckStrings.length];
        for (int i = 0; i < deckStrings.length; i++){
            deckNames[i] = deckStrings[i].charAt(0);
            deckCards[i] = deckStrings[i].substring(1);
        }

        char[] drawDeckNames = new char[drawRequest.length() / 2];
        int[] drawCounts = new int[drawRequest.length()/2];
        for (int i =0; i <drawRequest.length(); i += 2){
            drawDeckNames[i/2] = drawRequest.charAt(i);
            drawCounts[i / 2] = Character.getNumericValue(drawRequest.charAt(i + 1));
        }

        StringBuilder hand = new StringBuilder(gameState[2]);
        int index = 0;
        for (int i = 0; i < drawDeckNames.length; i++){
            char drawDeckName = drawDeckNames[i];
            int count = drawCounts[i];
            for (int j = 0; j < deckNames.length;j++){
                if (deckNames[j] == drawDeckName){
                    String cards = deckCards[j];
                    if (cards == null || cards.length() < count){
                        return gameState;
                    }
                    hand.insert(index, cards.substring(0,count));
                    index += count;
                    deckCards[j] = cards.substring(count);
                    break;
                }
            }
        }

        StringBuilder updatedDecks = new StringBuilder();
        for (int i = 0; i < deckNames.length; i++){
            updatedDecks.append(deckNames[i]).append(deckCards[i]);

        }

        char[] sortedDeckNames = Arrays.copyOf(deckNames,deckNames.length);
        Arrays.sort(sortedDeckNames);
        String[] sortedDeckCards = new String[deckNames.length];
        for (int i = 0; i < sortedDeckNames.length; i++){
            char deckName = sortedDeckNames[i];
            for (int j = 0; j < deckNames.length; j++){
                if (deckNames[j] == deckName){
                    sortedDeckCards[i] = deckCards[j];
                    break;
                }
            }
        }

        gameState[1] = updatedDecks.toString();
        gameState[2]= hand.toString();
        return gameState; // FIXME TASK 7
    }


    /**
     * Place the given card or fire tile as described by the placement string and return the updated gameState array.
     * See the README for details on these two strings.
     * You may assume that the placements given are valid.
     * <p>
     * When placing a card, you should update both the Board string and remove the corresponding card from the Hand
     * string in the gameState array.
     *
     * @param gameState       An array representing the game state.
     * @param placementString A string representing a Fire comp1110.ass2.Tile Placement or a Card Placement.
     * @return the updated gameState array after this placement has been made
     */
    public static String[] applyPlacement(String[] gameState, String placementString) {
        return new String[0]; // FIXME TASK 8
    }

    /**
     * Move the given cat as described by the cat movement string and return the updated gameState array. You may
     * assume that the cat movement is valid.
     * <p>
     * You should both move the cat (updating the Board string) and also add the cat to the Exhausted Cats string, or
     * update that cat's reference in the Exhausted Cats string if it was already exhausted.
     *
     * @param gameState      An array representing the game state.
     * @param movementString A string representing the movement of a cat and the cards discarded to allow this move.
     * @return the updated gameState array after this movement has been made.
     */
    public static String[] moveCat(String[] gameState, String movementString) {
        //complement movementString
        String catId = movementString.substring(0,1);
        String cat = catId+movementString.substring(5,9);
        String start = movementString.substring(0,5);
        int exhaustedLen =  gameState[3].length();
        //find exhausted cats and add them into movementString
        if(exhaustedLen==0){
            gameState[3] = gameState[3]+cat;
        }else{
            List<String> list = new ArrayList<>();
            list.add(cat);
            for(int i=0;i+5<=exhaustedLen;i+=5){
                String ts = gameState[3].substring(i,i+5);
                //judge whether the cat is on moving action
                if(ts.equals(start)) continue;
                list.add(gameState[3].substring(i,i+5));
            }
            Collections.sort(list);
            StringBuilder temp = new StringBuilder();
            for(String str:list){
                temp.append(str);
            }
            gameState[3] = temp.toString();
        }
        //update the state of board
        String[] map = gameState[0].split("\n");
        int len = map[0].length();
        int x1 = Integer.parseInt(movementString.substring(1,3));
        int y1 = Integer.parseInt(movementString.substring(3,5));
        int x2 = Integer.parseInt(movementString.substring(5,7));
        int y2 = Integer.parseInt(movementString.substring(7,9));
        //convert letters in cat's initial position to lowercase
        map[x1] = map[x1].substring(0,y1)+catId.toLowerCase()+(y1+1<len?map[x1].substring(y1+1):"");
        //convert the letters of the cat's end position to uppercase
        map[x2] = map[x2].substring(0,y2)+catId+(y2+1<len?map[x2].substring(y2+1):"");
        StringBuilder stringBuilder = new StringBuilder();
        for(String s:map){
            stringBuilder.append(s);
            stringBuilder.append("\n");
        }
        gameState[0] = stringBuilder.toString();
        return gameState;
    }// FIXME TASK 9


    /**
     * Given a challengeString, construct a board string that satisfies the challenge requirements.
     * <p>
     * Each board in the `squareBoard` or `rectangleBoard` arrays may only be used once. For example: if the
     * challenge requires 4 Large (square) boards, you must use all 4 square boards. You may not use the same board
     * twice, even in different orientations.
     * The cat, fire card and raft card placements should all match the challenge string.
     *
     * @param challengeString A string representing the challenge to initialise
     * @return A board string for this challenge.
     */
    public static String initialiseChallenge(String challengeString) {
        return "";  // FIXME 10
    }


    /**
     * Given a card placement string or a fire tile placement string, check if that placement is valid.
     * <p>
     * A card placement is valid if all the following conditions are met:
     * <p>
     * 1. No part of the card is off-board
     * 2. No part of the card is overlapping fire.
     * 3. No part of the card is overlapping a cat.
     * 4. No part of the card is overlapping part of a Raft card (any of the 8 squares surrounding the `o`
     * state)
     * </p>
     * A fire tile placement is valid if all the following conditions are met:
     * <p>
     * 1. No part of the fire tile is off-board
     * 2. No part of the fire tile overlaps fire
     * 3. No part of the fire tile overlaps a cat
     * 4. No part of the fire tile overlaps part of a Raft card (any of the 8 squares surrounding the `o` state)
     * 5. The Fire tile is orthogonally adjacent to another fire square.
     * </p>
     *
     * @param gameState       An array representing the gameState
     * @param placementString A string representing a card placement or a fire tile placement
     * @return True if the placement is valid, otherwise false.
     */
    public static boolean isPlacementValid(String[] gameState, String placementString) {
        return false; // FIXME TASK 12
    }

    /**
     * Given a cat movement string, check if the cat movement is valid.
     * <p>
     * A cat movement is valid if:
     * 1. The end location is the same colour as the cat.
     * 2. There is a path from start location to the end location, consisting only of squares the same colour as the
     * cat.
     * 3. The path does not include diagonal movements.
     *
     * @param gameState         An array representing the gameState
     * @param catMovementString A string representing a cat movement.
     * @return True if the cat movement is valid, otherwise false
     */
    public static boolean isCatMovementValid(String[] gameState, String catMovementString) {
        return false; // FIXME TASK 14
    }


    /**
     * Determine whether the game is over. The game ends if any of the following conditions are met:
     * <p>
     * Fire tile placement:
     * 1. If this placement action is not valid AND there is no other position this tile could be placed validly
     * (the game is lost).
     * 2. If placing this fire tile makes it impossible for any one cat to reach the raft (the game is lost).
     * <p>
     * Cat movement:
     * 1. If after moving this cat, all cats have safely reached the raft (the game is won).
     * <p>
     * Card placement:
     * 1. If after placing this card, there are no more fire tiles left in the bag (the game is lost).
     * </p>
     *
     * @param gameState An array of strings representing the game state
     * @param action    A string representing a fire tile placement, cat movement or card placement action.
     * @return True if the game is over (regardless of whether it is won or lost), otherwise False.
     */
    public static boolean isGameOver(String[] gameState, String action) {
        return false;     // FIXME TASK 15
    }


}
