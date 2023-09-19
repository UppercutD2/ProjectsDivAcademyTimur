package Ops_File;

import Utils.Array_Util;
import Utils.DateTime_Util;

import java.io.*;
import java.util.Scanner;

public class To_File {
    static boolean override = true;
    static int lineForUW =0;
    static int  linesToAddUW=0;
    public static int currentArraySize = 0;


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

    public static void UW_ToFile(File file,Scanner console)
    {




    }
    ////////////UW_ToFile///////////////////////

    //Method to find required Line in File
    //Method to know where to start inputing User words
    public static int getLineForUW(File file,int wordsLength)
    {
        try(BufferedReader bf = new BufferedReader(new FileReader(file)))
        {


        }catch(IOException ex)
        {
            ex.printStackTrace();
        }


        return 0;
    }



    //////// RW_ToFile////////////
    public static void override_RW_ToFile(File file, String[] words)
    {

        try(FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
        {
            inputNumericLines(bufferedWriter,words);

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

           inputNumericLines(bufferedWriter,words);

        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }



    }

    ///////DRY METHODS/////


    public static void inputNumericLines(BufferedWriter bf,String[] words)
    {
        try {
            bf.write("=============================\n" +
            DateTime_Util.getDateTimeStr() +"\n" +
            "=============================\n" );
        bf.write("RANDOM WORDS FROM API: ");
        bf.newLine();
        int nmb = 1;

           for (String w : words) {
               bf.write(nmb + " - " + w);
               bf.newLine();
               nmb++;
           }
           bf.flush();

       }catch(IOException ex)
       {
           ex.printStackTrace();
       }
    }


}
