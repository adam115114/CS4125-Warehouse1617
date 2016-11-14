package ManageSales;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DatabaseManager.*;
import UserInterface.*;
import Objects.Stock;

public class Sales implements Sinter {
    Print p = new Print();
    ArrayList<Stock> cart = new ArrayList<>();
    DataReader e = new DataReader();
    public int idNum;
    public float total = 0.0f;
    public String shop, error;

    public Sales() throws IOException {
        cart.clear();
    }

    public boolean addToCart(int num, int quan) throws IOException {
        DataReader e = new DataReader();
        idNum = e.employee.get(LoginPage.number).getEmpno();
        boolean n = false;
        boolean q = false;
        String name;
        int y;
        float price;
        for (int i = 0; i < e.stock.size() && !n && !q; i++) {
            if (e.stock.get(i).getStockNum() == num) {
                n = true;
                if (e.stock.get(i).getStockNum() == num && quan <= e.stock.get(i).getQuantity()) {
                    q = true;
                    name = e.stock.get(i).getName();
                    price = e.stock.get(i).getPrice();
                    Stock s = new Stock(num, name, quan, price);
                    cart.add(s);
                }
            }
        }
        if(n && q)
            return true;
        else if(!n) {
            error = "Error:Product not valid";
            return false;
        }
        else if (!q) {
            error = "Error: not enough quantity";
            return false;
        }
        return false;
    }

    public void invoice() throws IOException {
        idNum = e.employee.get(LoginPage.number).getEmpno();
        String out = "";
        File invoices = new File("res\\invoices.txt");
        out +=  "Product\tQuantity\tPrice\n";
        if (!invoices.exists())
            invoices.createNewFile();
        for(Stock x : cart) {
            out += x.getName() + "\t" + x.getQuantity() + "\t\t\t" + (x.getQuantity() * x.getPrice()) + "\n";
        }
        totals();
        p.printToFile(invoices, "" + idNum + "," + total + "," + currentDate() + "\n", true);
        String rec = "res\\Receipts\\" + "" + idNum;
        File receipt = new File(rec);
        receipt.createNewFile();
        p.print("Sale Invoice\t" + currentDate() + "\n" + out + "\nTotal:" + total, true);
        p.printToFile(receipt, "Sale Invoice\t" + currentDate() + "\n" + out + "\nTotal:" + total + "\n", true);
        e.update();
        menu menu = new menu();
    }
    public void updates(){
        int no;
        for(int j = 0; j < cart.size(); j++)
        {
            for (int i = 0; i < cart.size(); i++) {
                if (e.stock.get(i).getStockNum() == cart.get(j).getStockNum()) {
                        no = e.stock.get(i).getQuantity() - cart.get(j).getQuantity();
                        e.stock.get(i).setQuantity(no);
                }
            }
        }
    }
    public void remove(int id,int q){
        int no;
            for (int i = 0; i < cart.size(); i++) {
                if (cart.get(i).getStockNum() == id) {
                    no = cart.get(i).getQuantity() - q;
                    cart.get(i).setQuantity(no);
                }
        }
    }

    public String currentDate() {
        DateFormat dateformat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Date currentDate = new Date();
        return dateformat.format(currentDate);
    }
    public void totals()
    {
        total = 0.0f;
        for(Stock x : cart) {
            total += (x.getQuantity() * x.getPrice());
        }
    }
    public void list()
    {
        shop = "";
        shop = "Number\tProduct\tQuantity\tPrice\n";
        for(Stock x : cart) {
            shop += (x.getStockNum() + "\t" + x.getName() + "\t" + x.getQuantity() + "\t" + x.getPrice() + "\n");
        }
    }
    public boolean inCart(int num)
    {
        boolean t = false;
        for(Stock x : cart) {
            if (num == x.getStockNum())
                return true;
        }
        return false;
    }
    public void addCart(int id, int q)
    {
        int no;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getStockNum() == id) {
                no = cart.get(i).getQuantity() + q;
                cart.get(i).setQuantity(no);
            }
        }
    }
}