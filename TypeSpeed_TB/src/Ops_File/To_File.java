package Ops_File;

import Utils.Array_Util;
import Utils.DateTime_Util;

import java.io.*;
import java.util.Scanner;

public class To_File {
    static boolean override = true;



    public static void RW_ToFile(Scanner console)
    {
        File file = Options_File.getFile(console);
        String [] words = Array_Util.generateRW_Array(console);
        if(override) {
            override_RW_ToFile(file, words);
        }
        else
        {
            append_RW_ToFile(file,words);
        }
        System.out.println("Words have been inserted to file: " + file.getAbsolutePath());
    }

    public static void override_RW_ToFile(File file, String[] words)
    {

        try(FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
        {
            bufferedWriter.write("=============================\n" +
                    DateTime_Util.getDateTimeStr() +"\n" +
                    "=============================\n" );
            bufferedWriter.write("RANDOM WORDS FROM API: ");
            bufferedWriter.newLine();
            for(String w : words)
            { bufferedWriter.write(w);
                bufferedWriter.newLine();

            }
            bufferedWriter.flush();

        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }




    }

    public static void append_RW_ToFile(File file,String[] words)
    {

        try(FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
        {
            bufferedWriter.write("=============================\n" +
                    DateTime_Util.getDateTimeStr() +"\n" +
                    "=============================\n" );
            bufferedWriter.write("RANDOM WORDS FROM API: ");
            bufferedWriter.newLine();
            for(String w : words)
            { bufferedWriter.write(w);
                bufferedWriter.newLine();

            }
            bufferedWriter.flush();

        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }



    }
}
