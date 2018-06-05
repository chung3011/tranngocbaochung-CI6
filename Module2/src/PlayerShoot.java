import java.util.ArrayList;
import java.util.List;

public class PlayerShoot {
    public List<BulletPlayer> bulletsPlayer;
    private FrameCounter frameCounter = new FrameCounter(10);

    public PlayerShoot() {
        this.bulletsPlayer = new ArrayList<>();
    }

    public void run(Player player) {
        if (frameCounter.run()) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(player.position);
            bulletPlayer.velocity.set(player.playerMove.velocity.add(player.playerMove.velocity.normalize().multiply(6)));
            this.bulletsPlayer.add(bulletPlayer);
            frameCounter.reset();
        }
    }
}

