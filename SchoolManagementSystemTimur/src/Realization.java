import java.util.Scanner;

import Util.Util;

import Util.StudentUtil;
import Util.TeacherUtil;
import Util.AdminUtil;
import config.GlobalDatas;
import employees.Admin;

public class Realization {


    public static void run(Scanner console)
    {
        Admin SUPER_ADMIN = new Admin();
        SUPER_ADMIN.setUsername("TB");
        SUPER_ADMIN.setPassword("123");
        GlobalDatas.adminsDynamicArray.add(SUPER_ADMIN);

        boolean mainMenu=true;
        while (mainMenu)
        {
            String option = Util.initScreenSlct(console);

            switch(option)
            {
                case "0":
                    System.exit(0);
                case "1":
                    StudentUtil.studentMenu(console);
                    break;
                case "2":
                    TeacherUtil.teacherMenu(console);
                    break;
                case "3":
                    AdminUtil.adminMenu(console);
                    break;
                default:
                    System.out.println("Wrong operation chosen");

            }
        }


    }
}
