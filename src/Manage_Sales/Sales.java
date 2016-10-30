package Manage_Sales;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Database_Manager.*;
import Console.*;
import objects.Stock;

public class Sales implements Sinter {
    Print p = new Print();
    public ArrayList<Stock> cart = new ArrayList<>();

    public void sale() throws IOException {
        ArrayList<Stock> cart = new ArrayList<>();
        DataReader e = new DataReader();
        Scanner in = new Scanner(System.in);
        String input, name = "";
        String[] temp;
        int num = 0, quan = 0;
        float price = 0.00f;
        Boolean sale = false, find = false;
        while (!sale) {
            p.print("Please enter sale details(ProductCode Quantity):", true);
            input = in.nextLine();
            if (input == "end") {
                temp = input.split(" ");
                num = Integer.parseInt(temp[0]);
                quan = Integer.parseInt(temp[1]);
                for (int i = 0; i < e.stock.size() && find; i++) {
                    if (e.stock.get(i).getStockNum() == num) {
                        if (e.stock.get(i).getQuantity() >= quan) {
                            find = true;
                            p.print("x", true);
                            name = e.stock.get(i).getName();
                            price = e.stock.get(i).getPrice();
                            Stock s = new Stock(num, name, quan, price);
                            cart.add(s);
                        } else
                            p.print("Error: not enough quantity. Only" + e.stock.get(i).getQuantity(), true);
                    } else
                        p.print("Error:Product not valid", true);
                }
            } else {
                sale = true;
                invoice();
            }
        }
    }

    public void buy() {

    }

    public void invoice() {

    public void invoice() throws IOException {
        String out = "";
        float total = 0;
        File invoices = new File("res\\invoices.txt");
        if (!invoices.exists())
            invoices.createNewFile();
        for(Stock s : cart) {
            out += s.getName() + "\t" + s.getQuantity() + (s.getQuantity() * s.getPrice());
            total += (s.getQuantity() * s.getPrice());
        }
        p.printToFile(invoices, /*userID +*/"," + total + "," + currentDate() + "\n");
        String rec = "res\\Receipts\\" + "zxcv" ;
        File receipt = new File("rec");
        receipt.createNewFile();
        p.printToFile(receipt, "Sale Invoice\t" + currentDate() + "\n" + out + "\n" + total);
    }

    public void cancel() {

    private String currentDate() {
        DateFormat dateformat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Date currentDate = new Date();
        return dateformat.format(currentDate);
    }

    public static void main(String args[]) {
        Sales s = new Sales();
    public void cancel() {

    }
}
