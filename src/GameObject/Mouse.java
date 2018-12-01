package GameObject;

import edu.princeton.cs.introcs.StdDraw;

public class Mouse extends GameObject {

    private int step = 40;
    private int movingDistance = 0;
    private final int MAX_RANGE = 150;
    private int HP = 3;
    private boolean justGotHit = false; //to avoid getting hit continuously by bird

    public Mouse(int x, int y, String[] model, int modelSize)
    {
        super(x, y, model, modelSize);
    }

    public void getDamaged()
    {
        if (HP > 0)
        {
            HP--;
            setModelSize(getModelSize() - 50);
            step += (step/Math.abs(step)) * 40;
        }
    }

    public boolean getHitBy(Bird hittingBird)
    {
        if ((this.getCurrentCoordinate().distance(hittingBird.getCurrentCoordinate())) <= (this.getModelSize() / 3 + hittingBird.getModelSize() / 3)
                && !justGotHit)
        {
            justGotHit = true;
            return true;
        }
        return false;
    }

    @Override
    public void move()
    {
        if (HP > 0)
        {
            moveBackAndForth();
            show();
        } else show();
    }

    private void moveBackAndForth()
    {
        if (Math.abs(movingDistance) >= MAX_RANGE) step *= -1;
        movingDistance += step;

        setCurrentCoordinate((int) (getInitialCoordinate().getX() + movingDistance), (int) getInitialCoordinate().getY());
    }

    @Override
    public void show()
    {
        StdDraw.picture(getCurrentCoordinate().getX(), getCurrentCoordinate().getY(), getModelPath()[HP], getModelSize(), getModelSize());
    }

    public int getHP()
    {
        return HP;
    }

    public void setJustGotHit(boolean justGotHit)
    {
        this.justGotHit = justGotHit;
    }
}
