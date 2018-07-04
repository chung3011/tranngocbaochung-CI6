package Game.Background;

import Base.GameObject;
import Constant.Constant;
import Renderer.BackgroundRenderer;

public class GameOverBackground extends GameObject {
    public GameOverBackground() {
        this.renderer = new BackgroundRenderer("resources/images/chet-do-doc-ban-sua-2-pixilart.png", Constant.Window.WIDTH,
                Constant.Window.HEIGHT);
    }
}
