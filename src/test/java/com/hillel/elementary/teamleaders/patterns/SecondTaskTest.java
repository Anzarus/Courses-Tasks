package com.hillel.elementary.teamleaders.patterns;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SecondTaskTest {
    @Test
    void findIdentificatorTest() throws IOException {
        ArrayList<String> arrayListExs = new ArrayList<>();
        arrayListExs.add("11 304 982");
        arrayListExs.add("39 683 234");
        arrayListExs.add("139 920 393");
        arrayListExs.add("150 000 000");
        Path path = Paths.get("src/main/resources/textFile");

        ArrayList<String> arrayList = (ArrayList<String>) SecondTask.findIdentificator(path);

        assertEquals(arrayListExs, arrayList);
    }
}