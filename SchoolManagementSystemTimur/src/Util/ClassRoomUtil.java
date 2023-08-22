package Util;

import config.GlobalDatas;
import employees.Teacher;
import jdk.swing.interop.SwingInterOpUtils;
import schools.ClassRoom;
import students.Student;

import java.util.Scanner;

public class ClassRoomUtil {




    public static void createClassRoom(Scanner console)
    {
        String className = Util.requiredString("Please Enter name of the class: ", console);
        ClassRoom classRoom = new ClassRoom(className);
        GlobalDatas.classRoomsDynamicArray.add(classRoom);
        System.out.println("Class Room with name "+ className + " has been created.");

    }

    public static ClassRoom selectClassRoom(Scanner console){
        ClassRoom classRoom=null;
        if(GlobalDatas.classRoomsDynamicArray.getArray().length==0)
        {
            System.out.println("No Class Rooms has been Created YET.");
        }
        else
        {
            int ClassNumber = printClassRooms(console);
            classRoom = GlobalDatas.classRoomsDynamicArray.get(ClassNumber);

        }
        return classRoom;
    }
    public static ClassRoom selectClassRoomOfStudent(ClassRoom[] array,Scanner console)
    {   ClassRoom cRoom = null;
        int index = 1;
        for (ClassRoom cr:array)
        {   String info = index +cr.toString();
            System.out.println(info);
            index++;
        }

        int option = Util.requiredInt("Select Class by Number: ",console);

        if(option<1 ||option>array.length) {
            System.out.println("Wrong number of Class inputted");
        }
        else
        {
            cRoom = array[option-1];
        }

        return cRoom;
    }//Supportig Method for REMOVAL sTUDENT fROM ASSIGNED cLASSES

    public static ClassRoom selectCROfTeacher(ClassRoom[] array, Scanner console)
    {
        ClassRoom cRoom = null;
        int index = 1;
        for (ClassRoom cr:array)
        {   String info = index +cr.toString();
            System.out.println(info);
            index++;
        }

        int option = Util.requiredInt("Select Class by Number: ",console);

        if(option<1 ||option>array.length) {
            System.out.println("Wrong number of Class inputted");
        }
        else
        {
            cRoom = array[option-1];
        }

        return cRoom;

    }

    public static int printClassRooms(Scanner console)
    {
        ClassRoom[] classes = GlobalDatas.classRoomsDynamicArray.getArray();
       boolean isActive = true;
       int classNumber = 0;
       while(isActive)
       {
           int index = 0;
           for(ClassRoom c : classes)
           {       ++index;
               System.out.println(index + " :  " +c);
           }

           int option = Util.requiredInt("Choose Class Room Number: ",console);

           if(option<1||option>classes.length)
           {
               System.out.println("Wrong Class Room index.Try again");
               continue;
           }else{
               classNumber= option;
               isActive=false;
           }

       }
        return classNumber;
    }

    public static void addStudentToClassRoom(Student student, Scanner console)
    {
        boolean found=false;
        ClassRoom room = selectClassRoom(console);
        Student[] students = room.getStdDynArray().getArray();
        for(Student s:students)
        {
            if(s.equals(student))
            {
                found=true;
            }
        }


            if(found) {
                System.out.println("The student is already in class");
            }
        else
            {
                room.addStudent(student);
                System.out.println("Student has been added to : " + room);
            }
    }

    public static void removeClassRoomFromDatabase(Scanner console)
    {
        ClassRoom guiltyRoom = selectClassRoom(console);
        if(guiltyRoom!=null) {
            String details = guiltyRoom.toString();
            System.out.println("Are you sure to want to delete Class Room: \n" +
                    details);
            String choice = Util.requiredString("Y/N?: ", console);
            if (choice.equalsIgnoreCase("Y")) {
                GlobalDatas.classRoomsDynamicArray.remove(guiltyRoom);
            } else {
                System.out.println("Cancelling deletion of Class Room");
            }
        }
    }

    public static void removeStudentFromClassRoom(Student student, Scanner console)
    {
        ClassRoom targetRoom = null;
        boolean isActive=true;
        while(isActive)
        {
            ClassRoom[] rooms = StudentUtil.getCRArrayOfStudent(student);
            if(rooms!=null&&rooms.length>0) {
                ClassRoom room = selectClassRoomOfStudent(rooms, console);

                if (room != null) {
                    isActive = false;
                    targetRoom = room;
                    break;
                }
                String input = Util.requiredString("Cancel Operation? (Y/N): ", console);
                if (input.equalsIgnoreCase("Y")) {
                    System.out.println("Cancelling Student Removal From Class");
                    break;
                }
            }
            else{
                isActive=false;
                System.out.println("Student is not assigned to any classes");
            }
        }

        if(targetRoom!=null)
        {
            ClassRoom[] array = GlobalDatas.classRoomsDynamicArray.getArray();
            for(ClassRoom c: array)
            {
                if(targetRoom.equals(c))
                    c.removeStudent(student);
            }


        }

    }
    public static void setTeacherToClassRoom(Teacher teacher, Scanner console)
    {
        ClassRoom room = selectClassRoom(console);
        room.setTeacher(teacher);
    }

    public static void set_ReplaceTeacherOfClassRoom(Teacher teacher,Scanner console)
    {
        ClassRoom room = selectClassRoom(console);
        Teacher t = TeacherUtil.getTeacherOfClassRoom(room);
        if(t==null)
        {
            room.setTeacher(teacher);
            teacher.setIsAssigned(true);
            System.out.println("Teacher : " + teacher.getUsername() + ", is now assigned to Class : "+room.getClassID());
        }
        else
        {
            boolean isActive = true;

            while(isActive)
            {
                System.out.println("Current Teacher is : " + t);

                String option = Util.requiredString("****************\n" +
                        "Would you like to Replace Him? (Y/N)",console);

                switch(option.toUpperCase())
                {
                    case "Y":
                        room.getTeacher().setIsAssigned(false);
                        room.setTeacher(teacher);
                        teacher.setIsAssigned(true);
                        isActive=false;
                        break;
                    case "N":
                        isActive=false;
                        break;
                    default:
                        System.out.println("Wrong input.Try again.");


                }
            }

        }
    }
}
