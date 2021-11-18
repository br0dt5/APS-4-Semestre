package com.unip.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

/**
 *
 * @author luanz
 */
public class LogGenerator {
    public static void newLog(String filename, String content) throws FileNotFoundException, UnsupportedEncodingException {
        String outputFilename = filename + "Log.txt";
        PrintWriter file = new PrintWriter(outputFilename, "UTF-8");
        
        Calendar now = Calendar.getInstance();
        file.printf("Data: %tF\n", now);
        file.printf("Hora: %tT\n", now);
        
        file.print("\n" + content);
        file.close();
    }
}
