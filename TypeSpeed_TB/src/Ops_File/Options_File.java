package Ops_File;

import Str_Messages.App_DataStr;
import Utils.Scanner_Util;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Options_File {



    public static File getFile(Scanner console)
    {
        File file = nameFile(console);
        if(file.exists())
        {   To_File.override=false;
           return file;
        }
        createFile(file);
        return file;
    }   //Returns existing file or creates new One.



   /////////////////////////////////////////////////////////////////////

   public static  void createFile(File file)
   {
       try{
           file.createNewFile();
           System.out.println("New File has been created | " + file.getAbsolutePath());
       }catch(IOException ex)
       {
           System.err.println("Creation of File failed");
           ex.printStackTrace();
       }
   }//Methods creating file with handling exceptions
   public static File nameFile(Scanner console)
    {
        App_DataStr.fileName = Scanner_Util.requiredString("Please input your name: ");
        String fileName = App_DataStr.resultPathStr + App_DataStr.fileName+".txt";
        return new File(fileName);
    } //Names file and returns Absolute path with TXT extension

}
