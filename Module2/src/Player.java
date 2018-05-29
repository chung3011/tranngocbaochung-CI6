import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.peer.CanvasPeer;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player {
//    public BufferedImage image;
    public Vector2d position;
//    public int width, height;
    public Vector2d velocity;
    public double angle;
    Random rand = new Random();
    List<Vector2d> verties;
    private Polygon polygon;


    public Player(int x,int y) {
//        this.image = image;
        this.position = new Vector2d(x,y);
//        this.width = width;
//        this.height = height;
        this.velocity = new Vector2d(5,0);
        this.verties = Arrays.asList(
                new Vector2d(),
                new Vector2d(0,16),
                new Vector2d(20,8)

        );
        this.updateVerties();
        this.polygon =  new Polygon();
    }

//    public void runLeft(){
//        if (this.x >0)
//            this.x -= velocityX;
//        else{
//            this.x=984;
//            this.y=rand.nextInt(530);
//        }
//    }
//    public void runRight(){
//        if (this.x <984)
//            this.x += velocityX;
//        else{
//            this.x=0;
//            this.y=rand.nextInt(530);
//        }
//    }
//    public void runUp(){
//        if (this.y >0)
//            this.y -= velocityY;
//        else{
//            this.y=530;
//            this.x=rand.nextInt(984);
//        }
//    }
//    public void runDown(){
//        if (this.y <530)
//            this.y += velocityY;
//        else{
//            this.y=0;
//            this.x=rand.nextInt(984);
//        }
//    }
    public void run(){
        this.velocity.set(this.velocity.rotate(this.angle));
        this.position.addUp(this.velocity);
        this.backToScreen();
        this.updateVerties();
    }
    public void updateVerties() {
        float k = (float) ((2.0 / 3.0) * (18 / this.velocity.length()));
        Vector2d GA = this.velocity.multiply(k);
        Vector2d OA = this.position.add(GA);
        Vector2d OI = this.position.subtract(GA.multiply((float) (1.0 / 2.0)));
        k = (float) ((8/ 2.0) / this.velocity.length());
        Vector2d OB = this.velocity.rotate(90).multiply(k).add(OI);
        Vector2d OC = this.velocity.rotate(270).multiply(k).add(OI);
        this.verties = Arrays.asList(OA, OB, OC);
    }
    public void backToScreen(){
        if (this.position.x>1024){
            this.position.set(0,this.rand.nextInt(600));
        }
        if (this.position.x<0){
            this.position.set(1024,this.rand.nextInt(600));
        }
        if (this.position.y>600){
            this.position.set(this.rand.nextInt(1024),0);
        }
        if (this.position.y<0){
            this.position.set(this.rand.nextInt(1024),600);
        }
    }

    public void render(Graphics graphics){
//        graphics.drawImage(this.image,this.x, this.y, this.width, this.height, null);
        graphics.setColor(Color.red);
        this.polygon.reset();
        this.verties.forEach(vertex -> polygon.addPoint((int)vertex.x,(int)vertex.y));
        graphics.fillPolygon(this.polygon);
    }
}
