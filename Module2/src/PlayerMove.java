import java.util.Random;

public class PlayerMove {
    public Vector2d velocity;
    public double angle;
    public Random random;

    public PlayerMove() {
        this.random = new Random();
        this.velocity = new Vector2d();
    }
    public void run(Player player){
        player.position.addUp(this.velocity);
        this.backToScreen(player);
    }

    public void backToScreen(Player player){
        if (player.position.x>1024){
            player.position.set(0,this.random.nextInt(600));
        }
        if (player.position.x<0){
            player.position.set(1024,this.random.nextInt(600));
        }
        if (player.position.y>600){
            player.position.set(this.random.nextInt(1024),0);
        }
        if (player.position.y<0){
            player.position.set(this.random.nextInt(1024),600);
        }
    }
}
