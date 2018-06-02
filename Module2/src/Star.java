import java.awt.*;

public class Star {
    public ImageRenderer renderer;
    public Vector2d position;
    public Vector2d velocity;

//    alt + insert
    public Star() {
        this.position = new Vector2d();
        this.velocity = new Vector2d();
        this.renderer = new ImageRenderer("resources/resources/images/star.png",5,5);
    }

    public void run(){
        this.position.addUp(this.velocity);
    }
    public void render(Graphics graphics){
        this.renderer.render(graphics,position);

    }
}
