package com.hillel.elementary.teamleaders.patterns;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class SecondTask {
    public static List<String> findIdentificator(Path path) throws IOException {
        FileReader reader = new FileReader(String.valueOf(path));
        BufferedReader bufferedReader = new BufferedReader(reader);

        ArrayList<String> matches = new ArrayList<>();

        while (bufferedReader.ready()) {
            String str = bufferedReader.readLine();

            Pattern pattern = Pattern.compile("([ ^])*([1-9])([0-9]|[0-9]{2})([ ])([0-9]{3})([ ])([0-9]{3})([ $])*",
                    Pattern.CASE_INSENSITIVE);

            Matcher matcher = pattern.matcher(str);

            while (matcher.find()) {
                matches.add(matcher.group(0));

                int element = stringChange(matches);
                if (element < 10_000_000 || element > 150_000_000) {
                    matches.remove(matches.size() - 1);
                }
            }

        }
        reader.close();

        return matches;
    }

    private static int stringChange(ArrayList<String> matches) {
        String strbuff = matches.get(matches.size()-1);
        String strbuff2 = strbuff.trim();
        String str = strbuff2.replaceAll(" ","");
        Integer element = parseInt(str);
        System.out.println(element);
        return element;
    }
}
