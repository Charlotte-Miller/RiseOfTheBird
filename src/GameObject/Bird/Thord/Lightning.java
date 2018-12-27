package GameObject.Bird.Thord;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.io.File;

public class Lightning
{
    private final File LIGHTNING_MODEL_FOLDER;
    private final File[] LIGHTNING_FRAME;
    private final Point INITIAL_POSTION;
    private final double ANGLE;
    private final double SPEED;
    private final double SIZE;
    public boolean striked;

    private double currentX;
    private double currentY;

    public Lightning(Point INITIAL_POSTION, double ANGLE, double SPEED, double SIZE)
    {
        this.LIGHTNING_MODEL_FOLDER = new File("src\\Model\\BirdModel\\Thord\\Lightning");
        this.LIGHTNING_FRAME = LIGHTNING_MODEL_FOLDER.listFiles();
        this.INITIAL_POSTION = INITIAL_POSTION;
        this.ANGLE = ANGLE;
        this.SPEED = SPEED;
        this.SIZE = SIZE;
        this.currentX = INITIAL_POSTION.getX();
        this.currentY = INITIAL_POSTION.getY();
    }

    public void dart()
    {
        double x = currentX * Math.cos(Math.toRadians(ANGLE));
        double y = currentY * Math.sin(Math.toRadians(ANGLE));

        StdDraw.picture(x, y, LIGHTNING_FRAME[0].getAbsolutePath(), SIZE, SIZE, ANGLE);

        currentX += SPEED;
        currentY += SPEED;
    }
}
