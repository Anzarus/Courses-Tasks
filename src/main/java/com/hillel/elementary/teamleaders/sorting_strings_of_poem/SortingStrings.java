package com.hillel.elementary.teamleaders.sorting_strings_of_poem;

import java.util.ArrayList;
import java.util.Comparator;

class SortingStrings {
    static void sort(ArrayList<String> arrStr, boolean fromShorterToLonger) {
        for (int i = 0; i < arrStr.size(); i++) {
            for (int j = i + 1; j < arrStr.size(); j++) {
                if (fromShorterToLonger) {
                    arrStr.sort(new Comparator<String>() {
                        @Override
                        public int compare(String o1, String o2) {
                            return o1.length()-o2.length();
                        }
                    });
                } else {
                    arrStr.sort(new Comparator<String>() {
                        @Override
                        public int compare(String o1, String o2) {
                            return o2.length()-o1.length();

                        }
                    });
                }
            }
        }
    }
}
