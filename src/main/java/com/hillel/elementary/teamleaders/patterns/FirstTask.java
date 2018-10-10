package com.hillel.elementary.teamleaders.patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstTask {
    public static List<String> findWord(String text) {
        List<String> matches = new ArrayList<>();

        Pattern pattern = Pattern.compile("([ '\n\t])+([a-zA-Z]{4})([ ,.:;'\n\t])+",
                Pattern.CASE_INSENSITIVE);//TODO

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            matches.add(matcher.group(2));
        }
        return matches;
    }
}
