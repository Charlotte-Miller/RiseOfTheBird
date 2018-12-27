package GameObject.Bird.Thord;

import GameObject.Bird.Bird;
import Model.BirdModel.BirdModel;

public class Thord extends Bird
{
    private final Lightning LIGHTNING;

    public Thord(int x, int y, int modelSize)
    {
        super(x, y, BirdModel.THORD_ORIGINAL, modelSize);
        LIGHTNING = new Lightning(this.getCurrentCoordinate(), this.getCurrentAngle(), 10, 100);
    }

    @Override
    public void useSkill()
    {
        //Throw a lightning in the direction that the bird is currently facing
        if (!LIGHTNING.striked)
        {
            LIGHTNING.dart();
        }
    }
}