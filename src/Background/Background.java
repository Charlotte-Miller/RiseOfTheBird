package Background;

import edu.princeton.cs.introcs.StdDraw;

import java.io.File;

public class Background {

    private final String backgroundPath;
    private final int width;
    private final int height;

    public Background(int width, int height)
    {
        this.backgroundPath = new File("src\\Background\\Ragnarok_background.jpg").getAbsolutePath();
        this.width = width;
        this.height = height;

        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(-width / 2, width / 2);
        StdDraw.setYscale(-height / 2, height / 2);
    }

    public void clear()
    {
        StdDraw.picture(0, 0, backgroundPath, this.width, this.height);
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }
}
