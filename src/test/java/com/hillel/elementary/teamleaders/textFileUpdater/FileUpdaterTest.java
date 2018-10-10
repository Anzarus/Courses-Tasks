package com.hillel.elementary.teamleaders.textFileUpdater;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.hillel.elementary.teamleaders.textFileUpdater.FileUpdater.*;
import static org.junit.jupiter.api.Assertions.*;

class FileUpdaterTest {

    @Test
    public void lineShakerTest() throws IOException {
        Path path1 = Paths.get("src/test/resources/TextFileUpdater/First_example");
        Path path2 = Paths.get("src/test/resources/TextFileUpdater/Second_example");
        Path path3 = Paths.get("src/test/resources/TextFileUpdater/Third_example");

        lineShaker(path1);
        lineShaker(path2);
        lineShaker(path3);//TODO: add matching
    }

    @Test
    public void lastWordAnalyserTest() {
        String str1 = "I tried to do it once again...";
        String str2 = "Hi guys!!";
        String str3 = "Deadpool is very funny movie;";
        String str4 = "Star wars is very famous franchise,";

        String result1 = "again";
        String result2 = "guys";
        String result3 = "movie";
        String result4 = "franchise";

        assertEquals(lastWordAnalyser(str1), result1);
        assertEquals(lastWordAnalyser(str2), result2);
        assertEquals(lastWordAnalyser(str3), result3);
        assertEquals(lastWordAnalyser(str4), result4);
    }

    @Test
    public void firstWordAnalyserTest() {
        String str1 = "I tried to do it once again...";
        String str2 = "Hi guys!!";
        String str3 = "Deadpool is very funny movie;";
        String str4 = "Star wars is very famous franchise,";

        String result1 = "I";
        String result2 = "Hi";
        String result3 = "Deadpool";
        String result4 = "Star";

        assertEquals(firstWordAnalyser(str1), result1);
        assertEquals(firstWordAnalyser(str2), result2);
        assertEquals(firstWordAnalyser(str3), result3);
        assertEquals(firstWordAnalyser(str4), result4);
    }

    @Test
    public void subStringsTest() {
        String str1 = "I tried to do it once again...";
        String str2 = "  Hi guys!!";
        String str3 = " Deadpool is very funny movie";
        String str4 = "   Star wars is very famous franchise";

        String first1 = "I";
        String first2 = "Hi";
        String first3 = "Deadpool";
        String first4 = "Star";

        String last1 = "again";
        String last2 = "guys";
        String last3 = "very";
        String last4 = "wars";

        String[] result1 = {""," tried to do it once ","..."};
        String[] result2 = {"  "," ","!!"};
        String[] result3 = {" "," is "," funny movie"};
        String[] result4 = {"   "," "," is very famous franchise"};

        assertArrayEquals(subStrings(str1, first1, last1), result1);
        assertArrayEquals(subStrings(str2, first2, last2), result2);
        assertArrayEquals(subStrings(str3, first3, last3), result3);
        assertArrayEquals(subStrings(str4, first4, last4), result4);
    }
}