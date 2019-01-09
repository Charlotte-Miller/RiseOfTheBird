package GameObject.Bird.Thord;

import GameObject.Bird.Bird;
import Model.BirdModel.BirdModel;

public class Thord extends Bird
{
    private final Lightning LIGHTNING;

    public Thord()
    {
        super(-700, -300, BirdModel.THORD, 200);
        this.LIGHTNING = new Lightning(170, 250);
    }

    @Override
    public void useSkill()
    {
        if (!skillKeyIsPressed)
        {
            skillKeyIsPressed = true;
            setVelocity(this.getVelocity() + 50);
            //Set up initial data for LIGHTNING
            LIGHTNING.setInitialAngle(getCurrentAngle());
            LIGHTNING.setCurrentPosition(getCurrentCoordinate());
        }

        //Throw a lightning in the direction that the bird is currently facing
        if (!LIGHTNING.striked)
        {
            LIGHTNING.dart();
        }
    }

    @Override
    public boolean isOverreached()
    {
        return super.isOverreached() || LIGHTNING.isOverreached();
    }
}