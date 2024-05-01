package comp1110.ass2;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;


public class Tile extends Image{

    public int posX,posY;

    public Tile(String url,int x, int y){
        super(url);
        this.posX =x;
        this.posY =y;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }


}
