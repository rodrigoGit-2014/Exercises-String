package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiccionarySuggest {

    public static void main(String[] args) {

        String[] pages = new String[]{
                "abceui jij wwi amn, 29 abdjdj jfjg",
                "bfbg abcuur kdk ns acjn ",
                "bfhr abcri abc94 abc43 ab31 abcd ab",
        };

        Map<Character, String> diccio = saveDicctionary(pages);

        List<String> startWith = searchStartWith(pages, "abc");

        for (String word : startWith) {
            System.out.println(word + ", ");
        }
    }


    public static Map<Character, String> saveDicctionary(String[] pages) {

        Map<Character, String> diccMap = new HashMap<>();

        int starInd = 0, endInd = 0;
        for (int ind = 0; ind < pages.length; ind++) {

            while (endInd < pages[ind].length()) {
                endInd = findIndexWordSeparator(pages[ind], starInd);
                String word = getWordWithPrefix(pages[ind], starInd, endInd - 1);
                starInd = endInd;
                if (diccMap.get(word.charAt(0)) == null) {
                    diccMap.put(word.charAt(0), word);
                } else {
                    diccMap.put(word.charAt(0), diccMap.get(word.charAt(0)) + " " + word);
                }

            }
            endInd = 0;
            starInd = 0;

        }

        return diccMap;
    }


    public static List<String> searchStartWith(String[] pages, String prefix) {

        int PAGES_LENGTH = pages.length;
        int PREFIX_LENGTH = prefix.length();

        List<String> wordFound = new ArrayList<>();

        for (int index1 = 0; index1 < PAGES_LENGTH; index1++) {

            int LINE_LENGTH = pages[index1].length();

            String words = pages[index1];

            int prefixInd = 0;

            int lineInd = 0;

            int posNextStart = 0;


            while (lineInd < LINE_LENGTH) {

                if (prefixInd < PREFIX_LENGTH &&
                        isEqual(words.charAt(lineInd), prefix.charAt(prefixInd))) {
                    prefixInd++;
                    lineInd++;
                } else if (prefixInd != PREFIX_LENGTH) {
                    posNextStart = findIndexWordSeparator(words, lineInd);
                    prefixInd = 0;
                    lineInd = posNextStart;
                } else {
                    posNextStart = findIndexWordSeparator(words, lineInd);
                    wordFound.add(getWordWithPrefix(words, lineInd - PREFIX_LENGTH, posNextStart - 1));
                    prefixInd = 0;
                    lineInd = posNextStart;
                }


            }

        }

        return wordFound;
    }

    public static int findIndexWordSeparator(String words, int startIndex) {
        while (startIndex < words.length() && words.charAt(startIndex) != ' ') {
            startIndex++;
        }
        return startIndex + 1;
    }

    public static String getWordWithPrefix(String words, int startIndex, int endIndex) {
        String word = new String();

        for (int i = startIndex; i < endIndex; i++) {
            word += words.charAt(i);
        }
        return word;
    }

    public static boolean isEqual(char a, char b) {
        return a == b;
    }
}
