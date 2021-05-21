package com.example.a2laboratorinis;

public class SymbolsWordsCounter {
    public static int getSymbolsCount(String txt) {
        return txt.length();
    }

    public static int getWordsCount(String txt) {
        if (txt.length() == 0)
            return 0;

        String[] words = txt.split("\\s+");
        return words.length;
    }
}
