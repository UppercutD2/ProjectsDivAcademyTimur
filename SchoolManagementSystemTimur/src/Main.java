import config.GlobalDatas;
import employees.Teacher;
import schools.ClassRoom;
import students.Student;

import java.util.Scanner;


public class Main {





    public static void main(String[] args) {

        Teacher Timur = new Teacher();
        Timur.generateId();
        Timur.setName("Timur");
        Timur.setSurname("Balmaqambetov");
        Timur.setAge(30);
        Timur.setEmail("Timur@mail.com");
        Timur.setPassword("Timur12345");
        Timur.setSalary(90000.0);
        Timur.setUsername("TT");

        Teacher Elcan = new Teacher();
        Elcan.generateId();
        Elcan.setName("Elcan");
        Elcan.setSurname("Elcan");
        Elcan.setAge(30);
        Elcan.setEmail("Elcan@mail.com");
        Elcan.setPassword("Elcan12345");
        Elcan.setSalary(80000.0);
        Elcan.setUsername("EE");

        Student Superman = new Student();
        Superman.generateId();
        Superman.setName("Superman");
        Superman.setSurname("Superman");
        Superman.setAge(30);
        Superman.setEmail("Superman@mail.com");
        Superman.setPassword("Superman12345");
        Superman.setUsername("SS");

        Student Batman = new Student();
        Batman.generateId();
        Batman.setName("Batman");
        Batman.setSurname("Batman");
        Batman.setAge(30);
        Batman.setEmail("Batman@mail.com");
        Batman.setPassword("Batman12345");
        Batman.setUsername("BB");

        GlobalDatas.teachersDynamicArray.add(Timur);
        GlobalDatas.teachersDynamicArray.add(Elcan);
        GlobalDatas.studentsDynamicArray.add(Superman);
        GlobalDatas.studentsDynamicArray.add(Batman);

        ClassRoom Java = new ClassRoom("JAVA");
        ClassRoom JavaScript= new ClassRoom("JavaScript");
        GlobalDatas.classRoomsDynamicArray.add(Java);
        GlobalDatas.classRoomsDynamicArray.add(JavaScript);





        Scanner console = new Scanner(System.in) ;
        Realization.run(console);
    }
}

