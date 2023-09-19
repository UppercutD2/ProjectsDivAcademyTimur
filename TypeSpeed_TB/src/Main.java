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
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        To_File.RW_ToFile(console);
        System.out.println(DateTime_Util.getDateTimeStr());


        //questions
        //1)clone git repository, and push it to another Git repository
        //2)method to get number of lines in TXT file
        //3)ways to cut Console.nextLine() without User pressing "enter"
    }

    public static void someMethod(Scanner console){
        File file = Options_File.getFile(console);
        try( FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader))
        {        String line = Files.readAllLines(Paths.get(file.getAbsolutePath())).get(4);
            System.out.println(line);



        }catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
}