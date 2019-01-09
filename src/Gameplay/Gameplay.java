package Gameplay;

import Assests.MouseModel.MouseModel;

public class Gameplay
{
    public static BirdCharacter[] characters = {BirdCharacter.THORD, BirdCharacter.THORD, BirdCharacter.BULK, BirdCharacter.BULK};

    public static void main(String[] args)
    {
        for (BirdCharacter birdCharacter : characters)
        {
            BirdConsole.addBird(birdCharacter);
        }

        MouseConsole.addMouse(MouseModel.MOUSELEFICENT, 225);

        GameConsole.play();
    }
}