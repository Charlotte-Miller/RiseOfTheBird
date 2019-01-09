package GameObject.Bird;

import GameObject.GameObject;
import Gameplay.GameConsole;
import edu.princeton.cs.introcs.StdDraw;

public abstract class Bird extends GameObject
{
    private double gravity = 1.5;
    private double time = 0;
    private double velocity;
    private double currentAngle;
    public boolean skillKeyIsPressed = false;
    private int formIndex;

    public Bird(int x, int y, String[] model, int modelSize, double velocity, double currentAngle)
    {
        super(x, y, model, modelSize);
        this.velocity = velocity;
        this.currentAngle = currentAngle;
        this.formIndex = 0;
    }

    public Bird(int x, int y, String[] model, int modelSize)
    {
        super(x, y, model, modelSize);
        this.formIndex = 0;
    }

    public abstract void useSkill();

    @Override
    public void move()
    {
        //The chick moves in parabolic orbit
        double vx = Math.cos(Math.toRadians(currentAngle)) * velocity;
        double vy = Math.sin(Math.toRadians(currentAngle)) * velocity - gravity * time;
        double x = vx * time + this.getInitialCoordinate().getX();
        double y = vy * time - (1 / 2) * gravity * time * time + this.getInitialCoordinate().getY();

        setCurrentCoordinate((int) x, (int) y);

        StdDraw.picture(x, y, this.getModelPath()[formIndex], this.getModelSize(), this.getModelSize(), currentAngle);

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

    @Override
    public void show()
    {
        StdDraw.picture(getCurrentCoordinate().getX(), getCurrentCoordinate().getY(), getModelPath()[formIndex], this.getModelSize(), this.getModelSize(), currentAngle);
    }

    public boolean isOverreached()
    {
        return (this.getCurrentCoordinate().getX() - this.getModelSize()) >= GameConsole.getBackground().getWidth()
                || (this.getCurrentCoordinate().getY() - this.getModelSize()) <= -GameConsole.getBackground().getHeight();
    }

    public void setVelocity(double velocity)
    {
        this.velocity = velocity;
    }

    public void setCurrentAngle(double angle)
    {
        this.currentAngle = angle;
    }

    public double getCurrentAngle()
    {
        return currentAngle;
    }

    public double getGravity()
    {
        return gravity;
    }

    public void setGravity(double gravity)
    {
        this.gravity = gravity;
    }

    public void changeForm()
    {
        this.formIndex = 1;
    }

    public double getVelocity()
    {
        return velocity;
    }
}
