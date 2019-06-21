package com.example.demo.pangram.exercice;

public class MissingPangram {

    private final int TOTAL_ALPHABET_LETTER_NUMBER = 26;

    private final char UPPER_A = 'A';
    private final char LOWER_A = 'a';

    private final char UPPER_Z = 'Z';
    private final char LOWER_Z = 'z';

    private boolean[] alpabetArr = new boolean[26];


    public char[] missingLetter(String word) {


        for (int index = 0; index < word.length(); index++) {
            if (isValidRange(word.charAt(index))) {
                updateAlpabetArr(word.charAt(index));
            }
        }


        for (int index = 0; index < word.length(); index++) {
            if (!alpabetArr[index]) {
                char letter = (char) (index + LOWER_A);
                System.out.print(letter + " ");
            }
        }
        return null;
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

    private boolean isValidRange(char letter) {
        return checkUpperLetter(letter) || checkLowerLetter(letter);
    }

    private void updateAlpabetArr(char letter) {
        int index = convertToIndex(letter);
        if (!alpabetArr[index]) alpabetArr[index] = true;
    }

    private int convertToIndex(char letter) {
        char newLetter = convertToLower(letter);
        return newLetter - LOWER_A;
    }

}
