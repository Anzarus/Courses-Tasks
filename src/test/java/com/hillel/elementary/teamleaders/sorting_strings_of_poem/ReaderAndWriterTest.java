package com.hillel.elementary.teamleaders.sorting_strings_of_poem;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class ReaderAndWriterTest {
    @Test
    void shouldRead() throws IOException {
        Path path = Paths.get("src/test/resources/Task with poem/Reader test");

        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("I'd heard there was a secret chord");
        expectedList.add("That David played and it pleased the Lord");
        expectedList.add("But you don't really care for music, do you?");
        expectedList.add("Well, it goes like this");
        expectedList.add("The fourth, the fifth, the minor fall, the major lift");
        expectedList.add("The baffled king composing Hallelujah");
        expectedList.add("Hallelujah, Hallelujah");

        ArrayList<String> resultList = ReadAndWriteToText.reader(path);

        assertEquals(expectedList, resultList);
    }

    @Test
    void shouldSortFromShorterToLonger() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Oh my God");//9
        list.add("How are you");//11
        list.add("The last of us");//14
        list.add("one");//3
        list.add("Hallelujah, Hallelujah");//22
        list.add("hi");//2
        list.add("hello");//5

        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("hi");//2
        expectedList.add("one");//3
        expectedList.add("hello");//5
        expectedList.add("Oh my God");//9
        expectedList.add("How are you");//11
        expectedList.add("The last of us");//14
        expectedList.add("Hallelujah, Hallelujah");//22

        SortingStrings.sort(list, true);
        assertEquals(expectedList, list);
    }

    @Test
    void shouldSortFromLongerToShorter() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Oh my God");//9
        list.add("How are you");//11
        list.add("The last of us");//14
        list.add("one");//3
        list.add("Hallelujah, Hallelujah");//22
        list.add("hi");//2
        list.add("hello");//5

        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("Hallelujah, Hallelujah");//22
        expectedList.add("The last of us");//14
        expectedList.add("How are you");//11
        expectedList.add("Oh my God");//9
        expectedList.add("hello");//5
        expectedList.add("one");//3
        expectedList.add("hi");//2

        SortingStrings.sort(list, false);
        assertEquals(expectedList, list);
    }

    @Test
    void shouldCreateNewFileWithSortedText() throws IOException {
        Path path = Paths.get("src/test/resources/Task with poem/Shevchenko");
        Path pathTest = Paths.get("src/test/resources/Task with poem/ShevchenkoTest");

        ArrayList<String> resultList = ReadAndWriteToText.reader(path);
        SortingStrings.sort(resultList,true);

        ReadAndWriteToText.writer(pathTest,resultList);

    }
}