package Console;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Print {

    public static void print(Object obj, boolean check) {
        if (!check)
            System.out.print("" + obj);
        else
            System.out.println("" + obj);
    }

    public void printToFile(File aFile, String output) throws IOException
    {
        FileWriter fw = new FileWriter(aFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(output);
        bw.close();
        fw.close();
    }
}
