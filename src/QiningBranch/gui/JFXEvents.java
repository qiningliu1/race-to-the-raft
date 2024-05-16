package QiningBranch.gui;//package QiningBranch.gui;
//
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.control.Button;
//import javafx.scene.input.KeyCode;
//import javafx.scene.layout.StackPane;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
//import javafx.scene.text.Font;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//
//public class JFXEvents extends javafx.application.Application{
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//        /**
//         * Crate a button
//         */
//        Group group = new Group();
//        Scene scene = new Scene(group);
//        Button exit = new Button("Exit");
//        group.getChildren().add(exit);
//
//        /**
//         * give sth to do when click the button
//         * every eventHandler comes with an on first
//         * input lambda
//         */
//        exit.setOnMouseClicked(event -> {
//            primaryStage.close();//close the window
//        });
//        //这里需要联动上边把StackPane改为Group，这样button会出现在左上角
//        Canvas canvas = new Canvas(800,800);
//        group.getChildren().add(canvas);
//
//        GraphicsContext ctx =canvas.getGraphicsContext2D();
//        ctx.setFill(Color.RED);//需要放置于下边的命令的前边
//        ctx.fillRect(40,40,120,160);//默认黑色
//
//
//
//        //导入game类
//        Game game = new Game(canvas);
//
//
//        /**
//         * crate rectangle
//         */
//
////        Rectangle rectangle = new Rectangle(100,100);
////
////        group.getChildren().add(rectangle);
////        rectangle.setFill(Color.BLUE);
////
////        rectangle.setX(100);
////        rectangle.setY(100);
//
//
//
////        Text text = new Text("Hello World");
////        group.getChildren().add(text);
////        text.setFont(new Font("Tahoma",50));
//
//
//
//        //Use the stage we set input,and use the scene we created
//        primaryStage.setScene(scene);
//
//        primaryStage.setTitle("Hello World");
//
////        //show the window
////        primaryStage.show();
////
////        //start the game after showing the window
////        game.start();
//
//
///**
// * 修改 key event
// */
//
//        canvas.setOnKeyPressed(event -> {
//                    System.out.println("Canvas "+event.getCode().toString());
//                    if(event.getCode()== KeyCode.UP) {
//                        game.yspeed=+5; //actually, this should be -5
//                    }
//                }
//        );
//
//
////show the window
//        primaryStage.show();
//
//        //start the game after showing the window
//        game.start();
//
//
//        //listen key events
//
//        //this event is now a key event
////        scene.setOnKeyTyped(event -> {
////            if(event.getCode() == KeyCode.UP){
////                game.yspeed =+5;
////
////            }//      });
//
//    }
//}
