package Manage_Stock;

import Database_Manager.DataReader;
import objects.Stock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static Console.Print.print;

/**
 * Created by Jason.
 */
public class Stock_Manager implements Sinter
{
    private ArrayList<Stock> stock = new ArrayList<>();
    private DataReader dr;

    public Stock_Manager() throws IOException
    {
        dr = new DataReader();
        stock = dr.stock;
    }

    public void addStock() throws IOException
    {
        String input, temp[];
        int stockID = 0, quan = 0;
        boolean converted = false;
        Scanner in = new Scanner(System.in);

        print("Please enter the stock update (<Stock ID> <Quantity Added>): ", false);
        input = in.nextLine();
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
        dr.stock = stock;
        //dr.update();
    }

    public void checkStock() throws IOException
    {
        String input;
        int stockID = 0;
        boolean converted = false;

        Scanner in = new Scanner(System.in);

        print("View all stock(Y/N): ", false);
        input = in.nextLine().toLowerCase();
        if (input.contains("y"))
        {
            print("ID\tName\tPrice\tQuantity", true);
            for (Stock s : stock)
                print(s.getStockNum() + "\t" + s.getName() + "\t" + s.getPrice() +"\t" + s.getQuantity(), true);
        } else
        {
            print("Which stock item would you like to view: ", false);
            input = in.nextLine();
            try
            {
                stockID = Integer.parseInt(input);
                converted = true;
            } catch (NumberFormatException e) { e.printStackTrace(); }
            if (converted) for (Stock s : stock)
                if (s.getStockNum() == stockID) print("Name: " + s.getName() + ", Price: " + s.getPrice() + "Quantity:" + s.getQuantity(), true);
        }
    }
}
