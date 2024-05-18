package comp1110.ass2.gui;

/**
 * Author: Qining liu u7100555
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;


import QiningBranch.*;
import comp1110.ass2.Utility;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static QiningBranch.newraftCard.getRaftTileTypeById;


public class Game extends Application {
    private final Group root = new Group();
    private static final int VIEWER_WIDTH = 1100;
    private static final int VIEWER_HEIGHT = 650;
    private static final int MARGIN_X = 20;
    private static final int TILE_SIZE = 40;
    private final Group controls = new Group();
    private TextArea handTextField;
    private TextArea boardTextField;
    private newTileType[][] board;


    private static String gameDifficulty;

    private newDecks newDecks;

    //My design
    private static final int SQUARE = 30;
    private TextArea fireTextField;

    private TextArea pathwayCardPlacement;


    /**
     * Draw the given board and hand in the window, removing any previously drawn boards/hands.
     *
     * @param boardstate newline separated string representing each row of the board (the board string, see the STRING-REPRESENTATION.md for more details
     * @param hand A string representing the cards in a player's hand (the hand string, see the STRING-REPRESENTATION.md for more details)
     *
     */
    void displayState(String boardstate, String hand) {
        // FIXME TASK 4

        clearDisplay();

    }


    private void clearDisplay() {
    }

    /**
     * Generate controls for Viewer
     */
    private void makeControls() {
        Label playerLabel = new Label("Cards in hand:");
        handTextField = new TextArea();
        handTextField.setPrefWidth(100);
        Label boardLabel = new Label("Board State:");
        boardTextField = new TextArea();
        boardTextField.setPrefWidth(100);
        Button button = refreshButton();
        button.setLayoutY(VIEWER_HEIGHT - 250);
        button.setLayoutX(MARGIN_X + 600);
        HBox fields = new HBox();
        fields.getChildren().addAll(handTextField, boardTextField);
        fields.setSpacing(20);
        fields.setLayoutX(MARGIN_X + 600);
        fields.setLayoutY(VIEWER_HEIGHT - 200);
        HBox labels = new HBox();
        labels.getChildren().addAll(playerLabel, boardLabel);
        labels.setSpacing(45);
        labels.setLayoutX(MARGIN_X  + 600);
        labels.setLayoutY(VIEWER_HEIGHT - 220);
        controls.getChildren().addAll(fields, labels, button);
    }

    private void selectDifficulties() {

        Label difficultyLabel = new Label("Input Game difficulty from 0 to 5:");

        fireTextField = new TextArea();
        fireTextField.setPrefWidth(100);
        fireTextField.setPrefHeight(50);

        Button button = difficultyButton();
        button.setLayoutY(VIEWER_HEIGHT - 250);
        button.setLayoutX(900);


        HBox fields = new HBox();
        fields.getChildren().addAll(fireTextField);
        fields.setSpacing(20);
        fields.setLayoutX(900);
        fields.setLayoutY(VIEWER_HEIGHT - 200);


        HBox labels = new HBox();
        labels.getChildren().addAll(difficultyLabel);

        labels.setSpacing(45);
        labels.setLayoutX(900);
        labels.setLayoutY(VIEWER_HEIGHT - 220);
        controls.getChildren().addAll(fields, labels, button);


    }


    private void setPathwayCardPlacement() {

        Label placementCardLabel = new Label("Input Players Placement Order:");

        pathwayCardPlacement  = new TextArea();
        pathwayCardPlacement.setPrefWidth(100);
        pathwayCardPlacement.setPrefHeight(50);

        Button button = placeHandCardButton();
        button.setLayoutY(VIEWER_HEIGHT - 550);
        button.setLayoutX(900);

        HBox fields = new HBox();
        fields.getChildren().addAll(pathwayCardPlacement);
        fields.setSpacing(20);
        fields.setLayoutX(900);
        fields.setLayoutY(VIEWER_HEIGHT - 500);

        HBox labels = new HBox();
        labels.getChildren().addAll(placementCardLabel);
        labels.setSpacing(45);
        labels.setLayoutX(900);
        labels.setLayoutY(VIEWER_HEIGHT - 520);
        controls.getChildren().addAll(fields, labels, button);

    }



    /**
     * Create refresh button. Upon pressing, capture the textFields and call displayState
     * @return the created button
     */
    private Button refreshButton() {
        Button button = new Button("Refresh");
        button.setOnAction(e -> {
            String boardText = boardTextField.getText();
            String handCards = handTextField.getText();
            displayState(boardText, handCards);
        });
        return button;
    }

    private Button difficultyButton(){
        Button button = new Button("Select difficulty");
        button.setOnAction(e -> {
            String difficultyTextFieldText = fireTextField.getText();
            try {
                // place user input to integer
                int difficulty = Integer.parseInt(difficultyTextFieldText);
                System.out.println("Difficulty set to: " + difficulty);

                //each time user input their selection, we redraw the board on the stage
                List<newTileType[][]> createBoard = initializedBoardList(difficulty);

                drawBoard(createBoard,0);
                drawBoard(createBoard,1);
                drawBoard(createBoard,2);
                drawBoard(createBoard,3);
                FireInitialization();
                CatInitialization();
                RaftInitialization();
                System.out.println(gameDifficulty);
            } catch (NumberFormatException ex) {

                System.err.println("Invalid input: " + difficultyTextFieldText);
            }

        });
        return button;
    }

    private Button placeHandCardButton(){
        Button button = new Button("Place HandCard");
        button.setOnAction(e -> {
            String pathwayCardPlacementText = pathwayCardPlacement.getText();
            try {

                System.out.println("Your placement at: " + pathwayCardPlacementText);
                //each time user input their selection, we place the Card on the stage
                drawHandCard(pathwayCardPlacementText);

            } catch (NumberFormatException ex) {

                System.err.println("Invalid input: " + pathwayCardPlacementText);
            }

        });
        return button;
    }











    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Race to the Raft Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);
        makeControls();
        displayState("", "");
        root.getChildren().add(controls);
        makeControls();//why use this method twice  ???????????

        selectDifficulties();// Initialize the HBox of the Difficulties button;

        /**
         * Here we try to input board List
         * use 0 as initially showing on the screen
         * default difficulties is zero
         * add Action button to react User input
         */
        int difficulty = 2;
        difficultyButton();// following User input;
        List<newTileType[][]> createBoard = initializedBoardList(difficulty);
        //With problem showing in screen
        //draw single Board, testing purpose

        drawBoard(createBoard,0);
        drawBoard(createBoard,1);
        drawBoard(createBoard,2);
        drawBoard(createBoard,3);
        System.out.println(gameDifficulty);

        FireInitialization();
        CatInitialization();
        RaftInitialization();

//
//        Decks decks1 = initializePlayersHand();
//        this.decks = decks1;
//
//        drawDecksArea('A',600,0);


        // drawDecksArea('C',600,300);


        // drawAllDecks("ABDBAA");


        /**
         * This part we add cards
         */

        setPathwayCardPlacement();
        placeHandCardButton();
        //drawHandCard("Ab1208S");

        /**
         * Other functional button out of game
         * Exit
         */
        addButton(root, "Exit", 900, 600);

        /**
         * Showing stage
         */
        stage.setScene(scene);
        stage.show();
    }




    /**
     * After initialize board with different difficulty
     * we should add Fire on the board
     */
    private void FireInitialization(){
        Map<Integer, List<Integer>> parseFireLocations = ChallengeParser.parseFireLocations(gameDifficulty);
        for (int fireRowNum = 0; fireRowNum <= 18; fireRowNum++) {
            //Although we store that key in the map
            //But we still need to know the value behind it
            //if the FireLocations contain that rowNumber
            if(parseFireLocations.containsKey(fireRowNum)){
                List<Integer> fireColList= parseFireLocations.get(fireRowNum);
                for (int firColIndex = 0; firColIndex < fireColList.size(); firColIndex++) {
                    //here is problem because
                    // fireIndex maybe cause difficult ->ie your colum at 9 ,but size of ColList is 4
                    // Be careful since in JavaFX, x layout is column, but y layout is row in the loop
                    int columnCord = fireColList.get(firColIndex);
                    addImage(root, newTileType.Fire,columnCord*SQUARE, fireRowNum*SQUARE);
                    addImage(root, newTileType.Fire,columnCord*SQUARE, (fireRowNum+1)*SQUARE);
                    addImage(root, newTileType.Fire,columnCord*SQUARE, (fireRowNum+2)*SQUARE);
                    addImage(root, newTileType.Fire,(columnCord+1)*SQUARE, fireRowNum*SQUARE);
                    addImage(root, newTileType.Fire,(columnCord+2)*SQUARE, fireRowNum*SQUARE);
                    addImage(root, newTileType.Fire,(columnCord+1)*SQUARE, (fireRowNum+2)*SQUARE);
                    addImage(root, newTileType.Fire,(columnCord+2)*SQUARE, (fireRowNum+1)*SQUARE);
                    addImage(root, newTileType.Fire,(columnCord+1)*SQUARE, (fireRowNum+1)*SQUARE);
                    addImage(root, newTileType.Fire,(columnCord+2)*SQUARE, (fireRowNum+2)*SQUARE);
                }
            }
        }
    }

    /**
     * After drawing fire
     * we should draw cat locations
     *
     */

    private  void CatInitialization(){

        Map<Integer,List<Location>> parseCatLocations = ChallengeParser.parseCatLocations(gameDifficulty);
        Map<Integer,List<List<Integer>>> catPairLocations=  Location.convertLocationMap(parseCatLocations);

        for (int catID = 0; catID <= 6; catID++) {
            if(catPairLocations.containsKey(catID)) {
                for (int pairLocationsIndex = 0; pairLocationsIndex < catPairLocations.size(); pairLocationsIndex++) {
                    List<List<Integer>> catLocationList =catPairLocations.get(catID);
                    for (int index = 0; index < catLocationList.size(); index++) {
                        List<Integer> pairLocations = catLocationList.get(index);
                        int catRow = pairLocations.get(0);
                        int catCol = pairLocations.get(1);
                        addImage(root, newCatCards.getCatTileTypeById(catID),catCol*SQUARE, catRow*SQUARE);

                    }
                }
            }
        }

    }
    /**
     * At Last turn
     * we should draw raft locations
     *
     */

    private void RaftInitialization(){
        Map<Integer, List<Location>> parseRaftLocations = ChallengeParser.parseRaftLocations(gameDifficulty);
        Map<Integer, List<List<Integer>>> raftPairLocations = Location.convertLocationMap(parseRaftLocations);

        for (int raftID = 0; raftID <= 3; raftID++) {
            if (raftPairLocations.containsKey(raftID)) {
                List<List<Integer>> raftLocationList = raftPairLocations.get(raftID);
                for (List<Integer> pairLocations : raftLocationList) {
                    int raftRow = pairLocations.get(0);
                    int raftCol = pairLocations.get(1);
                    newTileType raftTileType = getRaftTileTypeById(raftID);
                    addImage(root, raftTileType, raftCol * SQUARE, raftRow * SQUARE);
                }
            }
        }
    }




    //we need to have a method to store the length of row of each subIsland
    private static List<Integer> eachIslandLength(List<newTileType[][]> createBoard){
        List<Integer> subIslandRowLength = new ArrayList<>();
        for(int t =0; t<createBoard.size();t++){
            int temp =createBoard.get(t).length;
            System.out.println(temp);
            subIslandRowLength.add(temp);
        }
        return subIslandRowLength;
    }


    private void drawAllBoard(List<newTileType[][]> createBoard){
        for(int numOfIsland = 0; numOfIsland< createBoard.size();numOfIsland++){
            System.out.println(numOfIsland);
            drawBoard(createBoard,numOfIsland);
        }
        System.out.println(gameDifficulty);

    }



    private void drawBoard(List<newTileType[][]> createBoard, int numOfIsland) {
        List<Integer> subRowLength = eachIslandLength(createBoard);

        switch(numOfIsland) {
            case 0:
                newTileType[][] board = createBoard.get(0);//here should be zero not  numOfIsland
                for (int rowCoord = 0; rowCoord < board.length; rowCoord++) {
                    for (int colCoord = 0; colCoord < board[rowCoord].length; colCoord++) {
//                Rectangle rect = new Rectangle(c * TILE_SIZE, r * TILE_SIZE, TILE_SIZE, TILE_SIZE);
//                rect.setFill(getColorForTileType(board[r][c]));
//                root.getChildren().add(rect);
                        addImage(root, board[rowCoord][colCoord], SQUARE * colCoord, SQUARE * rowCoord);
                    }
                }
                break;
            case 1:
                newTileType[][] board1 = createBoard.get(1);
                for (int rowCoord = 0; rowCoord < board1.length; rowCoord++) {
                    for (int colCoord = 0; colCoord < board1[rowCoord].length; colCoord++) {
                        addImage(root, board1[rowCoord][colCoord], SQUARE * colCoord,
                                (subRowLength.get(0))*SQUARE+  SQUARE * rowCoord);
                        //initial y layout should move a subRowLength based on
                        //the row length of left top most board
                    }
                }
                break;
            case 2:
                newTileType[][] board2 = createBoard.get(2);
                for (int rowCoord = 0; rowCoord < board2.length; rowCoord++) {
                    for (int colCoord = 0; colCoord < board2[rowCoord].length; colCoord++) {
                        addImage(root, board2[rowCoord][colCoord], (9*SQUARE)+SQUARE * colCoord,
                                SQUARE * rowCoord);
                    }
                }
                break;

            case 3://the right bottom of board
                newTileType[][] board3 = createBoard.get(3);
                for (int rowCoord = 0; rowCoord < board3.length; rowCoord++) {
                    for (int colCoord = 0; colCoord < board3[rowCoord].length; colCoord++) {
                        addImage(root, board3[rowCoord][colCoord], (9*SQUARE)+SQUARE * colCoord,
                                (subRowLength.get(0))*SQUARE + SQUARE * rowCoord);
                    }
                }
                break;
        }

    }


    private static List<newTileType[][]> initializedBoardList(int difficulty){
        Challenge challenge = new Challenge();
        String IslandSubstring =Challenge.selectIsland(difficulty);
        //each time we select difficulty need to use static value to record it;
        //Because FireSubstring,CatSubstring, RaftSubstring will draw value from it;
        gameDifficulty = Challenge.randomDifficulty;

        List<newOrientation> newOrientationList = challenge.boardOrientation(IslandSubstring);
        System.out.println(newOrientationList);
        List<Character> sizeList = challenge.sizeOfBoard(IslandSubstring);
        System.out.println(sizeList);
        List<newTileType[][]> createBoard = challenge.createBoard(newOrientationList,sizeList);
        return createBoard;
    }


    /**
     * This part is for initialize players Hand Cards
     */

    public void drawHandCard(String placementString){

        HandCard handCard = new HandCard();
        if(placementString.charAt(0)=='A'){
            handCard = new HandCard(Utility.DECK_A[1]);
        }
        else if(placementString.charAt(0)=='B'){
            handCard = new HandCard(Utility.DECK_B[1]);
        }
        else if (placementString.charAt(0)=='C') {
            handCard = new HandCard(Utility.DECK_C[1]);
        }
        else if (placementString.charAt(0)=='D') {
            handCard = new HandCard(Utility.DECK_D[1]);
        }

        //Rotate handCardFirst
        switch (newOrientation.fromChar(placementString.charAt(6))){
            case NORTH ->  handCard =HandCard.rotateCard(handCard, newOrientation.NORTH);
            case EAST -> handCard=HandCard.rotateCard(handCard, newOrientation.EAST);
            case SOUTH -> handCard=HandCard.rotateCard(handCard, newOrientation.SOUTH);
            case WEST -> handCard=HandCard.rotateCard(handCard, newOrientation.WEST);
        }

        //Place HandCard
        Location location = new Location();
        location.pathwayCardPlacement(placementString);
        int row = location.getRow();
        System.out.println(row);
        int col = location.getColumn();
        System.out.println(col);

        newTileType[][] layout=   handCard.getCardLayOut();

        // we first place leftTopSquare
        // TileType leftTopSquare = layout[0][0];
        //addImage(root,leftTopSquare,col,row);

        for (int rowLayout = 0; rowLayout < 3; rowLayout++) {
            for (int colLayout = 0; colLayout < 3; colLayout++) {
                newTileType handCardSquare = layout[rowLayout][colLayout];
                System.out.println(handCardSquare);
                addImage(root,handCardSquare,(col+colLayout)*SQUARE,(row+rowLayout)*SQUARE);
            }
        }

    }

    /**
     * This method can initialize all  decks in the beginning
     * Once you call it you can not call it except you restart/reselect difficulty
     */
    public newDecks initializePlayersHand(){
        newDecks newDecksInitial = new newDecks();
        //if you change difficulty you should initialize again
        newDecksInitial.initializeDecks();
        this.newDecks = newDecksInitial;
        return newDecksInitial;
    }

    public HandCard playersHand(newDecks newDecks, char decksID){
        //update current board decks

//    switch (decksID){
//        case 'A':
//            //System.out.println(this.decks.getDecksA());
//            return decks.drawRequestFromDeck('A');
//        case 'B':
//            return decks.drawRequestFromDeck('B');
//        case 'C':
//            return decks.drawRequestFromDeck('C');
//        case 'D':
//            return decks.drawRequestFromDeck('D');
//        default:
//            System.out.println("your selection is wrong");
//            return null;
//    }
        if(decksID == 'A'){
            return newDecks.drawRequestFromDeck('A');
        }
        else if (decksID == 'B') {
            return newDecks.drawRequestFromDeck('B');
        } else if (decksID == 'C') {
            return newDecks.drawRequestFromDeck('C');
        }
        else if (decksID == 'D') {
            return newDecks.drawRequestFromDeck('D');
        }

        else{
            System.out.println("Your input is wrong");
            return null;}

    }

//public void drawDecksArea(char decksID) {
//            HandCard handCard = playersHand(this.decks, decksID);
//            TileType[][] handCardTile = handCard.getCardLayOut();
//            for (int rowIndex = 0; rowIndex < handCardTile.length; rowIndex++) {
//
//                for (int colIndex = 0; colIndex < handCardTile[rowIndex].length; colIndex++) {
//                    TileType handSquare = handCardTile[rowIndex][colIndex];
//                    addImage(root, handSquare, 600 + colIndex * SQUARE, 0 + rowIndex * SQUARE);
//                }
//            }
//        }

    public void drawDecksArea(char decksID, int startX, int startY) {
        HandCard handCard = playersHand(newDecks, decksID);
        newTileType[][] handCardTile = handCard.getCardLayOut();
        for (int rowIndex = 0; rowIndex < handCardTile.length; rowIndex++) {
            for (int colIndex = 0; colIndex < handCardTile[rowIndex].length; colIndex++) {
                newTileType handSquare = handCardTile[rowIndex][colIndex];
                addImage(root, handSquare, startX + colIndex * SQUARE, startY + rowIndex * SQUARE);
            }
        }
    }

    public void drawAllDecks(String playersOrder) {
        char id0 = playersOrder.charAt(0);
        char id1 = playersOrder.charAt(1);
        char id2 = playersOrder.charAt(2);
        char id3 = playersOrder.charAt(3);
        char id4 = playersOrder.charAt(4);
        char id5 = playersOrder.charAt(5);



        // Example positions for six 3x3 cards
        int[][] positions = {
                {600, 0}, {600, 300}, {600, 600},
                {900, 0}, {900, 300}, {900, 600}
        };

        // Draw cards at the specified positions
        drawDecksArea(id0, positions[0][0], positions[0][1]);
        drawDecksArea(id1, positions[1][0], positions[1][1]);
        drawDecksArea(id2, positions[2][0], positions[2][1]);
        drawDecksArea(id3, positions[3][0], positions[3][1]);
        drawDecksArea(id4, positions[4][0], positions[4][1]);
        drawDecksArea(id5, positions[5][0], positions[5][1]);
    }

    /**
     * This part is a test for showing the color board
     * @param type
     * @return
     */

    private Color getColorForTileType(newTileType type) {
        return switch (type) {
            case BLUE -> Color.BLUE;
            case GREEN -> Color.GREEN;
            case RED -> Color.RED;
            case YELLOW -> Color.YELLOW;
            case PURPLE -> Color.PURPLE;
            case Fire -> Color.ORANGE;
            case BLUE_CAT, GREEN_CAT, PURPLE_CAT, RED_CAT, YELLOW_CAT -> Color.BLACK;
            case WILD -> Color.GRAY;
            case Object -> Color.BROWN;
            default -> Color.WHITE;
        };
    }


    // we transfer Image[][] at here

    private Image getImageForTileType(newTileType type) {
        return switch (type) {
            case BLUE -> new Image("file:E:/ANU STUDY/JavaGroup/src/comp1110/ass2/gui/assets/blue.png");
            case GREEN -> new Image("file:E:/ANU STUDY/JavaGroup/src/comp1110/ass2/gui/assets/green.png");
            case RED -> new Image("file:E:/ANU STUDY/JavaGroup/src/comp1110/ass2/gui/assets/red.png");
            case YELLOW -> new Image("file:E:/ANU STUDY/JavaGroup/src/comp1110/ass2/gui/assets/yellow.png");
            case PURPLE -> new Image("file:E:/ANU STUDY/JavaGroup/src/comp1110/ass2/gui/assets/purple.png");
            case Fire -> new Image("file:E:/ANU STUDY/JavaGroup/src/comp1110/ass2/gui/assets/fire.png");
            case BLUE_CAT-> new Image("file:E:/ANU STUDY/JavaGroup/src/comp1110/ass2/gui/assets/blueCat.png");
            case GREEN_CAT-> new Image("file:E:/ANU STUDY/JavaGroup/src/comp1110/ass2/gui/assets/greenCat.png");
            case PURPLE_CAT-> new Image("file:E:/ANU STUDY/JavaGroup/src/comp1110/ass2/gui/assets/purpleCat.png");
            case RED_CAT-> new Image("file:E:/ANU STUDY/JavaGroup/src/comp1110/ass2/gui/assets/redCat.png");
            case YELLOW_CAT -> new Image("file:E:/ANU STUDY/JavaGroup/src/comp1110/ass2/gui/assets/yellowCat.png");
            case Object -> new Image("file:E:/ANU STUDY/JavaGroup/src/comp1110/ass2/gui/assets/objective.png");


            default -> null;
        };
    }

    private void addImage(Group group, newTileType type, double x, double y) {
        Image image = getImageForTileType(type);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(SQUARE);
        imageView.setFitHeight(SQUARE);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);

        group.getChildren().add(imageView);
    }


    private void handleButtonAction(String action) {
        switch (action) {
            case "Exit":
                System.exit(0);
                break;
            case "Restart Game":
                restartGame();
                break;
            case "Select Challenge":
                // 假设这是一个选择新挑战的功能
                selectChallenge();
                break;
        }
    }


    private void addButton(Group group, String text, double x, double y) {
        Button button = new Button(text);
        button.setLayoutX(x);
        button.setLayoutY(y);
        //add function to this button,use lambda function to add this
        button.setOnAction(e -> handleButtonAction(text));
        group.getChildren().add(button);
    }

    private void restartGame() {
        // ClearAll and restate the game
        System.out.println("Game restarted!");
    }

    private void selectChallenge() {
        // Choose a new game challenge
        System.out.println("Challenge selected!");
    }



}
