package Manage_Employee;

import Database_Manager.DataReader;
import objects.Employee;

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
        Employee e = new Employee(x, name, password, manager);
        reader.employee.add(e);
        reader.update();


    }
    public void deleteEmployee(String name, String password) throws IOException {
        DataReader reader = new DataReader();
        boolean checker  = true;
        for (int x = 0; x <= reader.employee.size() || checker == true; x ++ ){
            if (reader.employee.get(x).getName().equals(name) && reader.employee.get(x).getPassword().equals(password)){
                reader.employee.remove(x);
                checker = false;
                reader.update();
                continue;
            }
        }
        if(checker){
            /**
             *  display to the screen in a lMessage that that person wasn't there to delete and to try again
             */
        }


    }
}




       /* private ArrayList<Employee> employee = new ArrayList<>();
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

            print("Please enter the I.D. , Name and Password of the update employee info (101 John Password): ", false);
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
        }*/
