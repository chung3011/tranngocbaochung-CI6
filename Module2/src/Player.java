import java.awt.*;
import java.util.Random;

public class Player {
    public Vector2d position;
    public Vector2d velocity;
    public double angle;
    Random rand = new Random();
    private PolygonRenderer renderer;
    private PlayerShoot playerShoot;

    public Player() {
        this.position = new Vector2d();
        this.velocity = new Vector2d(5,0);
        this.renderer = new PolygonRenderer(
                Color.red,
                new Vector2d(0,0),
                new Vector2d(0,16),
                new Vector2d(20,8)
        );
        this.playerShoot = new PlayerShoot();
    }

    public void run(){
        this.position.addUp(this.velocity);
        this.renderer.angle = this.angle;
        this.backToScreen();
        this.playerShoot.run(this);
        this.playerShoot.bulletsPlayer.forEach(bulletPlayer -> bulletPlayer.run());
    }

    public void backToScreen(){
        if (this.position.x>1024){
            this.position.set(0,this.rand.nextInt(600));
        }
        if (this.position.x<0){
            this.position.set(1024,this.rand.nextInt(600));
        }
        if (this.position.y>600){
            this.position.set(this.rand.nextInt(1024),0);
        }
        if (this.position.y<0){
            this.position.set(this.rand.nextInt(1024),600);
        }
    }

    public void render(Graphics graphics){
        this.renderer.render(graphics, this.position);
        this.playerShoot.bulletsPlayer.forEach(bulletPlayer -> bulletPlayer.render(graphics));
    }
}
