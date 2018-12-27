package Gameplay;

import GameObject.Bird.Bird;
import edu.princeton.cs.introcs.StdDraw;

import java.io.File;
import java.util.ArrayList;

public abstract class Controller
{
    public static void reset()
    {
        Power.reset();
        Angle.reset();
    }

    //Power controller
    public static final class Power
    {
        private static final int width = Game.getBackground().getWidth();
        private static final int height = 70;
        private static final int VELOCITY_MULTIPLIER = 30;


        private static File folder = new File("src\\Model\\ControllerModel\\Power bar");
        private static File[] powerBarFrames = folder.listFiles();

        private static int currentFrame = 0;
        private static double currentVelocity = 0;
        private static int changeLevel = -1;

        private static void reset()
        {
            currentFrame = 0;
            currentVelocity = 0;
            changeLevel = -1;
        }

        public static void setInitialVelocity(Bird bird)
        {
            bird.setVelocity(currentVelocity);
        }

        public static void getInitialVelocityByPlayer()
        {
            if (currentFrame % (powerBarFrames.length - 1) == 0)
            {
                changeLevel *= -1;   //change direction of power flow if it reaches the bar's edges
            }
            currentFrame += changeLevel;
            currentVelocity = currentFrame * VELOCITY_MULTIPLIER;

            StdDraw.picture(0, -Game.getBackground().getHeight() / 2 + 50, Power.powerBarFrames[currentFrame].getAbsolutePath(), width, height);
        }
    }

    //Shooting Angle controller
    public static final class Angle
    {
        private static final String ARROW_MODEL_PATH = "src\\Model\\ControllerModel\\Angle bar\\arrow.png";
        private static final int ARROW_WIDTH = 150;
        private static final int ARROW_HEIGHT = 150;
        private static final int MAX_ANGLE = 80;
        private static ArrayList<String> angleModelPath = new ArrayList<>();
        private static int currentFrame = 0;
        private static double currentAngle = 0;
        private static int angleChangeLevel = 1;
        private static int arrowWidthChangeLevel = -1;

        static
        {
            for (int angle = 0; angle <= 360; angle++)
            {
                angleModelPath.add("" + angle + " degree");
            }
        }

        private static void reset()
        {
            currentAngle = 0;
            currentFrame = 0;
        }

        public static void setShootingAngle(Bird bird)
        {
            bird.setCurrentAngle(currentAngle);
        }

        public static void getShootingAngleByPlayer()
        {
            if (currentAngle >= MAX_ANGLE || currentAngle < 0) angleChangeLevel *= -1;
            currentAngle += 3 * angleChangeLevel;
        }

        public static void performCurrentShootingAngle(Bird bird)
        {
            double distanceBetweenBirdAndArrow = ARROW_WIDTH / 2 + 150;
            double arrowX = distanceBetweenBirdAndArrow * Math.cos(Math.toRadians(currentAngle)) + bird.getInitialCoordinate().getX();
            double arrowY = distanceBetweenBirdAndArrow * Math.sin(Math.toRadians(currentAngle)) + bird.getInitialCoordinate().getY();

            StdDraw.picture(arrowX, arrowY, ARROW_MODEL_PATH, ARROW_WIDTH, ARROW_HEIGHT, currentAngle);
        }
    }

    //Skill controller
    public static final class Skill
    {

    }
}