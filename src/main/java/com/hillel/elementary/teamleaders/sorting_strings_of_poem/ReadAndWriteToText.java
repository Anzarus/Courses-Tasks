package com.hillel.elementary.teamleaders.sorting_strings_of_poem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

class ReadAndWriteToText {
    static ArrayList<String> reader(Path path) throws IOException {
        FileReader reader = new FileReader(String.valueOf(path));
        BufferedReader bufferedReader = new BufferedReader(reader);

        ArrayList<String> arrStr = new ArrayList<>();

        while (bufferedReader.ready()) {
            String str = bufferedReader.readLine().trim();
            if (str.equals("")) {
                continue;
            }
            arrStr.add(str);
        }
        reader.close();
        return arrStr;
    }

    static void writer(Path path, ArrayList<String> arrStr) throws IOException {
        FileWriter writer = new FileWriter(String.valueOf(path));

        for (String anArrStr : arrStr) {
            writer.write(anArrStr + "\n");
        }
        writer.close();
    }
}
