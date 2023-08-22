package employees;

public class Admin extends  Employee{

    private static  int id;
    public int generateId() {
        id++;
        this.id=id;
        return id;
    }
    public int getId()
    {
        return this.id;
    }
    public void generateUsername() {
        String username =""+ ((int)(Math.random()*50)+100)
                + this.name.charAt(0)
                + this.surname.charAt(0)
                + (int)(Math.random()*333);
        this.username = username;
    }
    @Override
    public String toString() {
        return "==Admin Details==\n"+
                "id=" + this.id +
                "\nname='" + this.name + '\n' +
                "surname'" + this.surname + '\n' +
                "age='" + this.age +"\n" +
                "email='" + this.email + '\n' +
                "username='" + this.username + '\n' +
                "password='" + this.password + '\n' +
                "===================";
    }
}
