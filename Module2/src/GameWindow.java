import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class GameWindow extends JFrame {
    GameCanvas gameCanvas;
    long lastTime = 0;

    public GameWindow() {
        this.setSize(1024, 600);
        this.setupGameCanvas();
        this.event();
        this.setVisible(true); // cho phép cửa sổ hiển thị lên
    }

    private void setupGameCanvas() {
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }

    private void event() {
        this.keyboardEvent();
        this.windowEvent();
    }

    private void keyboardEvent() {
        this.addKeyListener(new KeyListener() {
            private Vector2d NORMAL = new Vector2d(4,0);
            private Vector2d HIGH = new Vector2d(8,0);

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                Vector2d velocity = NORMAL.copy();
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gameCanvas.player.playerMove.angle -= 10;

                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    gameCanvas.player.playerMove.angle += 10;

                }
                if(e.getKeyCode()==KeyEvent.VK_UP){
//                    gameCanvas.player.velocity.multiply(2);
                    velocity = HIGH.copy();
                }
                Vector2d rotate = velocity.rotate(gameCanvas.player.playerMove.angle);
                gameCanvas.player.playerMove.velocity.set(rotate);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                Vector2d velocity = NORMAL.copy();
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    velocity = NORMAL.copy();
                }
                Vector2d rotate = velocity.rotate(gameCanvas.player.playerMove.angle);
                gameCanvas.player.playerMove.velocity.set(rotate);
            }
        });
    }

    private void windowEvent() {
        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - lastTime >= 17_000_000) {
//                this.gameCanvas.positionXStar=(this.gameCanvas.positionXStar+3)%1024;
//                this.gameCanvas.positionYEnemy=(this.gameCanvas.positionYEnemy+3)%600;
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }

        }
    }
}
