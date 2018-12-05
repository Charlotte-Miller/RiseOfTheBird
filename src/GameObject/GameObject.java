package GameObject;

import java.awt.*;

public abstract class GameObject {

    private Point initialCoordinate;
    private Point currentCoordinate;
    private String[] modelPath;
    private int modelSize;

    public GameObject(int x, int y, String[] model, int modelSize)
    {
        this(new Point(x, y), model, modelSize);
    }

    public GameObject(Point initialCoordinate, String[] model, int modelSize)
    {
        this.initialCoordinate = initialCoordinate;
        this.modelPath = model;
        this.currentCoordinate = initialCoordinate;
        this.modelSize = modelSize;
    }

    public abstract void move();

    public abstract void show();

    public Point getInitialCoordinate()
    {
        return initialCoordinate;
    }

    public void setInitialCoordinate(Point initialCoordinate)
    {
        this.initialCoordinate = initialCoordinate;
    }

    public String[] getModelPath()
    {
        return modelPath;
    }

    public Point getCurrentCoordinate()
    {
        return currentCoordinate;
    }

    public int getModelSize()
    {
        return modelSize;
    }

    public void setModelSize(int modelSize)
    {
        this.modelSize = modelSize;
    }

    public void setCurrentCoordinate(int x, int y)
    {
        this.currentCoordinate = new Point(x, y);
    }
}