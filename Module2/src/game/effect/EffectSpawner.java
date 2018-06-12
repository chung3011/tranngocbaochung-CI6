package game.effect;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class EffectSpawner extends GameObject {
    private FrameCounter frameCounterShield, frameCounterShoot;
    private Random random;

    public EffectSpawner(){
        this.frameCounterShield = new FrameCounter(600);
        this.frameCounterShoot = new FrameCounter(800);
        this.random = new Random();
    }

    public void run(){
        if(this.frameCounterShield.run()){
            Shield effectShield = GameObjectManager.instance.recycle(Shield.class);
            effectShield.position.set(this.random.nextInt(800)+ 50, this.random.nextInt(400)+50);
            this.frameCounterShield.reset();
        }
        if(this.frameCounterShoot.run()){
            TripleShoot effectTripleShoot = GameObjectManager.instance.recycle(TripleShoot.class);
            effectTripleShoot.position.set(this.random.nextInt(800)+50, this.random.nextInt(400)+50);
            this.frameCounterShoot.reset();
        }

    }

}