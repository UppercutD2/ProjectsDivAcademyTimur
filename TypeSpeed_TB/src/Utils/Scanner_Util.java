package Utils;

import java.util.Scanner;

public class Scanner_Util {


    public static String requiredString(String s)
    {
        System.out.println(s);
        return new Scanner(System.in).nextLine();
    }

    public static int requiredInt(String s,Scanner console)
    {

        System.out.println(s);
       String input = console.nextLine();

       return intCheck(input)? Integer.parseInt(input): 69;
    }
    public static boolean intCheck(String s)
    {
        try{
                Integer.parseInt(s);
                return true;
        }catch(NumberFormatException ex)
        {
            System.out.println("Wrong number format inputted.");
        }
        return false;
    }

}
