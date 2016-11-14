package ManageEmployee;

import DatabaseManager.DataReader;
import Objects.Employee;
import javax.swing.*;
import java.io.IOException;


/**
 * Created by Tadhg on 31/10/2016.
 */
public class Employee_Manager implements Einter
{
    public  Employee_Manager(boolean option, String name, String password, boolean manager) throws IOException {
        if(option){
            addEmployee(name, password, manager);
        }else{
            deleteEmployee(name, password);
        }
    }
    public void addEmployee(String name, String password, boolean manager) throws IOException {
        DataReader reader = new DataReader();
        int x = reader.employee.get(reader.employee.size() - 1).getEmpno();
        x++;
        Employee e = new Employee(x, name, password, manager);
        reader.employee.add(e);
        reader.update();
        JOptionPane.showMessageDialog(null, "New employee created. \n" +
                                            "info:\n" +
                                            "Name:                " + name +
                                            "\nPassword:       " + password +
                                            "\nManager:          " + manager +
                                            "\nEmployee No.:   " + x);


    }
    public void deleteEmployee(String name, String password) throws IOException {
        DataReader reader = new DataReader();
        boolean checker  = true;
        System.out.println(reader.employee.size());
        for (int x = 0; x < reader.employee.size() && checker == true; x ++ ){
            if (reader.employee.get(x).getName().equals(name) && reader.employee.get(x).getPassword().equals(password)){
                reader.employee.remove(x);
                checker = false;
                reader.update();
                continue;
            }
        }
        if(checker){
            JOptionPane.showMessageDialog(null, "The employee with those details doesn't exists.\nPlease try again.");
        }
    }
}

