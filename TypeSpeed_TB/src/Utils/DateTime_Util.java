package Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime_Util {


    public static String getDateTimeStr()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(" dd MMM yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();

        return dtf.format(date);
    }
}
