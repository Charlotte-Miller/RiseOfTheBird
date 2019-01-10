package Gameplay;

import Background.Background;
import GameObject.Bird.Bird;
import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.VK_ENTER;

public final class GameConsole
{
    public static void main(String[] args)
    {
//        replay();
    }

    static final Background background = new Background(1900, 1000);
    static int point = 0;

    public static void play()
    {
        for (Bird bird : BirdConsole.birdList)
        {
            playOneRound(bird);
            if (point == 3)
            {
                break;
            }
        }
        gameOver();
    }

    public static void playOneRound(Bird currentBird)
    {
        StdDraw.enableDoubleBuffering();

        background.clear();

        currentBird.show();
        MouseConsole.runAllMouses();
        StdDraw.show();

        BirdConsole.setShootingAngle(currentBird);
        BirdConsole.setInitialVelocity(currentBird);
        BirdConsole.shoot(currentBird);

        resetCurrentGameData();
    }

    private static void gameOver()
    {
        if (point >= 3) won();
        else lost();

        if (wantToReplay()) replay();
    }

    public static void replay()
    {
        point = 0;
        reset();
        play();
    }

    private static void reset()
    {
        resetCurrentGameData();

        BirdConsole.birdList = new ArrayList<>();
        for (BirdCharacter birdCharacter : Gameplay.characters)
        {
            BirdConsole.addBird(birdCharacter);
        }

        MouseConsole.mouseList = new ArrayList<>();
        MouseConsole.addMouse(Assests.MouseModel.MouseModel.MOUSELEFICENT, 225);
    }

    private static boolean wantToReplay()
    {
        File[] path = new File("src\\Model\\Menu\\Replay").listFiles();

        //Show instruction to replay
        StdDraw.pause(1000);
        StdDraw.clear(Color.BLACK);
        StdDraw.picture(0, 0, path[0].getAbsolutePath(), background.getHeight(), background.getHeight());
        StdDraw.show();

        //Press Enter to accept to replay
        while (true)
        {
            if (StdDraw.isKeyPressed(VK_ENTER))
            {
                StdDraw.clear(Color.WHITE);
                StdDraw.picture(0, 0, path[1].getAbsolutePath(), background.getHeight(), background.getHeight());
                StdDraw.show();
                StdDraw.pause(500);

                return true;
            }
        }
    }

    private static void lost()
    {
        String path = new File("src\\Model\\Menu\\lost.jpg").getAbsolutePath();
        StdDraw.picture(0, 0, path, background.getWidth(), background.getHeight());
        StdDraw.show();
    }

    private static void won()
    {
        String path = new File("src\\Model\\Menu\\won.jpg").getAbsolutePath();
        StdDraw.picture(0, 0, path, background.getWidth() / 2, background.getHeight());
        StdDraw.show();
    }

    private static void resetCurrentGameData()
    {
        Controller.reset();
        MouseConsole.resetHittingStatusOfAllMouses();
    }

    public static Background getBackground()
    {
        return background;
    }

    public static void increaseOnePoint()
    {
        point++;
    }
}