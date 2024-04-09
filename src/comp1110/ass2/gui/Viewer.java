package comp1110.ass2.gui;


import comp1110.ass2.Tiles;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;

public class Viewer extends Application {

    private final Group root = new Group();
    private static final int VIEWER_WIDTH = 1100;
    private static final int VIEWER_HEIGHT = 650;
    private static final int MARGIN_X = 20;

    private final Group controls = new Group();
    private TextArea handTextField;
    private TextArea boardTextField;

    public String getImagepath(Tiles tiles) {
        String path = null;
        switch (tiles) {
            case Fire:
                path = "comp1110/ass2/gui/assets/fire.png";
                break;
            case RED:
                path = "comp1110/ass2/gui/assets/red.png";
                break;
            case BLUE:
                path = "comp1110/ass2/gui/assets/blue.png";
                break;
            case YELLOW:
                path = "comp1110/ass2/gui/assets/yellow.png";
                break;
            case GREEN:
                path = "comp1110/ass2/gui/assets/green.png";
                break;
            case PURPLE:
                path = "comp1110/ass2/gui/assets/purple.png";
                break;
            case Object:
                path = "comp1110/ass2/gui/assets/objective.png";
                break;
            case WILD:
                path = "comp1110/ass2/gui/assets/objective.png";
                break;
            default:
                break;
        }
        return path;
    }

    /**
     * Draw the given board and hand in the window, removing any previously drawn boards/hands.
     *
     * @param boardstate newline separated string representing each row of the board (the board string, see the STRING-REPRESENTATION.md for more details
     * @param hand       A string representing the cards in a player's hand (the hand string, see the STRING-REPRESENTATION.md for more details)
     */
    void displayState(String boardstate, String hand) {
        int numRowsBoard = (int) boardstate.lines().count();
        String[] rowsofBoard = (String[]) boardstate.lines().toArray();
        int numTilesInRow = rowsofBoard[0].length();
        root.getChildren().clear();
        int xx = 20;
        int yy = 5;
        if(numRowsBoard == 0) {
           root.getChildren().clear();
        } else {
            for (int i = 0; i < numRowsBoard; i++) {
                String currentRow = rowsofBoard[i];
                for (int x = 0; x < numTilesInRow; x++) {
                    root.getChildren().add(tileRepresentation(xx,yy,currentRow.charAt(x)));
                    xx = xx +20;
                }
            }
            xx = 20;
            yy = yy + 5;

        }



        // FIXME TASK 4
    }
    private Rectangle tileRepresentation (int x, int y ,char tile) {
        double width = 30;
        double height = 30;

        Rectangle t = new Rectangle(x,y,width,height);
        Color colour = Color.WHITE;
        switch (tile) {
            case 'f':
                colour = Color.ORANGE;
                break;
            case 'r':
                colour = Color.RED;
                break;
            case 'b':
                colour = Color.BLUE;
                break;
            case 'y':
                colour = Color.YELLOW;
                break;
            case 'g':
                colour = Color.GREEN;
                break;
            case 'p':
                colour = Color.PURPLE;
                break;
            case 'o':
                colour = Color.BROWN;
                break;
            case 'w':
                colour = Color.LAVENDER;
                break;
            default:
                break;
        }
       t.setFill(colour);
        return t;
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
     *
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
}

