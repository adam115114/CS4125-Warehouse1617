/**
 * Created by David Sims on 17/10/2016.
 */

import objects.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.jar.Pack200;

public class WarehouseProject
{
    public ArrayList<Employee> employee = new ArrayList<>();
    public ArrayList<Stock> stock = new ArrayList<>();

    public WarehouseProject()
    {

    }

    public void addStock() throws IOException
    {
        String input, temp[];
        int stockID = 0, quan = 0;
        boolean converted = false;

        print("Please enter the stock update (<Stock ID> <Quantity Added>): ", false);
        input = System.console().readLine();
        temp = input.split(" ");
        try
        {
            stockID = Integer.parseInt(temp[0]);
            quan = Integer.parseInt(temp[1]);
            converted = true;
        } catch (NumberFormatException e)
        {
            e.printStackTrace();
        }
        if (converted)
        {
            // This is for-each loop, it iterates on the stock arraylist using a stock object("s" in this case) as a placeholder
            for (Stock s : stock)
                if (s.getStockNum() == stockID)
                {
                    s.setQuantity(s.getQuantity() + quan);
                }
        }
    }

    public void viewStock() throws IOException
    {
        String input, temp[];
        int stockID = 0;
        boolean converted = false;

        print("View all stock: ", false);
        input = System.console().readLine().toLowerCase();
        if (input.contains("y"))
        {
            print("Stock ID\tStock Name\tPrice", true);
            for (Stock s : stock)
                print(s.getStockNum() + "\t" + s.getName() + "\t" + s.getPrice(), true);
        } else
        {
            print("Which stock item would you like to view: ", false);
            input = System.console().readLine();
            try
            {
                stockID = Integer.parseInt(input);
                converted = true;
            } catch (NumberFormatException e)
            {
                e.printStackTrace();
            }
            if (converted) for (Stock s : stock)
                if (s.getStockNum() == stockID) print("Name: " + s.getName() + ", Price: " + s.getPrice(), true);
        }
    }

    public void doSale() throws IOException
    {
        String input;
        String[] temp;
        int num, quan;
        float price = 0.00f;
        String name = "";
        Boolean sale = false;
        System.out.print("Please enter sale details(ProductCode Quantity):");
        input = System.console().readLine();
        temp = input.split(" ");
        num = Integer.parseInt(temp[0]);
        quan = Integer.parseInt(temp[1]);

        for (int i = 0; i < stock.size(); i++)
            if (stock.get(i).getStockNum() == num && stock.get(i).getQuantity() >= quan)
            {
                price = stock.get(i).getPrice();
                name = stock.get(i).getName();
                sale = true;
            }
        if (sale)
        {
            invoice(num, name, quan, price);
        }
    }

    private void invoice(int stockNum, String name, int quantity, float price) throws IOException
    {
        File invoices = new File("CS4125-Warehouse1617\\res\\invoices.txt");
        if (!invoices.exists()) invoices.createNewFile();

        printToFile(invoices, "Sale Invoice\t" + currentDate() + "\n" + stockNum + "\t" + quantity);

    }

    private String currentDate()
    {
        DateFormat dateformat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Date currentDate = new Date();
        return dateformat.format(currentDate);
    }

    private void printToFile(File aFile, String output) throws IOException
    {
        FileWriter fw = new FileWriter(aFile);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(output);
    }

    private void print(Object input, Boolean nxtLn)
    {
        if (nxtLn) System.out.println(input);
        else System.out.print(input);
    }

    private void fillArray() throws IOException
    {
        Employee a;
        Stock b;
        String elements[];
        String aLineFromFile;
        File aFile = new File("CS4125-Warehouse1617\\res\\employee.txt");
        if (!aFile.exists()) aFile.createNewFile();
        Scanner in = new Scanner(aFile);
        while (in.hasNext())
        {
            aLineFromFile = in.nextLine();
            elements = aLineFromFile.split(",");
            a = new Employee(Integer.parseInt(elements[0]), elements[1], elements[2]);
            employee.add(a);
        }

        elements = null;
        aLineFromFile = "";
        aFile = new File("CS4125-Warehouse1617\\res\\Stock.txt");
        if (!aFile.exists()) aFile.createNewFile();
        in = new Scanner(aFile);
        while (in.hasNext())
        {
            aLineFromFile = in.nextLine();
            elements = aLineFromFile.split(",");
            b = new Stock(Integer.parseInt(elements[0]), elements[1], Integer.parseInt(elements[2]), Float.parseFloat(elements[3]));
            stock.add(b);
        }

    }

    public static void main(String[] args)
    {
        WarehouseProject a = new WarehouseProject();
    }
}