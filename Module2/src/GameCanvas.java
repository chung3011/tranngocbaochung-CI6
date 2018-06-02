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

    BufferedImage backBuffered;
    Graphics graphics;

    Player player;
    Background background;
    List<Star> stars;
    List<Enemy> enemies;
    EnemyAttack enemyAttack;

    private Random random = new Random();
    private int countStar = 0;
    private int countEnemy = 0;

    public GameCanvas() {
        this.setSize(1024, 600);
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
        this.setupEnemyAttack();
        this.setupPlayer();
        this.background= new Background();
    }
    private void setupPlayer(){
        this.player = new Player();
        this.player.position.set(500,500);
        this.player.velocity.set(5,0);
    }

    private void setupStar(){
        this.stars = new ArrayList<>();
    }
    private void setupEnemy(){
        this.enemies = new ArrayList<>();
    }
    private  void setupEnemyAttack(){
        this.enemyAttack = new EnemyAttack();
        this.enemyAttack.position.set(random.nextInt(1024),random.nextInt(600));
        this.enemyAttack.velocity.set(4,0);
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
        this.enemyAttack.render(graphics);
        this.repaint();
    }

    public void runAll(){
        this.createStar();
        this.stars.forEach(star -> star.run());
        this.createEnemy();
        this.enemies.forEach(enemy -> {
            Vector2d velocity = player.position.subtract(enemy.position).normalize().multiply(random.nextInt(5)+1);
            enemy.velocity.set(velocity);
        });
        this.enemies.forEach(enemy -> enemy.run());
        this.player.run();
        Vector2d velocity = player.position.subtract(enemyAttack.position).normalize()
                .multiply(2);
        this.enemyAttack.velocity.set(velocity);

        this.enemyAttack.run();
    }

    private void createStar(){
            if(this.countStar == 10){
                Star star = new Star();
                star.position.set(1024,this.random.nextInt(600));
                star.velocity.set(-(this.random.nextInt(3)+1),0);
                this.stars.add(star);
                this.countStar = 0;
            }else{
                this.countStar+=1;
            }

    }
    private void createEnemy(){
        if(this.countEnemy == 200){
            Enemy enemy = new Enemy();
            enemy.position.set(this.random.nextInt(1024),this.random.nextInt(600));
            this.enemies.add(enemy);
            this.countEnemy = 0;
        }else{
            this.countEnemy+=1;
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
