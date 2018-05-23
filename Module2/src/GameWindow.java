import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameWindow extends JFrame {
    GameCanvas gameCanvas;
    long lastTime=0;
    public GameWindow(){
        this.setSize(1024,600);
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()== KeyEvent.VK_LEFT){
                    if (gameCanvas.positionXPlayer>0)
                    gameCanvas.positionXPlayer=(gameCanvas.positionXPlayer-10)%1024;
                    else
                        gameCanvas.positionXPlayer=1024;
                }
                if(e.getKeyCode()== KeyEvent.VK_RIGHT){
                    gameCanvas.positionXPlayer=(gameCanvas.positionXPlayer+10)%1024;
                }
                if(e.getKeyCode()== KeyEvent.VK_UP){
                    if (gameCanvas.positionYPlayer>0)
                        gameCanvas.positionYPlayer=(gameCanvas.positionYPlayer-10)%600;
                    else
                        gameCanvas.positionYPlayer=600;
                }
                if(e.getKeyCode()== KeyEvent.VK_DOWN){
                    gameCanvas.positionYPlayer=(gameCanvas.positionYPlayer+10)%600;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.setVisible(true); // cho phép cửa sổ hiển thị lên
        }
        public void gameLoop(){
        while (true){
            long currentTime = System.nanoTime();
            if (currentTime - lastTime >= 17_000_000)
            {
//                this.gameCanvas.positionXStar=(this.gameCanvas.positionXStar+3)%1024;
//                this.gameCanvas.positionYEnemy=(this.gameCanvas.positionYEnemy+3)%600;
                for(int i=0; i<this.gameCanvas.starsList.length;i++){
                    this.gameCanvas.starsList[i].x =(this.gameCanvas.starsList[i].x+3)%1024;
                }
                for(int i=0; i<this.gameCanvas.enemiesList.length;i++){
                    this.gameCanvas.enemiesList[i].y =(this.gameCanvas.enemiesList[i].y+3)%600;
                }
                this.gameCanvas.repaint();
                this.lastTime = currentTime;
            }

        }
        }
}
