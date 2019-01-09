package Gameplay;

import GameObject.Bird.Bird;
import GameObject.Bird.Bulk;
import GameObject.Bird.Thord.Thord;
import edu.princeton.cs.introcs.StdDraw;

import java.util.ArrayList;

import static java.awt.event.KeyEvent.VK_SPACE;

public final class BirdConsole
{

    static ArrayList<Bird> birdList = new ArrayList<>();

    static void setShootingAngle(Bird currentBird)
    {
        while (true)
        {
            if (StdDraw.isKeyPressed(VK_SPACE))
            {
                while (StdDraw.isKeyPressed(VK_SPACE))
                {
                    Controller.Angle.getShootingAngleByPlayer();
                    Controller.Angle.setShootingAngle(currentBird);

                    GameConsole.background.clear();
                    currentBird.show();
                    Controller.Angle.performCurrentShootingAngle(currentBird);

                    MouseConsole.runAllMouses();

                    StdDraw.pause(60);
                    StdDraw.show();
                }
                break;
            }
        }
    }

    static void setInitialVelocity(Bird currentBird)
    {
        while (true)
        {
            if (StdDraw.isKeyPressed(VK_SPACE))
            {
                while (StdDraw.isKeyPressed(VK_SPACE))
                {
                    GameConsole.background.clear();
                    Controller.Power.getInitialVelocityByPlayer();
                    currentBird.show();

                    MouseConsole.runAllMouses();

                    StdDraw.pause(40);
                    StdDraw.show();
                }
                Controller.Power.setInitialVelocity(currentBird);
                break;
            }
        }

    }

    //throws a bird to the set direction and uses it's skill while flying
    static void shoot(Bird currentBird)
    {
        while (!currentBird.isOverreached())
        {
            GameConsole.background.clear();

            Controller.Skill.useSkillOf(currentBird);
            currentBird.move();

            MouseConsole.runAllMouses();

            StdDraw.pause(35);
            StdDraw.show();
        }
    }

    public static void addBird(BirdCharacter character)
    {
        switch (character)
        {
            case THORD:
                birdList.add(new Thord());
                break;
            case BULK:
                birdList.add(new Bulk());
                break;
        }
    }
}
