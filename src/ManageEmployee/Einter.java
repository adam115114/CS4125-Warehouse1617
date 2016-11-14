package ManageEmployee;

import java.io.IOException;

/**
 * Created by Tadhg on 31/10/2016.
 */
public interface Einter
{
    void addEmployee(String name, String passsword, boolean manager) throws IOException;
    void deleteEmployee(String name, String password) throws IOException;
}
