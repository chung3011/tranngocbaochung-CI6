import java.util.ArrayList;
import java.util.List;

public class EnemyShoot {
    public List<BulletEnemy> bulletEnemies;
    private FrameCounter frameCounter = new FrameCounter(200);

    public EnemyShoot(){
        this.bulletEnemies = new ArrayList<>();
    }
    public void run(EnemyAttack enemy){
        if(this.frameCounter.run()){
            for(int angle=0; angle<360 ; angle+=30){
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.velocity= new Vector2d(5,0).rotate(angle);
                bulletEnemy.position.set(enemy.position);
                this.bulletEnemies.add(bulletEnemy);
            }
            this.frameCounter.reset();
        }
    }

}