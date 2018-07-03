package Renderer;

import Base.Vector2D;

import java.awt.*;

public class WhiteBackgroundRenderer implements Renderer{

    private int width;
    private int height;
    private Color color;

    public WhiteBackgroundRenderer(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        graphics.setColor(this.color);
        graphics.fillRect((int) position.x, (int) position.y, this.width, this.height);
    }
}
