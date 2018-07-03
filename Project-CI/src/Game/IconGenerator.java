package Game;

import Constant.Constant;
import Game.ObjectsToCatch.LargeObject.LargeObjectIcon;
import Game.ObjectsToCatch.Leaves.LeavesGenerator;
import Game.ObjectsToCatch.Leaves.LeavesIcon;
import Game.ObjectsToCatch.MediumObject.MediumObjectIcon;
import Game.ObjectsToCatch.SmallObject.SmallObjectIcon;

public class IconGenerator {
    public int horizonPos = Constant.Icon.HORIZONTALPOSITION;
    public int verticalPos;

    public static IconGenerator instance = new IconGenerator();

    private IconGenerator() {
        verticalPos = 20;
    }

    public LargeObjectIcon addLargeObjectIcon() {
        LargeObjectIcon largeObjectIcon = new LargeObjectIcon();
        largeObjectIcon.position.set(verticalPos, horizonPos);
        this.changeHorizontalPos();
        return largeObjectIcon;
    }


    public MediumObjectIcon addMediumObjectIcon() {
        MediumObjectIcon mediumObjectIcon = new MediumObjectIcon();
        mediumObjectIcon.position.set(verticalPos, horizonPos);
        this.changeHorizontalPos();
        return mediumObjectIcon;
    }


    public SmallObjectIcon addSmallObjectIcon() {
        SmallObjectIcon smallObjectIcon = new SmallObjectIcon();
        smallObjectIcon.position.set(verticalPos, horizonPos);
        this.changeHorizontalPos();
        return smallObjectIcon;
    }


    public LeavesIcon addLeaf() {
        LeavesIcon leafIcon = new LeavesIcon();
        leafIcon.position.set(verticalPos, horizonPos);
        this.changeHorizontalPos();
        return  leafIcon;
    }
    public void resetVerticalPos() {
        this.verticalPos = 20;
    }

    private void changeHorizontalPos() {
        this.verticalPos += 25;
    }
}