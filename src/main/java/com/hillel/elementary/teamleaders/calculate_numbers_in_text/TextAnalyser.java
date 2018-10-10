package com.hillel.elementary.teamleaders.calculate_numbers_in_text;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.math.BigDecimal;

import java.util.regex.Pattern;

public class TextAnalyser {
    public static BigDecimal calculateSumInText(String str) {
        BigDecimal sum = BigDecimal.ZERO;

        sum = getSum(str, sum);

        return sum;
    }

    public static BigDecimal calculateSumInFile(Path path) throws IOException {
        BigDecimal sum = BigDecimal.ZERO;
        FileReader reader = new FileReader(path.toString());
        BufferedReader bufferedReader = new BufferedReader(reader);
        while (bufferedReader.ready()) {
            String str = bufferedReader.readLine();
            sum = getSum(str, sum);
        }
        return sum;
    }

    private static BigDecimal getSum(String str, BigDecimal sum) {
        Pattern pattern = Pattern.compile("((^)|[ ]+|[,;:\n\t]+)([0-9]+)($|([.][ ])|[ ,;:\n\t]+)",
                Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            BigDecimal value = new BigDecimal(matcher.group(3));
            sum = sum.add(value);
        }
        return sum;
    }
}