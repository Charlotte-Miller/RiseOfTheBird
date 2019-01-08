package GameObject.Bird.Thord;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.io.File;

public class Lightning
{
    private final File LIGHTNING_MODEL_FOLDER;
    private final File[] LIGHTNING_FRAME;
    private double initialAngle;
    private final double SPEED;
    private final double SIZE;
    public boolean striked;

    private Point currentPosition;

    public Lightning(double SPEED, double SIZE)
    {
        this.LIGHTNING_MODEL_FOLDER = new File("src\\Model\\BirdModel\\Thord\\Lightning");
        this.LIGHTNING_FRAME = LIGHTNING_MODEL_FOLDER.listFiles();
        this.initialAngle = 0;
        this.SPEED = SPEED;
        this.SIZE = SIZE;
        this.currentPosition = new Point(0, 0);
    }

    public void dart()
    {
        currentPosition.x += SPEED * Math.cos(Math.toRadians(initialAngle));
        currentPosition.y += SPEED * Math.sin(Math.toRadians(initialAngle));

        StdDraw.picture(currentPosition.x, currentPosition.y, LIGHTNING_FRAME[0].getAbsolutePath(), SIZE, SIZE, initialAngle + 100);
    }

    public void setInitialAngle(double initialAngle)
    {
        this.initialAngle = initialAngle;
    }

    public void setCurrentPosition(Point position)
    {
        this.currentPosition = new Point(position);
        this.currentPosition.x += 100;
    }
}
