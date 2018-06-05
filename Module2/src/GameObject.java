import java.awt.*;

public class GameObject {
    public Vector2d position;
    public Renderer renderer;

    public GameObject(){
        this.position = new Vector2d();
    }

    public void run(){}

    public void render(Graphics graphics){
        if (this.renderer == null) return;
        this.renderer.render(graphics,this.position);
    }
}
