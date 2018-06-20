package game.effect;

import action.*;
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
        this.createAction();
    }

    public void createAction(){
        this.addAction(
                new SequenceAction(
                        new WaitAction(600),
                        new LimitAction(
                                new SequenceAction(
                                        new ActionAdapter() {
                                            @Override
                                            public boolean run(GameObject owner) {
                                                int chooseEffect = random.nextInt(3);
                                                System.out.println(chooseEffect);
                                                if(chooseEffect <2){
                                                    EffectShield effectShield = GameObjectManager.instance.recycle(EffectShield.class);
                                                    effectShield.position.set(random.nextInt(800)+ 50, random.nextInt(400)+50);
                                                }
                                                else{
                                                    TripleShoot effectTripleShoot = GameObjectManager.instance.recycle(TripleShoot.class);
                                                    effectTripleShoot.position.set(random.nextInt(800)+50,random.nextInt(400)+50);
                                                }
                                                return true;
                                            }
                                        },
                                        new WaitAction(500)
                                )
                                ,4
                        )
                )
        );
    }

    public void run(){
//        if(this.frameCounterShield.run()){
//            EffectShield effectShield = GameObjectManager.instance.recycle(EffectShield.class);
//            effectShield.position.set(this.random.nextInt(800)+ 50, this.random.nextInt(400)+50);
//            this.frameCounterShield.reset();
//        }
//        if(this.frameCounterShoot.run()){
//            TripleShoot effectTripleShoot = GameObjectManager.instance.recycle(TripleShoot.class);
//            effectTripleShoot.position.set(this.random.nextInt(800)+50, this.random.nextInt(400)+50);
//            this.frameCounterShoot.reset();
//        }
        super.run();
    }

}