import java.awt.*;

public class EnemyAttack {
    public Vector2d position;
    public Vector2d velocity;
    private ImageRenderer renderer;
    private EnemyShoot enemyShoot;

    public EnemyAttack(){
        this.position = new Vector2d();
        this.velocity = new Vector2d();
        this.renderer = new ImageRenderer("resources/resources/images/circle.png",30,30);
        this.enemyShoot = new EnemyShoot();
    }

    public void run(){
        this.position.addUp(this.velocity);
        this.enemyShoot.run(this);
        this.enemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());

    }

    public void render(Graphics graphics){
        this.renderer.render(graphics,this.position);
        this.enemyShoot.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));

    }
}