package IO_Ops_Words;

import Str_Messages.App_DataStr;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Input_Util {





    public static String getRndWord(URL url)
    {
        try {
            Scanner scanner = new Scanner(url.openStream());
             String randomWord = scanner.nextLine();
             randomWord = randomWord.substring(2,randomWord.length()-2);
            return randomWord;

        } catch (Exception ex) {

            ex.printStackTrace();
        }
        return null;
    } //returns Random words from URL

    public static URL get_RW_URL()
    {
        try{
            return new URL(App_DataStr.wordAPI_URL_Str);
        }catch (MalformedURLException ex)
        {
            System.out.println("URL not found");
            ex.printStackTrace();
        }
        return null;
    } //Returns static URL for random words
}
