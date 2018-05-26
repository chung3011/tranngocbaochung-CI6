import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player {
    public BufferedImage image;
    public int x,y;
    public int width, height;
    public int velocityX;
    public int velocityY;
    Random rand = new Random();

    public Player(BufferedImage image, int x, int y, int width, int height, int velocityX, int velocityY) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public void runLeft(){
        if (this.x >0)
            this.x -= velocityX;
        else{
            this.x=984;
            this.y=rand.nextInt(560);
        }
    }
    public void runRight(){
        if (this.x <984)
            this.x += velocityX;
        else{
            this.x=0;
            this.y=rand.nextInt(560);
        }
    }
    public void runUp(){
        if (this.y >0)
            this.y -= velocityY;
        else{
            this.y=580;
            this.x=rand.nextInt(984);
        }
    }
    public void runDown(){
        if (this.y <560)
            this.y += velocityY;
        else{
            this.y=0;
            this.x=rand.nextInt(984);
        }
    }
    public void render(Graphics graphics){
        graphics.drawImage(this.image,this.x, this.y, this.width, this.height, null);
    }
}
