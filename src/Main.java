import Gameplay.Game;
import Model.BirdModel.BirdModel;
import Model.MouseModel.MouseModel;

public class Main {

    public static void main(String[] args)
    {
        Game.addBird(BirdModel.THORD_ORIGINAL, 300);
        Game.addBird(BirdModel.THORD_ORIGINAL, 300);
        Game.addBird(BirdModel.THORD_ORIGINAL, 300);
        Game.addBird(BirdModel.THORD_ORIGINAL, 300);
        Game.addBird(BirdModel.THORD_ORIGINAL, 300);

        Game.addMouse(MouseModel.MOUSELEFICENT, 225);

        Game.play();
    }
}