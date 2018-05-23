import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    BufferedImage starImage;
    public int positionXStar=1000;
    public int positionYStar=400;
    BufferedImage enemyImage;
    public int positionXEnemy=100;
    public int positionYEnemy=500;
    BufferedImage playerImage;
    public int positionXPlayer=512;
    public int positionYPlayer=300;

    public GameCanvas() {
        this.setSize(1024, 600);

        //load image
        try {
            this.starImage = ImageIO.read(new File("resources/resources/images/star.png"));
            this.enemyImage = ImageIO.read(new File("resources/resources/images/circle.png"));
            this.playerImage = ImageIO.read(new File("resources/resources/images/circle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0,0,1024,600);
        g.drawImage(this.starImage,this.positionXStar,this.positionYStar,10,10,null);
        g.drawImage(this.enemyImage,this.positionXEnemy,this.positionYEnemy,20,20,null);
        g.drawImage(this.playerImage,this.positionXPlayer,this.positionYPlayer,50,50,null);
    }
}
