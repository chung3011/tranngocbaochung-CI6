import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {

    BufferedImage playerImage;
    BufferedImage starImage;
//    public Point[] starsList = new Point[100];
    BufferedImage enemyImage;
//    public Point[] enemiesList = new Point[100];
    BufferedImage backBuffered;
    Graphics graphics;

    Player player;
    Background background;
    List<Star> stars;
    List<Enemy> enemies;

    private Random random = new Random();
    private int countStar = 0;
    private int countEnemy = 0;

    public GameCanvas() {

//        Random rand = new Random();
//        for (int i = 0; i < this.enemiesList.length; i++) {
//            while (true) {
//                int positionXEnemy = rand.nextInt(1024);
//                int positionYEnemy = rand.nextInt(600);
//                if (positionXEnemy != 512 && positionYEnemy != 300)
//                    this.enemiesList[i] = new Point(positionXEnemy, positionYEnemy);
//                break;
//            }
//        }
//
//        for (int i = 0; i < this.starsList.length; i++) {
//            int positionXStar = rand.nextInt(1024);
//            int positionYStar = rand.nextInt(600);
//            this.starsList[i] = new Point(positionXStar, positionYStar);
//        }

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
        this.setupStar();
        this.setupEnemy();
        this.player = new Player(loadImage("resources/resources/images/circle.png"),
                this.random.nextInt(984),
                this.random.nextInt(560),
                20,
                20,
                10,
                10);
        this.background= new Background(0,0,1024,600,Color.BLACK);
    }

    private void setupStar(){
//        this.star = new Star(this.loadImage("resources/resources/images/star.png"),
//                1024,
//                300,
//                5,
//                5,
//                -3,
//                0);
        this.stars = new ArrayList<>();
    }
    private void setupEnemy(){
        this.enemies = new ArrayList<>();
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.background.render(graphics);
        this.stars.forEach(star -> star.render(graphics));
        this.enemies.forEach(enemy -> enemy.render(graphics));
        this.player.render(graphics);
//        for (int i = 0; i < this.enemiesList.length; i++) {
//            this.graphics.drawImage(this.enemyImage, this.enemiesList[i].x, this.enemiesList[i].y, 10, 10, null);
//        }
//        for (int i = 0; i < this.starsList.length; i++) {
//            this.graphics.drawImage(this.starImage, this.starsList[i].x, this.starsList[i].y, 5, 5, null);
//        }
//        this.star.render(this.graphics);
        this.repaint();
    }

//    private void renderBackground(){
//        this.graphics.setColor(Color.BLACK);
//        this.graphics.fillRect(0, 0, 1024, 600);
//    }

    public void runAll(){
//        for (int i = 0; i < this.starsList.length; i++) {
//            this.starsList[i].x = (this.starsList[i].x + 3) % 1024;
//        }
//        for (int i = 0; i < this.enemiesList.length; i++) {
//            this.enemiesList[i].y = (this.enemiesList[i].y + 3) % 600;
//        }
//        this.star.run();
        this.createStar();
        this.stars.forEach(star -> star.run());
        this.createEnemy();
        this.enemies.forEach(enemy -> enemy.run(this.player.x,this.player.y));
    }

    private void createStar(){
            if(this.countStar == 8){
                Star star = new Star(
                        this.loadImage("resources/resources/images/star.png"),
                        1024,
                        this.random.nextInt(600),
                        5,
                        5,
                        -this.random.nextInt(3) - 1,
                        0
                );
                this.stars.add(star);
                this.countStar = 0;
            }else{
                this.countStar+=1;
            }

    }
    private void createEnemy(){
//        int vX=0, vY=0;
//        while(vX==0 && vY==0){
//            vX = this.random.nextInt(10)-5;
//            vY = this.random.nextInt(10)-5;
//        }
        if(this.countEnemy == 80){
            int signed = this.random.nextInt(2);
            if (signed==0) signed=-1;
            else signed=1;
            int velocityX = signed*(this.random.nextInt(4)+1);
            int velocityY = signed*(this.random.nextInt(4)+1);
            Enemy enemy = new Enemy(
                    this.loadImage("resources/resources/images/circle.png"),
                    this.random.nextInt(1024),
                    this.random.nextInt(600),
                    10,
                    10,
                    velocityX,
                    velocityY
            );
            this.enemies.add(enemy);
            this.countEnemy = 0;
        }else{
            this.countEnemy+=1;
        }
    }
//    private void createBackground(){
//        Background background = new Background(0,0,1024,600,Color.BLACK);
//        background.render(graphics);
//    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
