package Gameplay;

import GameObject.Bird.Bird;
import GameObject.Mouse;

import java.util.ArrayList;

public class MouseConsole
{
    public static ArrayList<Mouse> mouseList = new ArrayList<>();

    static void resetHittingStatusOfAllMouses()
    {
        for (Mouse mouse : mouseList)
        {
            mouse.setJustGotHit(false);
        }
    }

    public static void addMouse(String[] mouseModel, int modelSize)
    {
        Mouse addedMouse = new Mouse(700, -300, mouseModel, modelSize);
        mouseList.add(addedMouse);
    }

    static void runAllMouses()
    {
        for (Mouse mouse : mouseList)
        {
            for (Bird bird : BirdConsole.birdList)
            {
                if (mouse.getHP() == 0)
                {
                    mouseList.remove(mouse);
                    return;
                }
                else if (mouse.getHitBy(bird))
                {
                    mouse.getDamaged();
                    bird.knockBack();
                    GameConsole.increaseOnePoint();
                }
            }
            mouse.move();
        }
    }
}