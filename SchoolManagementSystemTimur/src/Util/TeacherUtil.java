package Util;

import config.GlobalDatas;
import dinamicArrays.ClassRoomDynamicArray;
import dinamicArrays.StudentsDynamicArray;
import dinamicArrays.TeachersDynamicArray;
import employees.Teacher;
import schools.ClassRoom;
import service.TeacherServiceImpl;
import students.Student;

import java.util.Scanner;

public class TeacherUtil {
    public static String teacherMenuStr = "==========Teacher Menu==========\n" +
            "<1> See all Students\n" +
            "<2> See all Classes\n"+
            "<0> Log out\n";

    public static String updateTeacherMenuStr = "===========Teacher Update Menu============\n" +
            "<1> Update Name\n" +
            "<2> Update Surname\n" +
            "<3> Update Age\n" +
            "<4> Update Email\n" +
            "<5> Update Password\n" +
            "<6> Update Class Room\n" +
            "<7> Update Salary\n" +
            "<0> Cancel";;

    public static Teacher teacherLoginScreen( Scanner console)
    {
        if(GlobalDatas.teachersDynamicArray.getArray().length==0)
        {
            System.out.println("No Teacher has been Created Yet.");
            return null;
        }


        int attempts=3;
        boolean access = false;

        Teacher[] teachers = (Teacher[]) GlobalDatas.teachersDynamicArray.getArray();
        Teacher teacher = null;
        boolean isActive=true;
        while(isActive)
        {
            String username = Util.userNameReader(console);
            if(username.equalsIgnoreCase("000")){
                System.out.println("Returning to Main Menu...");
                break;
            }

            Teacher teach = (Teacher) Util.usernameChecker(teachers, username);
            while (attempts > 0&& teach!=null) {

                teacher = teach;
                String password = Util.passwordReader(console);
                if (password.equals(teach.getPassword())) {
                    isActive=false;
                    break;
                }



                attempts--;
                if (attempts == 0) {
                    teach.setBlocked(true);
                    System.out.println("Teacher with username \"" + username + "\" has been blocked");
                    break;
                }
                System.out.println("Attempts left: " + attempts);
            }
        }
        return teacher;
    }


    public static void teacherMenu(Scanner console)
    {   boolean approved = false;

        Teacher teacher = teacherLoginScreen(console);
        if(teacher!=null)
        {
            approved=true;

        }


        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        while(approved)
        {
            System.out.println(teacherMenuStr);
            String option = Util.requiredString("Please enter selection: ",console);

            switch (option)
            {
                case "0":
                    approved=false;
                    break;
                case "1":
                    teacherService.seeAllStudents(teacher);
                    break;
                case "2":
                    teacherService.seeAllClasses(teacher);
                    break;
                default:
                    System.out.println("Wrong operation inserted.Please try again");

            }
        }
    }//Teacher Menu Loop

    public static void updateTeacher(Scanner console)
    {
        boolean isActive= false;
        Teacher t = getTeacherById(console);

        if(t!=null)
            isActive=true;

        while(isActive)
        {
            System.out.println(updateTeacherMenuStr);
            String option = Util.requiredString("Choose operation: ",console);

            switch(option)
            {
                case "0":
                    isActive=false;
                    break;
                case "1":
                    System.out.println("Current Name: "+t.getName());
                    t.setName(Util.nameChecker(console));
                    break;
                case "2":
                    System.out.println("Current Surname: "+ t.getSurname());
                    t.setSurname(Util.surnameChecker(console));
                    break;
                case "3":
                    System.out.println("Current Age: "+t.getAge());
                    t.setAge(Util.ageChecker(console));
                    break;
                case "4":
                    System.out.println("Current Email: " + t.getEmail());
                    t.setEmail(Util.emailChecker(console));
                    break;
                case "5":
                    System.out.println("Current Password: "+t.getPassword());
                    t.setPassword(Util.passwordChecker(console));
                    break;
                case "6":
                    UpdateClassRoomDataForTeacher(t,console);
                    break;
                case "7":
                    System.out.println("Current Salary: " + t.getSalary());
                    t.setSalary(Double.parseDouble(Util.requiredString("New Salary: ",console)));
                    //Update SALARY HERE
                    break;

                default:
                    System.out.println("Wrong Operation Inputted.Try again");
            }

        }
    }

    public static String getClassRoomsOfTeacher(Teacher teacher)
    {
        boolean assigned = false;
        String result = "";
        ClassRoom[] crArray = GlobalDatas.classRoomsDynamicArray.getArray();
        for(ClassRoom cr: crArray)
        {
            if(teacher.equals(cr.getTeacher()))
            {
                assigned = true;
                String classInfo = cr.toString();
                result = "|" + classInfo+ "|";

            }
        }
        if(!assigned)
        {
            result = "Teacher has not been assigned to any classes.";
        }
        return result;
    }
    public static ClassRoom[] getCRArrayOfTeacher(Teacher teacher)
    {
        ClassRoomDynamicArray teachCRRooms = new ClassRoomDynamicArray();

        boolean assigned = false;
        ClassRoom[] rooms = GlobalDatas.classRoomsDynamicArray.getArray();

        for(ClassRoom cr: rooms)
        {
            if(teacher.equals(cr.getTeacher()))
            {
                assigned=true;
                teachCRRooms.add(cr);
            }



        }

        if(!assigned)
            System.out.println( "Student is not assigned to any class");

        return teachCRRooms.getArray();

    }//getting array of classRoom if Teacher is ASSIGNED TO CLASSES

    public static void removeTeacherFromClassRoom(Teacher teacher, Scanner console)
    {
        ClassRoom targetRoom = null;
        boolean isActive=true;
        while(isActive)
        {
            ClassRoom[] rooms = getCRArrayOfTeacher(teacher);

            ClassRoom room = ClassRoomUtil.selectCROfTeacher(rooms,console);

            if(room!=null)
            {   isActive=false;
                targetRoom = room;
                break;
            }
            String input = Util.requiredString("Cancel Operation? (Y/N): ",console);
            if(input.equalsIgnoreCase("Y"))
            {
                System.out.println("Cancelling Teacher Removal From Class");
                break;
            }

        }

        if(targetRoom!=null)
        {
            ClassRoom[] array = GlobalDatas.classRoomsDynamicArray.getArray();
            for(ClassRoom c: array)
            {
                if(targetRoom.equals(c))
                    c.setTeacher(null);
            }


        }

    }
    public static void UpdateClassRoomDataForTeacher(Teacher teacher, Scanner console)
    {

        boolean isActive= true;
        while(isActive) {
            System.out.println(getClassRoomsOfTeacher(teacher));
            System.out.println("=========Teacher Class Update Menu========\n" +
                    "<1> Assign to Class Room\n" +
                    "<2> Remove from Class Room\n" +
                    "<0> Cancel\n" +
                    "==========================\n");
            String option = Util.requiredString("Choose option: ", console);


            switch(option)
            {
                case "0":
                    isActive=false;
                    break;
                case "1":
                    ClassRoomUtil.set_ReplaceTeacherOfClassRoom(teacher,console);
                    break;
                case "2":
                    if(teacher.getIsAssigned()){
                        removeTeacherFromClassRoom(teacher,console);
                    }
                    else {
                        System.out.println("Teacher is not assigned to any class");
                    }

                        break;
                default:
                    System.out.println("Wrong operation.Try again");

            }

        }


    }
    public static void removeTeacherFromDatabase(Scanner console)
    {
        Teacher guilty = getTeacherById(console);
        if(guilty!=null) {
            String details = guilty.toString();
            System.out.println("Are you sure to want to delete Teacher: \n" +
                    details);
            String choice = Util.requiredString("Y/N?: ", console);
            if (choice.equalsIgnoreCase("Y")) {
                ClassRoom[] rooms = getCRArrayOfTeacher(guilty);
                for (ClassRoom cr : rooms) {
                    cr.removeTeacher();
                }
                GlobalDatas.teachersDynamicArray.remove(guilty);
            } else {
                System.out.println("Cancelling deletion of Teacher: \n" +
                        details);
            }

        }
    }

    public static Teacher getTeacherById(Scanner console) {
        Teacher[] array = GlobalDatas.teachersDynamicArray.getArray();
        boolean found= false;
        Teacher teacher=null;
        int id = Util.requiredInt("Please enter Teacher ID: ",console);
        for(Teacher t: array)
        {
            if(id==t.getId())
            {
                teacher = t;
                found=true;
                break;
            }

        }
        if(!found){
            System.out.println("Teacher has not been found.");
        }
        else
        {
            if(teacher!=null)
            System.out.println(teacher);
        }


        return teacher;
    } //returns teacher if found

    public static Teacher getTeacherOfClassRoom(ClassRoom classRoom)
    {
        return classRoom.getTeacher();
    }
}
