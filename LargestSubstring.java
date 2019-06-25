package com.example.demo.pangram.exercice;

public class LargestSubstring {

    public static void main(String[] args) {

        char[] booleans = new char[]{'#', '*', '#', '#', '*', '*', '*', '#', '#', '#', '*', '*', '#'};
        String xx = largestSubstring(booleans);
        System.out.println(xx);
    }

    public static String largestSubstring(char[] line) {

        int duplicateCount = 1, auxDuplicateCount = 0, start = 0, end = 0;

    
        for (int ind = 1; ind < line.length; ind++) {

            if (line[ind - 1] != line[ind]) {
                if (duplicateCount > auxDuplicateCount) {
                    end = ind;
                    start = (ind - duplicateCount) - (duplicateCount - 1);
                }
                auxDuplicateCount = duplicateCount;
                duplicateCount = 0;

            }

            duplicateCount++;
        }

        return buildString(start, end, line);
    }


    private static String buildString(int start, int end, char[] line) {
        String substring = new String();
        for (int i = start; i <= end; i++) {
            substring += line[i];
        }
        return substring;
    }
}

