package com.hillel.elementary.teamleaders.calculate_numbers_in_text;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;


public class TextAnalyserTest {
    @Test
    void shouldCalculateSumInText() {
        String str = "123 planets\n80 stars\n99 columns 9, you";
        String str2 = "\n675.8 deaths\n";
        String str3 = "\n675.8.5.6.84. and 5 arrows\n";
        String str4 = "\n7987hu h7 bows 742";
        String str5 = "\n7!897 swords 67\n";

        BigDecimal sum = BigDecimal.valueOf(123 + 80 + 99 + 9);
        BigDecimal sum2 = BigDecimal.valueOf(0);
        BigDecimal sum3 = BigDecimal.valueOf(5);
        BigDecimal sum4 = BigDecimal.valueOf(742);
        BigDecimal sum5 = BigDecimal.valueOf(67);

        assertEquals(TextAnalyser.calculateSumInText(str), sum);
        assertEquals(TextAnalyser.calculateSumInText(str2), sum2);
        assertEquals(TextAnalyser.calculateSumInText(str3), sum3);
        assertEquals(TextAnalyser.calculateSumInText(str4), sum4);
        assertEquals(TextAnalyser.calculateSumInText(str5), sum5);
    }

    @Test
    void shouldCalculateSumInFile() throws IOException {
        Path path = Paths.get("src/test/resources/TextsForThirdTask/one");
        Path path2 = Paths.get("src/test/resources/TextsForThirdTask/two");
        Path path3 = Paths.get("src/test/resources/TextsForThirdTask/three");
        Path path4 = Paths.get("src/test/resources/TextsForThirdTask/four");
        Path path5 = Paths.get("src/test/resources/TextsForThirdTask/five");

        BigDecimal sum = BigDecimal.valueOf(123 + 80 + 99 + 9);
        BigDecimal sum2 = BigDecimal.valueOf(0);
        BigDecimal sum3 = BigDecimal.valueOf(5);
        BigDecimal sum4 = BigDecimal.valueOf(742);
        BigDecimal sum5 = BigDecimal.valueOf(67);

        assertEquals(TextAnalyser.calculateSumInFile(path), sum);
        assertEquals(TextAnalyser.calculateSumInFile(path2), sum2);
        assertEquals(TextAnalyser.calculateSumInFile(path3), sum3);
        assertEquals(TextAnalyser.calculateSumInFile(path4), sum4);
        assertEquals(TextAnalyser.calculateSumInFile(path5), sum5);
    }

}