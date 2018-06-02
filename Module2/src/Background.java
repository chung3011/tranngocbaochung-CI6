import java.awt.*;

public class Background {
    public Vector2d position;
    public BackgroundRenderer renderer;

    public Background() {
        this.position = new Vector2d();
        this.renderer = new BackgroundRenderer(Color.BLACK,1024,600);
    }
    public void render(Graphics graphics){
       this.renderer.render(graphics,this.position);
    }
}
