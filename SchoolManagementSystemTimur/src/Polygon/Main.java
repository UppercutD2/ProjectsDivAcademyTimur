package Polygon;


import Util.Util;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String name = Util.requiredString("Enter String: ",console);
        int x = Util.requiredInt("Enter number: ",console);
        System.out.println(name);
        String surname = Util.requiredString("Enter surname: ",console);

    }

    public static String getPassword(Animals animal)
    {
        return animal.toString();

    }
}
