package comp1110.ass2.gui;

import comp1110.ass2.Board;
import comp1110.ass2.Tile;
import comp1110.ass2.TileType;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Viewer extends Application {

    private final Group root = new Group();
    private static final int VIEWER_WIDTH = 1100;
    private static final int VIEWER_HEIGHT = 650;
    private static final int MARGIN_X = 20;

    private final Group controls = new Group();
    private TextArea handTextField;
    private TextArea boardTextField;

    public static String getImagepath(TileType tiles) {
        String path = "";
//        String name = tiles.name();
        path = switch (tiles)
        {
            case PURPLE -> "comp1110/ass2/gui/assets/purple.png";
            case WILD, Object -> "comp1110/ass2/gui/assets/objective.png";
            case Fire -> "comp1110/ass2/gui/assets/fire.png";
            case RED -> "comp1110/ass2/gui/assets/red.png";
            case BLUE -> "comp1110/ass2/gui/assets/blue.png";
            case YELLOW -> "comp1110/ass2/gui/assets/yellow.png";
            case GREEN -> "comp1110/ass2/gui/assets/green.png";
            case BLUE_CAT -> "comp1110/ass2/gui/assets/blueCat.png";
            case GREEN_CAT -> "comp1110/ass2/gui/assets/greenCat.png";
            case PURPLE_CAT -> "comp1110/ass2/gui/assets/purpleCat.png";
            case RED_CAT -> "comp1110/ass2/gui/assets/redCat.png";
            case YELLOW_CAT -> "comp1110/ass2/gui/assets/yellowCat.png";
            case None -> null;
        };
        return path;
    }

    /**
     * Draw the given board and hand in the window, removing any previously drawn boards/hands.
     *
     * @param boardstate newline separated string representing each row of the board (the board string, see the STRING-REPRESENTATION.md for more details
     * @param hand A string representing the cards in a player's hand (the hand string, see the STRING-REPRESENTATION.md for more details)
     *
     */
    void displayState(String boardstate, String hand) {
        root.getChildren().clear(); //clear previous board

        TileType[][] boardTiles = Board.getGameBoard(boardstate); // get gameboard as TileType[][]
        int boardWidth  = boardTiles[0].length;
        int boardLength = boardTiles.length;

        Tile[][] tiles = new Tile[boardLength][boardWidth]; //array of paths
        for (int i=0 ; i < boardLength; i++) {  //convert board into tile paths
            for(int j = 0; j < boardWidth; j++) {
                tiles[i][j] = new Tile(getImagepath(boardTiles[i][j]),i,j);
            }
        }

        //Creating a Grid Pane
        GridPane gridPane = new GridPane();

        //Setting size for the pane
        gridPane.setMinSize(VIEWER_WIDTH, VIEWER_HEIGHT);

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(0);
        gridPane.setHgap(0);

        //Setting the Grid alignment
        gridPane.setAlignment(Pos.CENTER);

        for (int i=0; i < tiles.length; i++) {
            for (Tile t : tiles[i]) {
                gridPane.add(getImageView(t),t.getPosX(),t.getPosY());

            }
        }

        //Creating a scene object
        Scene scene = new Scene(root);
        root.getChildren().add(gridPane);





        // FIXME TASK 4
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
        button.setLayoutX(MARGIN_X);
        HBox fields = new HBox();
        fields.getChildren().addAll(handTextField, boardTextField);
        fields.setSpacing(20);
        fields.setLayoutX(MARGIN_X);
        fields.setLayoutY(VIEWER_HEIGHT - 200);
        HBox labels = new HBox();
        labels.getChildren().addAll(playerLabel, boardLabel);
        labels.setSpacing(45);
        labels.setLayoutX(MARGIN_X);
        labels.setLayoutY(VIEWER_HEIGHT - 220);
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

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Race to the Raft Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);
        makeControls();
        displayState("", "");
        root.getChildren().add(controls);
        makeControls();
        stage.setScene(scene);
        stage.show();
    }

    public ImageView getImageView(Tile t){
        ImageView image = new ImageView(t);
        return image;
    }
}
