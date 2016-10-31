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

    public DataReader() throws IOException {
        read();
    }

    public void read() throws IOException
    {
        employee.clear();
        stock.clear();
        Employee a;
        Stock b;
        String elements[];
        String aLineFromFile;
        File aFile = new File("res\\employee.txt");
        if (!aFile.exists()) aFile.createNewFile();
        Scanner in = new Scanner(aFile);
        System.out.println("read");
        while (in.hasNext()) {
            aLineFromFile = in.nextLine();
            elements = aLineFromFile.split(",");
            a = new Employee(Integer.parseInt(elements[0]), elements[1], elements[2]);
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
    }

    public void update() throws IOException /* where the text file will be updated when the arraylists are edited*/{
        Print p = new Print();
        File stockf = new File("res\\Stock.txt");
        System.out.println(stock.size());
        for (Stock s : stock) {
            p.print("update1", true);
            p.printToFile(stockf, "" + s.getStockNum() + "," + s.getName() + "," + s.getQuantity() + "," + s.getPrice(), false);
        }
/*
        try
        {
            File empf = new File("res\\employee.text");
            for (Employee e : employee)
                p.printToFile(empf, e.getEmpno() + "," + e.getName() + "," + e.getPassword());
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "employee.txt could not be found.", "An Error has occurred.", JOptionPane.ERROR_MESSAGE);
        }*/
    }

}
