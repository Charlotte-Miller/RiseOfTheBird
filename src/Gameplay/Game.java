package Gameplay;

import Background.Background;
import GameObject.Bird.Bird;
import GameObject.Bird.Thord.Thord;
import edu.princeton.cs.introcs.StdDraw;

import java.io.File;

public final class Game
{
    public static void main(String[] args)
    {
        Thord thord = new Thord();
        thord.setCurrentAngle(0);
        while (true)
        {
            thord.show();
            thord.useSkill();
        }
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

        reset();
    }

    private static void gameOver()
    {
        if (point >= 3)
        {
            won();
        }
        else
        {
            lost();
        }
    }

    private static void lost()
    {
        String path = new File("src\\Gameplay\\lost.jpg").getAbsolutePath();
        StdDraw.picture(0, 0, path, background.getWidth(), background.getHeight());
        StdDraw.show();
    }

    private static void won()
    {
        String path = new File("src\\Gameplay\\won.jpg").getAbsolutePath();
        StdDraw.picture(0, 0, path, background.getWidth() / 2, background.getHeight());
        StdDraw.show();
    }

    private static void reset()
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