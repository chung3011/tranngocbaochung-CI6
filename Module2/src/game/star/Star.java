package game.star;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import renderer.ImageRenderer;

import java.awt.*;

public class Star extends GameObject {

    public Vector2D velocity;

    //constructor

    public Star() {

        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources-rocket/resources/images/star.png",5,5, Color.WHITE);
    }

    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        GameObjectManager.instance.killObject(this);
    }


}
