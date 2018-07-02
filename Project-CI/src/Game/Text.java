package Game;

import Base.GameObject;
import Base.Vector2D;
import Renderer.TextRenderer;

import java.awt.*;

public class Text extends GameObject {
    public Text(Vector2D position, String text, Color color, String path, int fontsize){
        this.position = position;
        this.renderer = new TextRenderer(text, color, path, fontsize);
    }
    public Text(Vector2D position,String text, String fontName,int fontSize, Color color){
        this.position = position;
        this.renderer = new TextRenderer(text, fontName, fontSize,color );
    }

    @Override
    public void render(Graphics graphics){
        super.render(graphics);

    }
}
