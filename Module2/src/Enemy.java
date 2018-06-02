import java.awt.*;

public class Enemy {
    public Vector2d position;
    public Vector2d velocity;
    private ImageRenderer renderer;

    public Enemy() {
        this.position = new Vector2d();
        this.velocity = new Vector2d();
        this.renderer = new ImageRenderer("resources/resources/images/circle.png",20,20);
    }

    public void run() {
        this.position.addUp(this.velocity);
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }
}

