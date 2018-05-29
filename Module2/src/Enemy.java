import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import static java.lang.Math.abs;

public class Enemy {
    public BufferedImage image;
    public Vector2d position;
    public int width, height;
    public Vector2d velocity;
    Random rand = new Random();


    //    alt + insert
    public Enemy(BufferedImage image, int x, int y, int width, int height) {
        this.image = image;
        this.position = new Vector2d(x,y);
        this.width = width;
        this.height = height;
        this.velocity = new Vector2d();
    }

    public void run() {
//        boolean outX = false, outY = false;
//        this.followPlayer(positionXPlayer, positionYPlayer);
//
//        if (this.x + this.velocityX <= 0) {
//            this.x = 1024;
//            outX = true;
//        } else if (this.x + this.velocityX >= 1024) {
//            this.x = 0;
//            outX = true;
//        }
//
//        if (this.y + this.velocityY <= 0) {
//            this.y = 600;
//            outY = true;
//        } else if (this.y + this.velocityY >= 600) {
//            this.y = 0;
//            outY = true;
//        }
//
//        if (!outX && !outY) {
//            this.x += this.velocityX;
//            this.y += this.velocityY;
//        } else if (outX && !outY) {
//            this.y = rand.nextInt(600);
//        } else if (outY && !outX) {
//            this.x = rand.nextInt(1024);
//        }
        this.position.addUp(this.velocity);
    }

    public void followPlayer(Vector2d positionPlayer) {
//        if (positionXPlayer == this.x && positionYPlayer == this.y) {
//            this.velocityX = 0;
//            this.velocityY = 0;
//        } else if (positionXPlayer == this.x) {
//            this.velocityX = 0;
//            this.velocityY = (positionYPlayer - this.y) / Math.abs(positionYPlayer - this.y) * (rand.nextInt(5) + 1);
//        } else if (positionYPlayer == this.y) {
//            this.velocityY = 0;
//            this.velocityX = (positionXPlayer - this.x) / Math.abs(positionXPlayer - this.x) * (rand.nextInt(5) + 1);
//        } else {
//            this.velocityX = (positionXPlayer - this.x) / Math.abs(positionXPlayer - this.x) * (rand.nextInt(5) + 1);
//            this.velocityY = (positionYPlayer - this.y) / Math.abs(positionYPlayer - this.y) * (rand.nextInt(5) + 1);
//        }
        this.velocity.set(positionPlayer.subtract(this.position).normalize()).multiply(3);
        this.run();
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int)this.position.x, (int)this.position.y, this.width, this.height, null);

    }
}

