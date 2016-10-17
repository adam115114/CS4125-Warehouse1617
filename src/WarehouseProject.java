import objects.*;

import java.io.File;
import java.io.IOException;

public class WarehouseProject
{
    public static void main(String[] args)
    {
        System.out.print("Does nothing");
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

            invoice();
        }
    }

    private static void invoice()
    {
        File invoices = new File("invoices.txt");
    }
}
