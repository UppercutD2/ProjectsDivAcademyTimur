package Util;

import config.GlobalDatas;
import config.Person;
import dinamicArrays.*;
import employees.Admin;
import employees.Teacher;
import schools.ClassRoom;
import service.AdminServiceImpl;
import service.StudentServiceImpl;
import service.TeacherServiceImpl;
import students.Student;

import java.util.Scanner;

public class Util {

   public static String searchMenuStr = "========== Search Menu ==========\n";


    public static String initScreenMenuStr = "+++++++++Welcome to School Management System+++++++++\n" +
            "Which one are you?\n" +
            "<1> Student\n" +
            "<2> Teacher\n" +
            "<3> Admin\n" +
            "<0> Exit!\n";

    public static String initScreenSlct(Scanner console)
    {
        System.out.println(initScreenMenuStr);
        String option= requiredString("Please enter selection : ",console);
        System.out.println("+++++++++++++++++++++++++++++++++");
        return option;
    }//getting option from initial Screen as a String(1,2,3,4)






    public static void searchMenu(Scanner console)
    {
        boolean isActive = true;
        while(isActive) {
            System.out.println(searchMenuStr);
            int option = requiredInt("Please Enter ID to search: ", console);
            if(option==333){
                System.out.println("Loggin out...");
                isActive=false;
            }//Exit door


            if(option<0||option>150)
            {
                System.out.println("Wrong ID inputted.");
            }//Wrong index commands
            else
            {
                if( option>=0 &&option<50)
                {
                    Student[] array = (Student[]) GlobalDatas.studentsDynamicArray.getArray();
                    for(Student s : array){
                        if(option==s.getId())
                        {
                            isActive=false;
                            System.out.println(s);
                        }
                    }

                }//if ID in Student range
                if(option>=50&&option<100)
                {
                    Teacher [] array = (Teacher[]) GlobalDatas.teachersDynamicArray.getArray();
                    for(Teacher t: array){
                        if(option==t.getId()){
                            System.out.println(t);
                        }

                    }
                }//if ID in teacher range
                if(option>=100&&option<150)
                {
                    Admin[] array = (Admin[]) GlobalDatas.adminsDynamicArray.getArray();
                    for(Admin a: array)
                    {
                        if(option==a.getId())
                        {
                            isActive=false;
                            System.out.println(a);
                        }

                    }
                }//if ID in Admin range

                if(isActive)
                {
                    System.out.println("ID is not used.Logging out");
                    isActive=false;
                }//if index in range not found
            } //range index check



        }

    }





    public static String userNameReader(Scanner console)
    {
        System.out.println("============Login============");
       return requiredString("Please enter Username: ",console);
    }

    public static String passwordReader(Scanner console)
    {
        return requiredString("Please enter password: ",console);
    }

    public static Person usernameChecker(Person[] array,String username)

    {
        boolean found=false;
        for(Person p : array)
        {
            if(username.equalsIgnoreCase(p.getUsername()))
            {
            return p;

        }
        }
        if(!found)
            System.out.println("Username not found");

        return null;
    }//looks for username of array objects, returns true if Found

    public static int ageChecker(Scanner console)
    {   boolean isActive=true;
        int age =0;
        while(isActive)
        {
            age = requiredInt("Enter  Age: ",console);
            if(age<=0||age>100){
                System.out.println("Incorrect age inputted.Please try again");
            }
            else
            {
                isActive=false;

            }
        }
        return age;
    }//age checker loop
    public static String nameChecker(Scanner console)
    {

        boolean isActive = true;
        String input = "";
        while(isActive)
        {
            input = requiredString("Enter  name: ",console);

            if(!input.matches("[a-zA-Z]{2,15}")){
                System.out.println("Name cannot contain, Special characters and numbers. Length range (2-15).Please try again");
            }
            else
            {
                isActive=false;
            }

        }
       return input;
    }//name checker loop
    public static String surnameChecker(Scanner console)
    {
        boolean isActive = true;
        String input = "";
        while(isActive)
        {
            input = requiredString("Enter  Surnname: ",console);

            if(!input.matches("[a-zA-Z]{2,30}")){
                System.out.println("Surname cannot contain, Special characters and numbers. Length range (2-30).Please try again");
            }
            else
            {
                isActive=false;
            }

        }
        return input;
    }//surname checker

    public static String emailChecker(Scanner console)
    {
        boolean isActive = true;
        String input = "";
        while(isActive)
        {
            input = requiredString("Enter  Email: ",console);

            if(!input.matches("(.+){2,20}@(mail|gmail|yahoo)\\.(ru|com)")){
                System.out.println("Incompatibale mail address.\n" +
                        "Email Supported (mail.ru,gmail.com,yahoo.com) \n" +
                        "Length prior @ sign is 20 Characters .Please try again");
            }
            else
            {
                isActive=false;
            }

        }
        return input;
    }//email regex checker
    public static String passwordChecker(Scanner console)
    {
        boolean isActive = true;
        String pass1= "";
        String pass2 = "";
        while (isActive)
        {
            System.out.println("Password conditions:  should contain Capital letter,number,overall length above 8 characters.");
            pass1=requiredString("Create password: ",console);
            if(!passwordConditionsCheck(pass1))
            {
                System.out.println("Password is not satisfying conditions.Please try again.");
                continue;
            }
            pass2 = requiredString("Please repeat password: ",console);

            if(pass1.equals(pass2)){
                isActive=false;

            }
            else
            {
                System.out.println("Password are not same.Please try again");
            }



        }
        return pass1;
    }//final check prior password setup
    private static boolean passwordConditionsCheck(String password)
    {
        boolean hasCapital = false;
        boolean hasLowerCase = false;
        boolean hasNumber = false;
        boolean haslength = false;
        char[] chars = password.toCharArray();
        for(char c : chars)
        {
            if(Character.isUpperCase(c))
            hasCapital=true;

            if(Character.isLowerCase(c))
                hasLowerCase=true;

            if(Character.isDigit(c))
                hasNumber=true;

            if(password.length()>8)
                haslength=true;
        }
        return hasNumber && hasCapital && haslength && hasLowerCase?true:false;
    }//password condition boolean checker
    public static int requiredInt(String s, Scanner console)
    {   boolean active=true;
        int number = 0;
        while(active) {
            System.out.print(s);
            String input = console.nextLine();


            if (intChecker(input)) {
                number = Integer.parseInt(input);
                active=false;

            } else {
                System.out.println("\nWrong format of Number inputted");

            }
        }return number;
    }//returns int , from console.nextLine()
    public static String requiredString(String s,Scanner console){
        System.out.print(s);
        return console.nextLine();
    }//returns String

    public static boolean intChecker(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }//checks if String IS integer or NOT

    //search by ID,name,surname,age,mail,username,classRoom,blocked



}
