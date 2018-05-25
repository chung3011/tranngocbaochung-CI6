import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import static java.lang.Math.abs;

public class Enemy {
    public BufferedImage image;
    public int x, y;
    public int width, height;
    public int velocityX, velocityY;
    Random rand = new Random();


    //    alt + insert
    public Enemy(BufferedImage image, int x, int y, int width, int height, int velocityX, int velocityY) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public void followPlayer(int positionXPlayer, int positionYPlayer){
        if(positionXPlayer == this.x && positionYPlayer ==this.y){
            this.velocityX =0;
            this.velocityY =0;
        }
        else if(positionXPlayer == this.x){
            this.velocityX =0;
            this.velocityY = (positionYPlayer - this.y)/Math.abs(positionYPlayer - this.y);
        }
        else if(positionYPlayer == this.y){
            this.velocityY =0;
            this.velocityX = (positionXPlayer - this.x)/Math.abs(positionXPlayer - this.x) ;
        }
        else{
            this.velocityX = (positionXPlayer - this.x)/Math.abs(positionXPlayer - this.x) ;
            this.velocityY = (positionYPlayer - this.y)/Math.abs(positionYPlayer - this.y) ;
        }
        }

    public void run(int windowWidth, int windowHeight,int positionXPlayer, int positionYPlayer) {
        boolean outX = false, outY = false;
        this.followPlayer(positionXPlayer, positionYPlayer);

        if (this.x + this.velocityX <= 0) {
            this.x = windowWidth;
            outX = true;
        } else if (this.x + this.velocityX >= windowWidth) {
            this.x = 0;
            outX = true;
        }

        if (this.y + this.velocityY <= 0) {
            this.y = windowHeight;
            outY = true;
        } else if (this.y + this.velocityY >= windowHeight) {
            this.y = 0;
            outY = true;
        }

        if (!outX && !outY) {
            this.x += this.velocityX;
            this.y += this.velocityY;
        } else if (outX && !outY) {
            this.y = rand.nextInt(windowHeight);
        } else if (outY && !outX) {
            this.x = rand.nextInt(windowWidth);
        }

    }


        public void render(Graphics graphics){
        graphics.drawImage( this.image, this.x, this.y, this.width, this.height,null);

    }
}

