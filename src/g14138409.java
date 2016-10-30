import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class g14138409
{
    public static ArrayList<ArrayList<Integer>> matrixI = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<Integer> ele = new ArrayList<Integer>();
    public static int[][] matrixA;
    public static int[] randOr;

    public static void main(String[] args) throws IOException
    {
        fillArray();
        toAdj();
        randomOrder();
        File bFile = new File("AI16.txt");
        if(!bFile.exists())
            bFile.createNewFile();
        FileWriter fw = new FileWriter(bFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        for(int x=0;x<(matrixA.length)-1;x++)
        {
            for(int y=0;y<(matrixA.length)-1;y++)
            {
                bw.write(matrixA[x][y]);
                System.out.print(matrixA[x][y]);
            }
            bw.write("\n");
        }
        for(int s: randOr)
        {
            bw.write(s);
            System.out.print(s);
        }
        bw.close();
        fw.close();
    }
    public static void fillArray() throws FileNotFoundException
    {
        File aFile = new File("in2.txt");
        int f =0;
        String line;
        String elements[];
        Scanner in = new Scanner(aFile);
        for(int x=0;in.hasNext(); x++)
        {
            matrixI.add(new ArrayList<Integer>());
            line = in.nextLine();
            elements = line.split("");
            f=x+1;
            for(int y=0;y<elements.length; y++)
            {
                f=y+1;
                try{
                    matrixI.get(x).add(Integer.parseInt(elements[y]));
                }catch(NumberFormatException ex){}
            }
        }
        matrixA = new int[f][f];
    }
    public static void toAdj()
    {
        for(int x=0;x<(matrixI.size());x++)
        {
            for(int y=0;y<(matrixI.get(x).size());y++)
            {
                if(matrixI.get(x).get(y) == 1)
                    ele.add(y);
            }
            matrixA[ele.get(0)][ele.get(1)] = 1;
            matrixA[ele.get(1)][ele.get(0)] = 1;
            ele.clear();
        }
    }
    public static void randomOrder()
    {
        Random randGen = new Random();
        randOr = new int[matrixA.length];
        for(int x=0; x<matrixA.length; x++)
            randOr[x] = x;
        for(int y=0; y<randOr.length; y++)
        {
            int ran = randGen.nextInt(randOr.length);
            int temp = randOr[y];
            randOr[y] = randOr[ran];
            randOr[ran] = temp;
        }
    }
}