package QiningBranch.gui;//package QiningBranch.gui;
//
//import javafx.animation.AnimationTimer;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.paint.Color;
//
//public class Game extends AnimationTimer {
//
//    //设置更精确的弹射范围
//    public static final  double WIDTH = 20;
//    public static final  double HEIGHT = 50;
//
//
//
//    Canvas canvas;
//
//
//
//    public Game(Canvas canvas){
//        this.canvas = canvas;
//    }
//
//    // we can have a reference for our X coordinate
//
//    double x = 50;
//    double y =  50;
//
//    double xspeed = 5;
//    double yspeed = 5;
//
//    /**
//     * So the other thing that we want is a reference
//     * to the canvas to paint on it.
//     * @param now
//     * The timestamp of the current frame given in nanoseconds. This
//     * value will be the same for all {@code AnimationTimers} called
//     * during one frame.
//     */
//
//    //这个方法重写会让我们按我们的实现方法来展示canvas中的内容
//    @Override
//    public void handle(long now) {
//    //And at every point, we'll just add, five to X, and then we'll draw.
//        x += xspeed;
//        y += yspeed;
//        //设置折返
//        if(x>canvas.getWidth()-WIDTH/2 || x <= WIDTH/2){
//            xspeed = -xspeed;
//        }
//        if(y>canvas.getHeight()-HEIGHT/2|| y <=HEIGHT/2){
//            yspeed = -yspeed;
//        }
//
//
//
//
//        GraphicsContext ctx = canvas.getGraphicsContext2D();
//
//    //为了盖住红色的长方形
//        ctx.setFill(Color.BLACK);//用幕布盖住红色区域
//        ctx.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
//        ctx.setFill(Color.ORANGE);//形成运动的橙色方块
//
//    //将x,y坐标设置为图形界面的中间位置
//
//       ctx.fillRect(x-WIDTH/2,y-HEIGHT/2,WIDTH,HEIGHT);//x作为变量将看到在图形窗口自行完成
//
//    // 这步做完后，区JFXEvents位置去调用这个命令
//
//
//    }
//}
