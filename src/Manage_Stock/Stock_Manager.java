package Manage_Stock;

import Database_Manager.DataReader;
import objects.Stock;

import javax.swing.*;
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

    private boolean NF;

    public Stock_Manager()
    {
        try { dr = new DataReader(); }
        catch (IOException e) {JOptionPane.showMessageDialog(null, "An error has occurred in trying to read the files.");}
        stock = dr.stock;
        NF = true;
    }

    public String addStock(String iId, String quant)
    {
        for (Stock s: dr.stock)
        {
            try {
                if (s.getStockNum() == Integer.parseInt(iId))
                {
                    s.setQuantity(Integer.parseInt(quant) + s.getQuantity());
                    NF = false;
                    break;
                } else { NF = true; }
            } catch (NumberFormatException exc) {
                return "Failed to convert ItemID to int.";
            }
        }
        if (NF)
            return "Failed to find an Item with id: " + iId;
        else {
            return "Succeeded the quantity update.";
        }
    }

    public String remStock(String iId, String quant)
    {
        for (Stock s: dr.stock)
        {
            try {
                if (s.getStockNum() == Integer.parseInt(iId))
                {
                    s.setQuantity(s.getQuantity() - Integer.parseInt(quant));
                    NF = false;
                    break;
                }
            } catch (NumberFormatException exc) {
                return "Failed to convert to an Int.";
            }
        }
        if (NF)
            return "Failed to find an Item with id: " + iId;
        else
            return "Succeeded removing the quantity.";
    }

    public String getAllStock()
    {
        String str = "";
        for (Stock s : stock)
        {
            str += "ID: " + s.getStockNum() + ", Name: " + s.getName() + ", Quantity: " + s.getQuantity() + ", Price: " + s.getPrice() + "\n";
        }
        return str;
    }

    public String getStockItem(String iId)
    {
        if (iId.matches("[0-9]+")) {
            try {
                int inputNum = Integer.parseInt(iId);
                for (Stock s : dr.stock) {
                    if (s.getStockNum() == inputNum) {
                        return "Name: " + s.getName() + ", Quantity: " + s.getQuantity() + ", Price: " + s.getPrice() + "\n";
                    }
                }
            } catch (NumberFormatException exc) {
                return "ERROR";
            }
        }
        return "ERROR";
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
