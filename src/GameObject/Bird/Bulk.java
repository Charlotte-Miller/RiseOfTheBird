package GameObject.Bird;

import Model.BirdModel.BirdModel;

public class Bulk extends Bird
{
    public Bulk()
    {
        super(-700, -300, BirdModel.BULK, 170);
    }

    @Override
    public void useSkill()
    {
        //Increase size
        this.setModelSize(this.getModelSize() + 20);
        //Increase gravity
        this.setGravity(this.getGravity() + 0.1);
    }
}
