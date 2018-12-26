package GameObject.Bird;

import Model.BirdModel.BirdModel;

import java.io.File;

public class Thord extends Bird
{
    private final File LIGHTNING_MODEL_FOLDER;
    private final File[] LIGHTNING_FRAME;

    public Thord(int x, int y, int modelSize)
    {
        super(x, y, BirdModel.THORD_ORIGINAL, modelSize);
        LIGHTNING_MODEL_FOLDER = new File("src\\Model\\BirdModel\\Thord\\Lightning");
        LIGHTNING_FRAME = LIGHTNING_MODEL_FOLDER.listFiles();
    }

    @Override
    public void useSkill()
    {
        //Throw a lightning in the direction that the bird is currently facing

    }
}