package Util;

import config.GlobalDatas;
import config.GlobalDatas.*;

import dinamicArrays.ClassRoomDynamicArray;
import schools.ClassRoom;
import students.Student;

import java.util.Scanner;

public class StudentUtil {

    public static String  studentMenuStr = "==========Student Menu==========\n" +
            "<1> See Details\n" +
            "<0> Log Out!\n";

    public static String updateStudentMenuStr = "==========Student Update menu===========\n" +
            "<1> Update Name\n" +
            "<2> Update Surname\n" +
            "<3> Update Age\n" +
            "<4> Update Email\n" +
            "<5> Update Password\n" +
            "<6> Update Class Room\n" +
            "<0> Cancel";



    public static Student studentLoginScreen( Scanner console)
    {
        int attempts=3;

        if(GlobalDatas.studentsDynamicArray.getArray().length==0)
            return null;

        Student[] students =  GlobalDatas.studentsDynamicArray.getArray();
        Student student=null;
        boolean isActive= true;
        while(isActive) {

            String username = Util.userNameReader(console);
            if(username.equalsIgnoreCase("333")){//exit door from login screen
                System.out.println("Returning to Main Menu...");
                break;
            }

            Student stud = (Student) Util.usernameChecker(students, username);
            while (attempts > 0&& stud!=null) {

                student = stud;
                String password = Util.passwordReader(console);
                if (password.equals(stud.getPassword())) {

                    isActive=false;
                    break;
                }



                attempts--;
                if (attempts == 0) {
                    stud.setBlocked(true);
                    System.out.println("Student with username \"" + username + "\" has been blocked");
                    break;
                }
                System.out.println("Attempts left: " + attempts);
            }
        }
        return student;
    }//returns student or null if not found, used for login algorithm in StudentMenu

    public static void studentMenu(Scanner console)
    {   boolean approved = false;
        Student student = studentLoginScreen(console);
        if(student!=null)
            approved = true;


        while(approved)
        {
            System.out.println(studentMenuStr);
            String option = Util.requiredString("Please enter selection: ",console);

            switch (option)
            {
                case "0":
                    approved=false;
                    break;
                case "1":
                    System.out.println(student);
                    break;
                default:
                    System.out.println("Wrong operation inserted.Please try again");

            }
        }

        if(!approved){
            System.out.println("No students created yet.");
        }

    }//Student Menu Loop

    public static void removeStudentFromDatabase(Scanner console)
    {
        Student guilty = getStudentById(console);
        if(guilty!=null) {
            String details = guilty.toTeacherString();
            System.out.println("Are you sure to want to delete Student: \n" +
                    details);
            String choice = Util.requiredString("Y/N?: ", console);
            if (choice.equalsIgnoreCase("Y")) {
                ClassRoom[] rooms = getCRArrayOfStudent(guilty);
                for (ClassRoom cr : rooms) {
                    cr.removeStudent(guilty);
                }
                GlobalDatas.studentsDynamicArray.remove(guilty);
            } else {
                System.out.println("Cancelling deletion of Student: \n" +
                        details);
            }

        }

    }


    public static String getClassesOfStudent(Student student)
    {   boolean assigned = false;
        ClassRoom[] rooms = GlobalDatas.classRoomsDynamicArray.getArray();
        String result="";
        for(ClassRoom cr: rooms) {
            Student[] stdArray = cr.getStdDynArray().getArray();

                if (stdArray.length != 0) {
                    for (Student s : stdArray) {
                        if (s.equals(student)) {
                            assigned=true;
                            result = "|" + cr + "|";
                        }
                    }
                }

        }
        if(!assigned)
            result =  "Student is not assigned to any class";
        return result;
    }

    public static ClassRoom[] getCRArrayOfStudent(Student student)
    {   ClassRoomDynamicArray stdCRRooms = new ClassRoomDynamicArray();

        boolean assigned = false;
        ClassRoom[] rooms = GlobalDatas.classRoomsDynamicArray.getArray();

        for(ClassRoom cr: rooms)
        {
            Student[] stdArray = cr.getStdDynArray().getArray();
            if(stdArray.length!=0)
            {
                for(Student s: stdArray)
                {
                    if(s.equals(student))
                    {
                        stdCRRooms.add(cr);
                    }
                }
            }



        }


        return stdCRRooms.getArray();
    }//gets Array of ClassRoom which Student is Assgined
    public static void updateStudent(Scanner console)
    {boolean isActive= false;
        Student s = getStudentById(console);
        if(s!=null)
        isActive=true;

        while(isActive)
        {

            System.out.println(updateStudentMenuStr);
            String option = Util.requiredString("Choose operation: ",console);

            switch(option)
            {
                case "0":
                    isActive=false;
                    break;
                case "1":
                    System.out.println("Current Name: "+s.getName());
                    s.setName(Util.nameChecker(console));
                    break;
                case "2":
                    System.out.println("Current Surname: "+ s.getSurname());
                    s.setSurname(Util.surnameChecker(console));
                    break;
                case "3":
                    System.out.println("Current Age: "+s.getAge());
                    s.setAge(Util.ageChecker(console));
                    break;
                case "4":
                    System.out.println("Current Email: " + s.getEmail());
                    s.setEmail(Util.emailChecker(console));
                    break;
                case "5":
                    System.out.println("Current Password: "+s.getPassword());
                    s.setPassword(Util.passwordChecker(console));
                    break;
                case "6":
                    updateClassRoomDataForStudent(s,console);
                    break;
                default:
                    System.out.println("Wrong Operation Inputted.Try again");
            }

        }


    }//Update Student data except Username and ID. they are unique.Or i just don't want to go so deep into it at the moment :-)
    public static Student getStudentById(Scanner console) {
        Student[] array = GlobalDatas.studentsDynamicArray.getArray();
        boolean found= false;
        Student student=null;
        int id = Util.requiredInt("Please enter Students ID: ",console);
        for(Student s: array)
        {
            if(id==s.getId())
            {
                student = s;
                found=true;
                break;
            }

        }
        if(!found){
            System.out.println("Student has not been found.");
        }
        else
        {
            System.out.println(student);
        }


        return student;
    }

    public static void updateClassRoomDataForStudent(Student student,Scanner console)
    {

        boolean isActive= true;
        while(isActive)
        {

            System.out.println("=========Student Class Update Menu========\n" +
                    "<1> Add to Class Room\n" +
                    "<2> Remove from Class Room\n" +
                    "<0> Cancel\n" +
                    "==========================\n");
            String option = Util.requiredString("Choose option: ",console);


            switch(option)
            {
                case "0":
                    isActive=false;
                    break;
                case "1":
                    ClassRoomUtil.addStudentToClassRoom(student,console);
                    break;
                case "2":
                    ClassRoomUtil.removeStudentFromClassRoom(student,console);
                    //print all classes which he assigned to//
                   // select the class to remove him from it
                    break;
                default:
                    System.out.println("Wrong operation. Try again.");
            }
        }

    }

}
