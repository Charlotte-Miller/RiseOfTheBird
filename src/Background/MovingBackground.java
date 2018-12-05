package Background;

import edu.princeton.cs.introcs.StdDraw;

public class MovingBackground
{

    public final String PATH = "F:\\IntelliJ IDEA 2018.2.1\\Workspace\\GunnyChick\\src\\Background\\Ragnarok_background.jpg";
    private final int SIZE;
    private int currentLayer;

    public MovingBackground(int size)
    {
        //set SIZE for the canvas
        this.SIZE = size;
        StdDraw.setCanvasSize(size, size);
        StdDraw.setXscale(-size, size);
        StdDraw.setYscale(-size, size);

        this.currentLayer = SIZE;   //This will draw the picture from it's left edge
    }

    public void run(int birdVelocity)
    {
        if (currentLayer < -SIZE + birdVelocity)
            show(currentLayer);    //"+ birdVelocity" to avoid over-showing background after reaching it's end
        else
        {
            show(currentLayer);
            currentLayer -= birdVelocity;
        }
    }

    public void show(int currentLayer)
    {
        StdDraw.picture(currentLayer, 0, PATH, 4 * SIZE, 2 * SIZE);
    }

    public int getSIZE()
    {
        return SIZE;
    }
}
