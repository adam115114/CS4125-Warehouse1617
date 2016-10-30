package objects;


public class Employee {
    private int empno;
    private boolean check;
    private String name, password;

    public Employee(int inNum, String inName, String inPassword) {
        empno = inNum;
        name = inName;
        password = inPassword;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getEmpno() {
        return empno;
    }

    public void setName(String inName) {
        name = inName;
    }

    public void setPassword(String inPassword) {
        password = inPassword;
    }

    public void setEmpno(int inNum) {
        empno = inNum;
    }

    public boolean passwordCheck(String inPassword) {
        check = false;
        if (inPassword.equals(password))
            return !check;
        return check;
    }

    public boolean empnoCheck(int inNum) {
        check = false;
        if (inNum == empno)
            return !check;
        return check;
    }
}

