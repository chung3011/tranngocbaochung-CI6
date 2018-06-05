import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageRenderer implements Renderer{
    private BufferedImage image;
    private int width, height;

    public ImageRenderer(String path,int width, int height) {
        this.width = width;
        this.height = height;
        this.image = this.loadImage(path);
    }
    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void render(Graphics graphics, Vector2d position){
        graphics.drawImage(this.image, (int)position.x, (int)position.y, this.width, this.height, null);
    }
}
