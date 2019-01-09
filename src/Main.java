import Assests.MouseModel.MouseModel;
import Gameplay.BirdCharacter;
import Gameplay.BirdConsole;
import Gameplay.Game;
import Gameplay.MouseConsole;

public class Main
{
    public static void main(String[] args)
    {
//        BirdConsole.addBird(BirdCharacter.THORD);
        BirdConsole.addBird(BirdCharacter.BULK);
//        BirdConsole.addBird(BirdCharacter.THORD);
//        BirdConsole.addBird(BirdCharacter.BULK);

        MouseConsole.addMouse(MouseModel.MOUSELEFICENT, 225);

        Game.play();
    }
}