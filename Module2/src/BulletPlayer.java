import java.awt.*;

public class BulletPlayer extends GameObject {

    public Vector2d velocity;

    public BulletPlayer(){
        this.velocity = new Vector2d();
        this.renderer = new ImageRenderer("resources/resources/images/circle.png",4,4);
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
