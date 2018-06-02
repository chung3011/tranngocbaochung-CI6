import java.awt.*;

public class BulletPlayer {
    public Vector2d position;
    public Vector2d velocity;
    private ImageRenderer renderer;

    public BulletPlayer(){
        this.position = new Vector2d();
        this.velocity = new Vector2d();
        this.renderer = new ImageRenderer("resources/resources/images/circle.png",4,4);
    }

    public void run(){
        this.position.addUp(this.velocity);
    }

    public void render(Graphics graphics){
        this.renderer.render(graphics,this.position );
    }
}
