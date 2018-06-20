package game.star;

import action.*;
import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class StarSpawner extends GameObject {

    FrameCounter frameCounter = new FrameCounter(30);
    Random random;

    public StarSpawner() {
        this.random = new Random();
        this.createAction();
    }

    public void createAction(){
        this.addAction(
                new LimitAction(
                        new SequenceAction(
                                new WaitAction(50),
                                new ActionAdapter() {
                                    @Override
                                    public boolean run(GameObject owner) {
                                        Star star = GameObjectManager.instance.recycle(Star.class);star.position.set(1024, random.nextInt(600));
                                        star.velocity.set(-(random.nextInt(2)+1),0);
                                        return true;
                                    }
                                }

                        )
                        ,60)
        );

    }

    @Override
    public void run(){
        if(this.frameCounter.run()){
            Star star = GameObjectManager.instance.recycle(Star.class);
            star.position.set(1024, random.nextInt(600));
            star.velocity.set(-(random.nextInt(3)+1),0);
            this.frameCounter.reset();
        }

    }
}
