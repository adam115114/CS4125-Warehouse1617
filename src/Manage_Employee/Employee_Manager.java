package Manage_Employee;

import Database_Manager.DataReader;
import Manage_Employee.Einter;
import objects.Employee;
import java.io.IOException;
import java.util.ArrayList;
import static Console.Print.print;

/**
 * Created by Tadhg on 31/10/2016.
 */
public class Employee_Manager implements Einter
{
        private ArrayList<Employee> employee = new ArrayList<>();
        private DataReader reader;

        public Employee_Manager() throws IOException
        {
            reader = new DataReader();
            employee = reader.employee;
        }

        public void addEmployee() throws IOException
        {
            String input, tempArray[];
            int empno = 0;
            String empName = "",empPass = "";
            boolean converted = false;

            print("Please enter the I.D. , Name and Password of the new Employee (101 John Password): ", false);
            input = System.console().readLine();
            tempArray = input.split(" ");
            try
            {
                empno = Integer.parseInt(tempArray[0]);
                empName = (tempArray[1]);
                empPass = (tempArray[2]);
                converted = true;
            } catch (NumberFormatException e)
            {
                e.printStackTrace();
            }
            if (converted)
            {
                for (Employee e : employee)
                    if (e.getEmpno() == empno)
                    {
                        e.setName(empName);
                        e.setPassword(empPass);
                    }
            }
            reader.employee = employee;
            reader.update();
        }
        public void deleteEmployee() throws IOException
        {
            String input, tempArray[];
            int empno = 0;
            String empName = "",empPass = "";
            boolean converted = false;

            print("Please enter the I.D. , Name and Password of the Employee you want to delete (101 John Password): ", false);
            input = System.console().readLine();
            tempArray = input.split(" ");
            try
            {
                empno = Integer.parseInt(tempArray[0]);
                empName = (tempArray[1]);
                empPass = (tempArray[2]);
                converted = true;
            } catch (NumberFormatException e)
            {
                e.printStackTrace();
            }
            employee.remove(empno);
            employee.remove(empName);
            employee.remove(empPass);

            reader.employee = employee;
            reader.update();
        }
}
