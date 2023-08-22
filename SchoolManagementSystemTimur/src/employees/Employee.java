package employees;

import config.Person;

public abstract class Employee extends Person {


    protected double salary ;
    protected String email;
    protected String username;
    protected String password;

    public Employee()
    {}
    public Employee(String name,String surname,int age,String mail,String username,String password,double salary)
    {
        super(name,surname,age,username,password);
        this.email=mail;
        this.salary=salary;
    }




    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
