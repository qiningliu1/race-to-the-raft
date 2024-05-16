package QiningBranch.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class RaceToRaft extends Application {

    private final Group root = new Group();
    private static final int WINDOW_WIDTH = 1100;
    private static final int WINDOW_HEIGHT = 650;

    // FIXME TASK 11 Basic game
    // FIXME TASK 13 Fully working game

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(this.root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setScene(scene);

        Group group = new Group();
        root.getChildren().add(group);


        /**
         * Add  button with applying addButton function
         */
        addButton(group, "Exit", 1000, 600);
        addButton(group, "Select Challenge", 1000, 550);
        addButton(group, "Restart Game", 1000, 500);


        /**
         * Add  Images with applying addImages function
         */
        addDraggableImage(group, "blue.png", 0, 0);
        addDraggableImage(group, "green.png", 40, 0);
        addDraggableImage(group, "purple.png", 80, 0);
        addDraggableImage(group, "red.png", 0, 40);
        addDraggableImage(group, "yellow.png", 40, 40);
        addDraggableImage(group, "blueCat.png", 80, 40);
        addDraggableImage(group, "greenCat.png", 0, 480);
        addDraggableImage(group, "yellowCat.png", 0, 560);
        addDraggableImage(group, "redCat.png", 0, 640);
        addDraggableImage(group, "purpleCat.png", 0, 720);

        stage.show();


    }

    private void addButton(Group group, String text, double x, double y) {
        Button button = new Button(text);
        button.setLayoutX(x);
        button.setLayoutY(y);
        //add function to this button,use lambda function to add this
        button.setOnAction(e -> handleButtonAction(text));
        group.getChildren().add(button);
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

    private void restartGame() {
        // ClearAll and restate the game
        System.out.println("Game restarted!");
    }

    private void selectChallenge() {
        // Choose a new game challenge
        System.out.println("Challenge selected!");
    }


    private void addDraggableImage(Group group, String imageName, double x, double y) {
        Image image = new Image("file:E:/ANU STUDY/JavaGroup/src/comp1110/ass2/gui/assets/" + imageName);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(40);
        imageView.setFitHeight(40);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);


        imageView.setOnMousePressed(event -> {
            imageView.toFront(); // Place the image at the front to avoid being obscured by other nodes
            imageView.setTranslateX(event.getSceneX() - imageView.getX());
            imageView.setTranslateY(event.getSceneY() - imageView.getY());
        });

        imageView.setOnMouseDragged(event -> {
            imageView.setX(event.getSceneX() - imageView.getTranslateX());
            imageView.setY(event.getSceneY() - imageView.getTranslateY());
        });

        group.getChildren().add(imageView);
    }

}


//Drag All element

       // double[] pos = new double[2];
//        group.setOnMousePressed(event->{
//            pos[0] = event.getSceneX() - group.getLayoutX();
//            pos[1] = event.getSceneY() - group.getLayoutY();
//                }
//        );
//        group.setOnMouseDragged(event -> {
//            group.setLayoutX(event.getSceneX() - pos[0]);
//            group.setLayoutY(event.getSceneY() - pos[1]);
//        });
//        group.setOnMouseReleased(event -> {
//
//        });



// Drag image1



