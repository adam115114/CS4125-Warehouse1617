package Console;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Print {

    public static void  print(Object obj, boolean check) { // This will not be used after Adam is done with the GUI's
        if (!check)
            System.out.print("" + obj);
        else
            System.out.println("" + obj);
    }

    public void printToFile(File aFile, String output) throws IOException // This is Sims's file print method
    {
        FileWriter fw = new FileWriter(aFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(output);
        bw.close();
        fw.close();
    }
}
