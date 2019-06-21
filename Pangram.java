package com.example.demo.pangram.exercice;

import java.util.HashMap;
import java.util.Map;

public class Pangram {

    private final int TOTAL_ALPHABET_LETTER_NUMBER = 26;

    private final char UPPER_A = 'A';
    private final char LOWER_A = 'a';

    private final char UPPER_Z = 'Z';
    private final char LOWER_Z = 'z';


    Map<Character, Boolean> alpabetCounterMap = new HashMap<>();


    public boolean isPangram(String word) {
        int countLetter = 0;

        for (int index = 0; index < word.length(); index++) {
            char letter = word.charAt(index);
            if (alpabetCounterMap.get(letter) == null && checkRange(letter)) {
                alpabetCounterMap.put(convertToLower(letter), true);
                countLetter++;
            }
        }

        if (countLetter == TOTAL_ALPHABET_LETTER_NUMBER) return true;
        return false;
    }

    private boolean checkRange(char letter) {
        return (checkUpperLetter(letter)) || checkLowerLetter(letter);
    }

    private boolean checkUpperLetter(char letter) {
        return UPPER_A <= letter && letter <= UPPER_Z;
    }

    private boolean checkLowerLetter(char letter) {
        return LOWER_A <= letter && LOWER_Z >= letter;
    }

    private char convertToLower(char letter) {
        if (checkUpperLetter(letter)) return Character.toLowerCase(letter);
        return letter;
    }
}
