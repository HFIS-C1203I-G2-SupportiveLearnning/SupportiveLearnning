/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MyDate {
    public final static String STANDARD_FORMAT = "MM/dd/yyyy";
    public static String getCurrentDate(String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date now = new Date();
        String rs = dateFormat.format(now);
        return rs;
    }
    
    public static String formatDate(String format, java.sql.Timestamp date){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String rs = dateFormat.format(date);
        return rs;
    }
    
    public static boolean isValidate(String format, String date){
        boolean check = false;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            dateFormat.parse(date);
            check = true;
        } catch (Exception e) {
        }
        return check;
    }
}
