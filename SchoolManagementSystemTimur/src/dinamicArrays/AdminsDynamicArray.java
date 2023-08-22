package dinamicArrays;

import config.GlobalDatas;
import employees.Admin;
import employees.Teacher;
import students.Student;


public class AdminsDynamicArray extends PersonDynamicArray{




    private Admin[] admins = new Admin[0];


    public AdminsDynamicArray() {

    }

    public Admin[] getArray()
    {
        return this.admins;
    }

    public void add(Admin admin) {
        Admin[] newAdmins = new Admin[admins.length + 1];

        for (int i = 0; i < admins.length; i++) {

            newAdmins[i] = admins[i];
        }

        newAdmins[newAdmins.length - 1] = admin;


        admins = newAdmins;

    }

    public Admin get(int index) {
        if (index > admins.length || index < 0) {
            System.out.println("Wrong index!!!!");
            return null;
        } else {
            return admins[index - 1];
        }
    }

    public void remove(Admin admin)
    {
        if(admins.length>0) {
            delete(admin);
            Admin[] newAdmins = new Admin[admins.length - 1];
            int j=0;
            for(int i=0;i<admins.length;i++)
            {
                if(admins[i]!=null)
                {
                    newAdmins[j]=admins[i];
                    j++;
                }

            }
            admins=newAdmins;

        }

    }//reorganize array with deleted admins

    public void delete(Admin admin)
    {
        for(int i=0;i<admins.length;i++){
            if(admins[i].equals(admin))
            {
                admins[i]=null;
                break;
            }
        }

    }//deletes admin from array
    public int size() {

        return admins.length;
    }
    public void adminListDetails()
    {
        String result="";
        for(Admin a :admins)
        {
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println(a);
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");

        }
    }
}
