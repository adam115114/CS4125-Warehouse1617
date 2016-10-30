package Console;


import java.io.IOException;
import java.util.Scanner;

/**
 * Created by adam on 30/10/2016.
 */

public class logIn  {
    private void login() throws IOException {
        String input;
        String pattern = "[0-9]+";
        int id = 0;
        boolean checker = true, stop = true;
        Scanner in = new Scanner(System.in);
        while(checker) {
            String outMessage = "Please enter your employee ID please: ";
            Print.print(outMessage, true);
            input = in.nextLine();
            if (!input.matches(pattern))
                Print.print("incorrect input or ID not recognised. Please try again", true);
            else {
                id = Integer.parseInt(input);
                for (int x = 0; x < employee.size() && stop; x++) {
                    if (id == employee.get(x).getEmpno())
                    {
                        Print.print("Enter your password", true);
                        input = in.nextLine();
                        if (input.matches(employee.get(x).getPassword()))
                        {
                            Print.print("Login was Successful", true);
                            stop = false;
                            checker = false;
                            menu a = new menu();
                        }
                        else
                            Print.print("Login was not successful please start again", true);
                    }
                    else if (x == employee.size())
                        Print.print("That ID was not found, Please try again", true);
                }
            }
        }
    }
}
