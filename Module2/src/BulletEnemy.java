import java.awt.*;

public class BulletEnemy extends GameObject {

    public Vector2d velocity;

    public BulletEnemy(){
        this.velocity = new Vector2d();
        this.renderer = new ImageRenderer("resources/resources/images/circle.png",6,6);
    }

    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
    }

    @Override
    public void render(Graphics graphics){
        super.render(graphics);
    }
}
