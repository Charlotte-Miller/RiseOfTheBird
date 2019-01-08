package GameObject.Bird.Thord;

import GameObject.Bird.Bird;
import Model.BirdModel.BirdModel;

public class Thord extends Bird
{
    private final Lightning LIGHTNING;

    public Thord()
    {
        super(-700, -300, BirdModel.THORD_ORIGINAL, 200);
        LIGHTNING = new Lightning(170, 250);
    }

    @Override
    public void useSkill()
    {
        if (!skillKeyIsPressed)
        {
            LIGHTNING.setInitialAngle(this.getCurrentAngle());
            LIGHTNING.setCurrentPosition(this.getCurrentCoordinate());
            this.skillKeyIsPressed = true;
        }

        //Throw a lightning in the direction that the bird is currently facing
        if (!LIGHTNING.striked)
        {
            LIGHTNING.dart();
        }
    }
}