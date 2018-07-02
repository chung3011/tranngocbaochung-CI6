import Base.Vector2D;
import Constant.Constant;
import Input.MouseInput;
import scene.GamePlayScene;
import scene.SceneManager;

import javax.swing.*;
import java.awt.event.*;


public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    long lastTime = 0;

    public GameWindow() {
        this.setSize(Constant.Window.WIDTH, Constant.Window.HEIGHT);
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
        this.event();
        this.setVisible(true);
    }

    private void event() {
        this.keyboardEvent();
        this.windowEvent();
        this.mouseEvent();
    }

    private void keyboardEvent() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (SceneManager.instance.getCurrentScene() instanceof GamePlayScene) {
                        gameCanvas.startCatching();
                    }
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {

                }

            }
        });
    }


    private void windowEvent() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }


    private void mouseEvent(){
//        this.addMouseListener(MouseInput.instance);
        // phải sử dụng getContentPane để lấy tọa độ 0,0 không tính phần bao của cửa sổ window
        // lệnh getX, getY lấy tọa độ so với điểm 0,0 là phần nội dung bên trong ko tính phần bao
        this.getContentPane().addMouseListener(MouseInput.instance);

    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();

            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }
        }

    }
}
