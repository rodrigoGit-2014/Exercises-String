package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class DiccionarySuggest {

    public static void main(String[] args) {

        String[] pages = new String[]{
                "abceui jij wwi amn, 29 abdjdj jfjg",
                "bfbg abcuur kdk ns acjn ",
                "bfhr abcri abc94 ",
        };

        List<String> startWith = search(pages, "abc");

       for(String word:startWith){
           System.out.println(word + ", ");
       }
    }


    public static List<String> search(String[] pages, String prefix) {

        int PAGES_LENGTH = pages.length;
        int PREFIX_LENGTH = prefix.length();

        List<String> wordFound = new ArrayList<>();

        for (int index1 = 0; index1 < PAGES_LENGTH; index1++) {

            int LINE_LENGTH = pages[index1].length();

            String words = pages[index1];

            int indexStartWith = 0;

            int indexWord = 0;

            int posNextStart = 0;


            while (indexWord < LINE_LENGTH) {


                if (indexStartWith < PREFIX_LENGTH &&
                        isEqual(words.charAt(indexWord), prefix.charAt(indexStartWith))) {
                    indexStartWith++;
                    indexWord++;
                } else if (indexStartWith != PREFIX_LENGTH) {
                    posNextStart = findIndexWordSeparator(words, indexWord);
                    indexStartWith = 0;
                    indexWord = posNextStart;
                } else {

                    wordFound.add(getWordWithPrefix(words, indexWord - PREFIX_LENGTH, posNextStart - 1));
                    indexStartWith = 0;
                    posNextStart = findIndexWordSeparator(words, indexWord);
                    indexWord = posNextStart;
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

    public static String getWordWithPrefix(String words, int startIndex, int endIndexd) {
        int endIndex = findIndexWordSeparator(words, startIndex) - 1;
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
