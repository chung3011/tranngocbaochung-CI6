import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GameCanvas extends JPanel {

    BufferedImage playerImage;
    public int positionXPlayer = 512;
    public int positionYPlayer = 300;

    BufferedImage starImage;
//    public int positionXStar=600;
//    public int positionYStar=400;
    public Point[] starsList = new Point[100];
    BufferedImage enemyImage;
//    public int positionXEnemy=100;
//    public int positionYEnemy=500;
    public Point[] enemiesList = new Point[100];

    BufferedImage backBuffered;
    Graphics graphics;

    public GameCanvas() {

        Random rand = new Random();
        for (int i = 0; i < this.enemiesList.length; i++) {
            while (true) {
                int positionXEnemy = rand.nextInt(1024);
                int positionYEnemy = rand.nextInt(600);
                if (positionXEnemy != 512 && positionYEnemy != 300)
                    this.enemiesList[i] = new Point(positionXEnemy, positionYEnemy);
                break;
            }
        }

        for (int i = 0; i < this.starsList.length; i++) {
            int positionXStar = rand.nextInt(1024);
            int positionYStar = rand.nextInt(600);
            this.starsList[i] = new Point(positionXStar, positionYStar);
        }

        this.setSize(1024, 600);

        //load image
//        try {
//            this.starImage = ImageIO.read(new File("resources/resources/images/star.png"));
//            this.enemyImage = ImageIO.read(new File("resources/resources/images/circle.png"));
//            this.playerImage = ImageIO.read(new File("resources/resources/images/circle.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        this.setupBackBuffered();
        this.setupCharacter();
        this.setVisible(true);
    }

    private void setupBackBuffered(){
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter(){
        this.starImage = this.loadImage("resources/resources/images/star.png");
        this.enemyImage = this.loadImage("resources/resources/images/circle.png");
        this.playerImage = this.loadImage("resources/resources/images/circle.png");
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.renderBackground();
        this.graphics.drawImage(this.playerImage, this.positionXPlayer, this.positionYPlayer, 20, 20, null);
        for (int i = 0; i < this.enemiesList.length; i++) {
            this.graphics.drawImage(this.enemyImage, this.enemiesList[i].x, this.enemiesList[i].y, 10, 10, null);
        }
        for (int i = 0; i < this.starsList.length; i++) {
            this.graphics.drawImage(this.starImage, this.starsList[i].x, this.starsList[i].y, 5, 5, null);
        }
        this.repaint();
    }

    private void renderBackground(){
        this.graphics.setColor(Color.BLACK);
        this.graphics.fillRect(0, 0, 1024, 600);
    }

    public void runAll(){
        for (int i = 0; i < this.starsList.length; i++) {
            this.starsList[i].x = (this.starsList[i].x + 3) % 1024;
        }
        for (int i = 0; i < this.enemiesList.length; i++) {
            this.enemiesList[i].y = (this.enemiesList[i].y + 3) % 600;
        }
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
