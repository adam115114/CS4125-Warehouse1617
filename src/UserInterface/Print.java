package UserInterface;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Print {
    public void printToFile(File aFile, String output, Boolean append) throws IOException // This is Sims's file print method
    {
        FileWriter fw = new FileWriter(aFile, append);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(output);
        bw.close();
        fw.close();
    }
}