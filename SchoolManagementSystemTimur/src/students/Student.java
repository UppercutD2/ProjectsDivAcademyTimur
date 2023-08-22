package students;


import config.Person;


import static Util.StudentUtil.*;

public class Student  extends Person {

    private static int id ;
    private int uniqueId;

    private String email;
    private String username;
    private String password;
    private boolean isBlocked;

    private boolean isAssigned;

    public Student()
    {

    }
    public Student(String name,String surname,int age,String username,String password,String mail,int id){
        super(name,surname,age,username,password);
        this.email=mail;
        this.uniqueId=id;

    }

    public int generateId() {
        id++;
        uniqueId=id;
        return uniqueId;
    }
    public int getId()
    {
        return uniqueId;
    }

    public boolean getIsAssigned() {
        return isAssigned;
    }

    public void setIsAssigned(boolean assigned) {
        this.isAssigned = assigned;
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

    public void generateUsername() {
        String username = ""+(int)(Math.random()*50)
                        + this.name.charAt(0)
                        + this.surname.charAt(0)
                         + (int)(Math.random()*333);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }



    @Override
    public String toString() {
        return "==Student Details==\n"+
                "id=" + this.uniqueId +
                "\nname='" + this.name + '\n' +
                "surname'" + this.surname + '\n' +
                "age='" + this.age +"\n" +
                "email='" + this.email + '\n' +
                "username='" + this.username + '\n' +
                "Classes: "+ getClassesOfStudent(this)+
                "\n===================";
    }

    public String toTeacherString()
    {
        return "==Student Details==\n"+
                "id=" + this.uniqueId +
                "\nname='" + this.name + '\n' +
                "surname'" + this.surname + '\n' +
                "age='" + this.age +"\n" +
                "email='" + this.email + '\n' +
                "username='" + this.username + '\n' +
                "Classes: "+ getClassesOfStudent(this)+
                "\n===================";
    }
    public String toAdminString()
    {
        return "==Student Details==\n"+
                "id=" + this.uniqueId +
                "\nname='" + this.name + '\n' +
                "surname'" + this.surname + '\n' +
                "age='" + this.age +"\n" +
                "email='" + this.email + '\n' +
                "username='" + this.username + '\n' +
                "password='" + this.password + '\n' +
                "Classes: "+ getClassesOfStudent(this)+
                "\n===================";
    }

}
