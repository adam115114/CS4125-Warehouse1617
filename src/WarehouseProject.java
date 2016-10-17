/**
 * Created by David Sims on 17/10/2016.
 */
import objects.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class WarehouseProject
{
    public ArrayList<Employee> employee = new ArrayList<>();
    public ArrayList<Stock> Stock = new ArrayList<>();

    public WarehouseProject()  {


    }
    public void doSale() throws IOException
    {


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

    private void invoice(int stockNum, int quantity) throws IOException {
        File invoices = new File("invoices.txt");
        if(!invoices.exists())
            invoices.createNewFile();
        System.out.print("Sale Invoice\t" + CurrentDate() + "\n" +stockNum + "\t" + quantity);

    }

    private String CurrentDate()
    {
        DateFormat dateformat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Date currentDate = new Date();
        return dateformat.format(currentDate);
    }
    private void print(Object input, Boolean nxtLn)
    {
        if (nxtLn)
            System.out.println(input);
        else
            System.out.print(input);
    }

    private void fillArray() throws IOException {
        Employee a;
        Stock b;
        String elements [];
        String aLineFromFile;
        File aFile = new File("CS4125-Warehouse1617\\res\\employee.txt");
        if (!aFile.exists())
            aFile.createNewFile();
        Scanner in = new Scanner(aFile);
        while (in.hasNext()){
            aLineFromFile = in.nextLine();
            elements = aLineFromFile.split(",");
            a = new Employee(Integer.parseInt(elements[0]), elements[1], elements[2]);
            employee.add(a);
        }
        elements = null;
        aLineFromFile = "";


    }








    public static void main(String[] args)
    {
        WarehouseProject a = new WarehouseProject();
    }
}