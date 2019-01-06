package GameObject.Bird.Thord;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.io.File;

public class Lightning
{
    private final File LIGHTNING_MODEL_FOLDER;
    private final File[] LIGHTNING_FRAME;
    private Point currentPosition;
    private double initialAngle;
    private final double SPEED;
    private final double SIZE;
    public boolean striked;

    private double currentX;
    private double currentY;

    public Lightning(double SPEED, double SIZE)
    {
        this.LIGHTNING_MODEL_FOLDER = new File("src\\Model\\BirdModel\\Thord\\Lightning");
        this.LIGHTNING_FRAME = LIGHTNING_MODEL_FOLDER.listFiles();
        this.initialAngle = 0;
        this.SPEED = SPEED;
        this.SIZE = SIZE;
        this.currentX = 0;
        this.currentY = 0;
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

    public void setCurrentPosition(Point currentPosition)
    {
        this.currentPosition = currentPosition;
        this.currentX = currentPosition.getX() + 50;
        this.currentY = currentPosition.getY();
    }
}
