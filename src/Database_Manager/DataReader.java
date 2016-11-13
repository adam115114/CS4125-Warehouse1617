package Database_Manager;

import Console.Print;
import objects.Employee;
import objects.Stock;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Exchanger;

public class DataReader implements Dinter{

    public ArrayList<Employee> employee = new ArrayList<>();
    public ArrayList<Stock> stock = new ArrayList<>();
    public ArrayList<String> invoice = new ArrayList<>();

    public DataReader() throws IOException {
        read();
    }

    public void read() throws IOException
    {
        employee.clear();
        stock.clear();
        invoice.clear();
        Employee a;
        Stock b;
        String elements[];
        String aLineFromFile;
        File aFile = new File("res\\employee.txt");
        if (!aFile.exists()) aFile.createNewFile();
        Scanner in = new Scanner(aFile);
        while (in.hasNext()) {
            aLineFromFile = in.nextLine();
            elements = aLineFromFile.split(",");
            a = new Employee(Integer.parseInt(elements[0]), elements[1], elements[2], Boolean.parseBoolean(elements[3]));
            employee.add(a);
        }

        elements = null;
        aLineFromFile = "";
        aFile = new File("res\\Stock.txt");
        if (!aFile.exists()) aFile.createNewFile();
        in = new Scanner(aFile);
        while (in.hasNext()) {
            aLineFromFile = in.nextLine();
            elements = aLineFromFile.split(",");
            b = new Stock(Integer.parseInt(elements[0]), elements[1], Integer.parseInt(elements[2]), Float.parseFloat(elements[3]));
            stock.add(b);
        }
        elements = null;
        aLineFromFile = "";
        aFile = new File("res\\invoices.txt");
        if (!aFile.exists())
            aFile.createNewFile();
        in = new Scanner(aFile);
        while (in.hasNext()){
            aLineFromFile = in.nextLine();
            elements = aLineFromFile.split(",");
            invoice.add(elements[0]); // starting at [0]every second line will have a code for the employee that made the transaction. int format
            invoice.add(elements[1]); // starting at [1]every second will have the amount the transaction was worth. Float format
        }
    }

    public void update() throws IOException /* where the text file will be updated when the arraylists are edited*/{
        boolean x  = true;
        String a = "";
        Print p = new Print();
        File stockf = new File("res\\Stock.txt");
        p.printToFile(stockf, "", false);
        for (Stock s : stock) {
            p.printToFile(stockf, "" + a + s.getStockNum() + "," + s.getName() + "," + s.getQuantity() + "," + s.getPrice() , true);
            if (x) {
                x=false;
                a="\n";
            }
        }
        x=true;
        a = "";
        File empf = new File("res\\employee.txt");
        p.printToFile(empf, "", false);
        for (Employee e : employee) {
            p.printToFile(empf,"" + a + e.getEmpno() + "," + e.getName() + "," + e.getPassword() + "," + e.isCheck(), true);
            if(x) {
                x =false;
                a="\n";
            }
        }
    }
}
