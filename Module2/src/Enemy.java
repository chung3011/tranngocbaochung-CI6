import java.awt.*;

public class Enemy extends GameObject{
    public Vector2d velocity;

    public Enemy() {
        this.velocity = new Vector2d();
        this.renderer = new ImageRenderer("resources/resources/images/circle.png",20,20);
    }

    @Override
    public void run() {
        super.run(); //run của cha
        this.position.addUp(this.velocity);
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
    }
}

