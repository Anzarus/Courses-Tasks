package com.hillel.elementary.teamleaders.text_file_updater;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FileUpdater {
    public static void lineShaker(Path path) throws IOException {
        FileReader reader = new FileReader(String.valueOf(path));
        FileWriter writer = new FileWriter(String.valueOf(path + "(updated ver)"));
        BufferedReader bufferedReader = new BufferedReader(reader);

        while (bufferedReader.ready()) {
            String str = bufferedReader.readLine();

            String last = lastWordAnalyser(str.trim());
            String first = firstWordAnalyser(str.trim());

            String[] parts = subStrings(str, first, last);
            writer.write(parts[0] + last + parts[1] + first + parts[2] + "\n");
        }

        reader.close();
        writer.close();
    }

    static String lastWordAnalyser(String str) {
        String buffer = "";

        Pattern pattern = Pattern.compile(".*(^|[ ])(\\w+)([ ]|[-!\"#$%&'()*+,./:;<=>?@\\[\\]_`{|}~])*$",
                Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            buffer = matcher.group(2);
        }
        return buffer;
    }

    static String firstWordAnalyser(String str) {
        String buffer = "";

        Pattern pattern = Pattern.compile("^([ ]|[-!\"#$%&'()*+,./:;<=>?@\\[\\]_`{|}~])*(\\w+)",
                Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            buffer = matcher.group(2);
        }
        return buffer;
    }

    static String[] subStrings(String str, String first, String last) {
        String[] stringBuff = new String[3];
        int indexLast = str.indexOf(last);
        int indexFirst = str.indexOf(first);
        if (indexLast >= 0 && indexFirst >= 0) {
            stringBuff[0] = str.substring(0, indexFirst);
            stringBuff[1] = str.substring(indexFirst + first.length(), indexLast);
            stringBuff[2] = str.substring(indexLast + last.length(), str.length());
        } else {
            stringBuff[0] = str;
            stringBuff[1] = stringBuff[2] = "";
        }
        return stringBuff;
    }
}
