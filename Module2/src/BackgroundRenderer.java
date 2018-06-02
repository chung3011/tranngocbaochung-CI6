import java.awt.*;

public class BackgroundRenderer {
    private Color color;
    private int width,height;

    public BackgroundRenderer(Color color, int width, int height){
        this.color = color;
        this.width = width;
        this.height = height;
    }
    public void render(Graphics graphics, Vector2d position){
        graphics.setColor(color);
        graphics.fillRect((int)position.x, (int)position.y,this.width, this.height);
    }
}
