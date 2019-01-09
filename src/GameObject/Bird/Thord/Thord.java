package GameObject.Bird.Thord;

import Assests.BirdModel.BirdModel;
import GameObject.Bird.Bird;

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
}