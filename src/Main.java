import Gameplay.BirdCharacter;
import Gameplay.Game;
import Model.MouseModel.MouseModel;

public class Main
{
    public static void main(String[] args)
    {
        Game.addBird(BirdCharacter.THORD);
        Game.addBird(BirdCharacter.THORD);
        Game.addBird(BirdCharacter.THORD);
        Game.addBird(BirdCharacter.THORD);
        Game.addBird(BirdCharacter.THORD);

        Game.addMouse(MouseModel.MOUSELEFICENT, 225);

        Game.play();
    }
}