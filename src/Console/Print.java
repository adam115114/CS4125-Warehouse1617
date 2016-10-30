package Console;

/**
 * Created by adam on 30/10/2016.
 */
public class Print {

    public static void print(Object obj, boolean check){
        if (!check)
            System.out.print(""+ obj);
        else
            System.out.println(""+ obj);
    }
}
