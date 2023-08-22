package employees;

import Util.ClassRoomUtil;
import Util.TeacherUtil;

public class Teacher  extends Employee{
    private boolean isBlocked;
    private static int id;
    private int uniqueId;
    private boolean isAssigned;


    public Teacher()
    {

    }
    public Teacher(String name,String surname,int age, String mail,String password,String username,Double salary,int id)
    {
        super(name,surname,age,mail,username,password,salary);
        this.uniqueId=id;
    }

    public int generateId() {
        id++;
        uniqueId=id;
        return uniqueId;
    }
    public int getId()
    {
        return uniqueId ;
    }
    public void generateUsername() {
        String username = ""+((int)(Math.random()*50)+50)
                + this.name.charAt(0)
                + this.surname.charAt(0)
                + (int)(Math.random()*333);
        this.username = username;
    }

    public boolean getIsAssigned() {
        return isAssigned;
    }

    public void setIsAssigned(boolean assigned) {
        this.isAssigned = assigned;
    }

    public boolean isBlocked() {
        return isBlocked;
    }


    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
    @Override
    public String toString() {
        return "==Teacher Details==\n"+
                "id=" + this.uniqueId +
                "\nname='" + this.name + '\n' +
                "surname'" + this.surname + '\n' +
                "age='" + this.age +"\n" +
                "email='" + this.email + '\n' +
                "username='" + this.username + '\n' +
                "Assigned classes :\n " + TeacherUtil.getClassRoomsOfTeacher(this)+
                "\n===================";
    }
    public String toAdminString()
    {
        return "==Teacher Details==\n"+
                "id=" + this.uniqueId +
                "\nname='" + this.name + '\n' +
                "surname'" + this.surname + '\n' +
                "age='" + this.age +"\n" +
                "email='" + this.email + '\n' +
                "username='" + this.username + '\n' +
                "password='" + this.password + '\n' +
                "Assigned classes :\n " + TeacherUtil.getClassRoomsOfTeacher(this)+
                "===================";
    }

}
