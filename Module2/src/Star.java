import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {
    public BufferedImage image;
    public Vector2d position;
    public int width, height;
    public Vector2d velocity;

//    alt + insert
    public Star(BufferedImage image, int x, int y, int width, int height, int velocityX, int velocityY) {
        this.image = image;
        this.position = new Vector2d(x,y);
        this.width = width;
        this.height = height;
        this.velocity = new Vector2d(velocityX,velocityY);
    }

    public void run(){
        this.position.addUp(this.velocity);
    }
    public void render(Graphics graphics){
        graphics.drawImage(this.image, (int)this.position.x,(int)this.position.y, this.width, this.height,null);

    }
}
