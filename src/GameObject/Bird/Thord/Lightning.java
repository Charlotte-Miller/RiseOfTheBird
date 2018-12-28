package GameObject.Bird.Thord;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.io.File;

public class Lightning
{
    private final File LIGHTNING_MODEL_FOLDER;
    private final File[] LIGHTNING_FRAME;
    private final Point INITIAL_POSTION;
    private double initialAngle;
    private final double SPEED;
    private final double SIZE;
    public boolean striked;

    private double currentX;
    private double currentY;

    public Lightning(Point INITIAL_POSTION, double SPEED, double SIZE)
    {
        this.LIGHTNING_MODEL_FOLDER = new File("src\\Model\\BirdModel\\Thord\\Lightning");
        this.LIGHTNING_FRAME = LIGHTNING_MODEL_FOLDER.listFiles();
        this.initialAngle = 0;
        this.INITIAL_POSTION = INITIAL_POSTION;
        this.SPEED = SPEED;
        this.SIZE = SIZE;
        this.currentX = INITIAL_POSTION.getX() + 200;
        this.currentY = INITIAL_POSTION.getY();
    }

    public void dart()
    {
        currentX += SPEED * Math.cos(Math.toRadians(initialAngle));
        currentY += SPEED * Math.sin(Math.toRadians(initialAngle));

        StdDraw.picture(currentX, currentY, LIGHTNING_FRAME[0].getAbsolutePath(), SIZE, SIZE, initialAngle + 100);

        currentX += SPEED;
    }

    public void setInitialAngle(double initialAngle)
    {
        this.initialAngle = initialAngle;
    }
}
