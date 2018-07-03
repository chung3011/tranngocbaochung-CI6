package Game;

import Constant.Constant;
import scene.*;

public class Level {

    private int LEVEL_ONE_MAX_SCORE = 5;
    private int LEVEL_TWO_MAX_SCORE = 10;

    public int countSmallObjects;
    public int countLargeObjects;
    public int countMediumObjects;
    public int countLeaves;
    public int sum;
    public static int level;



    private boolean isCompleted;

//    public static int level;

    public Level() {
        this.level += 1 ;
        this.reset();
    }

    public void reset() {
        this.isCompleted = false;
        this.countLargeObjects = 0;
        this.countMediumObjects = 0;
        this.countSmallObjects = 0;
        this.countLeaves = 0;
        this.sum = 0;
        IconGenerator.instance.resetVerticalPos();

    }


    public void addLargeObjects() {
        this.countLargeObjects++;
        this.sum++;
    }

    public void addMediumObjects() {
        this.countMediumObjects++;
        this.sum++;
    }


    public void addSmallObjects() {
        this.countSmallObjects++;
        this.sum++;
    }

    public void addLeaf() {
        this.countLeaves++;
        this.sum++;
    }

    public void isCompleted() {
        if (level == 1) {
            if (countLargeObjects >= Constant.Level.largeLv1 && countMediumObjects
                    >= Constant.Level.mediumLv1 && countSmallObjects >= Constant.Level.smallLv1) {
//            if (sum >= 1 ) {
                this.isCompleted = true;
                System.out.println("level up!");
                this.reset();
                SceneManager.instance.changeScene(new LevelTwoScene());
            }

            if (sum == 7 && this.isCompleted == false) {
                this.reset();
                SceneManager.instance.changeScene(new GameOverAnNhieuScene());
            }
        }

        else if (level == 2) {
            if (countLargeObjects >= Constant.Level.largeLv2 && countMediumObjects >= Constant.Level.mediumLv2 &&
                  countSmallObjects >= Constant.Level.smallLv2 ) {
//            if (countSmallObjects >= 1) {
                this.isCompleted  = true;
                this.reset();
                SceneManager.instance.changeScene(new LevelThreeScene());
            }

//            if (sum > 15) {
            if (sum == 15 && this.isCompleted == false) {
                this.reset();
                SceneManager.instance.changeScene(new GameOverAnNhieuScene());
            }
        }

        else if (level == 3) {
            if (countLargeObjects >= Constant.Level.largeLv3 && countMediumObjects >= Constant.Level.mediumLv3 &&
                  countSmallObjects >= Constant.Level.smallLv3 ) {
//            if (sum >= 1) {
                this.isCompleted  = true;
                this.reset();
                SceneManager.instance.changeScene(new WinningScene());
            }

//            if (sum > 15) {
            if (sum == 15 && this.isCompleted == false) {
                this.reset();
                SceneManager.instance.changeScene(new GameOverAnNhieuScene());
            }
        }

    }

    public void countObjects() {
        sum = this.countLargeObjects + this.countMediumObjects
                + this.countSmallObjects + this.countLeaves;
    }


    public int getLevel() {
        return this.level;
    }

}
