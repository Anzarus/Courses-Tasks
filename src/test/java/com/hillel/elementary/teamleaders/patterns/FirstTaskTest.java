package com.hillel.elementary.teamleaders.patterns;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FirstTaskTest {
    @Test
    void shouldFindAllFourLetterWords() {
        String[] expectedResult = {"such", "mere", "this", "well", "that", "some"};
        String text = "However little known the feelings or views of such a man may be on his\n" +
                "mere, first entering a neighbourhood, this truth is so well fixed in the minds\n" +
                "of the surrounding families, that he is considered the rightful property\n" +
                "of some: one or other of their daughters.";


        List<String> result = FirstTask.findWord(text);

        assertArrayEquals(expectedResult, result.toArray());
    }
}