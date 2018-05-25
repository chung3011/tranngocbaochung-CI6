import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player {
    public BufferedImage image;
    public int x,y;
    public int width, height;
    public int velocityX;
    Random rand = new Random();

    public Player(BufferedImage image, int x, int y, int width, int height, int velocityX) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityX = velocityX;
    }

    public void run(String direction, int width, int height) {
        int step = 0;
        if (direction.equalsIgnoreCase("left")) {
            step = -this.velocityX;
        } else if (direction.equalsIgnoreCase("right")) {
            step = this.velocityX;

        }
        if (this.x + step <= 0) {
            this.x = width;
            while (true) {
                this.y = rand.nextInt(height);
                if (this.y != 0)
                    break;
            }
        } else if (this.x + step >= width) {
            this.x = 0;
            while (true){
                this.y = rand.nextInt(height);
                if (this.y != 0)
                    break;
            }
        } else {
            this.x += step;
        }

    }
    public void render(Graphics graphics){
        graphics.drawImage(this.image,this.x, this.y, this.width, this.height, null);
    }
}
