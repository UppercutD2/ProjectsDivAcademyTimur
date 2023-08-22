package Util;

import config.GlobalDatas;

import employees.Admin;
import schools.ClassRoom;
import service.AdminServiceImpl;


import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class AdminUtil {
    public static String adminMenu = "==========Admin Menu==========\n" +

            "<1> Show menu\n" +
            "<2> Search menu\n" +
            "<3> Add menu \n" +
            "<4> Update menu\n" +
            "<5> Remove Menu\n" +
            "<0> Log out!\n";
    public static Admin adminLoginScreen( Scanner console)
    {   int attempts=3;
        boolean access = false;

        Admin[] admins = GlobalDatas.adminsDynamicArray.getArray();
        Admin admin = null;
        boolean isActive=true;
        while(isActive)
        {
            String username = Util.userNameReader(console);
            if(username.equalsIgnoreCase("000")){
                System.out.println("Returning to Main Menu...");
                break;
            }

            Admin adm = (Admin) Util.usernameChecker(admins, username);
            while (attempts > 0&& adm!=null) {

                admin = adm;
                String password = Util.passwordReader(console);
                if (password.equals(adm.getPassword())) {

                    isActive=false;
                    break;
                }



                attempts--;
                if (attempts == 0) {
                    adm.setBlocked(true);
                    if(adm.getUsername().equals("TB"))
                        adm.setBlocked(false);

                    System.out.println("Admin with username \"" + username + "\" has been blocked");
                    return null;
                }
                System.out.println("Attempts left: " + attempts);
            }
        }
        return admin;
    }

    public static void adminMenu(Scanner console)
    {
        boolean approved = false;
        Admin admin = adminLoginScreen(console);
        if(admin!=null)
            approved = true;

        while(approved)
        {
            System.out.println(adminMenu);
            String option = Util.requiredString("Please enter selection: ",console);

            switch (option)
            {
                case "0":
                    approved=false;
                    break;
                case "1":
                    admShowMenu(console);
                    break;
                case "2":
                    admSearchMenu(console);
                    break;
                case "3":
                    admAddMenu(console);
                    break;
                case "4":
                    admUpdateMenu(console);
                    break;
                case "5":
                    admRemoveMenu(console);
                    break;
                default:
                    System.out.println("Wrong operation inserted.Please try again");

            }
        }
        if(!approved)
        {
            System.out.println("Returning to main Screen.");
        }
    }



    public static void admShowMenu(Scanner console) {

        //show Admins
        //show Students
        //Show Teachers
        boolean isActive = true;
        while (isActive) {
            System.out.println("==========Admin Show menu==========\n" +
                    "<1> Show Admins\n" +
                    "<2> Show Teachers\n" +
                    "<3> Show Students\n" +
                    "<4> Show Class Rooms\n" +
                    "<0> Cancel\n");

            String option = Util.requiredString("Choose Operation: ", console);

            switch (option) {
                case "0":
                    isActive = false;
                    break;
                case "1":
                    GlobalDatas.adminsDynamicArray.adminListDetails();
                    break;
                case "2":
                    if (GlobalDatas.teachersDynamicArray.getArray().length == 0) {
                        System.out.println("No Teachers added yet");
                    } else {
                        GlobalDatas.teachersDynamicArray.teachersListDetails();
                    }
                    break;
                case "3":
                    if (GlobalDatas.studentsDynamicArray.getArray().length == 0) {
                        System.out.println("No Students added yet");
                    } else {
                        GlobalDatas.studentsDynamicArray.studentListDetails();
                    }
                    break;
                case "4":
                    if (GlobalDatas.classRoomsDynamicArray.getArray().length == 0) {
                        System.out.println("No Class Rooms added yet");
                    } else {
                        ClassRoom[] classes = GlobalDatas.classRoomsDynamicArray.getArray();
                        for (ClassRoom c: classes)
                        {
                            System.out.println(c);
                        }
                    }
                    break;
                default:
                    System.out.println("Wrong operation inputted.PLease try again");

            }
        }
    }

    public static void admSearchMenu(Scanner console)
    {

        AdminServiceImpl adminService = new AdminServiceImpl();

        boolean isActive =true;
        while(isActive)
        {
            System.out.println("==========Admin Search Menu==========\n" +
                    "<1> Search for a Student by ID\n" +
                    "<2> Search for a Teacher by ID\n" +
                    "<0> Cancel");
            int option = Util.requiredInt("Choose operation: ",console);

            switch(option)
            {
                case 0:
                    isActive=false;
                    break;
                case 1:
                    adminService.searchForStudent(console);
                    break;
                case 2:
                    adminService.searchForTeacher(console);
                    break;
                default:
                    System.out.println("Wrong operation inputted.Please try again");


            }


        }
    }

    public static void admAddMenu(Scanner console)
    {

        AdminServiceImpl adminService = new AdminServiceImpl();
        boolean isActive = true;
        while(isActive)
        {
            System.out.println("==========Admin Add Menu==========\n" +
                    "<1> Add Teacher\n" +
                    "<2> Add Student\n" +
                    "<3> Create ClassRoom \n" +
                    "<0> Cancel\n");

            String option = Util.requiredString("Choose option: ",console);


            switch(option)
            {
                case "0":
                    isActive=false;
                    break;
                case "1":
                    adminService.addTeacher(console);
                    break;
                case "2":
                    adminService.addStudent(console);
                    break;
                case "3":
                    ClassRoomUtil.createClassRoom(console);
                    break;
                default:
                    System.out.println("Wrong operation inputted.Try again.");
            }
        }

    }

    public static void admUpdateMenu(Scanner console)
    {
        boolean isActive = true;
        while(isActive)
        {
            System.out.println("=========Admin Update Menu========\n" +
                    "<1> Update Student\n" +
                    "<2> Update Teacher\n" +
                    "<0> Cancel\n");
            String option = Util.requiredString("Choose option: ",console);

            switch(option)
            {
                case "0":
                    isActive=false;
                    break;
                case "1":
                    StudentUtil.updateStudent(console);
                    break;
                case "2":
                    TeacherUtil.updateTeacher(console);
                    break;
                default:
                    System.out.println("Wrong operation inputted.Try again");
            }
        }
    }

    public static void admRemoveMenu(Scanner console)
    {
        boolean isActive = true;
        while(isActive)
        {
            System.out.println("=========Admin Remove Menu========\n" +
                    "<1> Remove Student\n" +
                    "<2> Remove Teacher\n" +
                    "<3> Remove Class Room\n" +
                    "<0> Cancel\n");
            String option = Util.requiredString("Choose option: ",console);

            switch(option)
            {
                case "0":
                    isActive=false;
                    break;
                case "1":
                    StudentUtil.removeStudentFromDatabase(console);
                    break;
                case "2":
                    TeacherUtil.removeTeacherFromDatabase(console);
                    break;
                case "3":
                    ClassRoomUtil.removeClassRoomFromDatabase(console);
                    break;
                default:
                    System.out.println("Wrong operation inputted.Try again");
            }
        }
    }


}
