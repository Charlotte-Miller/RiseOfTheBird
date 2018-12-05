import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test
{
    public static void main(String[] args)
    {
        File folder = new File("F:\\IntelliJ IDEA 2018.2.1\\Workspace\\GunnyChick\\src\\Model\\ControllerModel\\Power bar");
        File[] listOfFile = folder.listFiles();
        List<File> fileList = new ArrayList<>(Arrays.asList(listOfFile));

        for (File file : fileList)
        {
            if (file.isFile())
            {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}
