import Ops_File.To_File;
import Utils.Array_Util;
import Utils.DateTime_Util;

import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        To_File.RW_ToFile(console);
        System.out.println(DateTime_Util.getDateTimeStr());
    }
}