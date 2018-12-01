package GameObject;

import Gameplay.Game;
import edu.princeton.cs.introcs.StdDraw;

public class Bird extends GameObject {

    private double gravity = 1.5;
    private double time = 0;

    private double velocity;
    private double currentAngle;

    public Bird(int x, int y, String[] model, int modelSize, double velocity, double currentAngle)
    {
        super(x, y, model, modelSize);
        this.velocity = velocity;
        this.currentAngle = currentAngle;
    }

    public Bird(int x, int y, String[] model, int modelSize)
    {
        super(x, y, model, modelSize);
    }

    @Override
    public void move()
    {
        //The chick moves in parabolic orbit
        double vx = Math.cos(Math.toRadians(currentAngle)) * velocity;
        double vy = Math.sin(Math.toRadians(currentAngle)) * velocity - gravity * time;
        double x = vx * time + this.getInitialCoordinate().getX();
        double y = vy * time - (1 / 2) * gravity * time * time + this.getInitialCoordinate().getY();

        setCurrentCoordinate((int) x, (int) y);

        StdDraw.picture(x, y, this.getModelPath()[0], this.getModelSize(), this.getModelSize(), currentAngle);

        currentAngle = Math.toDegrees(Math.atan(vy / vx));
        time += 0.5;
    }

    public void knockBack()
    {
        currentAngle += 180;
        velocity *= -1;
        setInitialCoordinate(getCurrentCoordinate());
        time = 0;
        gravity += 0.2;
    }

    //TODO creates the ground object then gets it's highest coordinate to finish this function

    @Override
    public void show()
    {
        StdDraw.picture(getInitialCoordinate().getX(), getInitialCoordinate().getY(), getModelPath()[0], this.getModelSize(), this.getModelSize(), currentAngle);
    }

    public boolean isOverreached()
    {
        return (this.getCurrentCoordinate().getX() - this.getModelSize()) >= Game.getBackground().getWidth()
                || (this.getCurrentCoordinate().getY() - this.getModelSize()) <= -Game.getBackground().getHeight();
    }

    public void setVelocity(double velocity)
    {
        this.velocity = velocity;
    }

    public void setCurrentAngle(double angle)
    {
        this.currentAngle = angle;
    }
}
