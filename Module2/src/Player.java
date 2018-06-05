import java.awt.*;
import java.util.Random;

public class Player extends GameObject{
    private PlayerShoot playerShoot;
    public PlayerMove playerMove;

    public Player() {
        this.renderer = new PolygonRenderer(
                Color.red,
                new Vector2d(0,0),
                new Vector2d(0,16),
                new Vector2d(20,8)
        );
        this.playerShoot = new PlayerShoot();
        this.playerMove = new PlayerMove();
    }

    public void run(){
        this.playerMove.run(this);
        ((PolygonRenderer)this.renderer).angle = this.playerMove.angle;
        this.playerShoot.run(this);
        this.playerShoot.bulletsPlayer.forEach(bulletPlayer -> bulletPlayer.run());
    }

    public void render(Graphics graphics){
        this.renderer.render(graphics, this.position);
        this.playerShoot.bulletsPlayer.forEach(bulletPlayer -> bulletPlayer.render(graphics));
    }
}
