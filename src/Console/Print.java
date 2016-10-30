package Console;

/**
 * Created by adam on 30/10/2016.
 */
public class Print {

    public static void print(Object obj, boolean check) {
        if (!check)
            System.out.print("" + obj);
        else
            System.out.println("" + obj);
    }

    /*private void printToFile(File aFile, String output) throws IOException
    {
        FileWriter fw = new FileWriter(aFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(output);
        bw.close();
        fw.close();
    }*/
}
