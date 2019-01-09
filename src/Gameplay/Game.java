package Gameplay;

public class Game
{
    public Game()
    {
        BirdConsole.addBird(BirdCharacter.THORD);
        BirdConsole.addBird(BirdCharacter.BULK);
        BirdConsole.addBird(BirdCharacter.THORD);
        BirdConsole.addBird(BirdCharacter.BULK);


    }

    public void play()
    {
        GameConsole.play();
    }
}
