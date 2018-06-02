import java.awt.*;

public class BulletEnemy {
    public Vector2d position;
    public Vector2d velocity;
    private ImageRenderer renderer;

    public BulletEnemy() {
        this.position = new Vector2d();
        this.velocity = new Vector2d();
        this.renderer = new ImageRenderer("resources/resources/images/circle.png",6,6);
    }

    public void run() {
        this.position.addUp(this.velocity);
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }
}
