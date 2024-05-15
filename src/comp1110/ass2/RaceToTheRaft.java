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
        if (gameState[4] == "") {
            return "";
        }

        GameState game = new GameState(gameState);
        Random rand = new Random();
        ArrayList<FireTile> bag = game.getFireTileBag();
        FireTile req = bag.get(rand.nextInt(bag.size()));


        return req.toString();



//        // Apply gameState[4] to crate GameState object
//        FireTiles gameStateObj = new FireTiles(gameState[4]);
//        String tileID = gameStateObj.drawFireTileID();
//
//        // update gameState[4] to show draw fireTile ID
//        gameState[4] = gameStateObj.getUpdateFireBagState();
//        return tileID;
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
        return FireTile.placeFireTileOnBoard(gameState,placementString);

         // FIXME TASK 8
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
        char[] cards = movementString.substring(9).toCharArray();
        //check handcard and update it
        String[] haveCard = new String[4];
        gameState[2]=gameState[2]+'E';
        for(int i=0;i<4;i++){
            haveCard[i] = gameState[2].substring(gameState[2].indexOf('A'+i),gameState[2].indexOf('B'+i));
        }
        int k = 0;
        while(k<cards.length){
            int c = cards[k++]-'A';
            while(k<cards.length&&cards[k]>='a'){
                haveCard[c].replace(cards[k]+"","");
                k++;
            }
        }
        StringBuilder newHaveCard = new StringBuilder();
        for(int i=0;i<4;i++){
            newHaveCard.append('A'+i);
            newHaveCard.append(haveCard[i]);
        }
        gameState[2] = newHaveCard.toString();
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
        map[x2] = map[x2].substring(0,y2)+map[x2].substring(y2,y2+1).toUpperCase()+(y2+1<len?map[x2].substring(y2+1):"");
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
        Board initial = Island.getInitialIsland(challengeString);
        Island.applyFireCard(initial,challengeString);
        Island.applyRaft(initial,challengeString);
        Island.applyCatCard(initial,challengeString);





        return initial.toString();

         // FIXME 10
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
        if(!check(placementString)) return false;

        TileType[][] gameboard = Board.getGameBoard(gameState[0]);
        int len = gameboard.length;
        int hig = gameboard[0].length;
        if(placementString.charAt(1)>'9'){
            int x = Integer.parseInt(placementString.substring(2,4))+1;
            int y = Integer.parseInt(placementString.substring(4,6))+1;
            if(x+1>=len||x==0||y+1>=hig||y==0) return false;
            for(int i=x-1;i<=x+1;i++){
                for(int j=y-1;j<=y+1;j++){
                    switch (gameboard[i][j]){
                        case Fire:
                        case BLUE_CAT:
                        case RED_CAT:
                        case PURPLE_CAT:
                        case YELLOW_CAT:
                        case GREEN_CAT:
                            return false;
                    }
                }
            }
            int l = y-2>0?y-2:0;
            int r = y+2<hig?y+2:hig-1;
            int low = x-2>0?x-2:0;
            int up = x+2<len?x+2:len-1;
            for(int i=low;i<=up;i++){
                for(int j=l;j<=r;j++){
                    if(gameboard[i][j]==TileType.Object) return false;
                }
            }
            return true;
        }
        int index = placementString.charAt(0)>='a'?placementString.charAt(0)-'a':placementString.charAt(0)-'A'+26;
        FireTile tile = new FireTile(Utility.FIRE_TILES[index]);
        if(tile.getFireTile()==null) return false;
        TileType[][] fileTile = tile.getFireTile();
        if(placementString.charAt(5)=='F'){
            fileTile = FireTile.rotateFireTile(tile,Orientation.fromChar(placementString.charAt(6))).getFireTile();
        }else{
            FireTile.flipFireTileNorthSouth(fileTile);
            tile.setFireTile(fileTile);
            fileTile = FireTile.rotateFireTile(tile,Orientation.fromChar(placementString.charAt(6))).getFireTile();
        }

        int x = Integer.parseInt(placementString.substring(1,3));
        int y = Integer.parseInt(placementString.substring(3,5));
        int fileTileLen = fileTile.length;
        if(x+fileTileLen>=len&&y+fileTileLen>=hig) return false;
        boolean f = false;
        for(int i=0;i<fileTileLen;i++){
            int tx = i+x;
            for(int j=0;j<fileTileLen;j++){
                int ty = y+j;
                if(tx>=len||ty>=hig){
                    if (fileTile[i][j]==TileType.Fire) return false;
                    continue;
                }
                if(fileTile[i][j]==TileType.Fire) {
                    switch (gameboard[tx][ty]) {
                        case Fire:
                        case BLUE_CAT:
                        case RED_CAT:
                        case PURPLE_CAT:
                        case YELLOW_CAT:
                        case GREEN_CAT:
                        case Object:
                            return false;
                    }
                    if(isOnRaft(tx,ty,gameboard)) return false;
                    if(i==0){
                        if(tx>0&&gameboard[tx-1][ty]==TileType.Fire) f = true;
                    }else if(i==fileTileLen-1){
                        if(tx+1<len&&gameboard[tx+1][ty]==TileType.Fire) f = true;
                    }
                    if(j==0){
                        if(ty>0&&gameboard[tx][ty-1]==TileType.Fire) f = true;
                    }else if(j==fileTileLen-1){
                        if(ty+1<hig&&gameboard[tx][ty+1]==TileType.Fire) f = true;
                    }
                }
            }

        }
        return f; // FIXME TASK 12
    }



    public static boolean check(String placementString){
        int len = placementString.length();
        if(placementString==null||(len!=7)) return false;
        char start = placementString.charAt(0);
        if(placementString.charAt(1)>='a'){
            if(start<'A'||start>'D') return false;
            if(placementString.charAt(1)<'a'||placementString.charAt(1)>'z') return false;
            for(int i = 2;i<6;i++){
                if(placementString.charAt(i)<'0'||placementString.charAt(i)>'9') return false;
            }

        }else{
            if(!((start>='A'&&start<='Z')||(start>='a'&&start<='z'))) return false;
            for(int i = 1;i<5;i++){
                if(placementString.charAt(i)<'0'||placementString.charAt(i)>'9') return false;
            }
            if(placementString.charAt(5)!='F'&&placementString.charAt(5)!='T') return false;
        }
        switch (placementString.charAt(6)){
            case 'N':
                break;
            case 'W':
                break;
            case 'E':
                break;
            case 'S':
                break;
            default:
                return false;
        }
        return true;
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
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        TileType[][] gameboard = Board.getGameBoard(gameState[0]);
        int c = 0;
        for(TileType[] te:gameboard){

            c++;
        }
        c = 0;
        String[] mp = gameState[0].split("\n");
        for(String str:mp){

            c++;
        }
        int len = gameboard.length;
        int hig = gameboard[0].length;
        int x1 = Integer.parseInt(catMovementString.substring(1,3));
        int y1 = Integer.parseInt(catMovementString.substring(3,5));
        int x2 = Integer.parseInt(catMovementString.substring(5,7));
        int y2 = Integer.parseInt(catMovementString.substring(7,9));

        gameState[2]=gameState[2]+'E';
        String[] haveCard = new String[4];
        for(int i=0;i<4;i++){
            haveCard[i] = gameState[2].substring(gameState[2].indexOf('A'+i),gameState[2].indexOf('B'+i));
        }
        if(catMovementString.length()==11){
            if(gameState[3].contains(catMovementString.substring(1,5))) return false;

            int index = catMovementString.charAt(9)-'A';
            if(haveCard[index].indexOf(catMovementString.charAt(10))==-1) return false;
        }else{
            if(!gameState[3].contains(catMovementString.substring(1,5))) return false;
            if(catMovementString.length()==12){
                int index = catMovementString.charAt(9)-'A';
                if(haveCard[index].indexOf(catMovementString.charAt(10))==-1||haveCard[index].indexOf(catMovementString.charAt(11))==-1) return false;
            }else{
                int index1 = catMovementString.charAt(9)-'A';
                int index2 = catMovementString.charAt(11)-'A';
                if(haveCard[index1].indexOf(catMovementString.charAt(10))==-1||haveCard[index2].indexOf(catMovementString.charAt(12))==-1) return false;
            }
        }
        if(x1>=len||x2>=len||y1>=hig||y2>=hig) return false;
        char id = catMovementString.charAt(0);
        char color = (char) (id+32);
        if((gameboard[x2][y2]!=TileType.WILD&&gameboard[x2][y2]!=TileType.fromChar(color))||gameboard[x1][y1]!=TileType.fromChar(id)) return false;
        boolean[][] visited = new boolean[len][hig];
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{x1,y1});
        while(!que.isEmpty()){
            int[] p = que.poll();
            if(p[0]==x2&&p[1]==y2) return true;
            if(visited[p[0]][p[1]]) continue;
            visited[p[0]][p[1]]=true;
            for(int[] dir:dirs){
                int tx = p[0]+dir[0];
                int ty = p[1]+dir[1];
                if(tx<0||tx>=len||ty<0||ty>=hig) continue;
                if(gameboard[tx][ty]!=TileType.fromChar(color)&&gameboard[tx][ty]!=TileType.WILD) continue;
                que.offer(new int[]{tx,ty});
            }
        }
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
        String[] map = gameState[0].split("\n");
        char[] cs = {'W','E','S','N'};
        int len = map.length;
        int hig = map[0].length();
        int type = type(action);
        if(type==3){
            if(isCatMovementValid(gameState,action)){
                gameState = moveCat(gameState,action);
            }
            if(checkCat(gameState[0].split("\n"))) return true;
        }else if(type==2){
            if(isPlacementValid(gameState,action)) gameState = FireTile.placeFireTileOnBoard(gameState,action);
            else{
                String temp = action.substring(5);
                for(int i=0;i<len;i++){
                    StringBuilder str = new StringBuilder();
                    str.append(action.charAt(0));
                    if(i<10) str.append("0");
                    str.append(i);
                    for(int j=0;j<hig;j++){
                        if(j<10) str.append("0");
                        str.append(j);

                        str.append("F");
                        for(char c:cs){
                            str.append(c);
                            if(isPlacementValid(gameState,str.toString())) return false;

                            str.deleteCharAt(str.length()-1);
                        }
                        str.deleteCharAt(str.length()-1);
                        str.append("T");
                        for(char c:cs){
                            str.append(c);
                            if(isPlacementValid(gameState,str.toString())) return false;
                            str.deleteCharAt(str.length()-1);
                        }
                        str.delete(str.length()-3,str.length());
                    }
                }
                return true;
            }

        }else{
            if(isPlacementValid(gameState,action)){
                if(gameState[4].length()==0) return true;
            }
        }
        return havingCannotMov(gameState[0].split("\n"));
        // FIXME TASK 15
    }

    public static boolean checkCat(String[] map){
        int len = map.length;
        int hig = map[0].length();
        char[][] gameboard = new char[len][hig];
        for(int i=0;i<len;i++){
            gameboard[i] = map[i].toCharArray();
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<hig;j++){
                if(gameboard[i][j]=='f') continue;
                if(isCat(gameboard[i][j])){
                    if(!isOnRaft(i,j,gameboard)) return false;
                }
            }
        }
        return true;
    }

    public static boolean havingCannotMov(String[] map){
        int len = map.length;
        int hig = map[0].length();
        char[][] gameboard = new char[len][hig];
        for(int i=0;i<len;i++){
            gameboard[i] = map[i].toCharArray();
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<hig;j++){
                if(!isCat(gameboard[i][j])){
                    continue;
                }
//                System.out.println(gameboard[i][j]);
                if(!canMove(i,j,gameboard)) return true;
            }
        }
        return false;
    }
    public static int type(String action){
        if(action.length()==7){
            if(action.charAt(1)>='a') return 1;
            else return 2;
        }else return 3;
    }

    public static boolean isCat(char type){
        switch (type) {
            case 'B':
            case 'R':
            case 'P':
            case 'Y':
            case 'G':
                return true;
            default:
                return false;
        }
    }
    public static void updateBoard(char[][] board,char target){
        int len = board.length;
        int hig = board[0].length;
        for(int i=0;i<len;i++){
            for(int j=0;j<hig;j++){
                if(board[i][j]!='f') continue;
                if(i+2>=len||board[i+2][j]=='f'){
                    if(i+1<len&&board[i+1][j]!=target) board[i+1][j] = 'f';
                }else if(i+3>=len||board[i+3][j]=='f'){
                    if(board[i+1][j]!=target&&board[i+2][j]!=target)board[i+1][j]=board[i+2][j]='f';
                }
                if(j+2>=hig||board[i][j+2]=='f'){
                    if(j+1<hig&&board[i][j+1]!=target) board[i][j+1] = 'f';
                }else if(j+3>=hig||board[i][j+3]=='f'){
                    if(board[i][j+2]!=target&&board[i][j+1]!=target)board[i][j+1]=board[i][j+2]='f';
                }
            }
        }
    }
    public static boolean canMove(int x,int y,char[][] boar){
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        int len = boar.length;
        int hig = boar[0].length;
        char[][] board = new char[len][hig];
        for(int i=0;i<len;i++){
            for(int j=0;j<hig;j++){
                board[i][j] = boar[i][j];
            }
        }
        updateBoard(board,(char)(board[x][y]+32));
        boolean[][] visited = new boolean[len][hig];
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{x,y});
        while(!que.isEmpty()){
            int[] p = que.poll();
            if(visited[p[0]][p[1]]) continue;
            if(isOnRaft(p[0],p[1],board)) return true;
            visited[p[0]][p[1]]=true;
            for(int[] dir:dirs){
                int tx = p[0]+dir[0];
                int ty = p[1]+dir[1];
                if(tx<0||tx>=len||ty<0||ty>=hig) continue;
                if(board[p[0]][p[1]]==board[x][y]+32){
                    que.offer(new int[]{tx,ty});
                    continue;
                }
                if(board[p[0]][p[1]]=='f') continue;
                if(isOnRaft(tx,ty,board)&&board[tx][ty]!=(board[x][y]+32)&&board[tx][ty]!='w'&&board[tx][ty]!='W') continue;
                que.offer(new int[]{tx,ty});
            }
        }
        return false;
    }



    public static boolean isOnRaft(int x,int y,char[][] board){
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1},{-1,-1},{1,1},{-1,1},{1,-1}};
        int len = board.length;
        int hig = board[0].length;
        for(int[] dir:dirs){
            int tx = x+dir[0];
            int ty = y+dir[1];
            if(tx<0||tx>=len||ty<0||ty>=hig) continue;
            if(board[tx][ty]=='o') return true;
        }
        return false;
    }

    public static boolean isOnRaft(int x,int y,TileType[][] board){
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1},{-1,-1},{1,1},{-1,1},{1,-1}};
        int len = board.length;
        int hig = board[0].length;
        for(int[] dir:dirs){
            int tx = x+dir[0];
            int ty = y+dir[1];
            if(tx<0||tx>=len||ty<0||ty>=hig) continue;
            if(board[tx][ty]==TileType.Object) return true;
        }
        return false;
    }
}
