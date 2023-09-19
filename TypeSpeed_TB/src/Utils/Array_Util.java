package Utils;

import IO_Ops_Words.Input_Util;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Array_Util {





    public static String[] generateRW_Array (Scanner console)
    {
        int size = Scanner_Util.requiredInt("Number of Words: ",console);
        String [] words = createStrArray(size);
        fill_RW_ArrayStr(words);
        return words;
    }

    public static String[] createStrArray(int size)
    {
        return new String[size];
    }

    public static void fill_RW_ArrayStr( String[] words)
    {
        URL url = Input_Util.get_RW_URL();
        for(int i =0; i< words.length;i++)
        {
            words[i]=Input_Util.getRndWord(url);
        if(i== words.length-1) {
            System.out.print("Loading Random Words " + (i + 1) + " out of " + words.length +"\n");
            break;
        }
            System.out.print("Loading Random Words " + (i + 1) + " out of " + words.length +"\r");
        }
        System.out.println("Loading Completed!");
    }
}
