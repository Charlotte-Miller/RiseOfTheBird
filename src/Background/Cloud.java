package Background;

import GameObject.GameObject;
import edu.princeton.cs.introcs.StdDraw;

import java.io.File;

public class Cloud extends GameObject
{

    private int step = 40;

    public Cloud(int x, int y)
    {
        super(x, y, new String[]{new File("src\\Model\\cloud.png").getAbsolutePath()}, 0);
    }

    @Override
    public void move()
    {
        show();
        setCurrentCoordinate((int) getCurrentCoordinate().getX() - step, (int) getCurrentCoordinate().getY());
    }

    @Override
    public void show()
    {
        StdDraw.picture(getCurrentCoordinate().getX(), getCurrentCoordinate().getY(), getModelPath()[0], 500, 250);
    }
}
