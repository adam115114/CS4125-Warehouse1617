/**
 * Created by David Sims on 17/10/2016.
 */
import objects.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WarehouseProject
{
    public WarehouseProject()
    {


    }
    public static void main(String[] args)
    {
        WarehouseProject a = new WarehouseProject();
    }

    public static void doSale() throws IOException
    {
        Runtime.getRuntime().exec("cls");

        String input;
        String[] temp;
        int num, quan;
        System.out.print("Please enter sale details(ProductCode Quantity):");
        input = System.console().readLine();
        temp = input.split(" ");
        num = Integer.parseInt(temp[0]);
        quan = Integer.parseInt(temp[1]);

        Stock sale = new Stock();
        if (sale.checkSale(num, quan))
        {

            invoice(num, quan);
        }
    }

    private static void invoice(int stockNum, int quantity) throws IOException {
        File invoices = new File("invoices.txt");
        if(!invoices.exists())
            invoices.createNewFile();
        System.out.print("Sale Invoice\t" + CurrentDate() + "\n" +stockNum + "\t" + quantity);

    }
    private static String CurrentDate()
    {
        DateFormat dateformat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Date currentDate = new Date();
        return dateformat.format(currentDate);
    }

}