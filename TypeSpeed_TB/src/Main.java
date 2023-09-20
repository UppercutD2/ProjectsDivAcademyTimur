import Ops_File.Options_File;
import Ops_File.To_File;
import Utils.Array_Util;
import Utils.DateTime_Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        To_File.RW_ToFile(console);
        System.out.println(DateTime_Util.getDateTimeStr());
        int total_Lines = someMethod(console);
        System.out.println("Total Lines are - " + total_Lines);
        int startAnswers =total_Lines-To_File.currentArraySize;
        System.out.println(" will start on " + startAnswers );

        //questions
        //1)clone git repository, and push it to another Git repository
        //2)method to get number of lines in TXT file
        //3)ways to cut Console.nextLine() without User pressing "enter"
    }

    public static int someMethod(Scanner console){
        File file = Options_File.getFile(console);
        try{
           List<String> lines =  Files.readAllLines(Paths.get(file.getAbsolutePath()));
            System.out.println(lines);
            return lines.size();


        }catch(IOException ex)
        {
            ex.printStackTrace();
        }
        return -1;
    }
}