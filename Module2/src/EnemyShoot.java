import java.util.ArrayList;
import java.util.List;

public class EnemyShoot {
    public List<BulletEnemy> bulletEnemies;
    private int countBullet = 0;
    private double angleBullet =0;

    public EnemyShoot(){
        this.bulletEnemies = new ArrayList<>();
    }
    public void run(EnemyAttack enemy){
        if(countBullet ==200){
            for(int i=0; i<10 ; i++){
                BulletEnemy bulletEnemy = new BulletEnemy();
                this.angleBullet +=36;
                bulletEnemy.velocity= new Vector2d(5,0).rotate(this.angleBullet);
                bulletEnemy.position.set(enemy.position);
                this.bulletEnemies.add(bulletEnemy);
            }
            countBullet =0;
            this.angleBullet =0;
        }
        else{
            countBullet +=1;
        }
    }

}