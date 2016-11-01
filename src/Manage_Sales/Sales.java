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
    ArrayList<Stock> cart = new ArrayList<>();
    DataReader e = new DataReader();
    public int idNum;

    public Sales() throws IOException {
    }

    public void sale() throws IOException {
        idNum = e.idNum;
        Scanner in = new Scanner(System.in);
        String input, name = "";
        String[] temp;
        int num = 0, quan = 0, no = 0;
        float price = 0.00f;
        Boolean sale = false, find,q,n;
        while (!sale) {
            p.print("Please enter sale details(ProductCode Quantity):", true);
            input = in.nextLine();
            find = false;
            q = false;
            n = false;
            if (!input.equals("end")) {
                temp = input.split(" ");
                num = Integer.parseInt(temp[0]);
                quan = Integer.parseInt(temp[1]);
                for (int i = 0; i < e.stock.size() && !find; i++) {
                    if (e.stock.get(i).getStockNum() == num) {
                        n = true;
                        if (e.stock.get(i).getQuantity() >= quan) {
                            q = true;
                            find = true;
                            name = e.stock.get(i).getName();
                            price = e.stock.get(i).getPrice();
                            Stock s = new Stock(num, name, quan, price);
                            cart.add(s);
                            no = e.stock.get(i).getQuantity()- quan;
                            e.stock.get(i).setQuantity(no) ;
                        }
                    }
                }
                if (!q)
                    p.print("Error: not enough quantity", true);
                else if(!n)
                    p.print("Error:Product not valid", true);
            } else {
                sale = true;
                invoice();
            }
        }
    }

    public void invoice() throws IOException {
        p.print(cart.size(),true);
        String out = "";
        float total = 0.0f;
        File invoices = new File("res\\invoices.txt");
        out +=  "Product\tQuantity\tPrice\n";
        if (!invoices.exists())
            invoices.createNewFile();
        for(Stock x : cart) {
            out += x.getName() + "\t" + x.getQuantity() + "\t\t\t" + (x.getQuantity() * x.getPrice()) + "\n";
            total += (x.getQuantity() * x.getPrice());
        }
        p.printToFile(invoices, "" + idNum + "," + total + "," + currentDate() + "\n", true);
        String rec = "res\\Receipts\\" + "" + idNum;
        File receipt = new File(rec);
        receipt.createNewFile();
        p.print("Sale Invoice\t" + currentDate() + "\n" + out + "\nTotal:" + total, true);
        p.printToFile(receipt, "Sale Invoice\t" + currentDate() + "\n" + out + "\nTotal:" + total + "\n", true);
        e.update();
        menu menu = new menu();
    }

    public void cancel() {

    }

    private String currentDate() {
        DateFormat dateformat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Date currentDate = new Date();
        return dateformat.format(currentDate);
    }
}
