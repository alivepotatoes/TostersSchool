package Helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Readfile {
    public static String readFile(String pathToFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(pathToFile, StandardCharsets.UTF_8));
        String line = null;
        StringBuilder StringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        try {
            while ((line = reader.readLine()) !=null) {
                StringBuilder.append(line);
                StringBuilder.append(ls);
            }
        } catch (IOException e) {
            e.printStackTrace ();
        } finally {
            reader.close();
        }
        return StringBuilder.toString();
    }
}
